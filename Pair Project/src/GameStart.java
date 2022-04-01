import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GameStart extends JPanel{

	GameStart(){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 800));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Oxygen", Font.BOLD, 44));
		g.setColor(Color.red);
		g.drawString("Penalty Shootout", 200,100);
		
		g.setFont(new Font("Arial", Font.ITALIC, 20));
		g.setColor(Color.black);
		g.drawString("Andrew Yi and Hamin Han", 280, 130);
		
		g.setFont(new Font("Arial",Font.BOLD, 50));
		g.setColor(Color.GREEN);
		g.fillRect(300, 600, 200, 100);
		g.setColor(Color.white);
		g.drawString("Start", 340, 670);
		
		g.setColor(new Color(51,153,255));
		g.fillOval(250, 200, 300, 300);
		
		g.setColor(new Color(51,204,255));
		g.fillOval(300, 250, 200, 200);
		
		ImageIcon ball = new ImageIcon("images/soccerball3.png");
		ball.paintIcon(this, g, 300, 220);
		
	}
	
	public boolean mouseClicked(int x, int y) {
		if(x<500 && x>300 && y>600 && y<700)
			return true;
		return false;
	}
	
	public static void main (String args[]) {
		JFrame display = new JFrame();
		display.setResizable(false);
		GameStart panel = new GameStart();
		display.add(panel);
		panel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				System.out.println(panel.mouseClicked(e.getX(), e.getY()));
			}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
			
		});
		display.pack();
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setVisible(true);	
	}
	
}

