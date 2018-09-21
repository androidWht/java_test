package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Test Java OutPutStream
 * @author Administrator
 *
 */
public class Out {
	public static void main(String[] args) throws IOException{
		OutputStream outputStream = null;
		byte[] bytes = new byte[1024];
		/**
		 * write a byte
		 */
		outputStream.write('a');
		
		/**
		 * write bytes
		 */
		outputStream.write(bytes);
		
		/**
		 * write bytes of [off,len)
		 */
		int off = 0;
		int len = 1024;
		outputStream.write(bytes, off, len);
		
		/**
		 * flush buffer
		 */
		outputStream.flush();
		
		/**
		 * close OutputStream and clear resource
		 */
		outputStream.close();
	}
}
