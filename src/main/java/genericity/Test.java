package genericity;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
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
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		List<? extends Map<String, String>> list5 
				= new ArrayList<HashMap<String,String>>();
//		
//		types("List getTypeParameters",list5.getClass().getTypeParameters(),true);
//		
//		types("A getTypeParameters",A.class.getTypeParameters(),true);
//		types("B getTypeParameters",B.class.getTypeParameters(),true);
//		types("C getTypeParameters",C.class.getTypeParameters(),true);
//		
//		type("String getGenericSuperclass",F.class.getGenericSuperclass(),true);
//		types("String getGenericInterfaces",F.class.getGenericInterfaces(),true);
		
		
		test();
		
 	}
	
	
	private static void test() {
		Type type = Dog.class.getGenericSuperclass();
		type("Dog GenericSuperclass",type,true);
		Type[] types = Dog.class.getGenericInterfaces();
		types("Dog GenericInterfaces",types,true); 
		TypeVariable<Class<Dog>>[] typeParameters = Dog.class.getTypeParameters();
		types("Dog TypeParameters",typeParameters,true);
	}
	
	
	private static void types(String prix,Type[] types,boolean deep){
		for(Type type:types){
			type(prix,type,deep);
		}
	}
	
	private static void type(String prix,Type type,boolean deep){
		
		System.out.println("--------------------------------------");
		
		if(type == null){
			System.out.println(prix + ":" + null);
			return;
		}
		
		System.out.println(prix + "Type name:" + type.getTypeName());
		if(type instanceof ParameterizedType){
			System.out.println(prix + ":" + "ParameterizedType");
			ParameterizedType parameterizedType = (ParameterizedType)type;
			type(prix + " " + "ParameterizedType RawType", parameterizedType.getRawType(),false);
			type(prix + " " + "ParameterizedType OwnerType", parameterizedType.getOwnerType(),false);
			Type[] actualTypes = parameterizedType.getActualTypeArguments();
			for(Type actualType:actualTypes){
				type(prix + " " + "ParameterizedType ActualTypeArguments", actualType,false);
			}
		}else if(type instanceof GenericArrayType){
			System.out.println(prix + ":" + "ParameterizedType");
			GenericArrayType genericArrayType = (GenericArrayType)type;
			type(prix + " " + "getGenericComponentType",genericArrayType.getGenericComponentType(),false);
		}else if(type instanceof TypeVariable){
			System.out.println(prix + ":" + "TypeVariable");
			TypeVariable<?> typeVariable = (TypeVariable<?>)type;
			System.out.println(prix + " TypeVariable name " + type.getTypeName());
			AnnotatedType[] annotatedTypes = typeVariable.getAnnotatedBounds();
			for(AnnotatedType anootatedType:annotatedTypes){
				System.out.println(prix + " " + "TypeVariable AnnotatedBounds " + anootatedType.getClass().getName()); 
			}
			Type[] bounds = typeVariable.getBounds();
			for(Type bound:bounds){
				type(prix + " " + "TypeVariable Bounds",bound,false);
			}
		}else if(type instanceof WildcardType){
			System.out.println(prix + ":" + "WildcardType");
			WildcardType wildcardType = (WildcardType)type;
			types(prix + " " + "WildcardType LowerBounds",wildcardType.getLowerBounds(),false);
			types(prix + " " + "WildcardType UpperBounds",wildcardType.getUpperBounds(),false);
		}
	}
	
	private static class A<A>{
		
	}
	
	private static class B<String>{
		
	}
	
	private static class C<C extends String>{ 
		
	}
	
	private interface E<E> {
		
	}
	
	private static class F<F> extends C<String>{ 
		
	}
	
	public static <T> void add(T t){
		
	}
	
	
	private interface UnaryFunction<T>{
		T apply(T arg);
	}
	
	
	private static UnaryFunction<String> GENERIC_INSTANCE = new UnaryFunction<String>(){

		@Override
		public String apply(String arg) {
			return arg;
		}
		
	};
	
	@SuppressWarnings("unchecked")
	private static <T> UnaryFunction<T> identityFunction(){
		return (UnaryFunction<T>)GENERIC_INSTANCE;
	}
	
	private static void dontKnown(){
		UnaryFunction<String> str = identityFunction();
		UnaryFunction<Integer> integer = identityFunction();
		integer.apply(1);
	}
	
	
	
	
	
	private class Favoriter{
		private Map<Class<?>,Object> favorites = new HashMap<>();
		
		public <T> T getFavoriter(Class<T> cls){
			
			return cls.cast(favorites.get(cls));  
			
		}
		
		public <T> void setFavoriter(Class<T> cls,T instance){
			favorites.put(cls, instance);
		}
		
	}
	
	private void testFavoriter(){
		Favoriter favoriter = new Favoriter();
		favoriter.setFavoriter(Integer.class, 1);
		favoriter.setFavoriter(String.class,"str");
		
		int num = favoriter.getFavoriter(Integer.class);
		String str = favoriter.getFavoriter(String.class);
	}
	
}
