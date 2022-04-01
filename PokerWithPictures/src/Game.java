import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;

public class Game extends FlexiblePictureExplorer implements ImageObserver{
	
	private boolean playerWin,compWin = false;
	private boolean check, next = false;
	private final String path = "cards/";
	private String playerRank="";
	
	private int playerScore, compScore = 0;
	
	ArrayList<Card> tableCards = new ArrayList<Card>();
	ArrayList<Card> playerCards = new ArrayList<Card>();
	ArrayList<Card> compCards = new ArrayList<Card>();
	ArrayList<Card> combined = new ArrayList<Card>();
	
	Picture disp = new Picture(800,1358);
	Graphics2D graphics = disp.createGraphics();
	
	private String[][] images = { {"table","blue_back", "play","bet","stop", "again"},
								  {"AH", "AS", "AC", "AD"},
								  {"2H", "2S", "2C", "2D"},
								  {"3H", "3S", "3C", "3D"},
								  {"4H", "4S", "4C", "4D"},
								  {"5H", "5S", "5C", "5D"},
								  {"6H", "6S", "6C", "6D"},
								  {"7H", "7S", "7C", "7D"},
								  {"8H", "8S", "8C", "8D"},
								  {"9H", "9S", "9C", "9D"},
								  {"10H", "10S", "10C", "10D"},
								  {"JH", "JS", "JC", "JD"},
								  {"QH", "QS", "QC", "QD"},
								  {"KH", "KS", "KC", "KD"} };
	
	Game(HandEvaluator myHand) {
		super(new Picture(800,1358));
		playerRank = myHand.getRank();
		combined = myHand.getCombined();
		compCards = myHand.getComputer();
		tableCards = myHand.getTable();
		playerCards = myHand.getPlayerCards();
		displayGame();
		//displayScores();
		displayTable();
		displayCards();
	}
	
	public void displayScores() {
		String player = "Your score: " + playerScore;
		String comp = "Computer's score: " + compScore;
		Graphics2D scoreBoard = disp.createGraphics();
		scoreBoard.setColor(Color.white);
		scoreBoard.setFont(new Font("Coppertone", Font.BOLD, 20));
		scoreBoard.drawString(player, 1120, 20);
		scoreBoard.drawString(comp, 1120, 60);
		setImage(disp);
	}
	
	public void displayGame() {
		Picture background = new Picture(path + images[0][0] + ".jpg");
		Picture play = new Picture("cards/play.png");
		Picture bet = new Picture("cards/bet.png");
		Picture stop = new Picture("cards/stop.png");
		Picture again = new Picture("cards/again.png");
		graphics.drawImage(background.getBufferedImage(), 0, 0, this);
		graphics.drawImage(play.getBufferedImage(), 479,60, this);
		graphics.drawImage(bet.getBufferedImage(), 629,60, this);
		graphics.drawImage(stop.getBufferedImage(), 779,60, this);
		graphics.drawImage(again.getBufferedImage(), 604,590, this);
		/*String player = "Your score: " + playerScore;
		String comp = "Computer's score: " + compScore;
		Graphics2D scoreBoard = disp.createGraphics();
		scoreBoard.setColor(Color.white);
		scoreBoard.setFont(new Font("Coppertone", Font.BOLD, 20));
		scoreBoard.drawString(player, 1120, 20);
		scoreBoard.drawString(comp, 1120, 60);*/
		setImage(disp);
	}
	
