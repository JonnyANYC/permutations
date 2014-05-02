package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Calculates any permutation for a given input set.
 * The set should be large enough that its factorial doesn't fit in a long. Otherwise, LongPermutations is more efficient. 
 * The input set actually is required to be a List, to guarantee consistent ordering and thus guarantee that all permutations are unique.
 * 
 * @param <T> The type of items in the input set.
 */
public class BigIntegerPermutations<T> implements PermutationGenerator<T> {  

	private final List<T> inputSet;
	private final BigInteger permutationCount;

	public BigIntegerPermutations( List<T> set, BigInteger permutationCount ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		this.permutationCount = permutationCount;
	}

	private BigInteger currentPathIndexBigInteger = BigInteger.valueOf( -1 );

	@Override
	public List<T> next() { 
		currentPathIndexBigInteger = currentPathIndexBigInteger.add( BigInteger.ONE );
		return generatePermutation( currentPathIndexBigInteger );
	}

	@Override
	public boolean hasNext() {
		return ( currentPathIndexBigInteger.compareTo( permutationCount.subtract(BigInteger.ONE) ) < 0 );
	}

	@Override
	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	/** 
	 * Calculate the given permutation. Initialize the variables and then call the recursive function.
	 * 
	 * @param permutationIndex The zero-indexed permutation to calculate for the input set.
	 * @return The calculated permutation.
	 */
	public List<T> generatePermutation( BigInteger permutationIndex ) {

		List<T> currentPath = new ArrayList<T>( inputSet.size() );
		LinkedList<T> available = new LinkedList<T>( inputSet );
		// Copy the BigInteger. This should be safe, because BigIntegers are immutable.
		BigInteger offset = permutationIndex;
		BigInteger levelCost = permutationCount;

		return generatePermutation(	currentPath, 
										available, 
										offset, 
										levelCost);
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
	private List<T> generatePermutation( 	List<T> currentPath, 
												LinkedList<T> available, 
												BigInteger offset, 
												BigInteger levelCost ) {

		if ( available.size() == 1 ) { 
			// The path is complete.
			currentPath.add( available.get(0) );
			return currentPath;
		}

		levelCost = levelCost.divide( BigInteger.valueOf( available.size() ) );
		// These are BigIntegers, so a division should drop any remainder.
		BigInteger levelShift = offset.divide( levelCost );

		currentPath.add( available.remove( levelShift.intValue() ) );
		offset = offset.subtract( levelShift.multiply( levelCost ) );

		return generatePermutation(currentPath, available, offset, levelCost );
	}

}
