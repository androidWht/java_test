package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	
	public static void main(String[] args) {
		
		/**
		 * �ֲ��ڲ���
		 * @author Administrator
		 *
		 */
		class LocalAnonymousInner{
			
		}
		
		/**
		 * �����ڲ���
		 */
		Thread thread = new Thread(){
			public void run() {};
		};
		
		try {
			Class<MemberInner> cls = 
					(Class<MemberInner>) Class.forName("reflect.Test$MemberInner");
			
			/**
			 * ��ȡ����public�Ĺ�����
			 */
			constructor(cls.getConstructors());
			/**
			 * ��ȡ���������Ĺ�����
			 */
			constructor(cls.getDeclaredConstructors());
			/**
			 * ��ȡ�ڹ����������ľֲ���Ĺ�����
			 */
			constructor(LocalAnonymousInner.class.getEnclosingConstructor());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ�����������ֶ�
			 */
			field(cls.getDeclaredFields());
			/**
			 * ��ȡ���������ͼ̳е�public�ֶ�
			 */
			field(cls.getFields());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ���������ķ���
			 */
			method(cls.getDeclaredMethods());
			/**
			 * ��ȡ���������ͼ̳е�public����
			 */
			method(cls.getMethods());	
			/**
			 * ��ȡ�ڷ����������ľֲ�����ⲿ����
			 */
			method(LocalAnonymousInner.class.getEnclosingMethod());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ���������ĳ�Ա�ڲ���
			 */
			classes_(Test.class.getDeclaredClasses());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ�ڲ�����ⲿ��
			 */
			class_(MemberInner.class.getEnclosingClass());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * �Ƿ��������࣬�Ƿ��Ǿֲ��࣬��Ա�ڲ���
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
			 * ��ȡ�ڲ����Ȩ�޶���
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
	
	
	/**    ��Ա�ڲ���        ***/
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
	
	
	/**      �����ڲ���      ***/
	private static Thread THREAD = new Thread(){
		
	};
}
