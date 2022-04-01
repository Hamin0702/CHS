
import java.util.ArrayList;
import java.util.Iterator;
 
public class IterateArrayList 
{
  public static void main(String[] args) 
  {
   //Creating an ArrayList object
   ArrayList<Integer> list = new ArrayList<Integer>();
 
   //Adding values into the ArrayList
   list.add(1);
   list.add(2);
   list.add(3);
   list.add(4);
   list.add(5);
 
   System.out.println("Iterating ArrayList using Iterator interface");
   Iterator<Integer> itr = list.iterator();
   while(itr.hasNext())
   {
     System.out.println(itr.next());
   }
  }
}
