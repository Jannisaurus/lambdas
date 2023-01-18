package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		User user = new User("Amanda", "designer");
		User user2 = new User("Bob", "bartender");
		User user3 = new User("Reno", "adventurer");
		User user4 = new User("Elise", "adventurer");
		
		List<String> meList = new ArrayList(List.of("I", "am", "String", "thing", "in", "the", "infinite", "Striiing"));
		List<User> userList = List.of(user, user2, user3, user4);
		List<String> names = new ArrayList<String>();
		
		
		
		while(true) {
			System.out.println("Write input: ");
			String userInput = scanner.nextLine();
			
			switch(userInput) {
				case "supplier":
					Supplier<String> supplier = () -> "Why this world?";
					
					String string = supplier.get();
					System.out.println(string);
					System.out.println(string.indexOf('w'));
					break;
					
				case "second supplier": 
					Supplier<String> supplier2 = () -> {
						System.out.println("Oh dear");
						return "Why this world?";
					};
					
					System.out.println(supplier2.get());
					break;
				
				case "consumer":
					Consumer<String> consumer = (String s) -> System.out.println(s);
					
					consumer.accept("Bad Bobby Bird");
					break; 
					
				case "second consumer":
					Consumer<String> consumer2 = (String s) -> {
						System.out.println("Save my soul!");
						System.out.println(s); 
					};
					
					consumer2.accept("Pardon me, Sir");
					break; 
					
				case "predicate":
					Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
					System.out.println(nonEmptyStringPredicate.test(userInput));
					break; 
					
//				case "second predicate": 
//					Predicate<String> remember = s -> {
//						;
//					};
					
				case "predicate filter": //Using Predicate and Consumer to filter a list
					Consumer<String> consumerList = cl -> System.out.println(cl);
					meList.removeIf(s -> s.startsWith("i"));
					meList.forEach(consumerList);
					break; 
					
				case "function": 
					Function<User, String> getName =
					testUser -> user.getName();
					
					System.out.println(getName.apply(user));
					break; 
					
				case "name function": 
					Function<User, String> toName = (User tmpUser) -> tmpUser.getName(); 
					
					for (User tmpUser : userList) {
						String name = toName.apply(tmpUser);
						names.add(name);
					}
					userList.forEach(u -> System.out.println(u));
					names.forEach(y -> System.out.println(y)); //It magically knows it's a String instead of a User?
					break;
				case "chaining":
					Consumer<String> chain1 = chainString1 -> System.out.println("Hello " + chainString1); 
					Consumer<String> chain2 = chainString2 -> System.err.println("Hello " + chainString2); //Something about System.err being able to write to a file?? 
					Consumer<String> chain3 = chain1.andThen(chain2); 
					chain3.accept("Bob");
					break; 
				case "empty predicate": 
					Predicate<String> isNull = whatever -> whatever == null; 
					System.out.println("Time to try a null? " + isNull.test(null));
					
					Predicate<String> isEmpty = thisever -> thisever.isEmpty(); 
					System.out.println("Thisever empty? " + isEmpty.test(""));
					
					Predicate<String> p = isNull.negate().and(isEmpty.negate()); 
					System.out.println("Time to try a something? " + p.test(null));
					System.out.println("Time to try for something? " + p.test(""));
					System.out.println("Time to try for something? " + p.test("YES"));
					
				default: 
					break; 
			
		}
	}

		
		//Supplier 
//		Supplier<String> supplier = () -> "Why this world?";
//		
//		String string = supplier.get();
//		System.out.println(string);
//		
//		System.out.println(string.indexOf('w'));
		 
		//Alt Supplier
//		Supplier<String> supplier2 = () -> {
//			System.out.println("Oh dear");
//			return "Why this world?";
//		};
//		
//		System.out.println(supplier2.get());
		
		//Consumer
//		Consumer<String> consumer = (String s) -> System.out.println(s);
//		
//		consumer.accept("Bad Bobby Bird");
		
		//Alt consumer
		
//		Consumer<String> consumer2 = (String s) -> {
//			System.out.println("Save my soul!");
//			System.out.println(s); 
//		};
//		
//		consumer2.accept("Pardon me, Sir");
		
		//Predicate 
		
//		Predicate<String> isEmpty = 
//				q -> q.isEmpty();
		
//		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
//		System.out.println(nonEmptyStringPredicate.test(string));
		
		//Predicate and Consumer used to filter a list
		
//		Predicate<String> filter = s -> s.startsWith("i");
//		
//		Consumer<String> consumerList = cl -> System.out.println(cl);
//		meList.removeIf(filter);
//		meList.forEach(consumerList);
		
		//Function
		
//		Function<User, String> getName =
//				testUser -> user.getName();
//				
//		System.out.println(getName.apply(user));
		
	}

}
