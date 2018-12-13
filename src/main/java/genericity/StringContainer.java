package genericity;

public class StringContainer implements Container<String> {

	private String value;
	
	@Override
	public String get() {
		return value;
	}

	@Override
	public void set(String e) {
		this.value = e;
	}

}
