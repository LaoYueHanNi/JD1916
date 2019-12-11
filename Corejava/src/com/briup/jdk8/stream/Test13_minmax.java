package com.briup.jdk8.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * min max distinct方法
 */
public class Test13_minmax {
	public static void main(String[] args) throws Exception {
		demo_max();
		
		System.out.println("******************");
		
		String filePath = "src/com/briup/day2/stream/a.txt";
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		
		//stream里面逐行放进去数据
		Stream<String> stream = in.lines();
		
		/*  注意flatMap的用法,
		 * 	<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
		 *  
		 *  public static<T> Stream<T> of(T... values) {
		        return Arrays.stream(values);
		    }
		 */
		stream.flatMap(s->Stream.of(s.split(" ")))
			.filter(s->s.length()>0)
			.map(String::toLowerCase)
			.distinct()		//去除重复
			.sorted()
			.forEach(System.out::println);
	}

	//基础测试
	private static void demo_max() throws FileNotFoundException {
		String filePath = "src/com/briup/day2/stream/a.txt";
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		
		//stream里面逐行放进去数据
		Stream<String> stream = in.lines();
		/*
		 * IntStream mapToInt(ToIntFunction<? super T> mapper);
		 * 	public interface ToIntFunction<T> {
    			int applyAsInt(T value);
			}
		 */
		int n = stream.mapToInt(s->s.length()).max().getAsInt();
		System.out.println(n);
	}
}
