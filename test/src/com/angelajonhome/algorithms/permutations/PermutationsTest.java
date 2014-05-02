package com.angelajonhome.algorithms.permutations;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.angelajonhome.algorithms.permutations.Permutations;


public class PermutationsTest {

	private ArrayList<String> listOf50Strings;
	private List<Integer> listOf21Integers;

	@Before
	public void setUp() throws Exception {
		
		Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		listOf21Integers = Arrays.asList( ints );

		listOf50Strings = new ArrayList<String>(50);
		listOf50Strings.add("apple");
		listOf50Strings.add("banana");
		listOf50Strings.add("cherry");
		listOf50Strings.add("mango");
		listOf50Strings.add("orange");
		listOf50Strings.add("pear");
		listOf50Strings.add("kumquat");
		listOf50Strings.add("lychee");
		listOf50Strings.add("melon");
		listOf50Strings.add("canteloupe");
		listOf50Strings.add("watermelon");
		listOf50Strings.add("strawberry");
		listOf50Strings.add("raspberry");
		listOf50Strings.add("blueberry");
		listOf50Strings.add("lemon");
		listOf50Strings.add("lime");
		listOf50Strings.add("blackberry");
		listOf50Strings.add("grape");
		listOf50Strings.add("avocado");
		listOf50Strings.add("guanabana");
		listOf50Strings.add("plantain");
		listOf50Strings.add("coconut");
		listOf50Strings.add("pineapple");
		listOf50Strings.add("kiwifruit");
		listOf50Strings.add("peach");
		listOf50Strings.add("apple");
		listOf50Strings.add("banana");
		listOf50Strings.add("mango");
		listOf50Strings.add("pear");
		listOf50Strings.add("orange");
		listOf50Strings.add("cherry");
		listOf50Strings.add("kumquat");
		listOf50Strings.add("lychee");
		listOf50Strings.add("melon");
		listOf50Strings.add("canteloupe");
		listOf50Strings.add("watermelon");
		listOf50Strings.add("strawberry");
		listOf50Strings.add("raspberry");
		listOf50Strings.add("blueberry");
		listOf50Strings.add("lemon");
		listOf50Strings.add("lime");
		listOf50Strings.add("blackberry");
		listOf50Strings.add("grape");
		listOf50Strings.add("avocado");
		listOf50Strings.add("guanabana");
		listOf50Strings.add("plantain");
		listOf50Strings.add("coconut");
		listOf50Strings.add("pineapple");
		listOf50Strings.add("kiwifruit");
		listOf50Strings.add("peach");

	}


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
	public void listWith6ItemsTest() {
		List<String> items = new ArrayList<String>(6);
		items.add("apple");
		items.add("banana");
		items.add("cherry");
		items.add("mango");
		items.add("orange");
		items.add("pear");

		Permutations<String> permutations = new Permutations<String>( items );

		List<String> actualPermutation = null;
		int count = 0;
		for ( List<String> permutation : permutations ) { 
			if ( count == 350 ) { 
				actualPermutation = permutation;
			}
			count++;
		}

		String[] testPermutation = { "cherry", "pear", "mango", "banana", "apple", "orange" };
		assertEquals( Arrays.asList( testPermutation ), actualPermutation );
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

	@SuppressWarnings("unused")
	@Test
	public void getOnePermutationByIndexAndThenIterate() { 

		List<String> items = new ArrayList<String>(6);
		items.add("apple");
		items.add("banana");
		items.add("cherry");
		items.add("mango");
		items.add("orange");
		items.add("pear");

		Permutations<String> permutations = new Permutations<String>( items );

		List<String> actualPermutation = permutations.getPermutation( new BigInteger("350") );

		String[] testPermutation = { "cherry", "pear", "mango", "banana", "apple", "orange" };
		assertEquals( Arrays.asList( testPermutation ), actualPermutation );

		// Count the remaining permutations.
		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
		}

		assertEquals( 719-350, count ); 
	}

	
	@Test
	public void getOnePermutationByIndexAndThenIterateBigInteger() { 

		Permutations<Integer> permutations = new Permutations<Integer>( listOf21Integers );

		List<Integer> actualPermutation1 = permutations.getPermutation( new BigInteger("1234567890") );

		Integer[] testPermutation1 = { 1, 2, 3, 4, 5, 6, 7, 8, 11, 16, 21, 12, 10, 13, 20, 17, 18, 19, 9, 14, 15 };
		assertEquals( Arrays.asList( testPermutation1 ), actualPermutation1 );

		List<Integer> actualPermutation2 = null;
		// Count the remaining permutations.
		int count = 0;
		for ( List<Integer> permutation : permutations ) { 
			count++;
			if ( count == 10 ) { 
				actualPermutation2 = permutation;
				break;
			}
		}

		Integer[] testPermutation2 = { 1, 2, 3, 4, 5, 6, 7, 8, 11, 16, 21, 12, 10, 13, 20, 17, 19, 9, 18, 14, 15 };
		assertEquals( Arrays.asList( testPermutation2 ), actualPermutation2 ); 
	}


	@Test
	@SuppressWarnings("unused")
	public void listWith50ItemsSubsetTest() {

		Permutations<String> permutations = new Permutations<String>( listOf50Strings );

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
