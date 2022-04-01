import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bouncing extends JPanel implements ActionListener{

	
	double x = 0, y = 0, velx = 2, vely = 2;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x,y,40,40);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(x<0 |x>560) {
			velx = -velx;
		}
		if(y<0 |y>360) {
			vely = -vely;
		}
		x+=velx;
		y+=vely;
		repaint();
		try{
        	Thread.sleep(10);
        }catch(Exception E){
        	
        }   
		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Bouncing");
	}
}
