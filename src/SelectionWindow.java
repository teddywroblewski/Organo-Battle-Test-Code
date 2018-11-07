import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;


public class SelectionWindow extends JFrame {
	
	static final int ATTACK = 1;
	static final int DEFEND = 2;
	static final int RECHARGE = 3;
	
	static int playerOneHealth = 100;
	static int playerOnePower = 20;

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
	
	public SelectionWindow() {
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(null);
		
		JProgressBar health = new JProgressBar();
		health.setStringPainted(true);
		health.setString("Health");
		health.setForeground(new Color(255,0,0));
		health.setValue(playerOneHealth);
		health.setMaximum(100);
		health.setMinimum(0);
		health.setBounds(50, 10, 400, 25);
		add(health);
		
		JProgressBar power = new JProgressBar();
		power.setStringPainted(true);
		power.setString("Power");
		power.setForeground(new Color(255, 255, 0));
		power.setValue(playerOnePower);
		power.setMaximum(20);
		power.setMinimum(0);
		power.setBounds(50, 250, 400, 25);
		add(power);
		
		SelectionButton attack = new SelectionButton(ATTACK);
		SelectionButton defend = new SelectionButton(DEFEND);
		
		attack.setBounds(10, 375, 100, 75);
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
						BattleWindow bw = new BattleWindow();
						bw.setVisible(true);
						SelectionWindow.this.dispose();

					}	
				});
				attackMenu.show(SelectionWindow.this, 250, 250);
			}	
		});
		
		defend.setBounds(370, 375, 100, 75);
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
