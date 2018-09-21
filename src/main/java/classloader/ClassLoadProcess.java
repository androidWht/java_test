package classloader;

/**
 * ��������ع��̡�
 * ������n��һ�εĴ�ӡ���Ϊnull����˵������Super�Ĺ��������õ�ʱ������ĳ�Ա������û�г�ʼ����
 * �ܽ᣺�̳�����ع���
 *    1 ���ظ���
 *    	1 �����ֽ���
 *    	2 ����Class����
 *      3 ��̬��ʼ��
 *    2 ��������
 *    	1 �����ֽ���
 *    	2 ����Class����
 *    	3 ��̬��ʼ��
 *    3 ��ʼ��
 *    	 1 Ϊ��Ա���������ڴ�(ʹ�õ���Ĭ��ֵ)
 *    	 2 ���ø��๹����
 *    	 3 �������๹����  		 
 * ������ɸ��๹����ٽ������๹�졣
 * ���Ա�����ĸ�ֵ���ڹ��췽���н��еġ������������и�ֵָ�����˳������ڹ��췽���С�
 * �����ڵ��ø��๹������ʱ������ĳ�Ա������û�г�ʼ������������ڸ��๹�������ñ�������д�ķ��������ܻ���ֳ�ʼ�������⡣
 * ���Ը��๹�����е��õķ���Ӧ�þ���ʹ��final��
 * @author Administrator
 *
 */
public class ClassLoadProcess {
	
	private static abstract class Super{
		
		public Super(){
			doSometing();
		}
		
		public abstract void doSometing();
	}
	
	private static class Children extends Super{
		
		private String n = "Children";
		
		public Children(){
			super();
		}

		@Override
		public void doSometing() {
			System.out.println(n); 
		}
		
	}
	
	public static void main(String[] args){
		new Children();
	}
	
}
