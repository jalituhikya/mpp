package lab9.prob4;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printSquares(4);
		//printSquares(10);
	}
	
	public static void printSquares(int num) {
		Stream.iterate(1,(x) ->x+1).limit(num).map((x)->x*x).forEach(System.out::println);
		
	}

}
