package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	
	/**      �����ڲ���      ***/
	private static Thread memberAnonymous = new Thread(){
		
	};
	
	/**    ��Ա�ڲ���        ***/
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
		 * �ֲ��ڲ���
		 * @author Administrator
		 *
		 */
		class LocaInner{
			
		}
		
		/**
		 * �ֲ������ڲ���
		 */
		Thread localAnonymous = new Thread(){
			public void run() {};
		};
		
		try {
			Class<MemberInner> cls = 
					(Class<MemberInner>) Class.forName("reflect.Test$MemberInner");
			
			/**
			 * ��ȡ����public�Ĺ�����
			 */
			System.out.println("getConstructors");
			constructor(cls.getConstructors());
			/**
			 * ��ȡ���������Ĺ�����
			 */
			System.out.println("getDeclaredConstructors");
			constructor(cls.getDeclaredConstructors());
			/**
			 *��ȡ�ڹ������������Ĺ�����
			 */
			System.out.println("getEnclosingConstructor");
			constructor(LocaInner.class.getEnclosingConstructor());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ�ڵ�ǰ�������������ֶ�
			 */
			System.out.println("getDeclaredFields");
			field(cls.getDeclaredFields());
			/**
			 * ��ȡ���������ͼ̳е�public�ֶ�
			 */
			System.out.println("getFields");
			field(cls.getFields());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ��ǰ�����������з���
			 */
			System.out.println("getDeclaredMethods");
			method(cls.getDeclaredMethods());
			
			
			/**
			 * ��ȡ���������ͼ̳е�public����
			 */
			System.out.println("getMethods");
			method(cls.getMethods());	
			/**
			 * ��ȡ�ڷ����������ľֲ�����ⲿ����
			 */
			System.out.println("getEnclosingMethod");
			method(LocaInner.class.getEnclosingMethod());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ���������ĳ�Ա�ڲ���
			 */
			System.out.println("getDeclaredClasses");
			classes_(Test.class.getDeclaredClasses());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * ��ȡ�ڲ�����ⲿ��
			 */
			System.out.println("getEnclosingClass");
			class_(MemberInner.class.getEnclosingClass());
			
			System.out.println("-------------------------------------------");
			
			/**
			 * �Ƿ��������࣬�Ƿ��Ǿֲ��࣬��Ա�ڲ���
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
			 * ��ȡ�ڲ����ȫ�޶���
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
