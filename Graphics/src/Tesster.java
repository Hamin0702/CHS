public class Tesster {

	public static void main(String args[]) {
		int big = 0;
		int[] donations = {50, 100, 60, 20, 70};
		for(int i = 0; i<donations.length; i++) {
		if(donations[i]>big)
			big = donations[i];
		}
		System.out.println("Largest: " + big);
		double largest = (double) big;
		System.out.println(largest);
		
		double ratio1 = 50.0/largest;
		double ratio2 = 100.0/largest;
		double ratio3 = 60.0/largest;
		double ratio4 = 20.0/largest;
		double ratio5 = 70.0/largest;
		
		System.out.println(ratio1);
		System.out.println(ratio2);
		System.out.println(ratio3);
		System.out.println(ratio4);
		System.out.println(ratio5);
		System.out.println(1/2);
		
		System.out.println((int)(((30.0/100.0)*600)+100));
	}
	
}
