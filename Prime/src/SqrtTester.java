
public class SqrtTester {
	public static SquareRootPrimeCounter test = new SquareRootPrimeCounter();
	
	public static void main(String Args[]) {
		isPrime();
		System.out.println("Counting... ");
		count();
	}

	public static void isPrime() {
		System.out.println("2: " + test.isPrime(2));
		System.out.println("21: " + test.isPrime(21));
		System.out.println("7: " + test.isPrime(7));
		System.out.println("1: " + test.isPrime(1));
	}
	
	public static void count() {
		long a = System.currentTimeMillis();
		System.out.println("#: " + test.countPrimes(100000000));
		long b = System.currentTimeMillis();
		System.out.println("millisecs..." + (b-a));
	}
}