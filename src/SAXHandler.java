
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {
	 
	  List<InstructionResult> resultList = new ArrayList<>();
	  InstructionResult result = null;
	  String content = null;
	  @Override
	  //Triggered when the start of tag is found.
	  public void startElement(String uri, String localName, 
	                           String qName, Attributes attributes) 
	                           throws SAXException {
	    switch(qName){
	    
	      //Create a new Employee object when the start tag is found
	      case "instruction":
	    	  result = new InstructionResult();
	    	  //result.instruction = attributes.getValue("id");
	    	  //result.status = attributes.getValue("status");		    	  
	        break;
	    }
	  }
	 
	  @Override
	  public void endElement(String uri, String localName, 
	                         String qName) throws SAXException {
	   switch(qName){
	     //Add the employee to list once end tag is found
	     case "instructionResult":
	    	 resultList.add(result);       
	       break;
	     //For all other end tags the employee has to be updated.
	     case "instruction":
	    	 result.instruction = content;
	       break;
	     case "status":
	    	 result.status = content;
	       break;
	   }
	  }
	 
	  @Override
	  public void characters(char[] ch, int start, int length) 
	          throws SAXException {
	    content = String.copyValueOf(ch, start, length).trim();
	  }
	     
	}