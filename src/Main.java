import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

class Instruction{
	String instruction;
	String className;
	String methodName;
	String path;
	String status;
	@Override
	public String toString() {
		return "Import_Instruction [instruction=" + instruction + ", className=" + className + ", methodName="
				+ methodName + ", path=" + path + ", status=" + status + "]";
	}
	
	
}


public class Main {
	 private int data1 = 100;
	  private String data2 = "hello";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String content = new String(Files.readAllBytes(Paths.get("D:\\Work\\Temp\\rksir\\simple\\src\\jsondata.txt")));

		String jsonStringArray[];
		String delimitter = "\n";
		jsonStringArray = content.split(delimitter);
		
		Gson gson = new Gson();
		
		int marks=0;
		Instruction instObj;
		for (int i = 0; i < jsonStringArray.length; i++){
			System.out.println(jsonStringArray[i]);
			instObj = gson.fromJson(jsonStringArray[i], Instruction.class);
			if(instObj.status==null)
				continue;
			if(instObj.instruction.equals("import"))	
				if(instObj.path.equals("com.fitnesse")&&instObj.status.equals("pass"))
						marks+=15;
			if(instObj.instruction.equals("make"))	
				if(instObj.className.equals("ShippingMode")&&instObj.status.equals("pass"))
						marks+=15;
			if(instObj.instruction.equals("call"))	
				if(instObj.status.equals("pass"))
						marks+=10;
				else if(instObj.status.equals("fail"))		//just for expressing the logic
						marks+=0;
			}

	      
	     
	      System.out.println("Marks: "+marks);

	}

}
