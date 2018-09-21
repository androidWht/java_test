package rxjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

public class Test {
	public static void main(String[] args) {
		
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
		buffer();
	}
	
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
	 * ��ѹ����������������
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
	 * ת��������
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
	 *  ת��ΪObservable��ƽ�̣�����֤ʱ��
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
	 * ת��ΪObservable��ƽ�̣�����֤ʱ��
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
	 * ת��ΪIterator,��ƽ��
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
	 * ת��ΪObservable,������һ�����ݲ���ʱȡ����һ��������Observable
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
	 * Ϊ�����������ۼӺ���
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
	 * ����
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
	 * �������ת��ΪList
	 */
	public static void buffer() {
		Observable.from(new Integer[] {1,2,3,4})
		.buffer(2,1)
		.subscribe(new Action1<List<Integer>>() {

			@Override
			public void call(List<Integer> t) {
				System.out.println(t); 
			}
			
		});
	}
	
	/**
	 * ���������ת��ΪObservable
	 */
	public static void window() {
		Observable.from(new Integer[] {1,2,3,4})
		.window(2)
		.subscribe(new Action1<Observable<Integer>>() {

			@Override
			public void call(Observable<Integer> t) {
				
			}
			
		});
	}
	
}




