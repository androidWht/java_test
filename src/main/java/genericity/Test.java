package genericity;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �����ࣺ
 * 		1 ����
 * 			�������<T> <T extends String>  T��Ϊ���Ͳ������̳б���ʹ�þ������   X<T> extends Comparable<String>
 *			��������������List<String> List<?> List<? extends String> List<? super String>			
 * ���ͷ�����
 * 		<T> void a();
 * 
 * java������ͨ������ʵ�ֵģ�����Ϊ���ϱ߽硣
 * java�����Ƶ���ֻ�ڸ�ֵ���á�
 * 
 * {@link Type}
 * 		{@link TypeVariable } ���Ͳ���
 * 		{@link ParameterizedType} ������������
 * 		{@link GenericArrayType} ���Ա����Ϊ���͵��������͡�
 * 		{@link WildcardType} ͨ������ͣ� <? extends T>   <? super T>
 * 
 * 
 * ? ������������
 * ? extends T ����T�����������������
 * ? super T ����T��T�������������
 *
 * Class A ,Class B extends A.
 * List<A> != List<B>;
 * List<? extends A> = List<A>; List<? extends A> = List<B>;List<? extends A> = List<? extends B>
 * List<? super B> = List<B>; List<? super B> = List<A>;
 * ? extends A != A != B != ? super B;
 * 
 * @author Administrator
 *
 */
public class Test {
	
	private List<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
//		List<? extends Integer> listUpper = new ArrayList<>();
//		testUpperWildcards(listUpper); 
//		
//		List<? super Integer> listLower = new ArrayList<>();
//		testLowerWildcards(listLower);
		
//		testMethodParameterType();
		
		testFieldType();
		
 	}
	
	/**
	 *   ���Բ���������
	 */
	private static void testMethodParameterType() {

		Class<Test> cls = Test.class;
		try {
			Method method = cls.getDeclaredMethod("parameterMethod",List.class);
			Type returnType = method.getReturnType();
			Type genericReturnType = method.getGenericReturnType();
			Parameter[] parameters = method.getParameters();
			
			Type parameterType = parameters[0].getParameterizedType();
			
			printType(parameterType);
			
			printType(genericReturnType);
			
			System.out.println("parameters:" + Arrays.toString(parameters)); 
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static void testFieldType() {
		
		try {
			Field field = Test.class.getDeclaredField("list");
			Type fieldType = field.getGenericType();
			printType(fieldType);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static List<List<String>> parameterMethod(List<List<String>> list){
		
		return list;
		
	}
	
	
	/**
	 * �����ϱ߽� 
	 */
	public static void testUpperWildcards(List<? extends Integer> list) {
		
	}
	
	/**
	 * �����±߽�
	 */
	public static void testLowerWildcards(List<? super Integer> list) {
		
	}
	
	
	
	private static void printType(Type type) {
		System.out.println("#######################################"); 
		String typeName = type.getTypeName();
		System.out.println("typeName:" + typeName); 
		if(type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)type;
			Type rawType = parameterizedType.getRawType();
			Type[] actualTypes = parameterizedType.getActualTypeArguments();
			Type ownerType = parameterizedType.getOwnerType();
			System.out.println("ParameterizedType rawType " + rawType.getTypeName());
			for(Type item:actualTypes) {
				System.out.println("ParameterizedType actualType " + item.getTypeName());
			}
			System.out.println("ParameterizedType ownerType " + ownerType);
		}else if(type instanceof TypeVariable) {
			TypeVariable typeVariable = (TypeVariable)type;
			GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
			Type[] bounds = typeVariable.getBounds();
			System.out.println("TypeVariable genericDeclaration:" + Arrays.toString(genericDeclaration.getTypeParameters()));   
			for(Type item:bounds) {
				System.out.println("TypeVariable bound " + item.getTypeName());
			}
		}else if(type instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType)type;
			Type[] lowerTypes = wildcardType.getLowerBounds();
			Type[] upperTypes = wildcardType.getUpperBounds();
			
			for(Type item:lowerTypes) {
				System.out.println("WildcardType lowerType " + item.getTypeName());
			}
			for(Type item:upperTypes) {
				System.out.println("WildcardType upperType " + item.getTypeName());
			}
		}else if(type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType)type;
			Type componentType = arrayType.getGenericComponentType();
			System.out.println("GenericArrayType componentType " + componentType.getTypeName());
		}
		System.out.println("#######################################"); 
	}
	
	
	
}
