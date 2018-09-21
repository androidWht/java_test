package innerclass;


/**
 * 测试在类外部访问内部类
 * @author Administrator
 *
 */
public class AccessInnerClass {
	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		InnerClass.A a = innerClass.new A();
		
		InnerClass.E e = new InnerClass.E();
		
		
	}
}
