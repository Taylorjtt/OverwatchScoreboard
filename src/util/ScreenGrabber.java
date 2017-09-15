package util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class ScreenGrabber {
	
	public static BufferedImage grabScreen(Point startingPoint, Dimension dimension)
	{
		BufferedImage capture = null;
		Rectangle screenRect = new Rectangle(startingPoint,dimension);
		try {
			 capture = new Robot().createScreenCapture(screenRect);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capture;
		
	}
}
