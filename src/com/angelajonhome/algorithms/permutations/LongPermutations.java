package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Calculates any permutation for a given input set.
 * The set cannot be > 20 items, since in that case its factorial won't fit in a long. If so, use BigIntegerPermutations. 
 * The input set actually is required to be a List, to guarantee consistent ordering and thus guarantee that all permutations are unique.
 *
 * @param <T> The type of items in the input set. 
 */
public class LongPermutations<T> implements Iterator<List<T>>, PermutationGenerator<T> {

	private final List<T> inputSet;
	private final long permutationCount;

	public LongPermutations( List<T> set, long permutationCount ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		this.permutationCount = permutationCount;
	}

	private Long currentPathIndex = -1L;

	@Override
	public List<T> next() { 
		return generatePermutation( ++currentPathIndex );			
	}

	@Override
	public boolean hasNext() {
		return ( currentPathIndex <  permutationCount -1 );
	}

	@Override
	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	public List<T> generatePermutation( BigInteger permutationIndex ) {

		return generatePermutation( permutationIndex.longValue() );
	}


	/** 
	 * Start the calculation for the given permutation. Initialize the variables and then call the recursive function.
	 * 
	 * @param permutationIndex The zero-indexed permutation to calculate for the input set.
	 * @return The calculated permutation.
	 */
	private List<T> generatePermutation( long permutationIndex ) {

		List<T> currentPath = new ArrayList<T>( inputSet.size() );
		LinkedList<T> available = new LinkedList<T>( inputSet );
		long offset = permutationIndex;
		long levelCost = permutationCount;

		return generatePermutation( currentPath, available, offset, levelCost );
	}


	/**
	 * Recursively build the given permutation.
	 * The recursion ends when only one item remains to be chosen.
	 * The input set is implemented here as a LinkedList, to allow for easy removals at each level of the B-tree.
	 * See the How_it_works document in the project for more details.
	 * 
	 * @param currentPath Stores the permutation as it is built.
	 * @param available The set of items that aren't yet in the permutation that is built.
	 * @param offset The number of elements to shift from the zero-th path. Updated at every iteration.
	 * @param levelCost The size of the tree underneath each node. Retained to avoid re-calculating a factorial.
	 * @return The calculated permutation, after recursion is complete.
	 */
	private List<T> generatePermutation( List<T> currentPath, LinkedList<T> available, long offset, long levelCost ) {

		if ( available.size() == 1 ) { 
			// The path is complete.
			currentPath.add( available.get(0) );
			return currentPath;
		}

		levelCost = levelCost / available.size();
		int levelShift = (int) Math.floor( offset / levelCost );

		currentPath.add( available.remove( levelShift ) );
		offset = offset - ( levelShift * levelCost );

		return generatePermutation( currentPath, available, offset, levelCost );
	}

}
