package enums;

public class Test {
	public static void main(String[] args) {
		Planet planet = Planet.EARTH;
		Planet venus = Planet.VENUS;
		System.out.println(planet.getClass().getName()); 
	}
	
	public enum Planet{
		MERCURY,
		VENUS,
		EARTH,
		JUPITER;
	}
	
}
