import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class Riddle implements ActionListener {
	final static String riddle =  "Why was the picture sent to jail?";
	final static String answer = "Because it was framed";
	JFrame frame;
	JPanel contentPane;
	JLabel label1;
	JLabel label2;
	JButton button;
	
	public Riddle() {
//		Create and set up the frame
		frame = new JFrame("Riddle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Create a content pane with a BoxLayout and empty borders
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2,2,10,5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
//		Create and add label that is centered and has empty borders
		label1 = new JLabel(riddle);
		label1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		//label.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));
		contentPane.add(label1);
		
		
		
//		Create and add button that is centered
		button = new JButton("Answer");
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setActionCommand("Answer");
		button.addActionListener(this);
		contentPane.add(button);
		
//		Add content pane to frame
		frame.setContentPane(contentPane);
		
//		Size and then display the frame
		frame.pack();
		frame.setVisible(true);
	}
	
	/* 
	 Handle button click action event
	 pre: Action event is Hide or Show
	 post: Clicked button has different text, and label
	 displays message dependng on when the utton was clicked
	 */
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		boolean flag = true;
		if(eventName.equals("Answer") && flag){
			frame = new JFrame("Riddle");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane = new JPanel();
			contentPane.setLayout(new GridLayout(2,2,10,5));
			contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			contentPane.add(label1);
			label2 = new JLabel(answer);
			label2.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
			contentPane.add(label2);
			//button.setActionCommand("Answer");
			//button.addActionListener(this);
			contentPane.add(button);
			
//			Add content pane to frame
			frame.setContentPane(contentPane);
			
//			Size and then display the frame
			flag = false;
			frame.pack();
			frame.setVisible(true);
		}

	}
	
//	Create and show the GUI
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Riddle theRiddle = new Riddle();	
	}
	
	public static void main(String[] args) {
//	Methods that create and show a GUI should be run from an event-dispatching thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}

		});
		
	}
}
