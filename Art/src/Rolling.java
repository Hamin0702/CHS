import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rolling{
	
	public boolean loop = true;
	public boolean outerloop = true;
	public boolean stop = true;
	public boolean color = true;
	int counter = 0;
	int count = 0;
	
	double a = Math.toRadians(22.5);
	double b = Math.toRadians(45);
	
	int one = 660, vel1 = -2;
	int two = 400, vel2 = 2;
	int three = (int) ((150)/(Math.cos(b))), vel3 = 2;
	int four = (int) ((-150)/(Math.cos(b))), vel4 = 2;
	int five = (int)((150+(150*(Math.sqrt(2)/2)))/Math.cos(a)), vel5 = 2;
	int six = -(int)((150-(150*Math.cos(b)))/Math.sin(a)), vel6 = 2;
	int seven = -(int)((150+(150*(Math.sqrt(2)/2)))/Math.cos(a)), vel7 = 2;
	int eight = (int)((150-(150*(Math.sqrt(2)/2)))/Math.sin(a)), vel8 = 2;
	int circle = 0, velc = 1;
	int circle1 = 500, velc1 = 1;
	
	
	int x1 = 0, y1 = 100, velx1 = 2, vely1 = 2;
	int x2 = 100, y2 = 0, velx2 = 2, vely2 = 2;
	int x3 = 750, y3 = 100, velx3 = -2, vely3 = -2;
	int x4 = 750, y4 = 500, velx4 = -2, vely4 = -2;
	int x5 = 375, y5 = 750, velx5 = 5, vely5 = 5;
	int x6 = 375, y6 = 750, velx6 = 4, vely6 = 4;
	int x7 = 375, y7 = 750, velx7 = 3, vely7 = 3;
	int x8 = 375, y8 = 750, velx8 = 2, vely8 = 2;
	int x9 = 375, y9 = 750, velx9 = 1, vely9 = 1;
	Color A = Color.RED;
	Color B = Color.BLUE;
	Color C = Color.GREEN;
	Color D = Color.YELLOW;
	
	
	public void play() {
		
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    DrawPanel draw = new DrawPanel();
	    draw.addMouseListener(new MyMouseListener());
	    frame.getContentPane().add(draw);
	    frame.setSize(800,800);
	    frame.setVisible(true);
	   
	    while(outerloop) {
	    	try{
    			Thread.sleep(1);
    		}catch(Exception e){
        	
    		} 
	    	while(loop) {
	    		draw.repaint(); 
	    		try{
	    			Thread.sleep(10);
	    		}catch(Exception e){
	        	
	    		}   
	    	}
	    }
	}

	public class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(SwingUtilities.isLeftMouseButton(e))
				loop = !loop;
			if(SwingUtilities.isRightMouseButton(e)) {
				vel1 = -vel1;
				vel2 = -vel2;
				vel3 = -vel3;
				vel4 = -vel4;
				vel5 = -vel5;
				vel6 = -vel6;
				vel7 = -vel7;
				vel8 = -vel8;
				velx5 = -velx5;
				velx6 = -velx6;
				velx7 = -velx7;
				velx8 = -velx8;
				velx9 = -velx9;
				vely5 = -vely5;
				vely6 = -vely6;
				vely7 = -vely7;
				vely8 = -vely8;
				vely9 = -vely9;
				velc = -velc;
				velc1 = -velc1;
			}
			if(SwingUtilities.isMiddleMouseButton(e)) {
				stop = !stop;
				color = !color;
			}
	
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
	class DrawPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			b1(g);
			b2(g);
			b3(g);
			b4(g);
			b5(g);
			b6(g);
			b7(g);
			b8(g);
			b9(g);
			progress1(g);
			progress2(g);
			outer(g);
			inner1(g);
			inner(g);
			line1(g);
			line2(g);
			line3(g);
			line4(g);
			line5(g);
			line6(g);
			line7(g);
			line8(g);
			ball1(g);
			ball2(g);
			ball3(g);
			ball4(g);
			ball5(g);
			ball6(g);
			ball7(g);
			ball8(g);
			
		}
		
		public void progress1(Graphics g) {
			g.setColor(new Color(204,0,0));
			g.fillRect(one-100, 750, 220, 50);
		}
		
		public void progress2(Graphics g) {
			g.setColor(new Color(51,204,255));
			g.fillRect(750, two-100, 50, 220);
		}
		
		public void ball1(Graphics g) {
			g.setColor(new Color(204,0,0));
			if(one<100 || one>680) {
				vel1 = -vel1;
			}
			one += vel1;
			
			if(stop) {
				if(one == 660) {
					counter++;
					if(counter>0 && counter%2==0)
						loop = !loop;
				}
				if(one == 100) {
					count++;
					if(count>0 && count%2==1)
						loop =!loop;
				}		
			}
			g.fillOval(one,400-20,40,40);
		}
		
		public void ball2(Graphics g) {
			g.setColor(new Color(51,204,255));
			if(two<100 || two>680) {
				vel2 = -vel2;
			}
			two += vel2;
			g.fillOval(400-20,two,40,40);
		}
		
		public void ball3(Graphics g) {
			int distance = (int)((Math.sqrt(800)-20)*Math.cos(b));
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(three<-300 || three>280) {
				vel3 = -vel3;
			}
			three += vel3;
			g.fillOval(400+(int)(three*Math.cos(b))-distance,400+(int)(three*Math.sin(b))-distance,40,40);
		}
		
		public void ball4(Graphics g) {
			int distancex = (int) (20 + (20*Math.cos(b)));
			int distancey = (int) (20 - (20*Math.sin(b)));
			
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(four<-300 || four>280) {
				vel4 = -vel4;
			}
			four += vel4;
			g.fillOval((400-(int)((four*Math.cos(b)))-distancex),400+(int)(four*Math.sin(b))-distancey,40,40);
		}
		
		public void ball5(Graphics g) {
			int distancex = (int)(20 - (20*Math.cos(a)));
			int distancey = (int)(20 - (20*Math.sin(a)));
			
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(five<-300 || five>280) {
				vel5 = -vel5;
			}
			five += vel5;
			g.fillOval(400+(int)(five*Math.cos(a))-distancex,400+(int)(five*Math.sin(a))-distancey,40,40);
		}
		
		public void ball6(Graphics g) {
			int distancex = (int) (20*Math.sin(a));
			int distancey = (int) (20 - (20*Math.cos(a)));
			
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(six<-300 || six>280) {
				vel6 = -vel6;
			}
			six += vel6;
			g.fillOval(400-(int)(six*Math.sin(a))-20-distancex,400+(int)(six*Math.cos(a))-distancey,40,40);
		}
		
		public void ball7(Graphics g) {
			int distancex = (int) (20 + (20*Math.cos(a)));
			int distancey = (int) (20 - (20*Math.sin(a)));
			
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(seven<-300 || seven>280) {
				vel7 = -vel7;
			}
			seven += vel7;
			g.fillOval(400-(int)(seven*Math.cos(a))-distancex,400+(int)(seven*Math.sin(a))-distancey,40,40);
		}
		
		public void ball8(Graphics g) {
			int distancex = (int) (20 - (20*Math.sin(a)));
			int distancey = (int) (20 - (20*Math.cos(a)));
			
			if(color)
				g.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			if(!color)
				g.setColor(new Color(255,255,0));
			if(eight<-300 || eight>280) {
				vel8 = -vel8;
			}
			eight += vel8;
			g.fillOval(400+(int)(eight*Math.sin(a))-distancex,400+(int)(eight*Math.cos(a))-distancey,40,40);
		}
		
		public void inner(Graphics g) {
			g.setColor(new Color(51,153,255));
			if(circle<0 || circle>600)
				velc = -velc;
			circle += velc;
			int start = (int) ((800 - circle) / 2);
			g.fillOval(start,start,circle,circle);
		}
		
		public void inner1(Graphics g) {
			g.setColor(new Color(0,204,0));
			if(circle1<0 || circle1>600)
				velc1 = -velc1;
			circle1 += velc1;
			int start = (int) ((800 - circle1) / 2);
			g.fillOval(start,start,circle1,circle1);
		}
		
		public void outer(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillOval(100, 100, 600, 600);
		}
		
		public void line1(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(100, 400, 700, 400);
		}
		
		public void line2(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400, 100, 400, 700);
		}
		
		public void line3(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400-(int)(300*Math.cos(b)), 400-(int)(300*Math.sin(b)),400+(int)(300*Math.cos(b)), 400+(int)(300*Math.sin(b)));
		}
		
		public void line4(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400+(int)(300*Math.cos(b)), 400-(int)(300*Math.sin(b)),400-(int)(300*Math.cos(b)), 400+(int)(300*Math.sin(b)));
		}
		
		public void line5(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400-(int)(300*Math.cos(a)), 400-(int)(300*Math.sin(a)),400+(int)(300*Math.cos(a)), 400+(int)(300*Math.sin(a)));
		}
		
		public void line6(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400+(int)(300*Math.sin(a)), 400-(int)(300*Math.cos(a)),400-(int)(300*Math.sin(a)), 400+(int)(300*Math.cos(a)));
		}
		
		public void line7(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400+(int)(300*Math.cos(a)), 400-(int)(300*Math.sin(a)),400-(int)(300*Math.cos(a)), 400+(int)(300*Math.sin(a)));
		}
		
		public void line8(Graphics g) {
			g.setColor(Color.WHITE);
			g.drawLine(400-(int)(300*Math.sin(a)), 400-(int)(300*Math.cos(a)),400+(int)(300*Math.sin(a)), 400+(int)(300*Math.cos(a)));
		}
		
		public void b1(Graphics g) {
			
			if(x1<0||x1>750) {
	    		velx1 = -velx1;
	    		A = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y1<0||y1>750) {
	    		vely1 = -vely1;
	    		A = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x1+=velx1;
	    	y1+=vely1;
	    	if(color)
	    		g.setColor(A);
	    	if(!color)
	    		g.setColor(new Color(102,255,102));
	        g.fillOval(x1,y1,50,50);
		}
		
		public void b2(Graphics g) {
			
			if(x2<0||x2>750) {
	    		velx2 = -velx2;
	    		B = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y2<0||y2>750) {
	    		vely2 = -vely2;
	    		B = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x2+=velx2;
	    	y2+=vely2;
	    	if(color)
	    		g.setColor(B);
	    	if(!color)
	    		g.setColor(new Color(102,255,102));
	        g.fillOval(x2,y2,50,50);
		}
		
		public void b3(Graphics g) {
			
			if(x3<0||x3>750) {
	    		velx3 = -velx3;
	    		C = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y3<0||y3>750) {
	    		vely3 = -vely3;
	    		C = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x3+=velx3;
	    	y3+=vely3;
	    	if(color)
	    		g.setColor(C);
	    	if(!color)
	    		g.setColor(new Color(102,255,102));
	        g.fillOval(x3,y3,50,50);
		}
		
		public void b4(Graphics g) {
			
			if(x4<0||x4>750) {
	    		velx4 = -velx4;
	    		D = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			}
	    	if(y4<0||y4>750) {
	    		vely4 = -vely4;
	    		D = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	    	}
	    	x4+=velx4;
	    	y4+=vely4;
	    	if(color)
	    		g.setColor(D);
	    	if(!color)
	    		g.setColor(new Color(102,255,102));
	        g.fillOval(x4,y4,50,50);
		}
		
		public void b5(Graphics g) {
			
			if(x5<0||x5>750) {
	    		velx5 = -velx5;
			}
	    	if(y5<0||y5>750) {
	    		vely5 = -vely5;
	    	}
	    	x5+=velx5;
	    	y5+=vely5;
			g.setColor(new Color(255,102,0));
	        g.fillOval(x5,y5,50,50);
		}
		
		public void b6(Graphics g) {
			
			if(x6<0||x6>750) {
	    		velx6 = -velx6;
			}
	    	if(y6<0||y6>750) {
	    		vely6 = -vely6;
	    	}
	    	x6+=velx6;
	    	y6+=vely6;
			g.setColor(new Color(255,102,0));
	        g.fillOval(x6,y6,50,50);
		}
		
		public void b7(Graphics g) {
			
			if(x7<0||x7>750) {
	    		velx7 = -velx7;
			}
	    	if(y7<0||y7>750) {
	    		vely7 = -vely7;
	    	}
	    	x7+=velx7;
	    	y7+=vely7;
			g.setColor(new Color(255,102,0));
	        g.fillOval(x7,y7,50,50);
		}
		
		public void b8(Graphics g) {
			
			if(x8<0||x8>750) {
	    		velx8 = -velx8;
			}
	    	if(y8<0||y8>750) {
	    		vely8 = -vely8;
	    	}
	    	x8+=velx8;
	    	y8+=vely8;
			g.setColor(new Color(255,102,0));
	        g.fillOval(x8,y8,50,50);
		}
		
		public void b9(Graphics g) {
			
			if(x9<0||x9>750) {
	    		velx9 = -velx9;
			}
	    	if(y9<0||y9>750) {
	    		vely9 = -vely9;
	    	}
	    	x9+=velx9;
	    	y9+=vely9;
			g.setColor(new Color(255,102,0));
	        g.fillOval(x9,y9,50,50);
		}


		
		
	}
	
	public static void main(String[] args)  {
		Rolling test = new Rolling();
		test.play();
	}

}
