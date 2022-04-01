import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JLabel.*;

public class Roll implements ActionListener{

	JFrame frame;
	JPanel contentPane;
	JButton rollDie1, rollDie2;
	JLabel dieFace1, dieFace2;
	
	public Roll() {
		frame = new JFrame("Roll");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		contentPane.setBackground(Color.white);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		dieFace1 = new JLabel(new ImageIcon("src/die1.gif"));
		dieFace1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		dieFace1.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		contentPane.add(dieFace1);
		
		dieFace2 = new JLabel(new ImageIcon("src/die1.gif"));
		dieFace2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		dieFace2.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		contentPane.add(dieFace2);
		
		rollDie1 = new JButton("Roll Die 1");
		rollDie1.setActionCommand("dice1");
		rollDie1.setAlignmentX(JButton.CENTER_ALIGNMENT);
		rollDie1.addActionListener(this);
		contentPane.add(rollDie1);
		
		rollDie2 = new JButton("Roll Die 2");
		rollDie2.setActionCommand("dice2");
		rollDie2.setAlignmentX(JButton.CENTER_ALIGNMENT);
		rollDie2.addActionListener(this);
		contentPane.add(rollDie2);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {	
		String command = event.getActionCommand();
		Random rand = new Random();
		int newRoll = rand.nextInt(6)+1;
		
		if(command.equals("dice1")) {
			if(newRoll==1) {
				dieFace1.setIcon(new ImageIcon("src/die1.gif"));
			} else if(newRoll==2) {
				dieFace1.setIcon(new ImageIcon("src/die2.gif"));
			}else if(newRoll==3) {
				dieFace1.setIcon(new ImageIcon("src/die3.gif"));
			}else if(newRoll==4) {
				dieFace1.setIcon(new ImageIcon("src/die4.gif"));
			}else if(newRoll==5) {
				dieFace1.setIcon(new ImageIcon("src/die5.gif"));
			}else if(newRoll==6) {
				dieFace1.setIcon(new ImageIcon("src/die6.gif"));
			}
		}
		
		if(command.equals("dice2")) {
			if(newRoll==1) {
				dieFace2.setIcon(new ImageIcon("src/die1.gif"));
			} else if(newRoll==2) {
				dieFace2.setIcon(new ImageIcon("src/die2.gif"));
			}else if(newRoll==3) {
				dieFace2.setIcon(new ImageIcon("src/die3.gif"));
			}else if(newRoll==4) {
				dieFace2.setIcon(new ImageIcon("src/die4.gif"));
			}else if(newRoll==5) {
				dieFace2.setIcon(new ImageIcon("src/die5.gif"));
			}else if(newRoll==6) {
				dieFace2.setIcon(new ImageIcon("src/die6.gif"));
			}
		}
		
		rollDie1.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		rollDie1.setForeground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		rollDie2.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		rollDie2.setForeground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		contentPane.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Roll test = new Roll();		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
			
	}
}
