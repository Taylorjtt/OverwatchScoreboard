package util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class ScreenSampler{
	
	BufferedImage lastImage = null;
	
	
	public BufferedImage getLastImage()
	{
		lastImage = ScreenGrabber.grabScreen(new Point(1400, 30), new Dimension(520, 547));
		return lastImage;
	}
	
}
