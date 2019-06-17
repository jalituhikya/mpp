package lab10.prob2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(10);
		ints.add(2);
		ints.add(3);
		ints.add(9);
		ints.add(5);
		ints.add(8);
		
		System.out.println("Second Smallest: "+ secondSmallest(ints));
		

	}
	
	public static <T extends Comparable<? super T>> T secondSmallest(List<T> list) {
		
		T smallest = list.get(0);
		T secondSmallest = list.get(0);
		
		for (T t : list) {
			if(t.compareTo(smallest) < 0 ) {
				T temp = smallest;
				smallest = t;
				secondSmallest = temp;
			}else if( t.compareTo(secondSmallest) < 0 ) {
				secondSmallest = t;
			}
			
		}
		return secondSmallest;
		
		
	}

}
