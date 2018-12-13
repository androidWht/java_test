package genericity;

public class GenericContainer<E> implements Container<E> {

	private E e;
	
	@Override
	public E get() {
		return e;
	}

	@Override
	public void set(E e) {
		this.e = e;
	}

}
