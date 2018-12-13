package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	
	/**      匿名内部类      ***/
	private static Thread memberAnonymous = new Thread(){
		
	};
	
	/**    成员内部类        ***/
	private class MemberInner extends Super{
		
		private String a2;
		public int b2;
	
		public MemberInner(){
			
		}
		
		
		public MemberInner(String str){
			
		}
		
		private MemberInner(int str){
			
		}
		
		
		public void a2() {
			
		}
		
		private void b2() {
			
		}
		
		
	}
	
	private class Super{
		private int a1;
		public int b1;
		
		public void a1() {
			
		}
		
		private void b1() {
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		/**
		 * 局部内部类
		 * @author Administrator
		 *
		 */
		class LocaInner{
			
		}
		
		/**
		 * 局部匿名内部类
		 */
		Thread localAnonymous = new Thread(){
			public void run() {};
		};
		
		try {
			Class<MemberInner> cls = 
					(Class<MemberInner>) Class.forName("reflect.Test$MemberInner");
			
			/**
			 * 获取所有public的构造器
			 */
			System.out.println("getConstructors");
			constructor(cls.getConstructors());
			/**
			 * 获取所有声明的构造器
			 */
			System.out.println("getDeclaredConstructors");
			constructor(cls.getDeclaredConstructors());
			/**
			 *获取在构造器定义的类的构造器
			 */
			System.out.println("getEnclosingConstructor");
			constructor(LocaInner.class.getEnclosingConstructor());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取在当前类声明的所有字段
			 */
			System.out.println("getDeclaredFields");
			field(cls.getDeclaredFields());
			/**
			 * 获取所有声明和继承的public字段
			 */
			System.out.println("getFields");
			field(cls.getFields());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取当前类声明的所有方法
			 */
			System.out.println("getDeclaredMethods");
			method(cls.getDeclaredMethods());
			
			
			/**
			 * 获取所有声明和继承的public方法
			 */
			System.out.println("getMethods");
			method(cls.getMethods());	
			/**
			 * 获取在方法中声明的局部类的外部方法
			 */
			System.out.println("getEnclosingMethod");
			method(LocaInner.class.getEnclosingMethod());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取所有声明的成员内部类
			 */
			System.out.println("getDeclaredClasses");
			classes_(Test.class.getDeclaredClasses());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取内部类的外部类
			 */
			System.out.println("getEnclosingClass");
			class_(MemberInner.class.getEnclosingClass());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 是否是匿名类，是否是局部类，成员内部类
			 */
			System.out.println("MemberInner isMemberClass " + MemberInner.class.isMemberClass());
			System.out.println("MemberInner isAnonymousClass " + MemberInner.class.isAnonymousClass());
			System.out.println("MemberInner isLocalClass " + MemberInner.class.isLocalClass()); 
			System.out.println("LocaInner isMemberClass " + LocaInner.class.isMemberClass());
			System.out.println("LocaInner isAnonymousClass " + LocaInner.class.isAnonymousClass());
			System.out.println("LocaInner isLocalClass " + LocaInner.class.isLocalClass()); 
			System.out.println("memberAnonymous isMemberClass " + memberAnonymous.getClass().isMemberClass());
			System.out.println("memberAnonymous isAnonymousClass " + memberAnonymous.getClass().isAnonymousClass());
			System.out.println("memberAnonymous isLocalClass " + memberAnonymous.getClass().isLocalClass()); 
			System.out.println("localAnonymous isMemberClass " + localAnonymous.getClass().isMemberClass());
			System.out.println("localAnonymous isAnonymousClass " + localAnonymous.getClass().isAnonymousClass());
			System.out.println("localAnonymous isLocalClass " + localAnonymous.getClass().isLocalClass()); 
			
			/**
			 * 获取内部类的全限定名
			 */
			class_(MemberInner.class);
			class_(LocaInner.class);
			class_(memberAnonymous.getClass());
			class_(localAnonymous.getClass());
			
			System.out.println("-------------------------------------------");
			
			System.out.println(Test.class.getResource("/"));
			
			System.out.println("-------------------------------------------");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void class_(Class<?> classes){
		if(classes == null){
			return;
		}
		System.out.println(classes.getName());
	}
	
	private static void classes_(Class<?>[] classes){
		for(Class cls:classes){
			class_(cls);
		}
		System.out.println();
	}
	
	 
	private static void constructor(Constructor<?>[] constructors){
		for(Constructor<?> constructor:constructors){
			constructor(constructor);
		}
		System.out.println();
	}
	
	private static void constructor(Constructor<?> constructor){
		if(constructor == null){
			System.out.println("null");
			return;
		}
		String desc = constructor.toString();
		System.out.println(desc);
	}
	
	private static void field(Field[] fields){
		for(Field field:fields){
			field(field);
		}
		System.out.println();
	}
	
	private static void field(Field field){
		if(field == null){
			return;
		}
		String desc = field.toString();
		System.out.println(desc); 
	}
	
	private static void method(Method[] methods){
		for(Method method:methods){
			method(method);
		}
		System.out.println();
	}
	
	private static void method(Method method){
		if(method == null){
			return;
		}
		String desc = method.toString();
		System.out.println(desc); 
	}
	
	
	
}
