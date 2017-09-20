package OCR;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.GrayFilter;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import util.ImageProcessor;

public class BattleTagReader {
	
	private ITesseract instance;
	
	public BattleTagReader()
	{
		instance = new Tesseract();
	}
	public void getBattleTagFromImage(BufferedImage image)
	{
		Mat result = null;
		Mat source = null;
		Mat source2 = null;
		try {
			 source = ImageProcessor.BufferedImage2Mat(image);
			 result = new Mat(source.rows(), source.cols(),source.type() );
			 source2 = new Mat(source.rows(), source.cols(),source.type() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Core.inRange(source,new Scalar(10,0,180),new Scalar(80,80,255), result);
		
		//Imgproc.adaptiveThreshold(source, source2, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 41, -5);
		//Imgproc.threshold(source2, result, 0.9, 255, Imgproc.THRESH_OTSU);
		//
		System.out.println(source.type());
		for(int firstCo = 0; firstCo < source.rows(); firstCo++)
		{
			for(int sco = 0; sco < source.cols(); sco++)
			{
				System.out.println(Arrays.toString(source.get(firstCo, sco)));
			}
		}
		Imgcodecs.imwrite("src/output.png", result);
		
		try {
			System.out.println(instance.doOCR(ImageProcessor.Mat2BufferedImage(result)));
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
