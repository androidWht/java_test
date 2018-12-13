package refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
/**
 * SoftReference 只有在堆内存不足时才回收SoftReference中的引用
 * 		无强引用时
 * WeakReference 在垃圾收集器运行时回收WeakReference中的引用
 * 		无强引用，无软引用
 * PhantomReference 不影响回收
 * 		无强引用，无软引用，无弱引用，没有重写finalize或者finalize已经运行
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
