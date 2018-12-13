package error;

public class Test {

	
	public static void main(String[] args) {
		
		try {
			throw new OutOfMemoryError();
		}catch(Error error) {
			error.printStackTrace();
		}
		
		System.out.println("Try Catch Error");
		
	}
	
}
