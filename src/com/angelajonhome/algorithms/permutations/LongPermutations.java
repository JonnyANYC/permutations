package com.angelajonhome.algorithms.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongPermutations<T> implements Iterable<List<T>>, Iterator<List<T>> {

	private final List<T> inputSet;
	private final int inputSetSize;
	private long permutationCount;

	public LongPermutations( Set<T> set ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( set );
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public LongPermutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public LongPermutations( T[] enumeration ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( Arrays.asList( enumeration ) );
		inputSetSize = inputSet.size();
		initialize( inputSet );		
	}

	private void initialize( List<T> inputList ) { 
		permutationCount = factorial(inputSetSize);
	}

	@Override
	public Iterator<List<T>> iterator() {		

		if ( inputSet == null || !(inputSetSize > 0) ) { 
			return new ArrayList<List<T>>().iterator();
		}

		// Return this instance as the iterator. We'll calculate the permutations one at a time.
		return this;		
	}

	private Long currentPathIndex = -1L;

	public List<T> next() { 
		return generateNextPermutation( ++currentPathIndex );			
	}

	public boolean hasNext() {
		return ( currentPathIndex <  permutationCount -1 );
	}

	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	private List<T> generateNextPermutation( long pathIndexToBuild ) {
		return generateNextPermutation(currentPathIndex, null, null, -1, -1);
	}


	private List<T> generateNextPermutation( long pathIndexToBuild, List<T> currentPath, LinkedList<T> available, long remainder, long levelWidth ) {

		if ( currentPath == null || available == null ) {
			currentPath = new ArrayList<T>( inputSetSize );
			available = new LinkedList<T>( inputSet );
			remainder = pathIndexToBuild;
			levelWidth = factorial( available.size() );
		}

		if ( available.size() == 1 ) { 
			// The path is complete.
			currentPath.add( available.get(0) );
			return currentPath;
		}

		levelWidth = levelWidth / available.size();
		int levelShift = (int) Math.floor( remainder / levelWidth );

		currentPath.add( available.remove( levelShift ) );
		remainder = remainder - ( levelShift * levelWidth );

		return generateNextPermutation(pathIndexToBuild, currentPath, available, remainder, levelWidth );
	}

	protected long factorial( int inputSetSize ) {
		long result = inputSetSize;
		for ( int i = inputSetSize -1; i > 1; i-- ) { 
			result *= i;
		}
		return result;
	}


}
