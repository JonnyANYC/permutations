package com.angelajonhome.algorithms.permutations;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.angelajonhome.algorithms.permutations.Permutations;


public class PermutationsTest {

	@Test
	public void factorialTest() { 

		List<String> items = new ArrayList<String>();
		Permutations<String> permutations = new Permutations<String>( items );

		BigInteger factorial = permutations.factorial( 25 );
	
		assertEquals( new BigInteger("15511210043330985984000000" ), factorial );
	}


	@Test
	@SuppressWarnings("unused")
	public void nullSetTest() {
		Set<String> set = null;
		
		Permutations<String> permutations = new Permutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals( 0, count );
	}

	@Test
	@SuppressWarnings("unused")
	public void nullListTest() {
		List<String> set = null;
		
		Permutations<String> permutations = new Permutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals( 0, count );
	}

	@Test
	@SuppressWarnings("unused")
	public void nullArrayTest() {
		String[] set = null;
		
		Permutations<String> permutations = new Permutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals( 0, count );
	}

	@Test
	@SuppressWarnings("unused")
	public void emptySetTest() {
		Set<String> set = new HashSet<String>(4);
		
		Permutations<String> permutations = new Permutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals( 0, count );
	}

	
	private enum fruit { APPLE, BANANA, CANTELOUPE } 

	@Test
	@SuppressWarnings("unused")
	public void enumWith3ItemsTest() {
		
		Permutations<fruit> permutations = new Permutations<fruit>( fruit.values() ); 

		int count = 0;
		for ( List<fruit> permutation : permutations ) { 
			count++;
		}
	
	assertEquals( 6, count );  // 3! = 6
	}


	@Test
	@SuppressWarnings("unused")
	public void listWith4ItemsTest() {
		List<String> set = new ArrayList<String>(4);
		set.add("apple");
		set.add("banana");
		set.add("canteloupe");
		set.add("durian");

		Permutations<String> permutations = new Permutations<String>( set ); 

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			// TODO Confirm that all permutations are different, even when an unordered set is provided and the permutations are calculated on-demand.
			count++;
		}

		assertEquals( 24, count );  // 4! = 24
	}

	@Test
	@SuppressWarnings("unused")
	public void setWith4ItemsTest() {
		Set<String> set = new HashSet<String>(4);
		set.add("apple");
		set.add("banana");
		set.add("canteloupe");
		set.add("durian");
		
		Permutations<String> permutations = new Permutations<String>( set );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			// TODO Confirm that all permutations are different, even when an unordered set is provided and the permutations are calculated on-demand.
			count++;
		}
		assertEquals( 24, count );  // 4! = 24
	}

	@Test
	@SuppressWarnings("unused")
	public void listWith6ItemsTest() {
		List<String> items = new ArrayList<String>(6);
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");

		Permutations<String> permutations = new Permutations<String>( items );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}
		
		assertEquals( 720, count );  // 6! = 720
	}


		@Test
		@SuppressWarnings("unused")
		public void listWith8ItemsTest() {
			List<String> items = new ArrayList<String>(3);
			items.add("apple");
			items.add("banana");
			items.add("mango");
			items.add("pear");
			items.add("orange");
			items.add("cherry");
			items.add("kumquat");
			items.add("lychee");
		
			Permutations<String> permutations = new Permutations<String>( items );
		
			int count = 0;
			for ( List<String> permutation : permutations ) { 
				count++;
			}
			
			assertEquals( 40320, count );  // 8! = 40,320
		}

	@Test
	@SuppressWarnings("unused")
	public void listWith10ItemsTest() {
		List<String> items = new ArrayList<String>(3);
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");
		items.add("kumquat");
		items.add("lychee");
		items.add("melon");
		items.add("canteloupe");

		Permutations<String> permutations = new Permutations<String>( items );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}
		
		assertEquals( 3628800, count );  // 10! = 3628800
	}

	@Test
	@SuppressWarnings("unused")
	public void setWith10ItemsTest() {
		// With more than 10-12 it will probably hit an OutOfMemoryError.
		Set<String> items = new HashSet<String>(3);
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");
		items.add("kumquat");
		items.add("lychee");
		items.add("melon");
		items.add("canteloupe");
	
		Permutations<String> permutations = new Permutations<String>( items );
	
		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}
		
		assertEquals( 3628800, count );  // 10! = 3628800
	}

	@Test
	public void testBigIntegerRemainder() { 
		
		BigInteger startValue = new BigInteger( "15" );
		BigInteger result = startValue.divide( BigInteger.TEN );
		
		assertEquals(BigInteger.ONE, result);
		assertEquals(1, result.intValue() );
	}

	@Test
	@SuppressWarnings("unused")
	public void listWith50ItemsSubsetTest() {
		List<String> items = new ArrayList<String>(50);
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");
		items.add("kumquat");
		items.add("lychee");
		items.add("melon");
		items.add("canteloupe");
		items.add("watermelon");
		items.add("strawberry");
		items.add("raspberry");
		items.add("blueberry");
		items.add("lemon");
		items.add("lime");
		items.add("blackberry");
		items.add("grape");
		items.add("avocado");
		items.add("guanabana");
		items.add("plantain");
		items.add("coconut");
		items.add("pineapple");
		items.add("kiwifruit");
		items.add("peach");
		items.add("apple");
		items.add("banana");
		items.add("mango");
		items.add("pear");
		items.add("orange");
		items.add("cherry");
		items.add("kumquat");
		items.add("lychee");
		items.add("melon");
		items.add("canteloupe");
		items.add("watermelon");
		items.add("strawberry");
		items.add("raspberry");
		items.add("blueberry");
		items.add("lemon");
		items.add("lime");
		items.add("blackberry");
		items.add("grape");
		items.add("avocado");
		items.add("guanabana");
		items.add("plantain");
		items.add("coconut");
		items.add("pineapple");
		items.add("kiwifruit");
		items.add("peach");

		Permutations<String> permutations = new Permutations<String>( items );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
			// Fetch only the first 8! permutations, to test that performance is workable and there are no OOM errors.
			if (count == 40320 ) { 
				break;
			}
		}

		assertEquals( 40320, count ); 
	}

}
