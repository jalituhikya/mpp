package lab9.prob8;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		// Query 1: Find all transactions from year 2011 and sort them by value (small
		// to high).
		System.out.println("1. Find all transactions from year 2011 and sort them by value (small to high).");
		transactions.stream()
		.filter((x) -> x.getYear() == 2011)
		.sorted(Comparator.comparing(Transaction::getValue))
		.forEach(System.out::println);

		// Query 2: What are all the unique cities where the traders work?
		System.out.println("\n2. What are all the unique cities where the traders work?");
		transactions
		.stream()
		.map((x) -> x.getTrader().getCity())
		.distinct()
		.forEach(System.out::println);

		// Query 3: Find all traders from Cambridge and sort them by name.
		System.out.println("\n3. Find all traders from Cambridge and sort them by name.");
		transactions
		.stream()
		.map((x) -> x.getTrader())
		.distinct()
		.filter((x) -> x.getCity().equals("Cambridge"))
		.sorted(Comparator.comparing(Trader::getName))
		.forEach(System.out::println);

		// Query 4: Return a string of all traders names sorted alphabetically.
		System.out.println("\n4. Return a string of all traders names sorted alphabetically.");
		System.out.println(
				transactions
				.stream()
				.map((x) -> x.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining(", ")));

		// Query 5: Are there any trader based in Milan?
		System.out.println("\n5. Are there any trader based in Milan?");
		/*System.out.println(
				transactions
				.stream()
				.filter((x) -> x.getTrader().getCity().equals("Milan"))
				.map((x) -> x.getTrader().getName())
				.findFirst()
				.orElse("No trader based in milan"));*/
		
		System.out.println(
				transactions
				.stream()
				.anyMatch((x) -> x.getTrader().getCity().equals("Milan"))?"Yes":"No");

		// Query 6: Update all transactions so that the traders from Milan are set to
		// Cambridge.
		System.out.println("\n6. Update all transactions so that the traders from Milan are set to  Cambridge.");
		transactions
		.stream()
		.map((x) -> {
			if (x.getTrader().getCity().equals("Milan"))
				x.getTrader().setCity("Cambridge");
			return x;
		})
		.forEach(System.out::println);

		// Query 7: What's the highest value in all the transactions?
		System.out.println("\n7. What's the highest value in all the transactions?");
		System.out.println(
				transactions
				.stream()
				.map((x) -> x.getValue())
				.max(Comparator.naturalOrder())
				.get());
	}
}
