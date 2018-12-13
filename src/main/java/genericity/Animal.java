package genericity;

public class Animal<T> {
	
	public final T name;

	public Animal(T name) {
		this.name = name;
	}
	
	T getValue() {
		return name;
	}
	
}
