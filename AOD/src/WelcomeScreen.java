import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeScreen extends JPanel {

	class comboBoxAction implements ActionListener {
		private int player;
		comboBoxAction(int player) {
			this.player = player;
		}

		public void actionPerformed(ActionEvent arg0) {
			JComboBox computerOptions = (JComboBox) arg0.getSource();
			if (((String) computerOptions.getSelectedItem()).equals("Expert")) {
				((ComputerPlayer) players[player-1]).setExpert();
				players[player-1].setName("Expert "+ player);

			} else if (((String) computerOptions.getSelectedItem()).equals("Basic")) {
				((ComputerPlayer) players[player-1]).setEasy();
				// System.out.println("Hello");
				players[player-1].setName("Basic "+ player);
			}
		}
	}

	class textFieldAction implements KeyListener {
		private JTextField humanField;
		private Player humanPlayer;

		textFieldAction(JTextField instance, Player humanPlayer) {
			humanField = instance;
			this.humanPlayer = humanPlayer;
		}

		public void keyPressed(KeyEvent arg0) {
		}

		public void keyReleased(KeyEvent arg0) {
			System.out.println(humanField.getText());
			((HumanPlayer) humanPlayer).setName(humanField.getText());
		}

		public void keyTyped(KeyEvent arg0) {
		}

	}

	class buttonAction implements ActionListener {
		private int player;
		private int option;
		private Player playerType;

		private final static int NONE = 0;
		private final static int HUMAN = 1;
		private final static int COMPUTER = 2;

		// This is the JComponent that will display whenever the button is pressed
		// ie. if the button is for the human, this component will be the JTextField to
		// the enter the player's name
		// if the button is for the computer, this component will be drop down menu
		// if the button is for the none option, this component will be a JLabel with
		// the string "none"
		private JComponent component;

		buttonAction(int i, int j) {
			this.player = i + 1;
			this.option = j;
			// j=0 is none
			// j=1 is human
			// j=2 is computer
			if (j == NONE) {
				playerType = null;
				component = new JLabel("None");
				component.setFont(new Font("Arial", Font.BOLD, 21));

			} else if (j == HUMAN) {
				playerType = new HumanPlayer();
				playerType.setName("Player " + player);
				component = new JTextField("Player " + player, 10);
				component.setFont(new Font("Arial", Font.BOLD, 21));
				component.setBounds(buttons[i][j].getX(), buttons[i][j].getY() - 130, 100, 50);
				((JTextField) component).addKeyListener(new textFieldAction((JTextField) component, playerType));
			} else if (j == COMPUTER) {
				playerType = new ComputerPlayer();
				playerType.setName("Expert "+ player);
				component = new JComboBox(new String[] { "Basic", "Expert" });
				((JComboBox) component).setSelectedIndex(1);
				component.setFont(new Font("Arial", Font.BOLD, 21));
				component.setBounds(buttons[i][j].getX(), buttons[i][j].getY() - 175, 100, 50);
				((JComboBox) component).addActionListener(new comboBoxAction(player));
				if (player == 2 || player == 3 || player == 4) {
					add(component);
				}
			}
		}

		public JComponent getJComponent() {
			return component;
		}

		public void actionPerformed(ActionEvent arg0) {
			add(component);

			if (option != HUMAN) {
				// if the button is not human, remove the player name textField for human player
				buttonAction ButtonActionListener = (buttonAction) (buttons[player - 1][HUMAN].getActionListeners()[0]);
				// System.out.println(playerButtonActionListener.getPlayerField());
				remove(ButtonActionListener.getJComponent());
			}
			if (option != NONE) {
				// if the button is not human, remove the player name textField for human player
				buttonAction ButtonActionListener = (buttonAction) (buttons[player - 1][NONE].getActionListeners()[0]);
				// System.out.println(playerButtonActionListener.getPlayerField());
				remove(ButtonActionListener.getJComponent());
			}
			if (option != COMPUTER) {
				// if the button is not human, remove the player name textField for human player
				buttonAction ButtonActionListener = (buttonAction) (buttons[player - 1][COMPUTER]
						.getActionListeners()[0]);
				// System.out.println(playerButtonActionListener.getPlayerField());
				remove(ButtonActionListener.getJComponent());
			}

			canPlay = checkCanPlay();
			players[player - 1] = playerType;
			revalidate();
			repaint();
		}
	}

	private Player[] players = new Player[4];
	private JRadioButton[][] buttons;
	private ButtonGroup[] groups = new ButtonGroup[4]; // group[i] is the (i+1)th player's buttons

	private boolean canPlay = true;

	private final static int buttonLength = 50;
	private final static int buttonWidth = 120;

	public Player[] getPlayers() {
		return players;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Oxygen", Font.BOLD, 44));
		g.setColor(Color.red);
		g.drawString("Ingenious", 595, 100);
		BufferedImage Board = null;
		
		// g.drawImage(Board, 490, 200, null);

		g.setFont(new Font("Arial", Font.BOLD, 21));

		// Draws Play Button
		if (canPlay) {
			g.setColor(Color.BLACK);
			g.fillRect(443, 670, buttonWidth, buttonLength);
			g.setColor(Color.WHITE);
			g.drawString("Play", 480, 700);
		} else {
			// Blurs out the play button if the current player configuration does not work
		}

		// Draws the Rules button
		g.setColor(Color.BLACK);
		g.fillRect(643, 600, buttonWidth, buttonLength);
		g.setColor(Color.white);
		g.drawString("How to Play", 645, 630);

		// Draws the Exit button
		g.setColor(Color.BLACK);
		g.fillRect(843, 670, buttonWidth, buttonLength);
		g.setColor(Color.white);
		g.drawString("Exit", 883, 700);
	}

	WelcomeScreen() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1500, 800));
		setLayout(null);
		buttons = new JRadioButton[4][3];
		for (int i = 0; i < 4; i++) {
			groups[i] = new ButtonGroup();
		}

		// initializes all the buttons
		String[] buttonTexts = { "none", "human", "computer" };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JRadioButton(buttonTexts[j]);
				buttons[i][j].setBackground(Color.white);
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 16));
				groups[i].add(buttons[i][j]);
			}
		}

		// Player one button placement
		buttons[0][0].setBounds(200, 200, 65, 14);
		buttons[0][1].setBounds(200, 245, 78, 14);
		buttons[0][2].setBounds(200, 290, 98, 14);

		// Player two button placement
		buttons[1][0].setBounds(200, 200 + 300, 65, 14);
		buttons[1][1].setBounds(200, 245 + 300, 78, 14);
		buttons[1][2].setBounds(200, 290 + 300, 98, 14);

		// Player three button placement
		buttons[2][0].setBounds(1125, 200, 65, 14);
		buttons[2][1].setBounds(1125, 245, 78, 14);
		buttons[2][2].setBounds(1125, 290, 98, 14);

		// Player four button placement
		buttons[3][0].setBounds(1125, 200 + 300, 65, 14);
		buttons[3][1].setBounds(1125, 245 + 300, 78, 14);
		buttons[3][2].setBounds(1125, 290 + 300, 98, 14);

		// Adds the buttons onto the JPanel
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				add(buttons[i][j]);
				buttons[i][j].addActionListener(new buttonAction(i, j));
			}
		}

		// Activates the buttons
		buttons[0][1].doClick();
		buttons[1][2].doClick();
		buttons[2][2].doClick();
		buttons[3][2].doClick();
	}

	// inputs the x and y coordinates of the mouse on the JFrame
	// outputs the String with the button pressed (play, rules, and exit)
	// if a button was not pressed, returns none
	// if the play button is blurred out, returns none if the region is pressed

	// needs to be opposite corners of the rectangle with x1<x2 and y1<y2
	private boolean inRect(int x, int y, int x1, int y1, int x2, int y2) {
		return (x1 < x && x < x2 && y1 < y && y < y2);
	}

	public String mouseClicked(int x, int y) {
		// Play button
		if (inRect(x, y, 443, 670, buttonWidth + 443, buttonLength + 670)) {
			return "Play button";
		}

		// How to Play button
		if (inRect(x, y, 643, 600, buttonWidth + 643, buttonLength + 600)) {
			return "How to Play button";
		}

		// Exit button
		if (inRect(x, y, 843, 670, buttonWidth + 843, buttonLength + 670)) {
			return "Exit button";
		}

		return "None";
	}

	// checks if we can play the game with the current player selections
	private boolean checkCanPlay() {
		int playersNotPlaying = 0;
		for (int i = 0; i < 4; i++) {
			if (buttons[i][0].isSelected()) {
				// if the none button is selected for the (i+1)th player
				playersNotPlaying++;
			}
		}
		return playersNotPlaying <= 2;
	}

	public static void main(String[] args) {
		JFrame display = new JFrame();
		display.setResizable(false);
		WelcomeScreen panel = new WelcomeScreen();
		display.add(panel);
		panel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				System.out.println(panel.mouseClicked(e.getX(), e.getY()));
			} 

			public void mouseReleased(MouseEvent e) {
			}
		});
		display.pack();
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setVisible(true);
	}
}