	public void displayTable() {
		if(check) {
			Picture card1 = new Picture(path + tableCards.get(0).imageName() + ".jpg");
			Picture card2 = new Picture(path + tableCards.get(1).imageName() + ".jpg");
			Picture card3 = new Picture(path + tableCards.get(2).imageName() + ".jpg");
			Picture card4 = new Picture(path + tableCards.get(3).imageName() + ".jpg");
			Picture card5 = new Picture(path + tableCards.get(4).imageName() + ".jpg");
			
			graphics.drawImage(card1.getBufferedImage(), 231, 280, this);
			graphics.drawImage(card2.getBufferedImage(), 415, 280, this);
			graphics.drawImage(card3.getBufferedImage(), 598, 280, this);
			graphics.drawImage(card4.getBufferedImage(), 783, 280, this);
			graphics.drawImage(card5.getBufferedImage(), 967, 280, this);
			setImage(disp);
		} else if(!check) {
			Picture card1 = new Picture(path + tableCards.get(0).imageName() + ".jpg");
			Picture card2 = new Picture(path + tableCards.get(1).imageName() + ".jpg");
			Picture card3 = new Picture(path + tableCards.get(2).imageName() + ".jpg");
			Picture card4 = new Picture(path + "blue_back" + ".jpg");
			Picture card5 = new Picture(path + "blue_back" + ".jpg");
			
			graphics.drawImage(card1.getBufferedImage(), 231, 280, this);
			graphics.drawImage(card2.getBufferedImage(), 415, 280, this);
			graphics.drawImage(card3.getBufferedImage(), 598, 280, this);
			graphics.drawImage(card4.getBufferedImage(), 783, 280, this);
			graphics.drawImage(card5.getBufferedImage(), 967, 280, this);
			setImage(disp);
		}
	}
	
	public void displayCards(){
		Picture myCard1 = new Picture(path + playerCards.get(0).imageName() + ".jpg");
		Picture myCard2 = new Picture(path + playerCards.get(1).imageName() + ".jpg");
		graphics.drawImage(myCard1.getBufferedImage(), 1015, 550, this);
		graphics.drawImage(myCard2.getBufferedImage(), 1180, 550, this);
		if(!check) {
			Picture ComputerCards = new Picture(path + "blue_back" + ".jpg");
			graphics.drawImage(ComputerCards.getBufferedImage(), 15, 0, this);
			graphics.drawImage(ComputerCards.getBufferedImage(), 180, 0, this);
		}else if(check) {
			Picture ccard1 = new Picture(path + compCards.get(0).imageName() + ".jpg");
			Picture ccard2 = new Picture(path + compCards.get(1).imageName() + ".jpg");
			graphics.drawImage(ccard1.getBufferedImage(), 15, 0, this);
			graphics.drawImage(ccard2.getBufferedImage(), 180, 0, this);
		}
			
		setImage(disp);
	}
	
	public void setCheck(boolean change) {
		check = change;
	}
	
