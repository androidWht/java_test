package innerclass;


/**
 * ���������ⲿ�����ڲ���
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
