import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class Bounce implements MouseListener{
	public boolean loop = true;
	
	public void play () {
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    DrawPanel draw = new DrawPanel();
	    frame.getContentPane().add(draw);
	    frame.setSize(1000,700);
	    frame.setVisible(true);
	    while(loop) {
	        draw.repaint(); 
	        try{
	        	Thread.sleep(10);
	        }catch(Exception e){
	        	
	        }   
	    }
	    
	}

	class DrawPanel extends JPanel{
		// x & y = starting points, velx & vely = velocity of the ball
		int x1 = 0, y1 = 100, velx1 = 2, vely1 = 2;
		int x2 = 100, y2 = 0, velx2 = 2, vely2 = 2;
		int x3 = 750, y3 = 100, velx3 = -2, vely3 = -2;
		int x4 = 750, y4 = 500, velx4 = -2, vely4 = -2;
		Color a = Color.RED;
		Color b = Color.BLUE;
		Color c = Color.GREEN;
		Color d = Color.YELLOW;
		
	
		public void paintComponent(Graphics g){
			background(g);
			//outer(g);
			//center(g);
//	        ball1(g);
//	        ball2(g);
//	        ball3(g);
//	        ball4(g);
		}
		
		public void background(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		
		public void outer(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillOval(250,100,500,500);
		}
		
		public void center(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillOval(400,250,200,200);
		}
		
		public void b1(Graphics g) {
			
			if(x1<0||x1>750) {
	    		velx1 = -velx1;
	    		a = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y1<0||y1>750) {
	    		vely1 = -vely1;
	    		a = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x1+=velx1;
	    	y1+=vely1;
			g.setColor(a);
	        g.fillOval(x1,y1,50,50);
		}
		
		public void b2(Graphics g) {
			
			if(x2<0||x2>750) {
	    		velx2 = -velx2;
	    		b = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y2<0||y2>750) {
	    		vely2 = -vely2;
	    		b = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x2+=velx2;
	    	y2+=vely2;
			g.setColor(b);
	        g.fillOval(x2,y2,50,50);
		}
		
		public void b3(Graphics g) {
			
			if(x3<0||x3>750) {
	    		velx3 = -velx3;
	    		c = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y3<0||y3>750) {
	    		vely3 = -vely3;
	    		c = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x3+=velx3;
	    	y3+=vely3;
			g.setColor(c);
	        g.fillOval(x3,y3,50,50);
		}
		
		public void b4(Graphics g) {
			
			if(x4<0||x4>750) {
	    		velx4 = -velx4;
	    		d = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y4<0||y4>750) {
	    		vely4 = -vely4;
	    		d = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x4+=velx4;
	    	y4+=vely4;
			g.setColor(d);
	        g.fillOval(x4,y4,50,50);
		}
	}
	
	
	
	
	 
	 
	public static void main(String[] args)  {
		Bounce bounce=new Bounce();
		bounce.play();
	}






	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}







