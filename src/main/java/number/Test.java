package number;

/**
 * Java����short��byteʱ���Ὣ����ת��Ϊint���ڽ��м��㡣
 * 
 * Java��λת��λ��ת����ʽΪʹ�÷���λ��չ��λ����ֵ���ֲ��䣩 
 *
 * Java��λת��λ���Ƚضϸ�λ����ʹ�÷���λ��չ��λ��
 * 
 * Java������������֮���ת�����ض�С�����ֻ���ֵ���ֲ��䡣
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
