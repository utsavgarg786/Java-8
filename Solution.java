package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Trader t1 = new Trader("Raoul", "Cambridge");
		Trader t2 = new Trader("Mario", "Milan");
		Trader t3 = new Trader("Alan", "Cambridge");
		Trader t4 = new Trader("Buan", "Cambridge");
		
		Transaction A = new Transaction(t4, 2011, 300);
		Transaction B = new Transaction(t1, 2012, 1000);
		Transaction C = new Transaction(t1, 2011, 400);
		Transaction D = new Transaction(t2, 2012, 710);
		Transaction E = new Transaction(t2, 2012, 700);
		Transaction F = new Transaction(t3, 2012, 950);
		
		List<Transaction> transactions = Arrays.asList(A,B,C,D,E,F); 
		
		List<Transaction> ans = transactions.stream().filter(i -> i.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction ::getValue)).collect(Collectors.toList());
		System.out.println(ans);
		
		List<String> ans1 = transactions.stream().map(i -> i.getTrader().getCity()).distinct().collect(Collectors.toList());
		System.out.println(ans1);
		
		List<Trader> ans2= transactions.stream().map(Transaction :: getTrader).filter(i->i.getCity() == "Cambridge").distinct()
		.sorted(Comparator.comparing(Trader :: getName)).collect(Collectors.toList());
		System.out.println(ans2);
		List<Trader> ans10= transactions.stream().map(i -> i.getTrader()).filter(i->i.getCity() == "Cambridge").distinct()
				.sorted(Comparator.comparing(Trader :: getName)).collect(Collectors.toList());
		System.out.println(ans10);
		
		String ans3 = transactions.stream().map(i->i.getTrader().getName()).distinct().sorted().reduce("", (c,e) -> c+e);
		System.out.println(ans3);
		
		List<String> ans11 = transactions.stream().map(i->i.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
		System.out.println(ans11);
		
		boolean isMilan = transactions.stream().anyMatch(i-> i.getTrader().getCity().equals("Milan"));
		System.out.println(isMilan);
		
		boolean isMilan1 = transactions.stream().map(Transaction :: getTrader).anyMatch(i -> i.getCity() == "Milan");
		System.out.println(isMilan1);
		
		
	}

}
