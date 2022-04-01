
public class FactorialCalculator {
	public static int factorial(int num) {
		int factorial = num;
		if(num>1) {
			factorial=factorial*(num-1);
			num--;
		}
		return factorial; 
	}
	public static void main() {
		System.out.print(factorial(5));
	}

}
