package Java8;

public class CalculatorImpl {

	public static void main(String[] args) {

		Calculator calculator = () -> System.out.println("Switch On");
		calculator.switchOn();

	}

	// Normal java
	/*
	 * public static void main(String[] args) { CalculatorImpl impl = new
	 * CalculatorImpl(); impl.switchOn(); }
	 * 
	 * @Override public void switchOn() { System.out.println("Swith On"); }
	 */
}
