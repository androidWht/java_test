package genericity;


public class Dog extends Animal<String>{

	public Dog(String name) {
		super(name);
	}
	

	@Override
	String getValue() {
		return "Dog";
	}
	
	
	

}
