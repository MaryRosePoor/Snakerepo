import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]) {
		List<Integer> thing1 = new ArrayList<Integer>();
		thing1.add(5);
		thing1.add(1);
		
		List<Integer> thing2 = new ArrayList<Integer>();
		thing2.add(5);
		thing2.add(1);
		
		if (thing1 == thing2) {
			System.out.println("same");
		} else {
			System.out.println("not");
		}
	}
	}