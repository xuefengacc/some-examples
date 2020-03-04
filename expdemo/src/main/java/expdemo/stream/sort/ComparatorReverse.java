package expdemo.stream.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorReverse {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("s","o","90","23","p");
		
		List<String> sortedList = list.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
	}
	
}
