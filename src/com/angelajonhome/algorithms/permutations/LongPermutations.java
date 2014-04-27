package com.angelajonhome.algorithms.permutations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LongPermutations<T> implements Iterator<List<T>> {

	private final List<T> inputSet;
	private long permutationCount;

	public LongPermutations( List<T> set, long permutationCount ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		this.permutationCount = permutationCount;
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
		
		List<T> currentPath = new ArrayList<T>( inputSet.size() );
		LinkedList<T> available = new LinkedList<T>( inputSet );
		long remainder = pathIndexToBuild;
		long levelWidth = permutationCount;

		return generateNextPermutation(currentPathIndex, currentPath, available, remainder, levelWidth);
	}


	private List<T> generateNextPermutation( long pathIndexToBuild, List<T> currentPath, LinkedList<T> available, long remainder, long levelWidth ) {

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

}
