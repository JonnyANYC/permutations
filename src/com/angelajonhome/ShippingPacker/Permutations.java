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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * 
 * TODO Implement a second algorithm that calculates each permutation separately, to keep memory complexity low 
 * (at the expense of time complexity). Necessary for sets > ~12.
 * 
 * @author Jonathan Atkinson
 *
 * @param <enumeration>
 */
public class Permutations<T> implements Iterable<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;
	private List<List<T>> permutations; 

	public Permutations( Set<T> set ) {
		this.inputSet = new ArrayList<T>( set );
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>(  );
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		if ( set instanceof ArrayList ) { 
			this.inputSet = set;			
		} else { 
			this.inputSet = new ArrayList<T>( set );			
		}
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>(  );
	}

	public Permutations( T[] enumeration ) {

		List<T>set = new ArrayList<T>( Arrays.asList( enumeration ) );
		this.inputSet = set;			
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>(  );
	}

	// TODO Consider re-implementing with a linked list for the path instead of an array list, so I can remove items instead of using a boolean[] tracker. 
	private void generatePermutations( List<Integer> currentPath, boolean[] taken ) {

		if ( currentPath == null || taken == null) {
			currentPath = new ArrayList<Integer>( inputSetSize );
			taken = new boolean[inputSetSize];
		}

		for ( int i = 0; i < taken.length; i++ ) { 

			if ( !taken[i] ) {
				List<Integer> branchPath = new ArrayList<Integer>( inputSetSize );
				branchPath.addAll( currentPath );
				branchPath.add( i );
								
				if ( branchPath.size() == inputSetSize ) {
					// Found a complete path.
					permutations.add( buildObjectPath(branchPath) );

				} else {

					boolean[] branchTaken = new boolean[ inputSetSize ];
					System.arraycopy( taken, 0, branchTaken, 0, inputSetSize );
					branchTaken[i] = true;

					// Keep looking.
					generatePermutations( branchPath, branchTaken );
				}
			}
		}
	}
	

	private List<T> buildObjectPath( List<Integer> path ) { 

		List<T> objectPath = new ArrayList<T>( inputSetSize );
		
		for (Integer i : path ) { 
			objectPath.add( inputSet.get(i) );
		}

		return objectPath;
	}
	
	@Override
	public Iterator<List<T>> iterator() {		

		// TODO Log a warning if the set size is greater than 10.

		// FIXME Handle a null input set.
		generatePermutations(null, null );
		return permutations.iterator();
	}
}

