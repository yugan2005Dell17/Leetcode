package HeadFirstDesign.java;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {	

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException{
		int c = this.in.read();
		
		return c==-1? c : Character.toLowerCase((char) c);
	}
	
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}
	
	public int read(byte[] b, int off, int len) throws IOException {
		int result = this.in.read(b, off, len);
		for (int i=off; i<off+len; i++){
			if (b[i]!=-1)
				b[i]= (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}
	

}
