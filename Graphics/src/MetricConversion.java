import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetricConversion implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JComboBox conversions;
	JLabel conversionListPrompt, ratio;
	
	public MetricConversion() {
		frame = new JFrame("MetricConversion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		conversionListPrompt = new JLabel("Select a conversion type: ");
		conversionListPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		contentPane.add(conversionListPrompt);
		
		String[] convert = {"inches to centimeters","feet to meters","gallons to liters", "pounds to kilograms"};		
		conversions = new JComboBox(convert);
		conversions.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
		conversions.setSelectedIndex(0);
		conversions.addActionListener(this);
		contentPane.add(conversions);
		
		ratio = new JLabel("1 inch = 2.54 centimeters");
		ratio.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		contentPane.add(ratio);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		JComboBox comboBox = (JComboBox) event.getSource();
		String conv = (String)comboBox.getSelectedItem();
		
		if(conv == "inches to centimeters") {
			ratio.setText("1 inch = 2.54 centimeters");
		}else if(conv == "feet to meters") {
			ratio.setText("1 foot = 0.3048 meters");
		}else if(conv == "gallons to liters") {
			ratio.setText("1 gallon = 4.5461 liters");
		}else if(conv == "pounds to kilograms") {
			ratio.setText("1 pound = 0.4536 kilograms");
		}
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		MetricConversion test = new MetricConversion();		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
			
	}
	
}
