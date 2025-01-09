import java.awt.*;
public class OutOfPlace extends FlexiblePictureExplorer {
	private int points=0;
	private static Picture round1 = new Picture("pic1.jpg");
	private Picture round2 = new Picture("pic2.jpg");
	private Picture round3 = new Picture("pic3.jpg");
	private Picture endScreen = new Picture("endScreen.jpeg");
	private String instructions=" Find 5 things that are out of place in this picture. "
	+ "Correct clicks give you 3 points, but incorrect clicks subtract a point. "
	+ "Click the \"Give Up\" button to move on to the next round. Good luck!";
	private int firstXShoe=24,lastXShoe=102, firstYShoe=172, lastYShoe=205; 
	private int firstXMelon=485,lastXMelon=532, firstYMelon=457, lastYMelon=503; 
	private int firstXUfo=36,lastXUfo=95, firstYUfo=32, lastYUfo=65; 
	private int firstXFork=29,lastXFork=45, firstYFork=362, lastYFork=417; 
	private int firstXBird=535, lastXBird=567, firstYBird=150, lastYBird=177; 
	private int firstXRobot=194,lastXRobot=259, firstYRobot=186, lastYRobot=311;
	private int firstXFish=344,lastXFish=370, firstYFish=309, lastYFish=334;
	private int firstXVac=497,lastXVac=566, firstYVac=320, lastYVac=435;
	private int firstXShark=569,lastXShark=647, firstYShark=225, lastYShark=255;
	private int firstXWasher=343,lastXWasher=372, firstYWasher=168, lastYWasher=202;
	private int firstXPlant=215,lastXPlant=275, firstYPlant=200, lastYPlant=270;
	private int firstXLight=522,lastXLight=653, firstYLight=318, lastYLight=385;
	private int firstXFood=676,lastXFood=717, firstYFood=208, lastYFood=236;
	private int firstXChair=62,lastXChair=97, firstYChair=145, lastYChair=190;
	private int firstXSnow=467,lastXSnow=506, firstYSnow=178, lastYSnow=247;
	private int firstXQuit=625,lastXQuit=726,firstYQuit=415,lastYQuit=508;
	private boolean foundShoe=false, foundMelon=false, foundUfo=false, 
	foundFork=false, foundBird=false;
	private boolean foundRobot=false, foundFish=false, foundVac=false, 
	foundShark=false,foundWasher=false;
	private boolean foundPlant=false, foundLight=false, foundFood=false, 
	foundChair=false, foundSnow=false;
	private boolean game1Over=false, game2Over=false, game3Over=false;
	public OutOfPlace() {
		super(round1);  
		makePopUp("Round 1:"+instructions);
	}
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		if (!game1Over)
			playRound1(pict, pix);
		else if (game1Over&&!game2Over)
			playRound2(pict, pix);
		else if (game1Over&&game2Over&&!game3Over)
			playRound3(pict, pix);
	}
	public void playRound1(DigitalPicture pict, Pixel pix) {
		if (!foundShoe&&pix.getX()>=firstXShoe&&
		pix.getX()<=lastXShoe&&pix.getY()>=firstYShoe&&pix.getY()<=lastYShoe) {
			correctClick(pict, firstXShoe, lastXShoe, firstYShoe, lastYShoe);
			foundShoe=true;
		} else if (!foundMelon&&pix.getX()>=firstXMelon&&
		pix.getX()<=lastXMelon&&pix.getY()>=firstYMelon&&pix.getY()<=lastYMelon) {
			correctClick(pict, firstXMelon, lastXMelon, firstYMelon, lastYMelon);
			foundMelon=true;
		} else if (!foundUfo&&pix.getX()>=firstXUfo&&
		pix.getX()<=lastXUfo&&pix.getY()>=firstYUfo&&pix.getY()<=lastYUfo) {
			correctClick(pict, firstXUfo, lastXUfo, firstYUfo, lastYUfo);
			foundUfo=true;
		} else if (!foundFork&&pix.getX()>=firstXFork&&
		pix.getX()<=lastXFork&&pix.getY()>=firstYFork&&pix.getY()<=lastYFork) {
			correctClick(pict, firstXFork, lastXFork, firstYFork, lastYFork);
			foundFork=true;
		} else if (!foundBird&&pix.getX()>=firstXBird&&
		pix.getX()<=lastXBird&&pix.getY()>=firstYBird&&pix.getY()<=lastYBird) {
			correctClick(pict, firstXBird, lastXBird, firstYBird, lastYBird);
			foundBird=true;
		} else {
			if (!giveUp(pix))
				wrongClick(pict, pix);
		}
		if ((foundShoe&&foundMelon&&foundUfo&&foundFork&&foundBird)
		||giveUp(pix)) {
			game1Over=true;
			setImage(round2);
			makePopUp("Round 2:"+instructions);
		}
	}
	public void playRound2(DigitalPicture pict, Pixel pix) {
		if (!foundRobot&&pix.getX()>=firstXRobot&&
		pix.getX()<=lastXRobot&&pix.getY()>=firstYRobot&&pix.getY()<=lastYRobot) {
			correctClick(pict, firstXRobot, lastXRobot, firstYRobot, lastYRobot);
			foundRobot=true;
		} else if (!foundFish&&pix.getX()>=firstXFish&&
		pix.getX()<=lastXFish&&pix.getY()>=firstYFish&&pix.getY()<=lastYFish) {
			correctClick(pict, firstXFish, lastXFish, firstYFish, lastYFish);
			foundFish=true;
		} else if (!foundVac&&pix.getX()>=firstXVac&&
		pix.getX()<=lastXVac&&pix.getY()>=firstYVac&&pix.getY()<=lastYVac) {
			correctClick(pict, firstXVac, lastXVac, firstYVac, lastYVac);
			foundVac=true;
		} else if (!foundShark&&pix.getX()>=firstXShark&&
		pix.getX()<=lastXShark&&pix.getY()>=firstYShark&&pix.getY()<=lastYShark) {
			correctClick(pict, firstXShark, lastXShark, firstYShark, lastYShark);
			foundShark=true;
		} else if (!foundWasher&&pix.getX()>=firstXWasher&&
		pix.getX()<=lastXWasher&&pix.getY()>=firstYWasher&&pix.getY()<=lastYWasher) {
			correctClick(pict, firstXWasher, lastXWasher, firstYWasher, lastYWasher);
			foundWasher=true;
		} else {
			if (!giveUp(pix))
				wrongClick(pict, pix);
		}
		if ((foundRobot&&foundFish&&foundVac&&foundShark&&foundWasher)
		||giveUp(pix)) {
			game2Over=true;
			setImage(round3);
			makePopUp("Round 3:"+instructions);
		}
	}
	public void playRound3(DigitalPicture pict, Pixel pix) {
		if (!foundPlant&&pix.getX()>=firstXPlant&&
		pix.getX()<=lastXPlant&&pix.getY()>=firstYPlant&&pix.getY()<=lastYPlant) {
			correctClick(pict, firstXPlant, lastXPlant, firstYPlant, lastYPlant);
			foundPlant=true;
		} else if (!foundLight&&pix.getX()>=firstXLight&&
		pix.getX()<=lastXLight&&pix.getY()>=firstYLight&&pix.getY()<=lastYLight) {
			correctClick(pict, firstXLight, lastXLight, firstYLight, lastYLight);
			foundLight=true;
		} else if (!foundFood&&pix.getX()>=firstXFood&&
		pix.getX()<=lastXFood&&pix.getY()>=firstYFood&&pix.getY()<=lastYFood) {
			correctClick(pict, firstXFood, lastXFood, firstYFood, lastYFood);
			foundFood=true;
		} else if (!foundChair&&pix.getX()>=firstXChair&&
		pix.getX()<=lastXChair&&pix.getY()>=firstYChair&&pix.getY()<=lastYChair) {
			correctClick(pict, firstXChair, lastXChair, firstYChair, lastYChair);
			foundChair=true;
		} else if (!foundSnow&&pix.getX()>=firstXSnow&&
		pix.getX()<=lastXSnow&&pix.getY()>=firstYSnow&&pix.getY()<=lastYSnow) {
			correctClick(pict, firstXSnow, lastXSnow, firstYSnow, lastYSnow);
			foundSnow=true;
		} else {
			if (!giveUp(pix))
				wrongClick(pict, pix);
		}
		if ((foundPlant&&foundLight&&foundFood&&foundChair&&foundSnow)
		||giveUp(pix)) {
			game3Over=true;
			setImage(endScreen);
			makePopUp("Your final score is "+points+"/45 points!");
		}
	}
	public void correctClick(DigitalPicture pic, int firstX, 
	int lastX, int firstY, int lastY) { 
		for (int x=firstX; x<=lastX; x++) {
			for (int y=firstY; y<=lastY; y++) {
				Pixel newPix = new Pixel(pic, x, y);
				newPix.setColor(Color.green);
			}
		}
		setScore(3);
	}
	public void wrongClick(DigitalPicture pic, Pixel pix) {
		for (int x=pix.getX()-5; x<=pix.getX()+5; x++) {
			for (int y=pix.getY()-5; y<=pix.getY()+5; y++) {
				Pixel newPix = new Pixel(pic, x, y);
				newPix.setColor(Color.red);
			}
		}
		setScore(-1);
	}
	public boolean giveUp(Pixel pix) {
		if (pix.getX()>=firstXQuit&&pix.getX()<=lastXQuit&&
		pix.getY()>=firstYQuit&&pix.getY()<=lastYQuit)
			return true;
		else
			return false;
	}
	public void setScore(int numPoints) {
		points+=numPoints;
		makePopUp("score: "+points);
	}
	public static void main(String[] args) {
		OutOfPlace newGame = new OutOfPlace();
	}
}