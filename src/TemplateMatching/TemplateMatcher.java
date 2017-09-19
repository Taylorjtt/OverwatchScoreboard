package TemplateMatching;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import Scoreboard.HeroName;
import Scoreboard.TeamColor;
import util.ImageProcessor;

public class TemplateMatcher {
	
	private File dir;
	private File[] directoryListing;
	private Mat img;
	private Mat result = null;
	private BufferedImage resultImage;
	
	public TemplateMatcher()
	{
		dir = new File("Resources");
		directoryListing = dir.listFiles();
		resultImage = null;
	}
	
	public BufferedImage getProcessedImage()
	{
		return resultImage;
	}
	public void processImage(BufferedImage image)
	{
		
		
		try {
			img = ImageProcessor.BufferedImage2Mat(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(File templateFile : directoryListing)
		{
			 Mat templ = Imgcodecs.imread(templateFile.getAbsolutePath());

	         // / Create the result matrix
             int result_cols = img.cols() - templ.cols() + 1;
             int result_rows = img.rows() - templ.rows() + 1;
             result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
             
             // / Do the Matching and Normalize
             Imgproc.matchTemplate(img, templ, result, Imgproc.TM_CCOEFF_NORMED);
             double threshold = 0.87;
             double maxval;
             
             while(true) 
             {
                 Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
                 Point maxp = maxr.maxLoc;
                 maxval = maxr.maxVal;
                 if(maxval < threshold && maxval >.85)
                 {
                 	System.out.println(maxval);
                 }
                 if(maxval >= threshold)
                 {
                 	HeroName hero = Match.getHeroFromFilename(templateFile.getName());
                 	TeamColor team = Match.getTeamFromFileName(templateFile.getName());
                 	//matches.add(new Match(maxr.maxLoc,new Dimension(templ.cols(),templ.rows()), hero, team));
                 	if(team.equals(TeamColor.RED))
                 	{
                 		Imgproc.rectangle(img, maxp, new Point(maxp.x + templ.cols(),
                                maxp.y + templ.rows()), new Scalar(0, 0, 255),5);
                 	}
                 	else
                 	{
                 		Imgproc.rectangle(img, maxp, new Point(maxp.x + templ.cols(),
                                maxp.y + templ.rows()), new Scalar(255, 0, 0),5);
                 	}
                     
                     Imgproc.rectangle(result, maxp, new Point(maxp.x + templ.cols(),
                             maxp.y + templ.rows()), new Scalar(0, 255, 0),-1);
                 }else{
                     break;
                 }
             }
             
             try {
            	 resultImage = ImageProcessor.Mat2BufferedImage(img);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
              
		}
	}

}
