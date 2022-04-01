
public class FasterPrimeCounter {

	public boolean isPrime(int N) {
		if(N==1)
			return false;
		for(int i = 2; i<=N/2; i++) {
			if(N % i == 0)
				return false;
		}
		return true;
	}
	
	public int countPrimes(int limit) {
		int counter = 0;
		for(int i = 1; i<=limit; i++) {
			if(isPrime(i))
				counter++;
		}
		return counter;
	}

}
