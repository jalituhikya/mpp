package lab9.prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		//System.out.println(Stream.of("Bill","Thomas","Mary").reduce("",(x,y)-> x+", "+y).substring(1));
		System.out.println(Stream.of("Bill","Thomas","Mary").collect(Collectors.joining(", ")));
	}

}
