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
import javax.swing.JOptionPane;

import BenzeneGroup.Benzene;
import BenzeneGroup.Chemical;

// have every reaction available to click, however if click one that does not work, fail and give error message
// this allows us to keep only one window open 
public class BattleWindow extends JFrame {

	private Chemical chemical;
	private String targetChemical;
	private Player whoseGettingAttacked;
	private Player whoseTurn;
	private PlayerOne playerOne;
	private PlayerTwo playerTwo;
	private int width;
	private int height;
	private Image molecule;
	
	
	private class ReactionButton extends JButton {
		private int number;
		public ReactionButton(int number) {
			this.number = number;
		}
		public int getNumber() {return number; }
	}
	
	public BattleWindow(PlayerOne playerOne, PlayerTwo playerTwo, String targetChemical, boolean whosePlaying) {
		
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() / 2;
		height = (int)(screenSize.getHeight() / 1.2);
		
		if (whosePlaying) {
			whoseGettingAttacked = playerTwo;
			whoseTurn = playerOne;
			this.playerOne.setTurn(false);
			this.playerTwo.setTurn(true);
		} else {
			whoseGettingAttacked = playerOne;
			whoseTurn = playerTwo;
			this.playerTwo.setTurn(false);
			this.playerOne.setTurn(true);
		}
		
		
		chemical = new Benzene();
		this.targetChemical = targetChemical;
		
		setSize(width, height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(null);
		
		//Implementing the first image and text 
		
		ImageIcon chemicalPic = new ImageIcon(chemical.getFile());
		Image chemImage = chemicalPic.getImage();
		Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		chemicalPic = new ImageIcon(temp);
        JLabel chemicalName = new JLabel(chemicalPic);
		chemicalName.setText(chemical.getName());
		chemicalName.setBounds(width/2 - width/6, height/2 - height/10, width/3, height/5);
		add(chemicalName);
		
		ReactionButton reactionOne = new ReactionButton(1);
		ReactionButton reactionTwo = new ReactionButton(2);
		ReactionButton reactionThree = new ReactionButton(3);
		ReactionButton reactionFour = new ReactionButton(4);
		
		//First Reaction Button
		reactionOne.setBounds(10, (int)height-100, (int)width/5, (int)height/15);
		reactionOne.setText(chemical.textOptionOne());
		reactionOne.setFont(new Font("Arial", Font.PLAIN, 12));
		reactionOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedUpon(((ReactionButton) e.getSource()).getNumber());
				reactionOne.setText(chemical.textOptionOne());
				reactionTwo.setText(chemical.textOptionTwo());
				reactionThree.setText(chemical.textOptionThree());
				reactionFour.setText(chemical.textOptionFour());
				chemicalName.setText(chemical.getName());
				
				//This is for the image
				ImageIcon chemicalPic1 = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPic1.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPic1 = new ImageIcon(temp);
				
				chemicalName.setIcon(chemicalPic1);
				
			}
		});
		
		add(reactionOne);
		
		//Second Reaction Button
		
		reactionTwo.setBounds((int)width/4 + 10, (int)height-100, (int)width/5, (int)height/15);
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
				
				ImageIcon chemicalPic2 = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPic2.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPic2 = new ImageIcon(temp);
				
				chemicalName.setIcon(chemicalPic2);
				
			}
		});
		
		add(reactionTwo);
		
		//Third Reaction Button
		reactionThree.setBounds((int)(2*(width/4)) + 10, (int)height-100, (int)width/5, (int)height/15);
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
				
				ImageIcon chemicalPic3 = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPic3.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPic3 = new ImageIcon(temp);
				
				chemicalName.setIcon(chemicalPic3);
			}
		});
		
		add(reactionThree);
		
		//Fourth Reaction Button
		reactionFour.setBounds((int)(3*(width/4)) + 10, (int)height-100, (int)width/5, (int)height/15);
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
				
				ImageIcon chemicalPic4 = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPic4.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPic4 = new ImageIcon(temp);
				
				chemicalName.setIcon(chemicalPic4);
			}
		});
		
		add(reactionFour);
	}
	
	private void clickedUpon(int action) {
		switch (action) {
			case 1: chemical = chemical.optionOne();
					whoseTurn.setPower(whoseTurn.getPower() - 1);
					break;
			case 2: chemical = chemical.optionTwo();
					whoseTurn.setPower(whoseTurn.getPower() - 1);
					break;
			case 3: chemical = chemical.optionThree();
					whoseTurn.setPower(whoseTurn.getPower() - 1);
					break;
			case 4: chemical = chemical.optionFour();
					whoseTurn.setPower(whoseTurn.getPower() - 1);
					break;
		}
		if (chemical.isFinal()) {
			if (chemical.getName().equalsIgnoreCase(targetChemical)) {
				JOptionPane.showMessageDialog(this, "Successfully made " + chemical.getName());
				whoseGettingAttacked.setHealth(whoseGettingAttacked.getHealth() - 10);
				new SelectionWindow(playerOne, playerTwo).setVisible(true);
				BattleWindow.this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Did not make " + targetChemical + " made " + chemical.getName());
				new SelectionWindow(playerOne, playerTwo).setVisible(true);
				BattleWindow.this.dispose();
			}
		}
	}
	
	
}
