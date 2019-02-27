//Teddy Working on this

//import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.Timer;
//
//public class ScientistAnimation {
//	private int x = 0;
//	private int y = 0;
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	private int width  = (int) screenSize.getWidth() / 2;
//	private int height = (int) (screenSize.getHeight() / 1.2);
//	ImageIcon scientist = new ImageIcon("scientist.jpeg");
//	Image sci = scientist.getImage();
//	Image temp2 = sci.getScaledInstance(width / 2, height / 2, java.awt.Image.SCALE_SMOOTH);
//	scientist = new ImageIcon(temp2); // transform it back
//
//	public ScientistAnimation() {
//		Timer timer = new Timer(40, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				moveScientist();
//				redraw();
//			}
//		});
//		timer.start();
//	}
//
//	protected void moveScientist() {
//		x++;
//		y++;
//	}
//
//	protected void redraw() {
//		add(scientistImage);
//	}
//
//}
//
