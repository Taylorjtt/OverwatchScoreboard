import java.io.File;
import net.sourceforge.tess4j.*;
import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Scalar;
import java.io.File;

import org.opencv.imgproc.Imgproc;

class MatchingDemo {
    public void run(String inFile,String outFile, int match_method) {
        System.out.println("\nRunning Template Matching");

        File dir = new File("Resources");
        File[] directoryListing = dir.listFiles();
        Mat dst = null;
        for(File templateFile: directoryListing)
        {
        	System.out.println(templateFile.getName());
        	Mat img = Imgcodecs.imread(inFile);
            Mat templ = Imgcodecs.imread(templateFile.getAbsolutePath());
            System.out.println(templateFile.getAbsolutePath());


            // / Create the result matrix
            int result_cols = img.cols() - templ.cols() + 1;
            int result_rows = img.rows() - templ.rows() + 1;
            Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);

            // / Do the Matching and Normalize
            Imgproc.matchTemplate(img, templ, result, match_method);
            double threshold = 0.99;
            double maxval;
            Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
           
            while(true) 
            {
                Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
                Point maxp = maxr.maxLoc;
                maxval = maxr.maxVal;
                Point maxop = new Point(maxp.x + templ.width(), maxp.y + templ.height());
                dst = img.clone();
                if(maxval >= threshold)
                {
                    System.out.println(maxr.maxLoc);
                    System.out.println(maxr.maxVal);
                    Imgproc.rectangle(img, maxp, new Point(maxp.x + templ.cols(),
                            maxp.y + templ.rows()), new Scalar(0, 255, 0),5);
                    Imgproc.rectangle(result, maxp, new Point(maxp.x + templ.cols(),
                            maxp.y + templ.rows()), new Scalar(0, 255, 0),-1);
                }else{
                    break;
                }
            }
           

            // Save the visualized detection.
           
           
        }
        Imgcodecs.imwrite(outFile, dst);
        
        System.out.println("Writing "+ outFile);
    }
    
    
}

public class TemplateMatching {
    public static void main(String[] args) {
        System.loadLibrary("opencv_java320");
        new MatchingDemo().run("src/testImage.png", "src/output.png", Imgproc.TM_CCOEFF);
    }
}