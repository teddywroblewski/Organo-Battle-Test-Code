import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;

//This class is for the main game play window
public class SelectionWindow extends JFrame {
	
	//Variables
	static final int ATTACK = 1;
	static final int DEFEND = 2;
	static final int RECHARGE = 3;
	private int width;
	private int height;
	Player whoseTurn;
	Moves move = new Moves();
	
	//Selection button class
	private class SelectionButton extends JButton {
		
		//Variables
		private static final long serialVersionUID = 1L;
		private int selectionNumber;
		
		//Selection Number 
		public SelectionButton(int selectionNumber) {
			this.selectionNumber = selectionNumber;
		}
		
		//Selection Number getter
		public int getSelectionNumber() { return selectionNumber; }
		}
	
	//Constructor
	public SelectionWindow(PlayerOne playerOne, PlayerTwo playerTwo) {
		
		//Determines who's turn
		if (playerOne.isTurn()) {
			whoseTurn = playerOne;
		} else {
			whoseTurn = playerTwo;}
		
		//Sets up JFrame Window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() / 2;
		height = (int)(screenSize.getHeight() / 1.2);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
		setLayout(null);
		
		//This is for background image
		ImageIcon background = new ImageIcon("CGB.jpeg");
		Image bg = background.getImage();
		Image temp = bg.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);  // transform it back
        JLabel backgroundImage = new JLabel(background);
        backgroundImage.setLocation(width/2, height/2);
        backgroundImage.setBounds(0, 0, width, height);	
		
		//This is for the health bar
		JProgressBar health = new JProgressBar();
		health.setStringPainted(true);
		health.setString("Health");
		health.setForeground(new Color(255,0,0));
		health.setValue(whoseTurn.getHealth());
		health.setMaximum(100);
		health.setMinimum(0);
		health.setBounds(40, 10, width/3, height/10);
		
		//This is for power bar
		JProgressBar power = new JProgressBar();
		power.setStringPainted(true);
		power.setString("Power");
		power.setForeground(new Color(255, 255, 0));
		power.setValue(whoseTurn.getPower());
		power.setMaximum(20);
		power.setMinimum(0);
		power.setBounds((width/2)+20, 10, width/3, height/10);
		
		//This is for the attack selection button
		SelectionButton attack = new SelectionButton(ATTACK);
		attack.setBounds(80, 3*(height/4), width/4, height/6);
		attack.setFont(new Font("Arial", Font.BOLD, 30));
		attack.setText("ATTACK");
		attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Opens Popup to List of Attacks
				JPopupMenu attackMenu = new JPopupMenu("Attack");
				
				//Once we have more attacks RNG goes here
				//TODO Random number generator
				//Spits out an array:
				
				int optionAttack[] = {0, 1};
				
				//Makes the random numbers into random moves from Moves class
				JMenuItem attack1 = new JMenuItem(move.getAttackName(optionAttack[0]));
				JMenuItem attack2 = new JMenuItem(move.getAttackName(optionAttack[1]));
				// TODO Add more attacks
		
				//Adds attacks to menu
				attackMenu.add(attack1);
				attackMenu.add(attack2);
				
				//Action Listener for each attack
				
				//Attack 1
				attack1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BattleWindow bw = new BattleWindow(playerOne, playerTwo, move.getAttackChemical(0), playerOne.isTurn(), move.getGroupNum(0));
						bw.setVisible(true);
						SelectionWindow.this.dispose();
					}	
				});
				
				//Attack 2
				attack2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BattleWindow bw = new BattleWindow(playerOne, playerTwo, move.getAttackChemical(1), playerOne.isTurn(), move.getGroupNum(1));
						bw.setVisible(true);
						SelectionWindow.this.dispose();

					}	
				});
				
				//Show attack menu when clicked upon
				attackMenu.show(SelectionWindow.this, width/6, (height/3)+(height/2));
				attackMenu.setSize(width/2, height/5);		
			}	
		});
		
		//This is for the defend selection button
		SelectionButton defend = new SelectionButton(DEFEND);
		defend.setBounds(4*(width/5) - 80, 3*(height/4), width/4, height/6);
		defend.setFont(new Font("Arial", Font.BOLD, 30));
		defend.setText("DEFEND");
		defend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPopupMenu defendMenu = new JPopupMenu("Defend");
				
				//Once we have more attacks RNG goes here
				//TODO Random number generator
				//Spits out an array:
				
				int optionDefend[] = {0, 1};
				
				//Makes the random numbers into random moves from Moves class
				JMenuItem defend1 = new JMenuItem(move.getDefendName(optionDefend[0]));
				JMenuItem defend2 = new JMenuItem(move.getDefendName(optionDefend[1]));
				// TODO Add more defends
		
				//Adds defends to menu
				defendMenu.add(defend1);
				defendMenu.add(defend2);
			
				//Action Listener for each defend
				
				//Defend 1
				defend1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BattleWindow bw = new BattleWindow(playerOne, playerTwo, move.getDefendChemical(0), playerOne.isTurn(), move.getGroupNum(0));
						bw.setVisible(true);
						SelectionWindow.this.dispose();
					}	
				});
				
				//Defend 2
				defend2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BattleWindow bw = new BattleWindow(playerOne, playerTwo, move.getDefendChemical(1), playerOne.isTurn(), move.getGroupNum(1));
						bw.setVisible(true);
						SelectionWindow.this.dispose();

					}	
				});
				
				
				//Show defend menu when clicked upon
				defendMenu.show(SelectionWindow.this, (width/6)+(width/2), (height/3)+(height/2));
				defendMenu.setSize(width/2, height/5);	
			}
		});
		
		//Add everything to the JFrame
		JOptionPane.showMessageDialog(this, whoseTurn.getName());
		add(power);
		add(health);
		add(attack);
		add(defend);
		add(backgroundImage);
	}
	
}
