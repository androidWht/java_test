package garbage;

/**
 * 测试垃圾收集时finalize()方法被调用的情况
 * 经测试发现有些对象的finalize()方法没有被调用
 * @author Administrator
 *
 */
public class Garbage{
	
	static boolean stopCreate = false; 
	public static void main(String[] args) {
		System.out.println(args[0]); 
		new Thread(){
			public void run() {
				try {
					sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stopCreate = true;
			}
		}.start();
		while(!Chair.f && !stopCreate){
			new Chair();
			new String("To take up space");
		}
		System.out.println("After all Chairs have been created:\n" 
				+ "total created = " + Chair.created 
				+ ",total finalized = " + Chair.finalized);
		if(args[0].equals("before")){
			System.out.println("gc():");
			System.gc();
			System.out.println("runFinalizeation():");
			System.runFinalization();
		}
		System.out.println("bye!");
		if(args[0].equals("after")){
			System.runFinalizersOnExit(true);
		}
	}
	
	
}

class Chair {
	volatile static boolean gcrun;
	volatile static boolean f;
	volatile static int created = 0;
	volatile static int finalized = 0;
	int i;
	
	Chair(){
		i = ++ created;
		if(created == 47){
			System.out.println("Created 47");
		}
	}
	
	@Override
	protected void finalize(){
		if(!gcrun){
			gcrun = true;
		}
		System.out.println("Beginning to finlize " + i + " after "
		+ created + " Chairs have been created");
		if(i == 47){
			System.out.println("Finalizing Chair #47, " 
		+ "Setting flag to stop Chair creation");
			f = true;
		} 
		finalized++;
		if(finalized >= created){
			System.out.println("All " + finalized + " finalized");
		}
	}
}