	public void askPlayer() {
		System.out.println("Continue? yes or no");
		Scanner a = new Scanner (System.in);
		String input = a.next();
		if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
			do{
				System.out.println("Oops, try again");
				a = new Scanner (System.in);
				input = a.next();	
			} while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		} 
		System.out.println();
		check = input.equalsIgnoreCase("yes");
		if(input.equalsIgnoreCase("no")) {
			System.out.println("\n");
			System.out.print("Computer wins!");
		}
		if(check) {
			System.out.println("\n");
			displayTable();
			displayCards();
		}
	}
	
	public void printBoard(){
		if(check) {
			System.out.println("The board contains the following cards:");
			for(int i =0; i<tableCards.size();i++){
				System.out.println(i+1 + ": " + tableCards.get(i).toString());
			}
			System.out.println("\n");
		}else if(!check) {
			System.out.println("The board contains the following cards:");
			for(int i =0; i<tableCards.size()-2;i++){
				System.out.println(i+1 + ": " + tableCards.get(i).toString());
			}
			System.out.println(4 + ": ???");
			System.out.println(5 + ": ???");
			System.out.println("\n");
		}
	}
	
	public void printCombined() {
		if(check) {
			int i = 0;
			System.out.println("Combined Hand:");
			for(Card deck: combined) {
				System.out.println(i+1 + ": " +deck);
				i++;
			}
			System.out.println("\n");
		}
	}
	
	public void printRank() {
		if(check) {
			System.out.print("You got " + playerRank);
			System.out.println("\n");
			System.out.println("---------------------------------------------------");
		}
	}
	
	public void printCompRank() {
		if(check) {
			HandEvaluator forComp = new HandEvaluator(compCards, tableCards);
			System.out.print("Computer got " + forComp.getRank());
			System.out.println("\n");
		}
	}
	
	public void printCompCards() {
		if(check) {
			System.out.println("\n");
			System.out.println("Computer has the following cards:");
			for(int i = 0; i<compCards.size(); i++) {
				System.out.println(i+1 + ": " +compCards.get(i));
			}
			System.out.println("\n");
		}
	}
	
	public void winner() {
		playerWin = false;
		compWin = false;
		if(check) {
			System.out.println("---------------------------------------------------");
			HandEvaluator forComp = new HandEvaluator(compCards, tableCards);
			int compRank = forComp.getRankNum();
			HandEvaluator forplayer = new HandEvaluator(playerCards, tableCards);
			int playerRank = forplayer.getRankNum();
			
			if(playerRank>compRank) {
				playerWin = true;
				System.out.println("\n");
				System.out.print("Player wins!");
			
			}else if(compRank>playerRank){
				compWin = true;
				System.out.println("\n");
				System.out.print("Computer wins!");
			
			} else if(playerRank==compRank) {
				System.out.println("\n");
				System.out.print("It's a tie!");
				
			}
		}
	}
	
	public void printScore() {
		System.out.println("\n");
		System.out.println("Player point: " + playerScore);
		System.out.println("Computer point: " + compScore);
		System.out.println("\n");
		System.out.println("*******************************************************");
		System.out.println("\n");
		if(playerScore>=20) {
			System.out.println("Congratulations! You won the game!");
		}else if(compScore>=20) {
			System.out.println("You lost.. Better luck next time!");
		}
	}
	
	public void setScore(int player, int comp) {
		compScore=comp;
		playerScore=player;
	}
	
	public int getPScore() {
		return playerScore;
	}
	
	public int getCScore() {
		return compScore;
	}
	
	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}


	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {	
		int x = pix.getX();
		int y = pix.getY();
		
		//stop
		if(!next && x>779 && x<879 && y>60 && y<159) {
			next = true;
			System.out.println("\n");
			System.out.print("You folded and the computer wins!");
			compScore = compScore + 2;
			playerScore = playerScore - 2;
			//displayScores();
			printScore();
		}

		//bet
		if(!next && x>629 && x<729 && y>60 && y<159) {
			next = true;
			check=true;	
			System.out.println("\n");
			System.out.println("How many points are you betting? (4-8)");
			Scanner a = new Scanner (System.in);
			String input = a.next();
			if(!input.equals("8") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7")) {
				do{
					System.out.println("Oops, try again");
					a = new Scanner (System.in);
					input = a.next();	
				} while(!input.equals("7") && !input.equals("6") && !input.equals("8") && !input.equals("4") && !input.equals("5"));
			} 
			
			System.out.println("\n");
			displayTable();
			displayCards();
			printCombined();
			printRank();
			printCompCards();
			printCompRank();
			winner();
			
			if(compWin) {
				compScore = compScore + Integer.parseInt(input);
				playerScore = playerScore - Integer.parseInt(input);
			} else if(playerWin) {
				compScore = compScore - Integer.parseInt(input);
				playerScore = playerScore + Integer.parseInt(input);
			}
			//displayScores();
			printScore();
		}
		
		//play
		if(!next && x>479 && x<579 && y>60 && y<159) {
			next = true;
			check=true;
			System.out.println("\n");
			displayTable();
			displayCards();
			printCombined();
			printRank();
			printCompCards();
			printCompRank();
			winner();
			if(compWin) {
				compScore = compScore + 3;
				playerScore = playerScore - 3;
			} else if(playerWin) {
				compScore = compScore - 3;
				playerScore = playerScore + 3;
			}
			//displayScores();
			printScore();
		}
		
		//again
		if(playerScore<20 && compScore<20 && next && x>604 && x<754 && y>590 && y<740) {
			int p = getPScore();
			int c = getCScore();
			next =false;
			check=false;
			Deck playingDeck = new Deck();
			Table myTable = new Table(playingDeck);
			Hand myHand = new Hand(playingDeck);
			Hand ComputerHand = new Hand(playingDeck);
			HandEvaluator myHandEval = new HandEvaluator(myHand,ComputerHand,myTable);
			Game myGame = new Game(myHandEval);
			playerRank = myHandEval.getRank();
			combined = myHandEval.getCombined();
			compCards = myHandEval.getComputer();
			tableCards = myHandEval.getTable();
			playerCards = myHandEval.getPlayerCards();
			myGame.setScore(p, c);
			myGame.printBoard();
			myHand.print();
			displayGame();
			//displayScores();
			displayTable();
			displayCards();
			
		}
	}

	
}