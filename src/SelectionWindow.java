import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class SelectionWindow extends JFrame {

	static final int ATTACK = 1;
	static final int DEFEND = 2;
	static final int RECHARGE = 3;

	private int width;
	private int height;

	Player whoseTurn;

	private HashSet<String> attackOptions;
	private HashSet<String> optionsForAttack = AttackOptions.getAcidAttacks();
	private HashSet<String> defendOptions;
	private HashSet<String> optionsForDefense = DefenseOptions.getAntiInflamatoryDefenses();

	private class SelectionButton extends JButton {
		private int selectionNumber;
		public SelectionButton(int selectionNumber) {
			this.selectionNumber = selectionNumber;
		}
	}

	public SelectionWindow(PlayerOne playerOne, PlayerTwo playerTwo) {

		attackOptions = new HashSet<String>();
		defendOptions = new HashSet<String>();

		if (playerOne.isTurn()) {
			whoseTurn = playerOne;
		} else {
			whoseTurn = playerTwo;
		}


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() / 2;
		height = (int)(screenSize.getHeight() / 1.2);

		setSize(width, height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);

		setLayout(null);

		//Check if game is over
		if (whoseTurn.getHealth() == 0) {
			
			//inner class to run background task while window is being made
			class PopUpWindow extends SwingWorker<String,String> {

				@Override
				protected String doInBackground() throws Exception {
					Thread.sleep(500);
					return whoseTurn.getName();
				}
				protected void done() {
					try {
						JOptionPane.showMessageDialog(SelectionWindow.this, "Game Over, " + this.get() + " Has Lost!");
						SelectionWindow.this.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			new PopUpWindow().execute();
		} else {
			class PopUpWindow extends SwingWorker<String,String> {

				@Override
				protected String doInBackground() throws Exception {
					Thread.sleep(500);
					return whoseTurn.getName();
				}
				protected void done() {
					try {
						JOptionPane.showMessageDialog(SelectionWindow.this, this.get());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			new PopUpWindow().execute();
		}

		//This is for background image
		ImageIcon background = new ImageIcon("CGB.jpeg");
		Image bg = background.getImage();
		Image temp = bg.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);  // transform it back
		JLabel backgroundImage = new JLabel(background);
		backgroundImage.setLocation(width/2, height/2);
		backgroundImage.setBounds(0, 0, width, height);	
		
		//This is for the scientist bro // Teddy fix at some point
		ImageIcon scientist = new ImageIcon("scientist.png");
		Image sci = scientist.getImage();
		Image temp2 = sci.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		scientist = new ImageIcon(temp2);  // transform it back
		JLabel scientistLabel = new JLabel(scientist);
		scientistLabel.setLocation(width/2, height/2);
		scientistLabel.setBounds(0, 0, width, height);	


		//This is for the health bar
		JProgressBar health = new JProgressBar();
		health.setStringPainted(true);
		health.setString("Health");
		health.setForeground(new Color(255,0,0));
		health.setValue(whoseTurn.getHealth());
		health.setMaximum(100);
		health.setMinimum(0);
		health.setBounds(40, 10, width/3, height/10);
		add(health);

		//This is for power bar
		JProgressBar power = new JProgressBar();
		power.setStringPainted(true);
		power.setString("Power");
		power.setForeground(new Color(255, 255, 0));
		power.setValue(whoseTurn.getPower());
		power.setMaximum(20);
		power.setMinimum(0);
		power.setBounds((width/2)+20, 10, width/3, height/10);
		add(power);

		//Attack and Defend buttons
		SelectionButton attack = new SelectionButton(ATTACK);
		SelectionButton defend = new SelectionButton(DEFEND);

		attack.setBounds(80, 3*(height/4), width/4, height/6);
		attack.setFont(new Font("Arial", Font.BOLD, 30));
		attack.setText("ATTACK");
		attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open attack window 
				int i = 0;
				for(String chemcialOption : optionsForAttack) {
					attackOptions.add(chemcialOption);
					i++;
					if (i == 5) {
						break;
					}
				}

				JPopupMenu attackMenu = new JPopupMenu("Attack");

				for(String chemicalOption : attackOptions) {
					JMenuItem itemOption = new JMenuItem(chemicalOption + " Target");
					attackMenu.add(itemOption);
					itemOption.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							BattleWindow bw = new BattleWindow(playerOne, playerTwo, chemicalOption, playerOne.isTurn(), AttackOptions.getStartChemical(chemicalOption));
							bw.setVisible(true);
							SelectionWindow.this.dispose();
						}
					});
				}

				attackMenu.setSize(width/5, height/5);
				attackMenu.show(SelectionWindow.this, width/2, height/2);

			}	
		});

		defend.setBounds(4*(width/5) - 80, 3*(height/4), width/4, height/6);
		defend.setFont(new Font("Arial", Font.BOLD, 30));
		defend.setText("DEFEND");
		defend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open defend window 	
				int i = 0;
				for(String chemcialOption : optionsForDefense) {
					defendOptions.add(chemcialOption);
					i++;
					if (i == 5) {
						break;
					}
				}

				JPopupMenu defenseMenu = new JPopupMenu("Defense");

				for(String chemicalOption : defendOptions) {
					JMenuItem itemOption = new JMenuItem(chemicalOption + " Target");
					defenseMenu.add(itemOption);
					itemOption.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							BattleWindow bw = new BattleWindow(playerOne, playerTwo, chemicalOption, playerOne.isTurn(), DefenseOptions.getStartingChemical(chemicalOption));
							bw.setVisible(true);
							SelectionWindow.this.dispose();
						}
					});
				}

				defenseMenu.setSize(width/5, height/5);
				defenseMenu.show(SelectionWindow.this, width/2, height/2);
			}
		});

		add(attack);
		add(defend);
		add(backgroundImage);

	}

}
