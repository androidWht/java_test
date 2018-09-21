package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test Java Input
 * 1 Read       read()
 * 2 Buffer		available()
 * 3 Seek		skip()  mark()  reset()  markSupport()
 * @author Administrator
 *
 */
public class Input {
	public static void main(String[] args) throws IOException{
		byte[] bytes = new byte[1024];
		InputStream inputStream = null;
		/**
		 * read a byte
		 */
		inputStream.read();
		/**
		 * read [0,bytes.length) byte
		 */
		inputStream.read(bytes);
		
		/**
		 * read [off,length) bytes
		 */
		int off = 0;
		int length = 1024;
		inputStream.read(bytes,off,length);
		
		/**
		 * skip skipLength bytes
		 */
		int skipLength = 1024;
		inputStream.skip(skipLength);
		/**
		 * check the available length read or skip without block
		 */
		inputStream.available();
		/**
		 * mark current position,mark available when read bytes length less than limitMark
		 */
		int limitMark = 1024;
		inputStream.mark(1024);
		/**
		 * reset to mark position
		 */
		inputStream.reset();
		/**
		 * check mark is support
		 */
		inputStream.markSupported();
		
		/**
		 * close InputStream and clear resource
		 */
		inputStream.close();
	}
}
