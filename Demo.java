package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "Utsav");
		map1.put(2, "Purva");
		
		map1.entrySet().stream().forEach(i -> System.out.println(i));

		List<Integer> values = Arrays.asList(12,20,45,46,75);
		int ans = values.stream().filter(i -> i%5 == 0).map(i->i*2).reduce(0, (c,e)-> c+e);
		System.out.println(ans);
		
		Optional<Integer> ans1 = values.stream().filter(i->i%5==0).map(i-> i*2).findFirst();
		System.out.println(ans1);
		
		Optional<Integer> ans2 = values.stream().filter(i->i%30 ==0).map(i->i*3).findFirst();
		System.out.println(ans2);
		
		Integer ans3 = values.stream().filter(i->i%30 ==0).map(i->i*3).findFirst().orElse(0);
		System.out.println(ans3);
		
		int ans4 = values.stream().mapToInt(i->i).sum();
		System.out.println(ans4);
		
		Optional<Integer> ans5 = values.stream().reduce(Integer :: sum);
		System.out.println(ans5);
		
		int ans6 =values.stream().reduce(0, (a,b) -> a+b);
		System.out.println(ans6);
		
		int maxValue = values.stream().reduce(0, (a,b) -> a>b? a:b);
		System.out.println(maxValue);
		
		Optional<Integer> maxValue2 = values.stream().reduce(Integer:: max);
		System.out.println(maxValue2);
		
		int maxValue3 = values.stream().reduce(Integer:: max).get();
		System.out.println(maxValue3);
		
		List<String> words = Arrays.asList("corejava", "spring" , "hibernate");
		
		String longestString =words.stream().reduce((word1,word2) -> word1.length()>word2.length() ? word1:word2).get();
		System.out.println(longestString);
		
		Optional<String> longestString1 =words.stream().reduce((word1,word2) -> word1.length()>word2.length() ? word1:word2);
		System.out.println(longestString1);
		
		String longestString2 = words.stream().reduce("", (word1,word2) -> word1.length() > word2.length() ? word1 : word2);
		System.out.println(longestString2);
		
		Stream<String> test = Stream.of("How", "To", "Do", "In", "Java");
		long count = test.count();
		System.out.println(count);
		
		Stream<Integer> test1 = Stream.of(1,2,3,4,5,6,7,8);
		long count1 = test1.count();
		System.out.println(count1);
		
		IntStream test2 = IntStream.of(1,2,3,4,5,6,7,8);
		long count2 = test2.count();
		System.out.println(count2);
		
		Stream<Integer> test3 = Stream.of(1,2,3,4,5,6,7,8);
		long countNew = test3.collect(Collectors.counting());
		System.out.println(countNew);
		
		String s = "ilovejava";
		
		Map<String, Long> map = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		
	}
}
