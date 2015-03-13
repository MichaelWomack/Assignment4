/** Michael Womack
 *  CS 3401-01
 *  Feb 10, 2015
 *  Assignment 4*/

package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NamePopularity {

	
	public static void main(String[] args) {
		
		String name = "Richard";
		String gender = "male";
		String year = "2005";
		
		try {
			System.out.println("Rank for " + name + " is " + determineRank(name,gender,year) +
					" in " + year);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	
	/**
	 * @param name
	 * @param gender
	 * @param year
	 * @returns the rank of a name in a year given the above parameters. Each name will be placed as a key 
	 * in a map, the rank as the key-value. One map for girls, one for boys. After each name for the 
	 * given year is in the map, the map is placed in an array index corresponding to the year. A loop with then
	 * iterate to the next year and repeat the procedure for each document until all the documents 
	 * have been checked. 
	 * @throws FileNotFoundException
	 */
	public static int determineRank(String name, String gender, String year) throws FileNotFoundException {
		Map[] boys = new Map[10];
		Map[] girls = new Map[10];
		
		for(int y = 0; y < 10; y++){
			String yr = String.valueOf(y+2001);
			Scanner input = new Scanner(
					new File("names/babynamesranking".concat(yr).concat(".txt")));
			
			Map<String, Integer> boyName = new HashMap<String, Integer>();
			Map<String, Integer> girlName = new HashMap<String, Integer>();
			
			
			boys[y] = boyName;
			girls[y] = girlName;
			
			while(input.hasNext()){
				int rank = input.nextInt();
				String boy = input.next();
					//skip past the number of occurrences of this boy name.
					input.nextInt();
				String girl = input.next();
					//skip past the number of occurrences of this girl name
					input.nextInt();
		
				if(!boyName.containsKey(boy)){
					boyName.put(boy, rank);
				}
			    if(!girlName.containsKey(girl)){
					girlName.put(girl, rank);
				}
				
			}
			input.close();
		}
		int index;
		switch(year){
		case "2001": 
			index = 0; break;
		case "2002": 
			index = 1; break;
		case "2003": 
			index = 2; break;
		case "2004": 
			index = 3; break;
		case "2005": 
			index = 4; break;
		case "2006": 
			index = 5; break;
		case "2007": 
			index = 6; break;
		case "2008": 
			index = 7; break;
		case "2009": 
			index = 8; break;
		case "2010": 
			index = 9; break;
		default:
			index = 0;
		}
		
		if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")){
			return (int) boys[index].get(name);		
		}
		else{
			return (int) girls[index].get(name);
		}
		
	}

}
