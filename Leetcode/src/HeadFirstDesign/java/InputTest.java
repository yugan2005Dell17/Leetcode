package HeadFirstDesign.java;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	
	public static void main(String[] args) throws IOException{
		int c=0;
		InputStream test = new FileInputStream("test.txt");
		test = new BufferedInputStream(test);
		test = new LowerCaseInputStream(test);
		
		while (c>=0){
			c = test.read();
			if (c!=-1) System.out.print((char)c);
		}
		test.close();
	}
}
	
	


