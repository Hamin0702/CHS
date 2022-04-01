import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GameEnd extends JPanel{
	
	private boolean won = false;

	GameEnd(boolean player){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 800));
		setLayout(null);
		won = player;
	}
	
	GameEnd(){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 800));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// if lose
		ImageIcon lose = new ImageIcon("images/youlose.jpg");
		//lose.paintIcon(this, g, 20, 60);
		// if win
		ImageIcon win = new ImageIcon("images/youwin.jpeg");
		if(won)
			win.paintIcon(this, g, 190, 170);
		if(!won)
			lose.paintIcon(this, g, 20, 60);
		g.setFont(new Font("Oxygen", Font.BOLD, 44));
		g.setColor(Color.red);
		//g.setColor(Color.green); green if win
		g.drawString("Game Over", 270,100);
		
		g.setFont(new Font("Arial",Font.BOLD, 50));
		g.setColor(Color.GREEN);
		g.fillRect(300, 620, 200, 100);
		g.setColor(Color.white);
		g.drawString("Restart", 310, 690);
		
	}
	
	public boolean mouseClicked(int x, int y) {
		if(x<500 && x>300 && y>600 && y<700)
			return true;
		return false;
	}
	
	public static void main (String args[]) {
		JFrame display = new JFrame();
		display.setResizable(false);
		GameEnd panel = new GameEnd();
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



