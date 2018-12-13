package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 不同的类装载器实例装载的类型是不一样的。 
 *
 */
public class ClassObj {
	
	public static void main(String[] args) {
		primitiveClassTest();
		loadByteCodeFile();
		getSystemClassLoader();
	}
	
	
	
	private static void getSystemClassLoader() {
		String name = "collection.Test";
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			Class<?> cls = classLoader.loadClass(name);
			System.out.println("System ClassLoader " + cls.getName()); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("System ClassLoader " + classLoader.getClass().getName()); 
		
		classLoader = ClassObj.class.getClassLoader();
		try {
			Class<?> cls = classLoader.loadClass(name);
			System.out.println("ClassObj ClassLoader " + cls.getName()); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("ClassObj ClassLoader " + classLoader.getClass().getName()); 
		
		try {
			Class <?> cls = Class.forName(name);
			System.out.println("forName " + cls.getName()); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Class <?> cls = Class.forName("java.lang.String");
			ClassLoader loadClassLoader = cls.getClassLoader();
			if(loadClassLoader != null) {
				System.out.println("String ClassLoader " +
							loadClassLoader.getClass().getName());
			}
			System.out.println("String forName " + cls.getName()); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void loadByteCodeFile() {
		String name = "ByteCodeFile";
		try {
			
			CustomClassLoader clssLoader = new CustomClassLoader();
			Class<?> cls = clssLoader.loadClass(name);
			Method m = cls.getMethod("invoke");
			m.invoke(null);
			
			CustomClassLoader clssLoader1 = new CustomClassLoader();
			Class<?> cls1 = clssLoader1.loadClass(name);
			
			System.out.println(cls == cls1);
			
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
	/**
	 * 8种基本类型都有其对应的class对象，由虚拟机创建，使用其包装类的.TYPE字段可以获取。
	 * 基本类型的包装类型的Class!=基本类型的Class
	 */
	private static void primitiveClassTest(){
		System.out.println("Test isPrimitive = " + isWrapperClass(ClassObj.class)); 
		System.out.println("int isPrimitive = " + isWrapperClass(int.class)); 
		System.out.println("Integer isPrimitive = " + isWrapperClass(Integer.class)); 
		System.out.println("Boolean isPrimitive = " + Boolean.TYPE.isPrimitive()); 
	}
	
	private static boolean isWrapperClass(Class<?> cls){
		return cls == Integer.TYPE || cls == Long.TYPE 
				|| cls == Short.TYPE|| cls == Byte.TYPE|| cls == Double.TYPE
				|| cls == Float.TYPE|| cls == Character.TYPE|| cls == Boolean.TYPE;
	}
}
