package classloader;

public class ClassObj {
	
	public static void main(String[] args) {
		
		primitiveClassTest();

	}
	
	
	/**
	 * 8�ֻ������Ͷ������Ӧ��class�����������������ʹ�����װ���.TYPE�ֶο��Ի�ȡ��
	 * �������͵İ�װ���͵�Class!=�������͵�Class
	 */
	private static void primitiveClassTest(){
		System.out.println("Test isPrimitive = " + isWrapperClass(ClassObj.class)); 
		System.out.println("Integer isPrimitive = " + isWrapperClass(Integer.class)); 
		System.out.println("Short isPrimitive = " + isWrapperClass(Short.class)); 
		System.out.println("Long isPrimitive = " + isWrapperClass(Long.class)); 
		System.out.println("Byte isPrimitive = " + isWrapperClass(Byte.class)); 
		System.out.println("Double isPrimitive = " + isWrapperClass(Double.class)); 
		System.out.println("Float isPrimitive = " + isWrapperClass(Float.class)); 
		System.out.println("Character isPrimitive = " + isWrapperClass(Character.class)); 
		System.out.println("Boolean isPrimitive = " + isWrapperClass(Boolean.class));
		
		System.out.println("Boolean isPrimitive = " + Boolean.TYPE.isPrimitive()); 
	}
	
	private static boolean isWrapperClass(Class<?> cls){
		return cls == Integer.TYPE || cls == Long.TYPE 
				|| cls == Short.TYPE|| cls == Byte.TYPE|| cls == Double.TYPE
				|| cls == Float.TYPE|| cls == Character.TYPE|| cls == Boolean.TYPE;
	}
}
