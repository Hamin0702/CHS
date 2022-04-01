import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisibleBy3 implements ActionListener{

	JFrame frame;
	JPanel contentPane;
	JLabel prompt; 
	JLabel result;
	JTextField checkInt;
	JButton check;
	
	public DivisibleBy3() {
		frame = new JFrame("DivisibleBy3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0,2,10,5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		prompt = new JLabel("Enter an integer");
		contentPane.add(prompt);
		
		checkInt = new JTextField(10);
		contentPane.add(checkInt);
		
		check = new JButton("Check");
		check.setActionCommand("Check");
		check.addActionListener(this);
		contentPane.add(check);
		
		result = new JLabel(" ");
		contentPane.add(result);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if(eventName.equals("Check")) {
			try {
				String message = "";
				String input = checkInt.getText();
				int number = Integer.parseInt(input);
				if(number%3==0) {
					message = "Number is divisible by 3";
				}else {
					message = "Number is not divisible by 3";
				}
				result.setText(message);
				frame.pack();
				frame.setVisible(true);
			}catch(Exception e) {
				result.setText("Oops, try again");
				frame.pack();
				frame.setVisible(true);
			}
		}
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		DivisibleBy3 test = new DivisibleBy3();		
	}
	
	public static void main(String[] args) {
//		Methods that create and show a GUI should be run from an event-dispatching thread
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					runGUI();
				}

			});
			
		}
	
}
