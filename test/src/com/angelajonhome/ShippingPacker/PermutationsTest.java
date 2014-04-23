/*
 *   Shipping Packer
 * 
 *   Copyright 2014 Jonathan Atkinson
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.angelajonhome.ShippingPacker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void setTest() {
		Set<String> set = new HashSet(4);
		set.add("apple");
		set.add("banana");
		set.add("canteloupe");
		set.add("durian");
		
		Permutations<String> permutations = new Permutations<String>( set );

		int count = 0;
		for ( List<String> permutation : permutations ) { 
			System.out.println( permutation.get( 0 ) + ", " + permutation.get( 1 ) + ", " + permutation.get( 2 ) + ", " + permutation.get( 3 ) );
			count++;
		}
		
		// 4! = 24
		assertEquals(count, 24);
	}

		@Test
	public void largeListTest() {
		// With more than 10-12 it will probably hit an OutOfMemoryError.
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
		/*
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
		items.add("kiwifruit");  */

		Permutations<String> permutations = new Permutations<String>( items );

		int count = 0;
		for ( List<String> perm : permutations ) { 
			count++;
		}
		
		// 10! = 3628800
		assertEquals(count, 3628800);
	}

	private enum fruit { APPLE, BANANA, CANTELOUPE } 

	@Test
	public void enumTest() {
		
		Permutations<fruit> permutations = new Permutations<fruit>( fruit.values() ); 

		int count = 0;
		for ( List<fruit> perm : permutations ) { 
			count++;
		}
	
	// 3! = 6
	assertEquals(count, 6);
	}

}
