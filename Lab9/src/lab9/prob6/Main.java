package lab9.prob6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		Set<String>  set1 = new HashSet<String>();
		set1.add("A");
		set1.add("B");
		
		Set<String>  set2 = new HashSet<String>();
		set2.add("D");
		
		Set<String>  set3 = new HashSet<String>();
		set3.add("1");
		set3.add("3");
		set3.add("5");
		
		List<Set<String>> listOfSets = new ArrayList<Set<String>>();
		listOfSets.add(set1);
		listOfSets.add(set2);
		listOfSets.add(set3);
		
		System.out.println(m.union(listOfSets));
		
	}
	
	public Set<String> union(List<Set<String>> sets){
		return sets.stream()
				.reduce(new LinkedHashSet<String>(),(x,y) ->
				{ 
					x.addAll(y);
				  return x;
					
				});
		
	}

}
