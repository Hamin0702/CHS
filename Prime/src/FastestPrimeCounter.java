
public class FastestPrimeCounter {

	private int[] alreadyFound = {0};
	private int numPrimes;
	
	public boolean isPrime(int N) {
		if(N==1)
			return false;
		for(int i = 0; i<alreadyFound.length; i++) {
			int temp = alreadyFound[i];
			if(temp!=0) {
				if(temp>(int) Math.sqrt(N))
					return true;
				if(N%temp == 0)
					return false;
			
			}
		}
		return true;
	}


	public int countPrimes(int limit) {
		numPrimes = 0;
		int[] temp;
		for(int i = 1; i<=limit; i++) {
			if(isPrime(i))
				numPrimes++;
				if(i<=(int) Math.sqrt(limit)) {
					if(alreadyFound[alreadyFound.length-1]!=0) {
						temp = new int[2*(alreadyFound.length)];
						for(int j = 0; j<alreadyFound.length;j++) {
							temp[j] = alreadyFound[j];
						}
						temp[alreadyFound.length] = i;
						alreadyFound = temp.clone();
					}
				}
		}
	
		return numPrimes;
	}
}
