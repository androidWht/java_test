package genericity;


public class Dog<T extends String,D> extends Animal<T>{

	public D d;
	
	public Dog(T t,D d) {
		super(t);
		this.d = d;
	}
}
