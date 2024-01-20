package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {

		Customer c1 = new Customer(1, "Utsav", "EC", 60000);
		Customer c2 = new Customer(2, "Purva", "IT", 50000);
		
		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		
		list.stream().sorted(Comparator.comparing(Customer :: getSalary)).forEach(i -> System.out.println(i));
		
		List<Customer> list1 = list.stream().sorted(Comparator.comparing(Customer :: getSalary)).collect(Collectors.toList());
		System.out.println(Arrays.asList(list1));
		
		Map<Customer, Integer> map = new HashMap<>();
		map.put(c1, 10);
		map.put(c2, 20);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Customer :: getSalary))).forEach(i -> System.out.println(i));
		
		Customer c3 = new Customer(3, "Abhinav", null, 57700);
		/*
		 * Optional<String> departmentOptional = Optional.of(c3.getDepartment());
		 * System.out.println(departmentOptional);
		 */
		
		Optional<String> departmentOptional1 = Optional.ofNullable(c3.getDepartment());
		System.out.println(departmentOptional1);
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		int ans = values.stream().reduce(0, (a,b) -> a+b);
		System.out.println(ans);
		
		Optional<Integer> ans2 = values.stream().reduce(Integer :: sum);
		System.out.println(ans2);
		
		int ans3 = values.stream().reduce(Integer :: sum).get();
		System.out.println(ans3);
		
		Employee e1 = new Employee(1, "Utsav", "A", 50000);
		Employee e2 = new Employee(2, "Purva", "B", 60000);
		Employee e3 = new Employee(3, "Sumit", "A", 70000);
		
		List<Employee> listEmp = new ArrayList<>();
		listEmp.add(e1);
		listEmp.add(e2);
		listEmp.add(e3);
		
		double avgSal= listEmp.stream().filter(i -> i.getGrade().equalsIgnoreCase("A")).map(i -> i.getSalary()).mapToDouble(i -> i).average().getAsDouble();
		System.out.println(avgSal);
		
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> listb = Arrays.asList(8,9,10,11,12,13);
		
		List<Integer> mergeList = Stream.of(lista, listb).flatMap(List :: stream).distinct().collect(Collectors.toList());
		System.out.println(mergeList);
		
		String s = "ilovejava";
		Map<String, Long> mapNew = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(mapNew);
		
		List<String> listNew = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(i -> i.getValue() > 1).map(i -> i.getKey()).collect(Collectors.toList());
		System.out.println(listNew);
		
		String firstNonRepeatedCharacter = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity() ,LinkedHashMap :: new , Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() == 1).map(i -> i.getKey()).findFirst().get();
		System.out.println(firstNonRepeatedCharacter);
	}

}

class Customer{
	private int id;
	private String name;
	private String department;
	private int salary;
	
	public Customer(int id, String name, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
	
}
