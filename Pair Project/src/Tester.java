import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class Tester {
	int x=0;
	int y=100;
	int velx = 2, vely = 2;
	int x2 = 100, y2 = 0, velx2 = 2, vely2 = 2;
	int x3 = 950, y3 = 100, velx3 = -2, vely3 = -2;
	public boolean loop = true;
	
	public void play() {
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    DrawPanel draw = new DrawPanel();
	    frame.getContentPane().add(draw);
	    frame.setSize(800,800);
	    frame.setBackground(Color.green);
	    frame.setVisible(true);
	    while(loop) {
	    	if(x<0||x>950)
	    		velx = -velx;
	    	if(y<0||y>630)
	    		vely = -vely;
	    	x+=velx;
	    	y+=vely;
	    	
	    	if(x2<0||x2>950)
	    		velx2 = -velx2;
	    	if(y2<0||y2>630)
	    		vely2 = -vely2;
	    	x2+=velx2;
	    	y2+=vely2;
	        
	    	if(x3<0||x3>950)
	    		velx3 = -velx3;
	    	if(y3<0||y3>630)
	    		vely3 = -vely3;
	    	x3+=velx3;
	    	y3+=vely3;
	        
	        draw.repaint();  //tells the panel to redraw itself so we can see the circle in new location
	        try{
	        	Thread.sleep(10);
	        }catch(Exception e){
	        	
	        }   
	    }
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
	        //g.setColor(Color.RED);
	        //g.fillOval(x,y,50,50);
	        //g.setColor(Color.BLUE);
	        //g.fillOval(x2,y2,50,50);
	        //g.setColor(Color.RED);
	       // g.fillOval(x3,y3,50,50);
	        ImageIcon i = new ImageIcon("images/soccerball3.png");
	        i.paintIcon(this, g, x3, y3);
		}
	}
	
	public void mouseClickedAction() {
		loop = !loop;
	}
	 
	 
	public static void main(String[] args)  {
		Tester circle=new Tester();
	    circle.play();
	}
}



