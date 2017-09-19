package Scoreboard;
import java.util.ArrayList;
import java.util.Timer;


import TemplateMatching.*;

import org.opencv.imgproc.Imgproc;

class MatchingDemo {
	ArrayList<Match> matches = new ArrayList();
	ArrayList<InteractionPair> interactionPairs = new ArrayList();
	
    public void run(String inFile,String outFile, int match_method) 
    {
    	Timer timer = new Timer();
    	timer.schedule(new ScreenDrawer(),0,3000);
    }
   
}



public class TemplateMatching {
    public static void main(String[] args) {
        System.loadLibrary("opencv_java320");
        new MatchingDemo().run("src/multiKill.png", "src/output.png", Imgproc.TM_CCOEFF_NORMED);
    }
}