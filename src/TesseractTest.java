import java.io.File;
import net.sourceforge.tess4j.*;

public class TesseractTest {
	
	public static void main (String[] args)
	{
		File imageFile = new File("src/fillfeedFiltered.jpg");
		ITesseract instance = new Tesseract();
		instance.setLanguage("eng");
		
		try
		{
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		}
		catch(TesseractException e)
		{
			System.err.println(e.getMessage());
		}
	}

}
