package lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main (String[] args) {
		
		User user = new User("Amanda");
		
		//Supplier 
		Supplier<String> supplier = () -> "Why this world?";
		
		String string = supplier.get();
		System.out.println(string);
		
		System.out.println(string.indexOf('w'));
		
		//Alt Supplier
		Supplier<String> supplier2 = () -> {
			System.out.println("Oh dear");
			return "Why this world?";
		};
		
		System.out.println(supplier2.get());
		
		//Consumer
		Consumer<String> consumer = (String s) -> System.out.println(s);
		
		consumer.accept("Bad Bobby Bird");
		
		//Alt consumer
		
		Consumer<String> consumer2 = (String s) -> {
			System.out.println("Save my soul!");
			System.out.println(s); 
		};
		
		consumer2.accept("Pardon me, Sir");
		
		//Predicate 
		
//		Predicate<String> isEmpty = 
//				q -> q.isEmpty();
		
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		System.out.println(nonEmptyStringPredicate.test(string));
		
		//Function
		
		Function<User, String> getName =
				testUser -> user.getName();
				
		System.out.println(getName.apply(user));	
		
	}

}
