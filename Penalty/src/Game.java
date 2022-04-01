import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Game {
	//ball coord
	int a = 300,b = 470;
	//keeper coord
	int Kx = 370, Ky = 80;
	
	public boolean startS = true;
	public boolean gameS = false;
	public boolean endS = false;
	
	public boolean reset = true;
	public boolean gg = false;
	
	public boolean playerW = false;
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;

	private int playerScore = 0;
	private int compScore = 0;


	JFrame frame = new JFrame();
	DrawPanel draw = new DrawPanel();
	
	public Game() {
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    draw.addMouseListener(new MyMouseListener());
	    frame.getContentPane().add(draw);
	    frame.setSize(800,800);
	    frame.setVisible(true);
	}
	
	public void defaultSettings() {
		a = 300; b = 470;
		Kx = 370; Ky = 80;
		startS = true; gameS = false; endS = false;
		reset = true;
		playerW = false;
		gg = false;
		playerScore = 0; compScore = 0;
	}
	
	class DrawPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(startS) {
				drawStart(g);
			}
			if(gameS) {
				drawBackground(g);
				drawKeeper(g);
				drawBall(g);
				drawPoints(g);
			}
			if(endS) {
				drawEnd(g);
			}
		}
		
		public void drawStart(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 800, 800);
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
		
		public void drawBackground(Graphics g) {
			g.setColor(Color.green);
			g.fillRect(0, 0, 800, 800);
			g.setColor(Color.white);
			for(int i =95;i<650;i+=3) {
				g.fillOval(i,40 ,30, 30);
			}
			for(int i =40;i<300;i+=3) {
				g.fillOval(95,i ,30, 10);
				g.fillOval(660,i ,30, 10);
			}
			
			g.drawRect(100,710,170,60);
			g.drawRect(330,710,140,60);
			g.drawRect(520,710,210,60);
			
			Font myFont = new Font("Courier New",1,70);
			g.setFont(myFont);
			g.drawString("LEFT", 100, 760);
			g.drawString("MID", 340, 760);
			g.drawString("RIGHT", 520, 760);
		}
		
		public void drawBall(Graphics g) {
			ImageIcon i = new ImageIcon("images/soccerball3.png");
			i.paintIcon(this, g, a, b);
		}
		
		public void drawKeeper(Graphics g) {
			g.setColor(new Color(51,153,255));
			g.fillRect(Kx, Ky, 50, 200);
		}
		
		public void drawPoints(Graphics g) {
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("First to 5 points wins!", 280, 400);
			g.drawString("Player:", 20, 400);
			g.drawString("" + playerScore, 20, 430);
			g.drawString("Computer:", 650, 400);
			g.drawString("" + compScore, 650, 430);
		}
		
		public void drawEnd(Graphics g) {
			// if lose
			ImageIcon lose = new ImageIcon("images/youlose.jpg");
			//lose.paintIcon(this, g, 20, 60);
			// if win
			ImageIcon win = new ImageIcon("images/youwin.jpeg");
			if(playerW)
				win.paintIcon(this, g, 190, 170);
			if(!playerW)
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
	}
	
	public class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(startS)
				SmouseClicked(e.getX(),e.getY());
			if(gameS)
				GmouseClicked(e.getX(),e.getY());
			if(endS)
				EmouseClicked(e.getX(),e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void SmouseClicked(int x, int y) {
			if(x<500 && x>300 && y>600 && y<700) {
				startS = false;
				gameS = true;
				draw.repaint();
			}
			
		}
		
		public void GmouseClicked(int x, int y) {
			if(gg) {
				gameS = false;
				endS = true;
				draw.repaint();
			}
			if(reset) {
				int computer = (int) (Math.random() *3);

				//left
				if(x<270 && x>100 && y>710 && y<770) {
					reset = false;
					a = 110;
					b = 20;
					if(computer == 0) {
						compScore++;
						Kx = 200;
					}else if(computer == 1) {
						playerScore++;
						Kx = 370;
					}else if(computer == 2) {
						playerScore++;
						Kx = 540;
					}
					draw.repaint();
				}
				//mid
				else if(x<470 && x>330 && y>710 && y<770) {
					reset = false;
					a = 300;
					b = 20;
					if(computer == 0) {
						playerScore++;
						Kx = 200;
					}else if(computer == 1) {
						compScore++;
						Kx = 370;
					}else if(computer == 2) {
						playerScore++;
						Kx = 540;
					}
					draw.repaint();
				}
				//right
				else if(x<730 && x>520 && y>710 && y<770) {
					reset = false;
					a = 490;
					b = 20;
					if(computer == 0) {
						playerScore++;
						Kx = 200;
					}else if(computer == 1) {
						playerScore++;
						Kx = 370;
					}else if(computer == 2) {
						compScore++;
						Kx = 540;
					}
					draw.repaint();
				}
				
				if(playerScore == 5 || compScore == 5) {
					gg = true;
					if(playerScore==5)
						playerW = true;
					if(compScore==5)
						playerW = false;
				}
			}else {
				a = 300;
				b = 470;
				Kx = 370;
				draw.repaint();
				reset = true;
			}

		}
		
		public void EmouseClicked(int x, int y) {
			if(x<500 && x>300 && y>600 && y<700) {
				endS = false;
				startS = true;
				defaultSettings();
				draw.repaint();
			}
		}
	}
	public static void main (String args[]) {
		Game game = new Game();
	}
}