import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Trials extends JPanel{
	
	GeneralPath vane = new GeneralPath();
	
	int number;
	
	float size;
	
	double[] limits = new double[] {0,7,4,-1};
	
	Trials(){
		
		setPreferredSize(new Dimension(720,500));
		
		vane.moveTo(0, 0);
		vane.lineTo(0.5, 0.1);
		vane.lineTo(1.5,0);
		vane.lineTo(0.5, -0.1);
		vane.closePath();
		
	}
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.BLACK);
		g2D.fill(new Rectangle2D.Double(-0.05,0.2,0.1,2.8));
		g2D.translate(0, 3);
		g2D.rotate(-number);
		g2D.setColor(new Color(138, 43, 226));
		
		for (int i = 1; i<=6; i++) {
			g2D.rotate(Math.PI/3);
			g2D.fill(vane);
		}
		
	}
	

	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setContentPane(new Trials());
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}