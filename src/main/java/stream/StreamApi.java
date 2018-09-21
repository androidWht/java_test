package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		juhe();
		collect();
		optional();
	}

	private static void juhe() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		// ���������ݸ���
		long result = stream.count();
		System.out.println("count " + result);

		// �������е�һ��Ԫ��,���ҵ��������ֹ������
		stream = Stream.of(1, 2, 3);
		Optional<Integer> op = stream.findFirst();
		System.out.println("findFirst " + op.get());

		// ��������һ������������Ԫ�أ����ҵ��������ֹ������
		stream = Stream.of(1, 2, 3);
		op = stream.findAny();
		System.out.println("findAny " + op.get());

		// ��ѯ�����Ƿ���ָ��������Ԫ��
		stream = Stream.of(1, 2, 3);
		boolean anyMatch = stream.anyMatch(t -> {
			return t == 1;
		});
		System.out.println("anyMatch " + anyMatch);

		// ��ѯ�Ƿ���������Ԫ�ض�����ָ������
		stream = Stream.of(1, 2, 3);
		boolean allMatch = stream.allMatch(t -> {
			return t == 1;
		});
		System.out.println("allMatch " + allMatch);

		// ��ѯ�Ƿ���������Ԫ�ض�������ָ������
		stream = Stream.of(1, 2, 3);
		boolean noneMatch = stream.noneMatch(t -> {
			return t == 1;
		});
		System.out.println("noneMatch " + noneMatch);
	}

	private static void collect() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		// �����ռ�Ϊһ������
		stream = Stream.of(1, 2, 3);
		Object[] array = stream.toArray();
		System.out.println(array);

		// �����ռ�Ϊһ��List
		stream = Stream.of(1, 2, 3);
		stream.collect(Collectors.toList());

		// �����ռ�Ϊһ��collection
		stream = Stream.of(1, 2, 3);
		ArrayList<Integer> collection = stream.collect(Collectors.toCollection(new Supplier<ArrayList<Integer>>() {

			@Override
			public ArrayList<Integer> get() {
				return new ArrayList<Integer>();
			}
		}));

		// ����Ԫ��ƴװΪstring
		Stream<String> streamStr = Stream.of("1", "2", "3");
		String join = streamStr.collect(Collectors.joining());
		System.out.println(join);

		// �ۺ���ΪSummaryStatistics
		streamStr = Stream.of("1", "2", "3");
		IntSummaryStatistics intSummaryStatistics = streamStr
				.collect(Collectors.summarizingInt(new ToIntFunction<String>() {

					@Override
					public int applyAsInt(String value) {
						return value.hashCode();
					}
				}));
		double average = intSummaryStatistics.getAverage();
		long count = intSummaryStatistics.getCount();
		long max = intSummaryStatistics.getMax();
		long min = intSummaryStatistics.getMin();
		long sum = intSummaryStatistics.getSum();

		// �����ۺ�Ϊһ��map����
		Map<Integer, String> map = stream.collect(Collectors.toMap(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t;
			}

		}, new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				return String.valueOf(t);
			}

		}));
		stream.collect(Collectors.toMap(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t;
			}

		}, new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				return String.valueOf(t);
			}

		}, new BinaryOperator<String>() {

			@Override
			public String apply(String t, String u) {
				return t + u;
			}
		}));

		Map<String, List<Integer>> map1 = stream.collect(Collectors.groupingBy(new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				return String.valueOf(t);
			}

		}));

		Map<Boolean, List<Integer>> map2 = stream.collect(Collectors.partitioningBy(t -> {
			return t > 0;
		}));

		stream.collect(Collectors.groupingBy(new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				return String.valueOf(t);
			}

		}, Collectors.counting()));

		Map<String, Optional<Integer>> map3 = stream.collect(Collectors.groupingBy(new Function<Integer, String>() {
			@Override
			public String apply(Integer t) {
				return String.valueOf(t);
			}

		}, Collectors.maxBy(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}

		})));

		// ����,��ֹ
		stream.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {

			}
		});
		// ˳����������Ե�������ֹ
		stream.forEachOrdered(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {

			}

		});

		stream.peek(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {

			}

		});
	}

	private static void optional() {
		Optional<String> optional = Optional.ofNullable("optional");
		String value = optional.orElse("empty");
		System.out.println("orElse " + value);

		value = optional.get();

		boolean isPresend = optional.isPresent();
		System.out.println("isPresend " + isPresend);

		value = optional.get();

		optional.orElse("get else");

		optional.orElseGet(new Supplier<String>() {
			@Override
			public String get() {
				return "get Supplier";
			}
		});

		optional.orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException();
			}
		});

		optional.ifPresent(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("ifPresent consumer " + t);
			}
		});

		optional.filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				System.out.println("filter " + t);
				return false;
			}
		});

		optional.map(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t + ".map";
			}
		});

		optional.flatMap(new Function<String, Optional<String>>() {
			@Override
			public Optional<String> apply(String t) {
				return Optional.of(t + ".flatMap");
			}

		});

		optional.filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return false;
			}

		});

	}

}
