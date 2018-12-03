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
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;

//This class accounts for the opening window of the game:

public class OpeningWindow extends JFrame {

	//Variables
	private static final long serialVersionUID = 1L;
	private int windowwidth;
	private int windowheight;
	
	//Constructor
	OpeningWindow(PlayerOne playerOne, PlayerTwo playerTwo) {

		//Set up JFrame Container
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		windowwidth = (int)screenSize.getWidth() / 2;
		windowheight = (int)(screenSize.getHeight() / 1.2);
		setSize(windowwidth, windowheight);
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//Background Image Icon
		ImageIcon hs = new ImageIcon("OBHP.jpeg");
		Image i = hs.getImage();
		Image temp = i.getScaledInstance(windowwidth, windowheight,  java.awt.Image.SCALE_SMOOTH);
		hs = new ImageIcon(temp);
      JLabel hsImage = new JLabel(hs);
      hsImage.setLocation(windowwidth/2, windowheight/2);
      hsImage.setBounds(0, 0, windowwidth, windowheight);	
		
		//Start Button
		JButton startButton = new JButton();
		int buttonwidth = windowwidth/2;
		startButton.setBounds(windowwidth/2-buttonwidth/2, 3*(windowheight/4), buttonwidth, windowheight/10);
		startButton.setFont(new Font("Courier New", Font.ROMAN_BASELINE, 30));
		startButton.setText("START");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectionWindow sW = new SelectionWindow(playerOne, playerTwo);
				sW.setVisible(true);
				OpeningWindow.this.dispose();
			}


		});
		
		add(startButton);
		add(hsImage);

	}
}