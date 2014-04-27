package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * FIXME Split this class into Permutations and PermutationsBigInteger, ideally hiding them behind this facade.
 * 
 * @param <enumeration>
 */
public class BigIntegerPermutations<T> implements Iterator<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;
	private BigInteger permutationCount;

	public BigIntegerPermutations( List<T> set, BigInteger permutationCount ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		inputSetSize = inputSet.size();
		this.permutationCount = permutationCount;
	}

	private BigInteger currentPathIndexBigInteger = BigInteger.valueOf( -1 );

	public List<T> next() { 
		currentPathIndexBigInteger = currentPathIndexBigInteger.add( BigInteger.ONE );
		return generateNextPermutation( currentPathIndexBigInteger );
	}

	public boolean hasNext() {
		return ( currentPathIndexBigInteger.compareTo( permutationCount.subtract(BigInteger.ONE) ) < 0 );
	}

	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	private List<T> generateNextPermutation( BigInteger pathIndexToBuild ) {

		List<T> currentPath = new ArrayList<T>( inputSetSize );
		LinkedList<T> available = new LinkedList<T>( inputSet );
		// Copy the BigInteger. This should be safe, because BigIntegers are immutable.
		BigInteger remainder = pathIndexToBuild;
		BigInteger levelWidth = permutationCount;

		return generateNextPermutationUsingBigIntegers(	currentPathIndexBigInteger, 
														currentPath, 
														available, 
														remainder, 
														levelWidth);
	}
	
	private List<T> generateNextPermutationUsingBigIntegers( BigInteger pathIndexToBuild, List<T> currentPath, LinkedList<T> available, BigInteger remainder, BigInteger levelWidth ) {

		if ( available.size() == 1 ) { 
			// The path is complete.
			currentPath.add( available.get(0) );
			return currentPath;
		}

		levelWidth = levelWidth.divide( BigInteger.valueOf( available.size() ) );
		// These are BigIntegers, so a division should drop any remainder.
		BigInteger levelShift = remainder.divide( levelWidth );

		currentPath.add( available.remove( levelShift.intValue() ) );
		remainder = remainder.subtract( levelShift.multiply( levelWidth ) );

		return generateNextPermutationUsingBigIntegers(pathIndexToBuild, currentPath, available, remainder, levelWidth );
	}

}
