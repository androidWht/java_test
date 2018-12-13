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
 * 泛型类：
 * 		1 定义
 * 			类名后加<T> <T extends String>  T：为泛型参数。继承必须使用具体的类   X<T> extends Comparable<String>
 *			泛型类型声明：List<String> List<?> List<? extends String> List<? super String>			
 * 泛型方法：
 * 		<T> void a();
 * 
 * java泛型是通过擦除实现的，擦除为其上边界。
 * java类型推导：只在赋值可用。
 * 
 * {@link Type}
 * 		{@link TypeVariable } 类型参数
 * 		{@link ParameterizedType} 参数化的类型
 * 		{@link GenericArrayType} 其成员类型为泛型的数组类型。
 * 		{@link WildcardType} 通配符类型？ <? extends T>   <? super T>
 * 
 * 
 * ? 代表任意类型
 * ? extends T 代表T及其子类的任意类型
 * ? super T 代表T及T父类的任意类型
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
	 *   测试参数化类型
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
	 * 测试上边界 
	 */
	public static void testUpperWildcards(List<? extends Integer> list) {
		
	}
	
	/**
	 * 测试下边界
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
