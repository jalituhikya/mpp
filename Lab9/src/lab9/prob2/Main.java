package lab9.prob2;

import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
	/*	IntSummaryStatistics summ = Stream.of(1,2,3,4,5,6,7).collect(Collectors.summarizingInt((x)->x));
		System.out.println("Max: "+ summ.getMax());
		System.out.println("Min: "+ summ.getMin()); :*/
		
		
		System.out.println("Max: "+ IntStream.of(1,2,3,4,5,6,7).max().getAsInt());
		System.out.println("Min: "+ IntStream.of(1,2,3,4,5,6,7).min().getAsInt());
		
	}

}
