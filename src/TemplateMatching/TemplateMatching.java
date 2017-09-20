package TemplateMatching;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;

import TemplateMatching.*;
import util.ScreenDrawer;

import org.opencv.imgproc.Imgproc;

import OCR.BattleTagReader;
import Scoreboard.InteractionPair;

class MatchingDemo {
	ArrayList<Match> matches = new ArrayList();
	ArrayList<InteractionPair> interactionPairs = new ArrayList();
	
    public void run(String inFile,String outFile, int match_method) 
    {
    	//Timer timer = new Timer();
    	//timer.schedule(new ScreenDrawer(),0,3000);
    	
    	BattleTagReader reader = new BattleTagReader();
    	
    	BufferedImage img = null;
    	try {
    	    img = ImageIO.read(new File("src/multiKill.png"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	reader.getBattleTagFromImage(img);
    }
   
}



public class TemplateMatching {
    public static void main(String[] args) {
        System.loadLibrary("opencv_java330");
        new MatchingDemo().run("src/multiKill.png", "src/output.png", Imgproc.TM_CCOEFF_NORMED);
    }
}