import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;

public class GameShow extends FlexiblePictureExplorer implements ImageObserver{
	private boolean main; 
	private boolean end;
	private boolean wall = false;
	private boolean liberty = false;
	private boolean itza = false;
	private boolean redeemer = false;
	private boolean colosseum = false;
	private boolean borealis = false;
	private boolean mahal = false;
	private boolean giza = false;
	private boolean eye = false;
	private boolean porcelain = false;
	private int score = 0;
	public int next = 1;
	private final String path = "GameShow/";

	private final String[][] images = { {"titleScreen.jpg","startOver.jpg","start.jpg","endScreen.jpg"},
										{"greatWall.jpg","greatWall(A).jpg","greatWall(B)_.jpg","greatWall(C).jpg","greatWall(D).jpg"}, 
										{"libertyStatue.jpg","libertyStatue(A).jpg","libertyStatue(B).jpg","libertyStatue(C)_.jpg","libertyStatue(D).jpg"},
										{"chichenItza.jpg","chichenItza(A)_.jpg","chichenItza(B).jpg","chichenItza(C).jpg","chichenItza(D).jpg"},
										{"christRedeemer.jpg","christRedeemer(A).jpg","christRedeemer(B).jpg","christRedeemer(C).jpg","christRedeemer(D)_.jpg"},
										{"colosseum.jpg","colosseum(A).jpg","colosseum(B).jpg","colosseum(C)_.jpg","colosseum(D).jpg"},	
										{"auroraBorealis.jpg","auroraBorealis(A).jpg","auroraBorealis(B).jpg","auroraBorealis(C).jpg","auroraBorealis(D)_.jpg"},
										{"tajMahal.jpg","tajMahal(A).jpg","tajMahal(B)_.jpg","tajMahal(C).jpg", "tajMahal(D).jpg"},
										{"giza.jpg","giza(A)_.jpg","giza(B).jpg","giza(C).jpg","giza(D).jpg"},
										{"londonEye.jpg","londonEye(A).jpg","londonEye(B).jpg" ,"londonEye(C).jpg","londonEye(D)_.jpg"},
										{"porcelainTower.jpg","porcelainTower(A).jpg","porcelainTower(B)_.jpg","porcelainTower(C).jpg","porcelainTower(D).jpg"} };

	Picture disp = new Picture(700, 700);
	Graphics2D graphics = disp.createGraphics();
	
	GameShow () {
		super(new Picture(700,700));
		displayMain();
	}
	
	public void displayMain() {
		main = true;
		Picture background = new Picture(path + images[0][0]);
		Picture button = new Picture(path + images[0][2]);
		Graphics2D graphics = disp.createGraphics();
		graphics.drawImage(background.getBufferedImage(), 0, 0, this);
		graphics.drawImage(button.getBufferedImage(), 215, 450, this);
		setImage(disp);
	}
	
	
	public void displayQuestions(int n) {
		main=false;
		Picture disp = new Picture(700, 700);
		Picture firstQuestion = new Picture(path + images[n][0]); 
		Picture q1 = new Picture(path + images[n][1]);
		Picture q2 = new Picture(path + images[n][2]);
		Picture q3 = new Picture(path + images[n][3]);
		Picture q4 = new Picture(path + images[n][4]);
		Graphics2D graphics = disp.createGraphics();
		graphics.drawImage(firstQuestion.getBufferedImage(), 0, 0, this);
		graphics.drawImage(q1.getBufferedImage(), 70, 450, this);
		graphics.drawImage(q2.getBufferedImage(), 360, 450, this);
		graphics.drawImage(q3.getBufferedImage(), 70, 560, this);
		graphics.drawImage(q4.getBufferedImage(), 360, 560, this);
		setImage(disp);
	}
	
	public void setScreen() {
		displayQuestions(next);
		next++;
	}
	
	public void displayEndscreen() {
		String endScore = "Your score is " + score + "/10!";
		Picture endPic = new Picture(path + images[0][3]);
		Picture startOver = new Picture(path + images [0][1]);
		Graphics2D endscreen = endPic.createGraphics();
		endscreen.setColor(Color.white);
		endscreen.setFont(new Font("Coppertone", Font.BOLD, 65));
		endscreen.drawString(endScore, 20, 400);
		endscreen.drawImage(startOver.getBufferedImage(), 215, 450, this);
		setImage(endPic);
		end = true;
	}

	
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		int x = pix.getX();
		int y = pix.getY();
		
		if (end & x>215 && x<485 && y>450 &&y<540) {
			score = 0;
			next = 1;
			displayMain();
			end = false;
		}
		if (porcelain) {
			if (x>360 && x<630 && y>450 && y<540) {
				score ++;
			}
			porcelain = false;
			displayEndscreen();
		} 
		
		if (eye) {
			if (x>360 && x<630 && y>560 && y<650) {
				score ++;
			} 
			setScreen();
			eye = false;
			porcelain = true;

		}
		
		if (giza) {
			if (x>70 && x<340 && y>450 && y<540) {
				score ++;
			}
			setScreen();
			giza = false;
			eye = true;
		}
		
		
		if (mahal) {
			if (x>360 && x<630 && y>450 && y<540) {
				score ++;
			}
			setScreen();
			mahal = false;
			giza = true;
		}
		
		if (borealis) {
			if (x>360 && x<630 && y>560 && y<650) {
				score ++;
			}
			setScreen();
			borealis = false;
			mahal = true;
		}
		
		if (colosseum) { 
			if (x>70 && x<340 && y>560 && y<650) {
				score ++;
			}
			setScreen();
			colosseum = false;
			borealis= true;
		}
		
		if (redeemer) {
			if (x>360 && x<630 && y>560 && y<650) {
				score ++;
			}
			setScreen();
			redeemer = false;
			colosseum = true;
		}
	
		if (itza ) {
			if (x>70 && x<340 && y>450 && y<540) {
				score ++;
			}
			setScreen();
			itza = false;
			redeemer= true;
		}
	
		
		if (liberty) {
			if (x>70 && x<340 && y>560 && y<650) {
				score ++;
			}
			setScreen();
			liberty = false;
			itza = true;
		}
	
		
		if (wall) {
			if (x>360 && x<630 && y>450 && y<540) {
				score++;
			}
			setScreen();
			wall = false;
			liberty = true;
		}
	
	
		if(main && x>215 && x<485 && y>450 &&y<540) {
			setScreen();
			wall = true;
		}
	}
	

	public static void main (String args[]){
		new GameShow();
	}


	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		return false;
	}
}




