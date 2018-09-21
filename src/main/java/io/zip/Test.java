package io.zip;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipOutputStream;

public class Test {
	
	public static void main(String[] args){
		
		
		
	}
	
	
	public static void zipCompress() throws IOException{
		
		FileOutputStream fos = new FileOutputStream("d:/zipTest");
		CheckedOutputStream csum = new CheckedOutputStream(fos, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream bos = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
	}
	
	
}
