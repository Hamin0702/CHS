
public class BCD {
	
	private int[] digits;
	

	private int diagonalSum (int[][] lattice, int column, int row) {
		int finalSum=0;
		for(int c=column, r=row; c<lattice[0].length && r>=0; c++, r--) {
			finalSum=finalSum+lattice[r][c];		
		}
		return finalSum;
	}
	
	private int[] addDiagonals(int[][] lattice){
 		int height = lattice.length;
 		int width = lattice[0].length;
 		int diagonals = width+height-1;
 		int[] result = new int[diagonals];
 		int diag=diagonals-1;
		//Add the diagonals that end at the bottom
 		for (int col=width-1;col>=0;col--){
 			result[diag]=diagonalSum(lattice,col,height-1);
 			diag--;
 		}
		//Add the diagonals that end at the left side
 		for (int row = height-2; row>=0; row--){
 			result[diag]=diagonalSum(lattice,0,row);
 			diag--;
 		}
 		return result;
 	}
	
	BCD(int[] bcdDigits){
		digits = new int[bcdDigits.length];
		for(int i=0;i<digits.length;i++) {
			digits[i]=bcdDigits[i];
		}
	}
	
	BCD(int num){
		int digit=num%10;
		num=num/10;
		digits = new int[1];
		digits[0]=digit;
		while(num>0) {
			digit=num%10;
			addADigit(digit);
			num=num/10;
		}
	}
	
	public int numberOfDigits() {
		return digits.length;
	}
	
	public int nthDigit(int n) {
		if (n>=digits.length){
			return 0;
		}
		else{
			return digits[n];
		}
	}
	
	public void addADigit(int newdigit) {
		int newBCD[]=new int [digits.length+1];
		for (int i=0; i<digits.length; i++){
			newBCD[i]=digits[i];
		}
		newBCD[digits.length]=newdigit;
		digits=newBCD;
	}
	
	public String toString() {
		String BCDnum="";
		int counter=3;
		for(int i=0; i<digits.length; i++) {
			BCDnum=digits[i]+BCDnum;
			counter--;
			if(counter==0 && i!=digits.length-1) {
				BCDnum="," + BCDnum;
				counter=3;
			}
		}
		return BCDnum;
	}

	public BCD addBCDs(BCD other) {
		int thisBCD=this.numberOfDigits();
		int otherBCD=other.numberOfDigits();
		int length=0;
		int startingDigit=0;
		int carryover=0;
		int last=length-1;
		
		if(thisBCD>otherBCD) {
			length=thisBCD;
		} else { 
			length=otherBCD;
		}
		
		int[] arrayA = {};
		BCD a = new BCD(arrayA);
		for (int i=0; i<length; i++) {
			int sum=other.nthDigit(i)+this.nthDigit(i)+carryover;
			startingDigit=(sum%10);
			a.addADigit(startingDigit);
			carryover=(sum/10);
			if (i==last && carryover!=0) {
				a.addADigit(carryover);
			}
		}
		return a;
	}

	public BCD multiplyBCDs(BCD other) {
		
		int[] arrayA = {};
		BCD returnBCD = new BCD(arrayA);
		
		int [][] A = new int [other.numberOfDigits()][this.numberOfDigits()];
		for (int y = 0; y<other.numberOfDigits(); y++){
		     for (int x = 0; x<this.numberOfDigits(); x++){
		       A [y][x] = this.nthDigit(x)*other.nthDigit(y);
		     }
		}
		
		int remaining = 0;
		int sum = 0;
		int ones = 0;
		int diag = this.numberOfDigits()+other.numberOfDigits()-1;
		int [] B = addDiagonals(A);
		
		
		for(int i = 0; i<=diag-1; i++) {
			sum = B[i];
			sum = sum+remaining;
			ones = sum%10;
			remaining = sum/10;
			returnBCD.addADigit(ones);
		}
		
		while(remaining>0) {
			ones = remaining%10;
			remaining = remaining/10;
			returnBCD.addADigit(ones);
		}
	
		return returnBCD;
	}

}




