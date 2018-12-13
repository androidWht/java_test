package rxjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class Test {
	public static void main(String[] args) {
//		interval();
//		timer();
//		take();
//		repeat();
//		elementAt();
//		debounce();
//		map();
//		flatMap();
//		concatMap();
//		flatMapIterable();
//		switchMap();
//		scan();
//		groupBy();
//		buffer();
//		window();
//		merge();
//		zip();
//		join();
//		combineLatest();
//		andThenWhen();
		startWith();
		
		//rxJava中线程都是守护线程，所以需要sleep
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	/**
	 * 从某个数据源中发送数据
	 *  集合
	 * Callable
	 * runnable
	 * future
	 */
	public static void from() {
		Observable.from(new Integer[] {1,2,3}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 *  调度发送数据
	 */
	public static void interval() {
		Observable.interval(1000,1000, TimeUnit.MILLISECONDS)
		.subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t);  
			} 
		});
	}
	
	/**
	 *  延迟发送数据
	 */
	public static void timer() {
		Observable.timer(1000, TimeUnit.MILLISECONDS)
		.subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t); 
			}
			
		},new Action1<Throwable>() {

			@Override
			public void call(Throwable t) {
				System.out.println(t); 
				
			}

			
			
		},new Action0() {

			@Override
			public void call() {
				System.out.println("end"); 
			}
			
		});
		
		
	}
	
	/**
	 *  发送前count条数据
	 */
	public static void take() {
		Observable.from(new Integer[] {1,2,3,4})
		.take(4)
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			 
		});
	}
	
	/**
	 *  重复数据流的发送
	 */
	public static void repeat() {
		Observable.from(new Integer[] {1,2,3,4})
		.repeat()
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 发送指定的index的数据，如果没有这条数据，发送指定数据
	 */
	public static void elementAt() {
		Observable.from(new Integer[] {1,2,3,4})
		.elementAtOrDefault(10, -1)
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 *  发送第一条数据，如果没有数据发送默认的数据
	 */
	public static void first() {
		Observable.from(new Integer[] {1,2,3,4})
		.firstOrDefault(-1, new Func1<Integer,Boolean>(){

			@Override
			public Boolean call(Integer t) {
				return t == 5;
			}
			
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 背压，抛弃过快数据流
	 */
	public static void debounce() {
		Observable.from(new Integer[] {1,2,3,4})
		.debounce(10,TimeUnit.SECONDS)
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 转换数据流
	 */
	public static void map() {
		Observable.from(new Integer[] {1,2,3,4})
		.map(new Func1<Integer,Integer>() {
			@Override
			public Integer call(Integer i) {
				return i * i;
			}
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 *  转换为Observable再平铺，不保证时序
	 */
	public static void flatMap() {
		Observable.from(new Integer[] {1,2,3,4})
		.flatMap(new Func1<Integer,Observable<Integer>>() {

			@Override
			public Observable<Integer> call(Integer t) {
				return Observable.just(t*t,t*t);
			}
			
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
		
	}
	/**
	 * 转换为Observable再平铺，并保证时序
	 */
	public static void concatMap() {
		Observable.from(new Integer[] {1,2,3,4})
		.concatMap(new Func1<Integer,Observable<Integer>>() {

			@Override
			public Observable<Integer> call(Integer t) {
				return Observable.just(t*t,t*t);
			}
			
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 转换为Iterator,再平铺
	 */
	public static void flatMapIterable() {
		Observable.from(new Integer[] {1,2,3,4})
		.flatMapIterable(new Func1<Integer,Iterable<Integer>>(){

			@Override
			public Iterable<Integer> call(Integer t) {
				List<Integer> list = new ArrayList<>();
				list.add(1);
				list.add(2);
				list.add(3);
				return new Iterable<Integer>() {
					@Override
					public Iterator<Integer> iterator() {
						return list.iterator();
					}
					
				};
			}
			
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
		
	}
	
	/**
	 * 转换为Observable,并在下一个数据产生时取消上一个产生的Observable
	 */
	public static void switchMap() {
		Observable.from(new Integer[] {1,2,3,4})
		.switchMap(new Func1<Integer,Observable<Integer>>() {

			@Override
			public Observable<Integer> call(Integer t) {
				return Observable.just(t * t,t * t); 
			}
			
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);
			}
			
		});
	}
	
	/**
	 * 为数据流运用累加函数
	 */
	public static void scan() {
		Observable.from(new Integer[] {1,2,3,4})
		.scan(new Func2<Integer,Integer,Integer>() {

			@Override
			public Integer call(Integer t1, Integer t2) {
				return t1 + t2;
			} 
			
		})
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);
			}
			
		});
	}
	
	/**
	 * 分组
	 */
	public static void groupBy() {
		Observable<GroupedObservable<Integer, Integer>> observable
		= Observable.from(new Integer[] {1,2,3,4})
		.groupBy(new Func1<Integer,Integer>() {

			@Override
			public Integer call(Integer t) {
				return t;
			}
			
		});
		Observable.concat(observable).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);
			}
			 
		});
	}
	
	/**
	 * 多个数据转换为List
	 */
	public static void buffer() {
		Observable.from(new Integer[] {1,2,3,4})
		.buffer(2,2)
		.subscribe(new Action1<List<Integer>>() {

			@Override
			public void call(List<Integer> t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 将多个数据转换为Observable
	 */
	public static void window() {
		Observable.from(new Integer[] {1,2,3,4})
		.window(2,1)
		.subscribe(new Action1<Observable<Integer>>() {

			@Override
			public void call(Observable<Integer> t) {
				t.subscribe(new Action1<Integer>() {

					@Override
					public void call(Integer t) {
						System.out.println(t);						
					}
					
				}) ;
			}
			
		});
	}
	
	
	/**
	 * 将多个数据流，到一个数据流
	 */
	public static void merge() {
		
		Observable<Integer> observable1 = Observable.from(new Integer[] {1,2,3,4});
		Observable<Integer> observable2 = Observable.from(new Integer[] {4,3,2,1});
		
		Observable.merge(observable1,observable2)
		.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
		
		
	}
	
	/**
	 * 压缩合并数据流
	 * 可用于多个网络请求
	 */
	public static void zip() {
		Observable<Integer> observable1 = Observable.from(new Integer[] {1,2,3,4});
		Observable<Integer> observable2 = Observable.from(new Integer[] {4,3,2,1});
		
		Observable.zip(observable1,observable2,new Func2<Integer,Integer,Integer>() {

			@Override
			public Integer call(Integer t1, Integer t2) {
				return t1 + t2;
			}
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t); 
			}
			
		});
	}
	
	
	public static void join() {
		Observable<Long> observable1 = Observable.from(new Long[] {1l,2l,3l,4l});
		Observable<Long> observable2 = Observable.from(new Long[] {4l,3l,2l,1l});
		
		observable1.join(observable2
				, new Func1<Long,Observable<Long>>() {

					@Override
					public Observable<Long> call(Long t) {
						return Observable.timer(1000, TimeUnit.MILLISECONDS);
					}
			
		} 
				, new Func1<Long,Observable<Long>>() {

					@Override
					public Observable<Long> call(Long t) {
						return Observable.timer(1000, TimeUnit.MILLISECONDS);
					}
			
		}
				, new Func2<Long,Long,Long>() {

					@Override
					public Long call(Long t1, Long t2) {
						return t1 + t2;
					}
			
		}).subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * 合并两条流
	 * 当一条流发送一个数据将与另一条流最后一条数据合并
	 */
	public static void combineLatest() {
		
		Observable<Long> observable1 = 
				Observable.interval(1000, TimeUnit.MILLISECONDS);
		
		Observable<Long> observable2 = 
				Observable.interval(1000, TimeUnit.MILLISECONDS);
		
		Observable.combineLatest(observable1,observable2,new Func2<Long,Long,String>(){

			@Override
			public String call(Long t1, Long t2) {
				return "" + t1 + t2;
			}
			
		}).subscribe(new Action1<String>() {

			@Override
			public void call(String t) {
				System.out.println(t); 
			}
			
		});
		
	}
	
	public static void andThenWhen() {
//		Observable<Long> observable1 = 
//				Observable.interval(1000, TimeUnit.MILLISECONDS);
//		
//		Observable<Long> observable2 = 
//				Observable.interval(1000, TimeUnit.MILLISECONDS);
//		
//		Pattern2<Long,Long> pattern = JoinObservable.from(observable1).and(observable2);
//		Plan0<String> plant = pattern.then(new Func2<Long,Long,String>() {
//
//			@Override
//			public String call(Long t1, Long t2) {
//				return "" + t1 + t2;
//			}
//			
//		});  
//		JoinObservable.when(plant).toObservable().subscribe(new Action1<String>() {
//
//			@Override
//			public void call(String t) {
//				System.out.println(t); 
//			}
//
//			
//		});
		
	}

	public static void startWith() {
		Observable<Long> observable = 
				Observable.interval(1000, TimeUnit.MILLISECONDS);
		observable.startWith(-1l).subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t); 
			}
		});
	}
	
	public static void schedulers() {
		Schedulers.io().createWorker().schedule(new Action0() {

			@Override
			public void call() {
				
			}
			
		});
	}
	
	
	
}




