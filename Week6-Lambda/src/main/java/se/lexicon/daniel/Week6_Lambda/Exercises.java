package se.lexicon.daniel.Week6_Lambda;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import se.lexicon.daniel.Week6_Lambda.utility.Gender;
import se.lexicon.daniel.Week6_Lambda.utility.Person;

/**
 * All exercises should be completed using Lambda expressions and the new
 * methods added to JDK 8 where appropriate. There is no need to use an
 * explicit loop in any of the code.
 *
 */

public class Exercises {
	private List<Person> persons;

	public Exercises(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * Exercise1
	 * Create print out the first names of each person in the list
	 */
	public void exercise1() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 1:\n");
		persons.forEach(p-> System.out.println(p.getFirstName()));
		System.out.println("**************************************");
	}

	/**
	 * Exercise2
	 * Remove the words that have odd lengths from the local list using removeIf()
	 * Print out the remainder
	 */
	public void exercise2() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 2:\n");
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
		list.removeIf(w -> (w.length() % 2) !=0);
		list.forEach(System.out::println);
		System.out.println("**************************************");
	}

	/**
	 * Exercise 3
	 * Replace every word in the list with its upper case equivalent using replaceAll()
	 * Print out the remainder
	 */
	public void exercise3() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 3:\n");
		List<String> list = new ArrayList<>(Arrays.asList(
				"alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

		list.replaceAll(w -> w.toUpperCase());
		list.forEach(System.out::println);
		System.out.println("**************************************");
	}

	/**
	 * Exercise 4
	 * Convert every key-value pair of the map into a string and append them all
	 * into a single string
	 * Hint: Maps forEach takes a BiConsumer...
	 */
	public void exercise4() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 4:\n");
		Map<String, Integer> map = new HashMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);

		StringBuilder stringBuilder = new StringBuilder();
		map.forEach((key, value) -> stringBuilder.append(key + value));
		System.out.println(stringBuilder.toString());
		System.out.println("**************************************");
	}

	/**
	 * Exercise 5 **Old one - Bonus**
	 * Create a new thread that prints the numbers from the local list
	 */
	public void exercise5() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 5:\n");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Eriks example
        // ExecutorService service = Executors.newSingleThreadExecutor();
        // service.execute(() -> list.forEach(i -> System.out.println(i)));
        
		// and you can also write it like this
		// service.execute(() -> list.forEach(System.out::println));
		
        //a other way you can write it is like this.
		Runnable runLambda = () -> { list.stream().forEach(System.out::println); };
		new Thread(runLambda).run();
		
		// you can also write it in this way
		// service.execute(() -> list.forEach(i -> System.out.println(i)));
		// service.execute(() -> list.forEach(System.out::println));
		System.out.println("**************************************");
	}

	/**
	 * Exercise 6
	 * By using stream create a new list with all the strings from the original list converted to
	 * lower case and print them out.
	 * Hint: Use .collect as a terminal operation(closing and ending)
	 */
	public void exercise6() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 6:\n");
		List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");     
		List<String> newList = list.stream()
				.map(String::toLowerCase)
				.peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println("**************************************");
	}

	/**
	 * Exercise 7
	 * Modify exercise 6 so that the new list only contains strings that have an
	 * odd length
	 */
	public void exercise7() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 7:\n");
		List<String> List = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
		List<String> newList = List.stream()
				.filter(s -> (s.length() % 2) != 0)
				.map(String::toLowerCase)
				.peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println("**************************************");
	}

	/**
	 * Exercise 8
	 * Turn list persons into a stream and print all elements whose lastName starts with 'A'
	 * Use a forEach as a terminal operation
	 */
	public void exercise8() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 8:\n");
		persons.stream().filter(p -> p.getLastName().startsWith("A")).forEach(p-> System.out.println(p));
		System.out.println("**************************************");
	}

	/**
	 * Exercise 9
	 * Create a new list from this.persons that should be sorted by lastName
	 */
	public void exercise9(){
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 9:\n");
		List <Person> list = persons.stream()
				.sorted((p1,p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()))
				.peek(System.out::println)
				.collect(Collectors.toList());
		System.out.println("**************************************");
	}

	/**
	 * Exercise 10
	 * Create a new list from persons that should only contain those with lastname "Ali".
	 * then change the first name of all inside the stream to Muhammad
	 */
	public void exercise10() {
		System.out.println("**************************************");
		System.out.println("\nRunning exercise 10:\n");
		List <Person> list = persons.stream()
				.filter(p -> p.getLastName().equals("Ali"))
				.peek(p -> p.setFirstName("Muhammad"))
				.peek(System.out::println)
				.collect(Collectors.toList());
		System.out.println("**************************************");
	}

	/**
	 * Exercise 11
	 * Count how many persons is of female gender in this.persons.
	 * Present the result
	 */
	public void exercise11(){

		System.out.println("**************************************");
		System.out.println("\nRunning exercise 11:\n");      
		long females = persons.stream().filter(p -> p.getGender() == Gender.FEMALE).count();
		System.out.println("it exist " + females + " amount of persons of female gender in the list");
		System.out.println("**************************************");

	}

}