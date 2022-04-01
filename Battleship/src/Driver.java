import java.util.ArrayList;

public class Driver {
	
	public static void main(String args[]) {
		//placeBoatTest();
		hitTest();
//		shootAtTest("horizontal");
//		shootAtTest("vertical");
//		initialTest();
//		nameTest();
//		sunkTest();
	}
	
	public static void placeBoatTest() {
	System.out.println("Expected \t\t|\t\tResult\t\t\t| Works?");
	System.out.println("Place Boat:\t\t|\t\t\t\t\t|");
	GoodOcean go = new GoodOcean();
	try {
		go.placeBoat("Aircraft Carrier", "vertical", new Position(0, 9));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Aircraft Carrier", "horizontal", new Position(9, 0));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Aircraft Carrier", "vertical", new Position(20, 0));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: out of grid"));

	}
	try {
		go.placeBoat("Aircraft Carrier", "vertical", new Position(0, 9));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: overlapping"));
	}
	go = new GoodOcean();
	try {
		go.placeBoat("Battleship", "vertical", new Position(0, 9));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Battleship", "horizontal", new Position(9, 0));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Battleship", "vertical", new Position(20, 0));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: out of grid"));
	}
	try {
		go.placeBoat("Battleship", "vertical", new Position(0, 9));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: overlapping"));
	}
	go = new GoodOcean();
	try {
		go.placeBoat("Cruiser", "vertical", new Position(0, 9));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Cruiser", "horizontal", new Position(9, 0));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Cruiser", "vertical", new Position(20, 0));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: out of grid"));
	}
	try {
		go.placeBoat("Cruiser", "vertical", new Position(0, 9));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: overlapping"));
	}
	go = new GoodOcean();
	try {
		go.placeBoat("Submarine", "vertical", new Position(0, 9));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Submarine", "horizontal", new Position(9, 0));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Submarine", "vertical", new Position(20, 0));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: out of grid"));
	}
	try {
		go.placeBoat("Submarine", "vertical", new Position(0, 9));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: overlapping"));
	}
	go = new GoodOcean();
	try {
		go.placeBoat("Destroyer", "vertical", new Position(0, 9));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Destroyer", "horizontal", new Position(9, 0));
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		go.placeBoat("Destroyer", "vertical", new Position(20, 0));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: out of grid"));
	}
	try {
		go.placeBoat("Destroyer", "vertical", new Position(0, 9));
	} catch (Exception e) {
		System.out.print("Exception Expected \t| ");
		System.out.print(e.toString());
		System.out.println(" \t| " + e.toString().equalsIgnoreCase("java.lang.Exception: overlapping"));
	}
}
//Hit (Connor):

