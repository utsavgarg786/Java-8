package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestions {

	public static void main(String[] args) {

		String s = "ilovejava";
		
		//Q1 -how many times each character is coming
		Map<String, Long> map= Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		//those character which are coming more than 1
		 List<String> list = Arrays.stream(s.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter(i-> i.getValue() > 1)
		.map(i -> i.getKey())
		.collect(Collectors.toList());
		 
		System.out.println(list); 
		
		/// Q2 - those elements which are coming only 1 time
		List<String> stringList = Arrays.stream(s.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter(i -> i.getValue()==1)
		.map(i-> i.getKey())
		.collect(Collectors.toList());
		System.out.println(stringList);
		
		//Q3- first non repeated character
		 Optional<String> firstNonRepeatedCharacter = Arrays.stream(s.split(""))
		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new,Collectors.counting()))
		.entrySet().stream()
		.filter(i -> i.getValue() == 1)
		.map(i ->i.getKey()).findFirst();
		 System.out.println(firstNonRepeatedCharacter);
		 
		 String firstNonRepeatedCharacter1 = Arrays.stream(s.split(""))
					.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new,Collectors.counting()))
					.entrySet().stream()
					.filter(i -> i.getValue() == 1)
					.map(i ->i.getKey()).findFirst().get();
					 System.out.println(firstNonRepeatedCharacter1);
					 
		// Q4- Find 2nd highest number from given array
		int[] numbers = {5,9,11,2,8,21,1};		 
		
		List<Integer> integerList = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
		System.out.println(integerList);
		
		Optional<Integer> ans = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println(ans);
		
		Integer ans3 = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(ans3);
		
		Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
		
		//Q5 - find the largest string from given array
		String[] str = {"corejava", "spring" , "hibernate"};
		
		Optional<String> longestString = Arrays.stream(str).reduce((word1, word2) -> word1.length() > word2.length()? word1:word2);
		System.out.println(longestString);
		
		//2nd way
		String lonString = Arrays.stream(str).reduce((word1,word2)-> word1.length()> word2.length() ? word1:word2).get();
		System.out.println(lonString);
		
		//Q6 - Java program which starts with 2
		int[] numbers1 = {5,9,11,2,8,21,1};
		List<Integer> ansnew1 = Arrays.stream(numbers1).boxed().filter(i-> String.valueOf(i).startsWith("2")).collect(Collectors.toList());
		System.out.println(ansnew1);
		
		List<Integer> listNew = Arrays.asList(5,9,11,2,8,21,1);
		List<Integer> ansNew = listNew.stream().filter(i-> String.valueOf(i).startsWith("2")).collect(Collectors.toList());
		System.out.println(ansNew);
	}
}
