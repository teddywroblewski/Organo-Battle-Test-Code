import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;


public class SelectionWindow extends JFrame {
	
	static final int ATTACK = 1;
	static final int DEFEND = 2;
	static final int RECHARGE = 3;
	
	private int width;
	private int height;
	
	Player whoseTurn;

	// need health bars for both players
	// need power meter
	// need buttons to select action
	
	private class SelectionButton extends JButton {
		private int selectionNumber;
		public SelectionButton(int selectionNumber) {
			this.selectionNumber = selectionNumber;
		}
		public int getSelectionNumber() { return selectionNumber; }
	}
	
	public SelectionWindow(PlayerOne playerOne, PlayerTwo playerTwo) {
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
		
		setLayout(null);
		
		JOptionPane.showMessageDialog(this, whoseTurn.getName());
		
		JProgressBar health = new JProgressBar();
		health.setStringPainted(true);
		health.setString("Health");
		health.setForeground(new Color(255,0,0));
		health.setValue(whoseTurn.getHealth());
		health.setMaximum(100);
		health.setMinimum(0);
		health.setBounds(50, 10, width - 100, height/20);
		add(health);
		
		JProgressBar power = new JProgressBar();
		power.setStringPainted(true);
		power.setString("Power");
		power.setForeground(new Color(255, 255, 0));
		power.setValue(whoseTurn.getPower());
		power.setMaximum(20);
		power.setMinimum(0);
		power.setBounds(50, height/2, width - 100, height/20);
		add(power);
		
		SelectionButton attack = new SelectionButton(ATTACK);
		SelectionButton defend = new SelectionButton(DEFEND);
		
		attack.setBounds(10, 3*(height/4), width/5, height/6);
		attack.setText("Attack");
		attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open attack window 
				JPopupMenu attackMenu = new JPopupMenu("Attack");
				JMenuItem benzene = new JMenuItem("Benzene Start");
				attackMenu.add(benzene);
				benzene.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Take to Benzene attack window
						BattleWindow bw = new BattleWindow(playerOne, playerTwo, "trinitrotoluene", playerOne.isTurn());
						bw.setVisible(true);
						SelectionWindow.this.dispose();

					}	
				});
				attackMenu.show(SelectionWindow.this, 250, 250);
			}	
		});
		
		defend.setBounds(4*(width/5) - 10, 3*(height/4), width/5, height/6);
		defend.setText("Defend");
		defend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open defend window 	
				JPopupMenu defendMenu = new JPopupMenu("Defend");
				JMenuItem defendChemical = new JMenuItem("Defend Chemical");
				defendMenu.add(defendChemical);
				defendChemical.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Open defend chemical window	
					}
				});
				defendMenu.show(SelectionWindow.this, 250,250);
			}
		});
		
		add(attack);
		add(defend);
	}
	
}
