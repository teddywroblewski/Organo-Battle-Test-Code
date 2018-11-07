import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BenzeneGroup.Benzene;
import BenzeneGroup.Chemical;

// have every reaction available to click, however if click one that does not work, fail and give error message
// this allows us to keep only one window open 
public class BattleWindow extends JFrame {

	private Chemical chemical;
	
	private class ReactionButton extends JButton {
		private int number;
		public ReactionButton(int number) {
			this.number = number;
		}
		public int getNumber() {return number; }
	}
	
	public BattleWindow() {
		
		chemical = new Benzene();
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(null);
		
		// placeholder for picture
		JLabel chemicalName = new JLabel();
		chemicalName.setText(chemical.getName());
		chemicalName.setBounds(200, 200, 200, 100);
		add(chemicalName);
		
		ReactionButton reactionOne = new ReactionButton(1);
		ReactionButton reactionTwo = new ReactionButton(2);
		ReactionButton reactionThree = new ReactionButton(3);
		ReactionButton reactionFour = new ReactionButton(4);
		
		//First Reaction Button
		reactionOne.setBounds(10, 400, 100, 30);
		reactionOne.setText(chemical.textOptionOne());
		reactionOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedUpon(((ReactionButton) e.getSource()).getNumber());
				reactionOne.setText(chemical.textOptionOne());
				reactionTwo.setText(chemical.textOptionTwo());
				reactionThree.setText(chemical.textOptionThree());
				reactionFour.setText(chemical.textOptionFour());
				chemicalName.setText(chemical.getName());
			}
		});
		
		add(reactionOne);
		
		//Second Reaction Button
		
		reactionTwo.setBounds(100, 400, 100, 30);
		reactionTwo.setText(chemical.textOptionTwo());
		reactionTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedUpon(((ReactionButton) e.getSource()).getNumber());
				reactionOne.setText(chemical.textOptionOne());
				reactionTwo.setText(chemical.textOptionTwo());
				reactionThree.setText(chemical.textOptionThree());
				reactionFour.setText(chemical.textOptionFour());
				chemicalName.setText(chemical.getName());
			}
		});
		
		add(reactionTwo);
		
		//Third Reaction Button
		reactionThree.setBounds(200, 400, 100, 30);
		reactionThree.setText(chemical.textOptionThree());
		reactionThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedUpon(((ReactionButton) e.getSource()).getNumber());
				reactionOne.setText(chemical.textOptionOne());
				reactionTwo.setText(chemical.textOptionTwo());
				reactionThree.setText(chemical.textOptionThree());
				reactionFour.setText(chemical.textOptionFour());
				chemicalName.setText(chemical.getName());
			}
		});
		
		add(reactionThree);
		
		//Fourth Reaction Button
		reactionFour.setBounds(300, 400, 100, 30);
		reactionFour.setText(chemical.textOptionFour());
		reactionFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedUpon(((ReactionButton) e.getSource()).getNumber());
				reactionOne.setText(chemical.textOptionOne());
				reactionTwo.setText(chemical.textOptionTwo());
				reactionThree.setText(chemical.textOptionThree());
				reactionFour.setText(chemical.textOptionFour());
				chemicalName.setText(chemical.getName());
			}
		});
		
		add(reactionFour);
	}
	
	private void clickedUpon(int action) {
		switch (action) {
			case 1: chemical = chemical.optionOne();
					break;
			case 2: chemical = chemical.optionTwo();
					break;
			case 3: chemical = chemical.optionThree();
					break;
			case 4: chemical = chemical.optionFour();
					break;
		}
	}
	
	
}
