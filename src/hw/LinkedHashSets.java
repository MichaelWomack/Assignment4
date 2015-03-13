/** Michael Womack
 *  CS 3401-01
 *  Feb 10, 2015
 *  Assignment 4*/

package hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSets {

	public static void main(String[] args) {
		
		Set<String> set1 = new LinkedHashSet<>(
				Arrays.asList("George", "Jim", "Blake", "Kevin", "Michael"));
		
		Set<String> set2 = new LinkedHashSet<>(
				Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
		
		System.out.println("\nUnion:\n" + union(set1, set2));
		System.out.println("\nIntersection:\n" + intersection(set1, set2));
		System.out.println("\nDifference Set1 vs Set2:\n" + difference(set1,set2));
		System.out.println("\nDifference Set2 vs Set1:\n" + difference(set2,set1));
	}

	/**
	 * @param set1
	 * @param set2
	 * @returns a set of elements from first set that are not also in the second set
	 */
	private static <E> Set<E> difference(Set<E> set1, Set<E> set2) {
		Set<E> set = new LinkedHashSet<>(set1);
		set.removeAll(set2);
		return set;
	}

	/**
	 * @param set1
	 * @param set2
	 * @returns a set of all the elements shared between the two sets
	 */
	private static <E> Set<E> intersection(Set<E> set1, Set<E> set2) {
		Set<E> set = new LinkedHashSet<>(set1);
		set.retainAll(set2);
		return set;
	}

	/**
	 * @param set1
	 * @param set2
	 * @returns a set of all the elements of the two sets
	 */
	private static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		Set<E> set = new LinkedHashSet<>(set1);
		set.addAll(set2);
		return set;
	}

}
