package lab9.prob5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
		// Implement the code
		return stream.limit(n+1).skip(m);
		}

	public static void main(String[] args) {
		// Make three calls for the streamSection() method with different inputs // use
		// nextStream() method to supply the Stream input as a first argument in
		// streamSection() method
		
		System.out.println(streamSection(nextStream(),1,2).collect(Collectors.joining(", ")));
		System.out.println(streamSection(nextStream(),0,5).collect(Collectors.joining(", ")));
		System.out.println(streamSection(nextStream(),2,8).collect(Collectors.joining(", ")));
		
	}

//support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
	}
}