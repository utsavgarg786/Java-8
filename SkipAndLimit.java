package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipAndLimit {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//Now I want to skip 1st element and print from 2 to 8
		values.stream().skip(1).limit(7).forEach(i->System.out.print(i));
		
		System.out.println("---------");
		//Now I want to skip 1st 2 elements and print from 3 to 8
		values.stream().skip(2).limit(6).forEach(System.out:: print);
		
		List<Integer> list = values.stream().skip(1).limit(7).collect(Collectors.toList());
		System.out.println(list);
	}

}
