
public class FirstTester {
	
	public static FirstPrimeCounter test = new FirstPrimeCounter();
	
	public static void main(String Args[]) {
		//isPrime();
		System.out.println("First");
		System.out.println("count 1000");
		countPrime1000();
		System.out.println("count 10000");
		countPrime10000();
		System.out.println("count 100000");
		countPrime100000();
	}

	public static void isPrime() {
		System.out.println("2: " + test.isPrime(2));
		System.out.println("21: " + test.isPrime(21));
		System.out.println("7: " + test.isPrime(7));
		System.out.println("1: " + test.isPrime(1));
	}
	//time: 1
	public static void countPrime1000() {
		long a = System.currentTimeMillis();
		test.countPrimes(1000);
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	//time: 28
	public static void countPrime10000() {
		long a = System.currentTimeMillis();
		test.countPrimes(10000);
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	//time: 2056
	public static void countPrime100000() {
		long a = System.currentTimeMillis();
		test.countPrimes(100000);
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
}