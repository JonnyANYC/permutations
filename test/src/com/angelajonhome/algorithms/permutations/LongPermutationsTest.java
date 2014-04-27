package com.angelajonhome.algorithms.permutations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


public class LongPermutationsTest {

	@Test
	public void setEmptyTest() {
		Set<String> set = new HashSet<String>(4);
		
		LongPermutations<String> permutations = new LongPermutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals(count, 0);
	}

	private enum fruit { APPLE, BANANA, CANTELOUPE } 

	@Test
	public void enum3Test() {
		
		LongPermutations<fruit> permutations = new LongPermutations<fruit>( fruit.values() ); 

		int count = 0;
		for ( List<fruit> permutation : permutations ) { 
			count++;
		}
	
	assertEquals(count, 6);  // 3! = 6
	}

	


	@Test
	public void list4Test() {
		List<String> set = new ArrayList<String>(4);
		set.add("apple");
		set.add("banana");
		set.add("canteloupe");
		set.add("durian");

		LongPermutations<String> permutations = new LongPermutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			// TODO Confirm that all permutations are different, even when an unordered set is provided and the permutations are calculated on-demand.
			count++;
		}

		assertEquals(count, 24);  // 4! = 24
	}

	@Test
	public void set4Test() {
		Set<String> set = new HashSet<String>(4);
		set.add("apple");
		set.add("banana");
		set.add("canteloupe");
		set.add("durian");
		
		LongPermutations<String> permutations = new LongPermutations<String>( set );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			// TODO Confirm that all permutations are different, even when an unordered set is provided and the permutations are calculated on-demand.
			count++;
		}
		assertEquals(count, 24);  // 4! = 24
	}

	@Test
	public void list6Test() {
		List<String> items = new ArrayList<String>(6);
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");

		LongPermutations<String> permutations = new LongPermutations<String>( items );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}
		
		assertEquals(count, 720);  // 6! = 720
	}

}
