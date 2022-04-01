import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BloodDrive extends JPanel implements ActionListener{

	JFrame frame;
	JPanel contentPane;
	JLabel blood1, blood2, blood3, blood4, blood5;
	JTextField input1, input2, input3, input4, input5;
	JButton enter;
	
	BloodDrive(){
		frame = new JFrame("BloodDrive");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800,800));
		contentPane.setLayout(new GridLayout(5,2,30,30));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,400,10));
		
		blood1 = new JLabel("Donation 1");
		blood2 = new JLabel("Donation 2");
		blood3 = new JLabel("Donation 3");
		blood4 = new JLabel("Donation 4");
		blood5 = new JLabel("Donation 5");
		
		input1 = new JTextField(10);
		input2 = new JTextField(10);
		input3 = new JTextField(10);
		input4 = new JTextField(10);
		input5 = new JTextField(10);
		input5.setActionCommand("enter");
		input5.addActionListener(this);
		
		contentPane.add(blood1);
		contentPane.add(input1);
		contentPane.add(blood2);
		contentPane.add(input2);
		contentPane.add(blood3);
		contentPane.add(input3);
		contentPane.add(blood4);
		contentPane.add(input4);
		contentPane.add(blood5);
		contentPane.add(input5);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	

	public void actionPerformed(ActionEvent event) {
		
		if((event.getActionCommand()).equals("enter")) {
			
			paintComponent(contentPane.getGraphics());
			
			frame.pack();
			frame.setVisible(true);
			
		}
			
	}
		

	public void paintComponent(Graphics g) {
		try {
			super.paintComponent(g);
			int one = Integer.parseInt(input1.getText());
			int two = Integer.parseInt(input2.getText());
			int three = Integer.parseInt(input3.getText());
			int four = Integer.parseInt(input4.getText());
			int five = Integer.parseInt(input5.getText());
			
			
			g.setColor(Color.black);
			g.drawLine(100, 730, 100, 430);
			
			g.drawString("Donation 1", 20, 460);
			g.drawString("Donation 2", 20, 520);
			g.drawString("Donation 3", 20, 580);
			g.drawString("Donation 4", 20, 640);
			g.drawString("Donation 5", 20, 700);
			
			int largest = 0; 
			boolean zero = true;
			int[] donations = {one, two, three, four, five};
			for(int i = 0; i<donations.length; i++) {
				if(donations[i]>largest)
					largest = donations[i];
				if(largest!=0)
					zero = false;
			}
			if(!zero) {
				double big = (double) largest;
				double first = (double) one;
				double second = (double) two;
				double third = (double) three;
				double fourth = (double) four;
				double fifth = (double) five;
				
				g.setColor(Color.red);
				//one
				g.drawLine(100, 460, (int)(((first/largest)*600)+100), 460);
				//two
				g.drawLine(100, 520, (int)(((second/largest)*600)+100), 520);
				//three
				g.drawLine(100, 580, (int)(((third/largest)*600)+100), 580);
				//four
				g.drawLine(100, 640, (int)(((fourth/largest)*600)+100), 640);
				//five
				g.drawLine(100, 700, (int)(((fifth/largest)*600)+100), 700);
			}
		
			frame.pack();
			frame.setVisible(true);
		}catch(Exception e) {
			
		}
	}  

	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		BloodDrive test = new BloodDrive();		
	}
	
	public static void main(String[] args) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					runGUI();
				}

			});
			
		}

}


