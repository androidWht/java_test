
package charater;

import java.nio.charset.Charset;

public class Test {
	public static void main(String[] args) {
		charset();
	}
	
	private void specicalChar(){
		byte[] arrays = "\n".getBytes();
        byte[] arrays1 = "\\n".getBytes();
        String str1 = "";
        for(byte by:arrays){
            str1 = str1 + " " + Integer.toHexString(by);
        }
        System.out.println(str1);

        String str2 = "";
        for(byte by:arrays1){
        	str2 = str2 + " " + Integer.toHexString(by);
        }
        System.out.println(str2);
        
        System.out.println("\n");
        System.out.println("\\n");
	}
	
	private static void charset(){
		Charset defualttCharset = Charset.defaultCharset();
		System.out.println(defualttCharset); 
	}
	
	private static void chinese() {
		char character = 'жа';
	}
	
	
}
