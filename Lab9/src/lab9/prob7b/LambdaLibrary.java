package lab9.prob7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final TriFunction<List<Employee>, Integer, Character,String> EMPLOYEE_NAMES =
		(list,salary,c) ->
			list.stream()
			.filter((x)-> x.getSalary() > salary && x.getLastName().charAt(0) > c  )
			.map((x)-> x.getFirstName() + " " +x.getLastName())
			.sorted()
	        .collect(Collectors.joining(", "));
}
