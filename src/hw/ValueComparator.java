package hw;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ValueComparator implements Comparator<Map.Entry<Character, Integer>>{
 
	public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2){
		if(e1.getValue() > e2.getValue())
			return 1;
		else if(e1.getValue() < e2.getValue())
			return -1;
		else return 0;
	}
}
