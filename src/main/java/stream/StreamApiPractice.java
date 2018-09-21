package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiPractice {

	private static String[] words = new String[]{
			"ssdd","ef","gdd","gswgfsdgs"
			,"eeteg","rhrhrsaa","eedfd","aaaaaaaaa"
			,"gggggggg","eeeeeeee"};
	
	public static void main(String[] args) {
		eleven();
	}
	
	
	
	private static void one() {
		Stream<String> stream = Stream.of(words);
		List<String> list = stream.sorted().parallel()
				.peek(t -> System.out.println(t))
				.filter(t -> t.length() > 5)
				.limit(5)
				.collect(Collectors.toList());
		System.out.println(list); 
	}
	
		
	/**
	 *  经测试stream转换后旧stream不再可用
	 */
	private static void two() {
		Stream<String> stream = Stream.of(words);
		Stream<String> stream1 = stream.sorted();
		long count = stream.count();
		count = stream1.count();
		System.out.print(count); 
	}
	
	/**
	 * 并发Stream
	 */
	private static void three() {
		Stream<String> stream = Stream.of(words);
		Stream<String> parallelStream = Stream.of(words).parallel();
	}
	
	/**
	 * 基本类型Stream
	 */
	private static void four() {
		Stream<Integer> stream = Stream.of(1,2,3);
		IntStream intStream = IntStream.of(1,2,3);
	}
	
	/**
	 * Stream.iterator生成
	 */
	private static void five() {
		LongStream.iterate(0,t -> (25214903914l*t + 11)%2^48)
		.limit(100)
		.forEach(t -> System.out.println(t)); 
	}
	
	/**
	 * Stream.map
	 */
	private static void six() {
		String str = "abcdefg";
		IntStream intStream = IntStream.range(0,str.length() - 1);
		IntStream charStream = intStream.map(t -> str.charAt(t));
		charStream.forEach(t -> System.out.println(t));
	}
	
	private static void serven() {
		Stream<String> stream = Stream.generate(new Supplier<String>() {

			@Override
			public String get() {
				return "a";
			}
			
		});
		System.out.println("start");
		try {
			stream.count();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("after");
	}
	
	
	
	private static void eight() {
		Stream<List<String>> stream = Stream.of(
				Arrays.asList(words)
				,Arrays.asList(words)
				,Arrays.asList(words));
		Stream<String> streamStr = stream.flatMap(new Function<List<String>,Stream<String>>(){

			@Override
			public Stream<String> apply(List<String> t) {
				return t.stream(); 
			}
		});
		List<List<String>> list1 = stream.collect(Collectors.toList()); 
		
	}
	
	/**
	 * 计算平均值
	 */
	private static void night() {
		DoubleStream stream = DoubleStream.of(1.1,1.2,1.3);
		DoubleSummaryStatistics summary = stream.summaryStatistics();
	}
	
	
	private static void ten() {
		AtomicInteger [] shortCount = new AtomicInteger[5];
		shortCount[0] = new AtomicInteger(0);
		shortCount[1] = new AtomicInteger(0);
		shortCount[2] = new AtomicInteger(0);
		shortCount[3] = new AtomicInteger(0);
		shortCount[4] = new AtomicInteger(0);
		
		Stream<String> stream = Stream.of(words);
		stream.parallel().filter(t -> t.length() < 5).forEach(t -> {
			int index = t.length() - 1;
			shortCount[index].getAndIncrement();
		});
		
		Stream.of(shortCount).forEach(t -> System.out.println(t)); 
		
	}
	
	private static void eleven() {
		Stream<String> stream = Stream.of(words);
		Collector<String, ?, Map<Integer, Integer>> collectMap = Collectors.toMap(new Function<String,Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}
		}, new Function<String,Integer>() {

			@Override
			public Integer apply(String t) {
				return 1;
			}
			
		}, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
			
		});
		Map<Integer, Integer> map = stream.collect(collectMap);
		System.out.println(map);
		
		
		Long counting = stream.collect(Collectors.counting());
		
	} 
	
	
	
}
