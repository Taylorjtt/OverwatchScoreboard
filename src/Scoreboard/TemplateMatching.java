package Scoreboard;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Scalar;
import TemplateMatching.*;


import org.opencv.imgproc.Imgproc;

class MatchingDemo {
	ArrayList<Match> matches = new ArrayList();
	
    public void run(String inFile,String outFile, int match_method) 
    {
        System.out.println("\nRunning Template Matching");

        File dir = new File("Resources");
        File[] directoryListing = dir.listFiles();
        Mat img = Imgcodecs.imread(inFile);
        Mat result = null;
        long startTime = System.currentTimeMillis();
        for(File templateFile: directoryListing)
        {
            Mat templ = Imgcodecs.imread(templateFile.getAbsolutePath());

            // / Create the result matrix
            int result_cols = img.cols() - templ.cols() + 1;
            int result_rows = img.rows() - templ.rows() + 1;
            result = new Mat(result_rows, result_cols, CvType.CV_32FC1);

            // / Do the Matching and Normalize
            Imgproc.matchTemplate(img, templ, result, match_method);
            double threshold = 0.90;
            double maxval;
           
            while(true) 
            {
                Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
                Point maxp = maxr.maxLoc;
                maxval = maxr.maxVal;
                if(maxval >= threshold)
                {
                	System.out.println(maxval);
                	HeroName hero = Match.getHeroFromFilename(templateFile.getName());
                	TeamColor team = Match.getTeamFromFileName(templateFile.getName());
                	matches.add(new Match(maxr.maxLoc,new Dimension(templ.cols(),templ.rows()), hero, team));
                    //Imgproc.rectangle(img, maxp, new Point(maxp.x + templ.cols(),
                           // maxp.y + templ.rows()), new Scalar(0, 255, 0),5);
                    Imgproc.rectangle(result, maxp, new Point(maxp.x + templ.cols(),
                            maxp.y + templ.rows()), new Scalar(0, 255, 0),-1);
                }else{
                    break;
                }
            }
       
           
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: "+totalTime+"ms");
        Imgcodecs.imwrite(outFile, img);
        
        System.out.println("Writing "+ outFile);
        for(Match m : matches)
        {
        	System.out.println(m.toString());
        }
    }
    
    public static Mat bufferedImageToMat(BufferedImage bi) 
    {
    	  Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
    	  byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
    	  mat.put(0, 0, data);
    	  return mat;
    }
}



public class TemplateMatching {
    public static void main(String[] args) {
        System.loadLibrary("opencv_java330");
        new MatchingDemo().run("src/multiKill.png", "src/output.png", Imgproc.TM_CCOEFF_NORMED);
    }
}