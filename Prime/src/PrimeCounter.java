import java.util.ArrayList;

public class PrimeCounter {
	public static ArrayList<Integer> primeTrack = new ArrayList<Integer>();
	
	public boolean isPrime(int N) {
		for(Integer p:primeTrack) {
			if(N==p)
				return true;
		}
		return false;
	}
	
	public static int countPrimes(int n) {
		if (n <= 2)
			return 0;
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				primeTrack.add(i);
				for (int j = i+i; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}
	
	
	public static void main(String Args[]) {

		System.out.println("(PrimeCounter) Counting... ");
		long a = System.currentTimeMillis();
		System.out.println("#: " + countPrimes(1000000000));
		long b = System.currentTimeMillis();
		System.out.println("millisecs..." + (b-a));
	}
}
