package classloader;

/**
 * 测试类加载过程。
 * 经测试n第一次的打印结果为null。这说明父类Super的构造器调用的时候，子类的成员变量还没有初始化。
 * 总结：继承类加载过程
 *    1 加载父类
 *    	1 加载字节码
 *    	2 创建Class对象
 *      3 静态初始化
 *    2 加载子类
 *    	1 加载字节码
 *    	2 创建Class对象
 *    	3 静态初始化
 *    3 初始化
 *    	 1 为成员变量分配内存(使用的是默认值)
 *    	 2 调用父类构造器
 *    	 3 调用子类构造器  		 
 * 必须完成父类构造后再进行子类构造。
 * 类成员变量的赋值是在构造方法中进行的。编译器将所有赋值指令按声明顺序插入在构造方法中。
 * 所以在调用父类构造器的时候子类的成员变量还没有初始化，这样如果在父类构造器调用被子类重写的方法，可能会出现初始化的问题。
 * 所以父类构造器中调用的方法应该尽量使用final。
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
