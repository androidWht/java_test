package test_finally;

public class Test {
	
	public static void main(String[] args) {
		
		boolean b = true;
		
		try {

			System.out.println("Try Execute");
			
			
		}finally {
			
			System.out.println("Finally Execute");
			
			if(b) {
				return;
			}
			
			
		}
		
		System.out.println("End Execute");
		
	}
	
	
	
}
