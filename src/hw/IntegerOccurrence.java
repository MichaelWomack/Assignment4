/** Michael Womack
 *  CS 3401-01
 *  Feb 10, 2015
 *  Assignment 4*/

package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class IntegerOccurrence {

	public static void main(String[] args) {
		
		if(args.length == 0)
			System.out.println("Missing command line argument");
		
		else{
			
			try {
				
				Map<Character, Integer> map = new TreeMap<Character, Integer>();
				countOccurrence(args[0], map);
				printHighestOccurence(map);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @param map
	 * 					Old Method
	 * This function will find the highest value of each key, then compare 
	 * the highest value with the rest of the key-values. If an element is
	 * equal to the highest value, that element will be displayed.
	 * 
	 * 					New Method
	 * Set will be added to a list and sorted using the ValueComparator class.
	 * The highest key will be at the end of the list. So if any values are 
	 * equal to the highest key, they will also be printed.
	 */
	private static void printHighestOccurence(Map<Character, Integer> map) {
		
		//This was my original method to sort the occurrences.	
		
		/*int highest = 0;
	
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();	
		for(Map.Entry<Character, Integer> entry: entrySet){
			if(entry.getValue() > highest)
				highest = entry.getValue();

		}
		System.out.println("Highest Occurrences:\n");
		for(Map.Entry<Character, Integer> entry: entrySet){
			if(entry.getValue() == highest)	
				System.out.println("Key: " + entry.getKey() + "\tNumber of Times:"  + entry.getValue());
			
		}*/
		
		//This is the new method using ValueComparator
		List<Map.Entry<Character,Integer>> list = new ArrayList<>();
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();	
		for(Map.Entry<Character, Integer> entry: entrySet){
			list.add(entry);
		}
		
		Collections.sort(list, new ValueComparator());
		for(int i = list.size()-1; i >= 0; i--)
			if(list.get(i).getValue() == list.get(list.size()-1).getValue())
			System.out.println("Key: " + list.get(i).getKey() + "\tNumber of Times:" 
					+ list.get(i).getValue());	
	}


	/**
	 * @param fileName from command argument
	 * @param map
	 * @throws FileNotFoundException
	 * This function will count the occurrences of each character in a file
	 * and store the character as key and the number of occurrences as the
	 * key value
	 */
	public static void countOccurrence(String fileName, Map map) throws FileNotFoundException  {
		
		Scanner input = new Scanner(new File(fileName));
		while(input.hasNext()){
			String s = input.next();
			for(int i = 0; i < s.length(); i++)
				if(!Character.isDigit(s.charAt(i)))
					break;
	
					if(!map.containsKey(s))
						map.put(s, 1);
					
					else{
						int value = (int)map.get(s);
						value++;
						map.put(s, value);
					}
					
		}
		input.close();
	}

}
