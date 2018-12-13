package inherit;

public class Test {
	
	
	public static void main(String[] args) {
		
		A a = new B();
		
		Object str = a.a();
		
		System.out.println(str);
		
	}
	
	
	private static class A{
		
		Object a() {
			
			return "A.a()";
			
		}
		
	}
	
	private static class B extends A{
		
		String a() {
			
			return "B.a()";
			
		}
		
	}
	

}
