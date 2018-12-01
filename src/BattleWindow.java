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
import benzeneGroup_1.Benzene;
import benzeneGroup_1.Chemical;

//This class is for the molecule building window. FOP, we will reference as "Battle Window"

public class BattleWindow extends JFrame {

	//Variables
	private Chemical chemical;
	private String targetChemical;
	private Player whoAttacks;
	private Player whoReceives;
	private PlayerOne playerOne;
	private PlayerTwo playerTwo;
	private int width;
	private int height;
	private Image molecule;
	
	//Class that makes "reaction button"
	private class ReactionButton extends JButton {
		private int number;
		public ReactionButton(int number) {
			this.number = number;
		}
		public int getNumber() {return number; }
	}
	
	//Constructor
	public BattleWindow(PlayerOne playerOne, PlayerTwo playerTwo, String targetChemical, boolean whosePlaying, int groupNumber) {
		
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		//Sets up JFrame Container
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() / 2;
		height = (int)(screenSize.getHeight() / 1.2);
		setSize(width, height);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
		setLayout(null);
		
		//Changes player for next turn
		if (whosePlaying) {
			whoAttacks = playerTwo;
			whoReceives = playerOne;
			this.playerOne.setTurn(false);
			this.playerTwo.setTurn(true);
		} else {
			whoAttacks = playerOne;
			whoReceives = playerTwo;
			this.playerTwo.setTurn(false);
			this.playerOne.setTurn(true);
		}
		
		//Sets the chemical group and target molecule
		switch (groupNumber) {
			case 1: chemical = new Benzene();
					break;
//			case 2: chemical = new //Set up for next chemical group
//					break;
	
		}
		
		this.targetChemical = targetChemical;
		
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
	
	//Clicked Method
	private void clickedUpon(int action) {
		switch (action) {
			case 1: chemical = chemical.optionOne();
					whoReceives.setPower(whoReceives.getPower() - 1);
					break;
			case 2: chemical = chemical.optionTwo();
					whoReceives.setPower(whoReceives.getPower() - 1);
					break;
			case 3: chemical = chemical.optionThree();
					whoReceives.setPower(whoReceives.getPower() - 1);
					break;
			case 4: chemical = chemical.optionFour();
					whoReceives.setPower(whoReceives.getPower() - 1);
					break;
		}
		if (chemical.isFinal()) {
			if (chemical.getName().equalsIgnoreCase(targetChemical)) {
				
				ImageIcon chemicalPicFinal = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPicFinal.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPicFinal = new ImageIcon(temp);
				
				JOptionPane.showMessageDialog(this, "Sucessfully made " + chemical.getName(), "Sucess", JOptionPane.INFORMATION_MESSAGE, chemicalPicFinal);
				
				whoAttacks.setHealth(whoAttacks.getHealth() - 10);
				new SelectionWindow(playerOne, playerTwo).setVisible(true);
				BattleWindow.this.dispose();
			}
			else {
				
				ImageIcon chemicalPicFinal = new ImageIcon(chemical.getFile());
				Image chemImage = chemicalPicFinal.getImage();
				Image temp = chemImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				chemicalPicFinal = new ImageIcon(temp);
				
				JOptionPane.showMessageDialog(this, "Failed to make target chemical, made  " + chemical.getName(), "Failed", JOptionPane.INFORMATION_MESSAGE, chemicalPicFinal);
				new SelectionWindow(playerOne, playerTwo).setVisible(true);
				BattleWindow.this.dispose();
			}
		}
	}
		
}
