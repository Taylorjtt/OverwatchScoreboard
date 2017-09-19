package Scoreboard;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import TemplateMatching.ImageProcessor;
import util.ScreenGrabber;

public class ScreenDrawer extends TimerTask {
	
	JFrame frame;
	BufferedImage image;
	ScreenSampler ss;
	ImageProcessor imp = new ImageProcessor();
	
	public ScreenDrawer()
	{
		ss = new ScreenSampler();
		image = null;
		frame = new JFrame("Screenshot");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void run()
	{
		frame.getContentPane().removeAll();
		imp.processImage(ss.getLastImage());
		frame.getContentPane().add(new JLabel(new ImageIcon(imp.getProcessedImage())));
		frame.pack();
		frame.setVisible(true);
	}

}
