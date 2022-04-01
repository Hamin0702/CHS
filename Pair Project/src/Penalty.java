import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Penalty {

	private boolean start = true;
	private boolean game = false;
	private boolean end = false;
	
	JFrame frame = new JFrame();
	DrawPanel draw = new DrawPanel();
	Penalty(){
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.addMouseListener(draw);
	    frame.add(draw);
	    frame.setSize(800,800);
	    frame.setVisible(true);
	}
	public static void main(String[] args) {
		Penalty p = new Penalty();
	}
	public void gameStart() {
		
	}
	
	class DrawPanel extends JPanel implements ActionListener,MouseListener{
		Timer t = new Timer(1,this);
		int x=300,y=470;
		double velX=10,velY=10;
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Color green = new Color(0,240,0);
			draw.setBackground(green);
			g.setColor(Color.white);
			for(int i =95;i<650;i+=3) {
				g.fillOval(i,40 ,40, 40);
			}
			for(int i =40;i<410;i+=3) {
				g.fillOval(95,i ,30, 10);
				g.fillOval(660,i ,30, 10);
			}
			ImageIcon i = new ImageIcon("soccerball3.png");
			i.paintIcon(this, g, x, y);
		
			g.drawRect(100,710,170,60);
			g.drawRect(330,710,140,60);
			g.drawRect(520,710,210,60);
			
			Font myFont = new Font("Courier New",1,70);
			g.setFont(myFont);
			g.drawString("LEFT", 100, 760);
			g.drawString("MID", 340, 760);
			g.drawString("RIGHT", 520, 760);

		}
		public void actionPerformed(ActionEvent e) {
			ImageIcon i = new ImageIcon("soccerball3.png");
			i.paintIcon(this, getGraphics(), 0, 0);
			repaint();
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			 
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();  
			int y = e.getY();  
			 //left button
			 if(y>710&&y<770) {
				if(x>100&&x<270) {
					for(x = 300;x>95&&y>40;x-=velX,y+=velY) {
						t.start();
						System.out.print("a");
						ImageIcon i = new ImageIcon("soccerball3.png");
						i.paintIcon(this, getGraphics(), x, y);
						//t.Thread.sleep(10);
						repaint();
					}
				}
				if(x>330&&x<470) {
						
				}
				//
				if(x>520&&x<730) {
						
				}
			}
			
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
}





