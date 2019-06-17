package lab9.prob3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		List<String> words = new ArrayList<String>();
		words.add("james");
		words.add("book");
		words.add("colors");
		words.add("pick");
		words.add("clever");
		words.add("drop");
		System.out.println(main.countWords(words, 'c', 'd', 6));

	}
	
	public long countWords(List<String> words, char c, char d, int len) {
		return words.stream()
				.filter((x)->	x.length()==len && x.contains(""+c) && !x.contains("" +d))
				.count();
	}

}
