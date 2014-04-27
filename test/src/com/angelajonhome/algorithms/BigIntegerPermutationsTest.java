package com.angelajonhome.algorithms;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BigIntegerPermutationsTest {

	@Test
	public void testBigIntegerRemainder() { 
		
		BigInteger startValue = new BigInteger( "15" );
		BigInteger result = startValue.divide( BigInteger.TEN );
		
		assertEquals(BigInteger.ONE, result);
		assertEquals(1, result.intValue() );
	}

	@Test
	public void listPartial50Test() {
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

		BigIntegerPermutations<String> permutations = new BigIntegerPermutations<String>( items );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			count++;
			// Fetch only the first 8! permutations, to test that performance is acceptable and there's no OOM errors.
			if (count == 40320 ) { 
				break;
			}
		}

		assertEquals(40320, count); 
	}

}
