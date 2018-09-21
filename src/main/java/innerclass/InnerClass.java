package innerclass;

/**
 * 测试内部类：
 * 1 成员内部类
 * 2 局部内部类
 * 3 静态内部类
 * @author Administrator
 *
 */
public class InnerClass {
	
	public void main(String[] args){
		
	}
	
	//**成员内部类**/
	class A{
		
	}
	
	private class B{
		
	}
	
	protected class C{
		
	}
	
	public class D{
		
	}
	
	//**静态内部类*/
	static class E{
		
	}
	
	//**局部内部类*/
	private void anonymousClass(){
		class F{
			void doSometing(){
				
			}
		}
		new F().doSometing();
		
	}
	
	//**匿名内部类*/
	private void localClass(){
		new Thread(){
			public void run() {
				
			};
		}.start();
	}
	
	
}
