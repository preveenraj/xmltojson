
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FitnesseEvaluator {

	public static void main(String[] args) throws Exception {
	    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
	    SAXParser parser = parserFactor.newSAXParser();
	    SAXHandler handler = new SAXHandler();
	    parser.parse(new File ("D:\\Work\\Temp\\rksir\\simple\\src\\Test3.xml"),handler);
	     
	    //Printing the list of results obtained from XML
	    System.out.println("HANDLER SIZE:"+ handler.resultList.size());
	    
	    
	    for ( InstructionResult instructionResult : handler.resultList) {
	      System.out.println(instructionResult);
	      
	      Properties p = new Properties();
	      
	    /*  OutputStream os = new FileOutputStream("dataconfig.properties");
	      p.setProperty("package_name", "com.fitnesse");
	      p.setProperty("className", "ShippingMode");
	      p.store(os,null);*/
	      
	      InputStream is = new FileInputStream("dataconfig.properties");
	      p.load(is);
	      
	     // System.out.println(p.getProperty("package_name"));
	     // System.out.println(p.getProperty("className"));
	     // System.out.println(p.getProperty("Test"));
	      
	      
	      
	    }
	  }
}
