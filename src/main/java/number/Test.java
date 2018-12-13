package number;

/**
 * Java操作short，byte时，会将其先转换为int，在进行计算。
 * 
 * Java短位转长位，转换方式为使用符号位扩展高位。（值保持不变） 
 *
 * Java长位转短位，先截断高位，再使用符号位扩展高位。
 * 
 * Java浮点数与整数之间的转换：截断小数部分或者值保持不变。
 * 
 */
public class Test {
	
	public static void main(String[] args) {
//		intToByte();
		doubleToInt();
	}
	
	
	private static void intToByte() {
		
		int n = 255;
		
		System.out.println(Integer.toBinaryString(n)); 
		
		byte b = (byte)n;
		
		System.out.println(Integer.toBinaryString(b));
		
		System.out.println(b); 
		
		
	}
	
	private static void doubleToInt() {
		
		double d = 2.5d;
		
		System.out.println(Double.toHexString(d)); 
		
		int i = (int)d;
		
		System.out.println(Integer.toHexString(i));
		
	}
	
	
	
}
