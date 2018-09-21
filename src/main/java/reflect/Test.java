package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	
	public static void main(String[] args) {
		
		/**
		 * 局部内部类
		 * @author Administrator
		 *
		 */
		class LocalAnonymousInner{
			
		}
		
		/**
		 * 匿名内部类
		 */
		Thread thread = new Thread(){
			public void run() {};
		};
		
		try {
			Class<MemberInner> cls = 
					(Class<MemberInner>) Class.forName("reflect.Test$MemberInner");
			
			/**
			 * 获取所有public的构造器
			 */
			constructor(cls.getConstructors());
			/**
			 * 获取所有声明的构造器
			 */
			constructor(cls.getDeclaredConstructors());
			/**
			 * 获取在构造器声明的局部类的构造器
			 */
			constructor(LocalAnonymousInner.class.getEnclosingConstructor());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取所有声明的字段
			 */
			field(cls.getDeclaredFields());
			/**
			 * 获取所有声明和继承的public字段
			 */
			field(cls.getFields());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取所有声明的方法
			 */
			method(cls.getDeclaredMethods());
			/**
			 * 获取所有声明和继承的public方法
			 */
			method(cls.getMethods());	
			/**
			 * 获取在方法中声明的局部类的外部方法
			 */
			method(LocalAnonymousInner.class.getEnclosingMethod());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取所有声明的成员内部类
			 */
			classes_(Test.class.getDeclaredClasses());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 获取内部类的外部类
			 */
			class_(MemberInner.class.getEnclosingClass());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * 是否是匿名类，是否是局部类，成员内部类
			 */
			System.out.println("MemberInner isMemberClass " + MemberInner.class.isMemberClass());
			System.out.println("MemberInner isAnonymousClass " + MemberInner.class.isAnonymousClass());
			System.out.println("MemberInner isLocalClass " + MemberInner.class.isLocalClass()); 
			System.out.println("LocalAnonymousInner isMemberClass " + LocalAnonymousInner.class.isMemberClass());
			System.out.println("LocalAnonymousInner isAnonymousClass " + LocalAnonymousInner.class.isAnonymousClass());
			System.out.println("LocalAnonymousInner isLocalClass " + LocalAnonymousInner.class.isLocalClass()); 
			System.out.println("THREAD isMemberClass " + THREAD.getClass().isMemberClass());
			System.out.println("THREAD isAnonymousClass " + THREAD.getClass().isAnonymousClass());
			System.out.println("THREAD isLocalClass " + THREAD.getClass().isLocalClass()); 
			System.out.println("thread isMemberClass " + thread.getClass().isMemberClass());
			System.out.println("thread isAnonymousClass " + thread.getClass().isAnonymousClass());
			System.out.println("thread isLocalClass" + thread.getClass().isLocalClass()); 
			
			/**
			 * 获取内部类的权限定名
			 */
			class_(MemberInner.class);
			class_(LocalAnonymousInner.class);
			class_(THREAD.getClass());
			
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
	
	
	/**    成员内部类        ***/
	private class MemberInner extends Super{
		
		private String str;
		private int number;
	
		public MemberInner(){
			
		}
		
		
		public MemberInner(String str){
			
		}
		
		private MemberInner(String[] args){
			
		}
		
		private void doSomething(){
			
		}
		
		private void doSomething(String args){
			
		}
		
		
	}
	
	
	private class Super{
		public String superStr = "superStre";
		public int superNumber = 0;
		
	}
	
	
	/**      匿名内部类      ***/
	private static Thread THREAD = new Thread(){
		
	};
}
