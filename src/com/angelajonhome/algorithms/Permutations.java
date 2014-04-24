package com.angelajonhome.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 
 * TODO Implement a second algorithm that calculates each permutation separately, to keep memory complexity low 
 * (at the expense of time complexity). Necessary for sets > ~12.
 * 
 * @param <enumeration>
 */
public class Permutations<T> implements Iterable<List<T>>, Iterator<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;
	private List<List<T>> permutations; 

	public Permutations( Set<T> set ) {
		this.inputSet = new ArrayList<T>( set );
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>();
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		if ( set instanceof ArrayList ) { 
			this.inputSet = set;			
		} else { 
			this.inputSet = new ArrayList<T>( set );			
		}
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>();
	}

	public Permutations( T[] enumeration ) {

		List<T>set = new ArrayList<T>( Arrays.asList( enumeration ) );
		this.inputSet = set;			
		this.inputSetSize = set.size();
		this.permutations = new ArrayList<List<T>>();
	}

	private int currentPathIndex = -1;
	private boolean generateOnDemand = false;

	public void generateOnDemand( boolean generateOnDemand ) { 
		this.generateOnDemand = generateOnDemand;
	}

	
	@Override
	public Iterator<List<T>> iterator() {		

		// FIXME Handle a null input set.

		if ( !(inputSetSize > 0) ) { 
			return new ArrayList<List<T>>().iterator();
		}

		if ( !generateOnDemand ) {
			// Calculate all permutations, store in a local List of Lists, and then return an iterator for the list.
			generatePermutations( null, null );
			return permutations.iterator();
		} 

		// Return this instance as the iterator. We'll calculate the permutations one at a time.
		// TODO Log a warning if the set size is greater than 12.
		return this;		
	}

	public List<T> next() { 
		return generateNextPermutation(++currentPathIndex, null, null, -1);
	}
	
	public boolean hasNext() {
		return ( currentPathIndex < factorial(inputSetSize) -1 );
	}
	
	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}
	
	private void generatePermutations( List<T> currentPath, LinkedList<T> available ) {

		if ( currentPath == null || available == null) {
			currentPath = new ArrayList<T>( inputSetSize );
			available = new LinkedList<T>( inputSet );
		}

		for ( int i = 0; i < available.size(); i++ ) { 

			List<T> branchPath = new ArrayList<T>( inputSetSize );
			branchPath.addAll( currentPath );

			LinkedList<T> branchAvailable = new LinkedList<T>( available );
			branchPath.add( branchAvailable.remove(i) );

			if ( branchAvailable.size() == 0 ) {
				// Found a complete path.
				permutations.add( branchPath );

			} else {
				// Keep looking.
				generatePermutations( branchPath, branchAvailable );
			}
		}
	}

	private List<T> generateNextPermutation( int pathIndexToBuild, List<T> currentPath, LinkedList<T> available, int remainder ) {

		if ( currentPath == null || available == null ) {
			currentPath = new ArrayList<T>( inputSetSize );
			available = new LinkedList<T>( inputSet );
			remainder = pathIndexToBuild;
		}
		
		if ( available.size() == 1 ) { 
			currentPath.add( available.get(0) );
			return currentPath;
		}

		int levelWidth = factorial( available.size() - 1);
		int levelShift = (int) Math.floor( remainder / levelWidth );

		currentPath.add( available.remove(levelShift) );

		return generateNextPermutation(pathIndexToBuild, currentPath, available, remainder - (levelShift*levelWidth) );
	}

	protected int factorial( int inputSetSize ) {
		int result = inputSetSize;
		for ( int i = inputSetSize -1; i > 1; i-- ) { 
			result *= i;
		}
		return result;
	}

}

