package genericity;

public class Animal<T extends String> {
	
	public final T name;

	public Animal(T name) {
		this.name = name;
	}
	
}
