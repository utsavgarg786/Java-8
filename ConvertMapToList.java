package Java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Utsav");
		map.put(2, "Purva");
		
		List<Integer> listKey = map.keySet().stream().collect(Collectors.toList());
		System.out.println(listKey);
		List<String> listValues = map.values().stream().collect(Collectors.toList());
		System.out.println(listValues);
	}

}
