package OCR;

import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BattleTagGrabber {
	
	private ITesseract instance;
	
	public BattleTagGrabber()
	{
		instance = new Tesseract();
	}
	
	public  String grabBattleTag(BufferedImage image)
	{
        try
        {
        	String res = instance.doOCR(image);
        	return res;
        }
        catch(TesseractException e)
        {
        	System.err.println(e.getMessage());
        }
        
        return "Jon Snow";
	}

}
