package innerclass;

/**
 * �����ڲ��ࣺ
 * 1 ��Ա�ڲ���
 * 2 �ֲ��ڲ���
 * 3 ��̬�ڲ���
 * @author Administrator
 *
 */
public class InnerClass {
	
	public void main(String[] args){
		
	}
	
	//**��Ա�ڲ���**/
	class A{
		
	}
	
	private class B{
		
	}
	
	protected class C{
		
	}
	
	public class D{
		
	}
	
	//**��̬�ڲ���*/
	static class E{
		
	}
	
	//**�ֲ��ڲ���*/
	private void anonymousClass(){
		class F{
			void doSometing(){
				
			}
		}
		new F().doSometing();
		
	}
	
	//**�����ڲ���*/
	private void localClass(){
		new Thread(){
			public void run() {
				
			};
		}.start();
	}
	
	
}