public static void hitTest() {
	GoodOcean go = new GoodOcean();
	System.out.println("Hit:\t\t\t|\t\t\t\t\t|");
	try {
		go.placeBoat("Aircraft Carrier", "vertical", new Position(1, 1));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	go.shootAt(new Position(0, 1));
	go.shootAt(new Position(3, 0));
	go.shootAt(new Position(6, 1));
	go.shootAt(new Position(3, 1));
	go.shootAt(new Position(11, 5));
	System.out.println("false \t\t\t| " + go.hit(new Position(0, 1)) + "\t\t\t\t\t| " + (go.hit(new Position(0, 1)) == false));
	System.out.println("false \t\t\t| " + go.hit(new Position(3, 0)) + "\t\t\t\t\t| " + (go.hit(new Position(3, 0)) == false));
	System.out.println("false \t\t\t| " + go.hit(new Position(6, 1)) + "\t\t\t\t\t| " + (go.hit(new Position(6, 1)) == false));
	System.out.println("true \t\t\t| " + go.hit(new Position(3, 1)) + "\t\t\t\t\t| " + (go.hit(new Position(3, 1)) == true));
	System.out.println("false \t\t\t| " + go.hit(new Position(11, 5)) + "\t\t\t\t\t| "+ (go.hit(new Position(11, 5)) == false));
}



//shootAt: (you have to pass both “vertical” and “horizontal”
public static void shootAtTest(String ori) {
	GoodOcean go = new GoodOcean();
	if(ori.equals("horizontal")) {
		try {
			go.placeBoat("Submarine", ori, new Position(1, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:" + go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(1,2)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 2))); //false
		System.out.println("In: go.sunk(1,3)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 3))); //false
		
		go.shootAt(new Position(1, 1));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(1,2)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 2))); //false
		System.out.println("In: go.sunk(1,3)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 3))); //false
		
		go.shootAt(new Position(1, 2));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(1,2)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 2))); //false
		System.out.println("In: go.sunk(1,3)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 3))); //false
		
		go.shootAt(new Position(1, 0));
		go.shootAt(new Position(1, 4));
		go.shootAt(new Position(2, 2));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(1,2)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 2))); //false
		System.out.println("In: go.sunk(1,3)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 3))); //false
		
		go.shootAt(new Position(1, 3));
		System.out.println("In: go.sunk(1,1)\t| Expc: true \t| actual:"+ go.sunk(new Position(1, 1))); //true
		System.out.println("In: go.sunk(1,2)\t| Expc: true \t| actual:"+ go.sunk(new Position(1, 2))); //true
		System.out.println("In: go.sunk(1,3)\t| Expc: true \t| actual:"+ go.sunk(new Position(1, 3))); //true
	}
	
	
	else if (ori.equals("vertical")) {
		try {
			go.placeBoat("Submarine", ori, new Position(1, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(2,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(2, 1))); //false
		System.out.println("In: go.sunk(3,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(3, 1))); //false
		
		
		go.shootAt(new Position(1, 1));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(2,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(2, 1))); //false
		System.out.println("In: go.sunk(3,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(3, 1))); //false
		
		go.shootAt(new Position(2, 1));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(2,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(2, 1))); //false
		System.out.println("In: go.sunk(3,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(3, 1))); //false
		
		go.shootAt(new Position(0, 1));
		go.shootAt(new Position(4, 1));
		go.shootAt(new Position(2, 2));
		System.out.println("In: go.sunk(1,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(1, 1))); //false
		System.out.println("In: go.sunk(2,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(2, 1))); //false
		System.out.println("In: go.sunk(3,1)\t| Expc: false\t| actual:"+ go.sunk(new Position(3, 1))); //false
		
		go.shootAt(new Position(3, 1));
		System.out.println("In: go.sunk(1,1)\t| Expc: true \t| actual:"+ go.sunk(new Position(1, 1))); //true
		System.out.println("In: go.sunk(2,1)\t| Expc: true \t| actual:"+ go.sunk(new Position(2, 1))); //true
		System.out.println("In: go.sunk(3,1)\t| Expc: true \t| actual:"+ go.sunk(new Position(3, 1))); //true
	}
		
}


//Name and initial test
public static void initialTest() {
	GoodOcean test = new GoodOcean();
	
	try {
		test.placeBoat("Aircraft Carrier", "horizontal", new Position(0,0));
		System.out.print("Initial Test on Aircraft Carrier || ");
		System.out.print("Expected: A || Result: " + test.boatInitial(new Position(0,0)) + " || Works?: ");
		if(test.boatInitial(new Position(0,0)) == 'A'){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Battleship", "horizontal", new Position(1,0));
		System.out.print("Initial Test on Battleship || ");
		System.out.print("Expected: B || Result: " + test.boatInitial(new Position(1,0)) + " || Works?: ");
		if(test.boatInitial(new Position(0,0)) == 'A'){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Cruiser", "horizontal", new Position(2,0));
		System.out.print("Initial Test on Cruiser || ");
		System.out.print("Expected: C || Result: " + test.boatInitial(new Position(2,0)) + " || Works?: ");
		if(test.boatInitial(new Position(0,0)) == 'A'){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Destroyer", "horizontal", new Position(3,0));
		System.out.print("Initial Test on Destroyer || ");
		System.out.print("Expected: D || Result: " + test.boatInitial(new Position(3,0)) + " || Works?: ");
		if(test.boatInitial(new Position(0,0)) == 'A'){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Submarine", "horizontal", new Position(4,0));
		System.out.print("Initial Test on Submarine || ");
		System.out.print("Expected: S || Result: " + test.boatInitial(new Position(4,0)) + " || Works?: ");
		if(test.boatInitial(new Position(0,0)) == 'A'){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

public static void nameTest() {
	GoodOcean test = new GoodOcean();
	
	try {
		test.placeBoat("Aircraft Carrier", "horizontal", new Position(0,0));
		System.out.print("Name Test on Aircraft Carrier || ");
		System.out.print("Expected: Aircraft Carrier || Result: " + test.boatName(new Position(0,0)) + " || Works?: ");
		if(test.boatName(new Position(0,0)).equals("Aircraft Carrier")){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Battleship", "horizontal", new Position(1,0));
		System.out.print("Name Test on Battleship || ");
		System.out.print("Expected: Battleship || Result: " + test.boatName(new Position(1,0)) + " || Works?: ");
		if(test.boatName(new Position(1,0)).equals("Battleship")){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Cruiser", "horizontal", new Position(2,0));
		System.out.print("Name Test on Cruiser || ");
		System.out.print("Expected: Cruiser || Result: " + test.boatName(new Position(2,0)) + " || Works?: ");
		if(test.boatName(new Position(2,0)).equals("Cruiser")){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Destroyer", "horizontal", new Position(3,0));
		System.out.print("Name Test on Destroyer || ");
		System.out.print("Expected: Destroyer || Result: " + test.boatName(new Position(3,0)) + " || Works?: ");
		if(test.boatName(new Position(3,0)).equals("Destroyer")){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	try {
		test.placeBoat("Submarine", "horizontal", new Position(4,0));
		System.out.print("Name Test on Submarine || ");
		System.out.print("Expected: Submarine || Result: " + test.boatName(new Position(4,0)) + " || Works?: ");
		if(test.boatName(new Position(4,0)).equals("Submarine")){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}


public static void sinkShip(GoodOcean ocean, Position pos, boolean vertical) {
	 char boatLetter = ocean.boatInitial(pos);
	 int size = 0;
	 if (boatLetter == 'A') {
		 size = 5;
	 }
	 else if (boatLetter == 'B') {
		 size = 4;
	 }
	 else if (boatLetter == 'C' || boatLetter == 'S') {
		 size = 3;
	 }
	 else {
		 size = 2;
	 }
	 if (vertical) {
		 for (int row = pos.rowIndex(); row < pos.rowIndex() + size; row++) {
			 ocean.shootAt(new Position(row, pos.columnIndex()));
		 }
	 }
	 else {
		 for (int col = pos.columnIndex(); col < pos.columnIndex() + size; col++) {
			 ocean.shootAt(new Position(pos.rowIndex(), col));
		 }
	 }
}

////XXX: sunk() and allSunk() tester
public static void sunkTest() {
ArrayList<Boat> fleet = new ArrayList<Boat>();
	 fleet.add(new Boat("Aircraft Carrier", new Position(0, 0), "horizontal"));
	 fleet.add(new Boat("Battleship", new Position(1, 0), "horizontal"));
	 fleet.add(new Boat("Cruiser", new Position(2, 0), "horizontal"));
	 fleet.add(new Boat("Destroyer", new Position(3, 0), "horizontal"));
	 fleet.add(new Boat("Submarine", new Position(4, 0), "horizontal"));
	 

	 ArrayList<Boat> fleet2 = new ArrayList<Boat>();
	 fleet2.add(new Boat("Aircraft Carrier", new Position(0, 0), "vertical"));
	 fleet2.add(new Boat("Battleship", new Position(0, 1), "vertical"));
	 fleet2.add(new Boat("Cruiser", new Position(1, 2), "vertical"));
	 fleet2.add(new Boat("Destroyer", new Position(0, 3), "vertical"));
	 fleet2.add(new Boat("Submarine", new Position(0, 4), "vertical"));
	 
	 GoodOcean ocean = new GoodOcean();
	 GoodOcean ocean2 = new GoodOcean();
	 
	 //XXX: allSunk test:
	 try {
		 for (Boat b : fleet) {
			 ocean.placeBoat(b.name(), b.direction(), b.position());
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 
	 for (int i = 0; i < 5; i++) {
		 System.out.println("allSunk? " + ocean.allSunk());
		 for (Boat b : fleet) {
			 System.out.println(b.name() + " at " + b.position() + " sunk? " + ocean.sunk(b.position()));
		 }
		 System.out.println("\nsinking " + fleet.get(i).name() + "...\n");
		 sinkShip(ocean, fleet.get(i).position(), fleet.get(i).direction().equals("vertical") ? true : false);
	 }
	 
	 for (Boat b : fleet) {
		 System.out.println(b.name() + " at " + b.position() + " sunk? " + ocean.sunk(b.position()));
	 }
	 System.out.println("allSunk? " + ocean.allSunk());
	 
	 System.out.println("\n\n");
	 
	 System.out.println("sunk one next to boat? " + ocean2.sunk(new Position(0, 1)));
	 System.out.println("sunk one past bow? " + ocean2.sunk(new Position(5, 0)));
	 
	 System.out.println("sunk one past stern? " + ocean2.sunk(new Position(0, 2)));
	 
	 ocean2.shootAt(new Position(0, 1));
	 System.out.println("boat sunk with 1 hit? " + ocean2.sunk(new Position(0, 1)));
	 ocean2.shootAt(new Position(0, 3));
	 System.out.println("destroyer sunk with 1 hit? " + ocean2.sunk(new Position(0, 3)));
}
}
