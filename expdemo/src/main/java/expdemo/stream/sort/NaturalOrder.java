package expdemo.stream.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NaturalOrder {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1","s","u","90","h");
		
		List<String> sortedList = list.stream().sorted()
				.collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
	}
	
}
