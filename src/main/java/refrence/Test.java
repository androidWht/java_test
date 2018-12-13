package refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
/**
 * SoftReference ֻ���ڶ��ڴ治��ʱ�Ż���SoftReference�е�����
 * 		��ǿ����ʱ
 * WeakReference �������ռ�������ʱ����WeakReference�е�����
 * 		��ǿ���ã���������
 * PhantomReference ��Ӱ�����
 * 		��ǿ���ã��������ã��������ã�û����дfinalize����finalize�Ѿ�����
 */
public class Test {
	
	private static final ReferenceQueue<E> queue = new ReferenceQueue<>();
	
	private static WeakReference<E> wekRef;
	
	private static SoftReference<E> softRef;
	
	private static PhantomReference<E> phantomRef;
	
	public static void main(String[] args) {
	
		E instance = new E();
		
		wekRef = new WeakReference<>(instance,queue);
		softRef = new SoftReference<>(instance,queue);
		phantomRef = new PhantomReference<>(instance,queue);
		
		instance = null;
		
		System.gc();
		
		System.out.println("Start"); 
		
		Reference<? extends Object> ref = null;
		
		try {
			while((ref = queue.remove()) != null) {
				
				System.out.println(ref.getClass().getName()); 
				
				if(ref instanceof PhantomReference) {
					
					ref.clear();
					
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End"); 
		
		
	}
	
	private static class E{
		
		@Override
		protected void finalize() throws Throwable {
			
			super.finalize();
			
			
		}
		
	}
	
	
	
}
