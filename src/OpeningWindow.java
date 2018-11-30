import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;

//WORKING ON AN OPENING WHICH WITH HAVE THE LOGO AS WELL AS A BUTTON TO START, 
//MAYBE SOUND TOO...AT THE MOMENT, IT IS HARD TO GET THE START BUTTON TO WORK AS
//I WANT
public class OpeningWindow extends JFrame {

	private int width;
	private int height;
	private boolean cont = true;

	public OpeningWindow() {
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() / 2;
		height = (int)(screenSize.getHeight() / 1.2);
		setSize(width, height);
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//Background Image
		//getContentPane().setBackground(Color.YELLOW);
	
		//Logo
		JLabel title = new JLabel();
		title.setText("ORGANOBATTLE");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setBounds(width/2 - width/6, height/2 - height/10, width, height);
		
		add(title);
		
		//Menu
		JButton start = new JButton();
		start.setBounds(80, 3*(height/4), width/4, height/6);
		start.setFont(new Font("Arial", Font.BOLD, 30));
		start.setText("START");
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpeningWindow.this.dispose();
				cont = false;
			}
		
		
	});
		add(start);
		//while(cont);
	
}
}
