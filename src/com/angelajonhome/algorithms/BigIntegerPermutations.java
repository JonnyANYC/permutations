package com.angelajonhome.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 
 * FIXME Split this class into Permutations and PermutationsBigInteger, ideally hiding them behind this facade.
 * 
 * @param <enumeration>
 */
public class BigIntegerPermutations<T> implements Iterable<List<T>>, Iterator<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;
	private BigInteger permutationCountBigInteger;

	public BigIntegerPermutations( Set<T> set ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( set );
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public BigIntegerPermutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public BigIntegerPermutations( T[] enumeration ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( Arrays.asList( enumeration ) );
		inputSetSize = inputSet.size();
		initialize( inputSet );		
	}

	private void initialize( List<T> inputList ) { 
		permutationCountBigInteger = factorial(inputSetSize);
	}

	@Override
	public Iterator<List<T>> iterator() {		

		if ( inputSet == null || !(inputSetSize > 0) ) { 
			return new ArrayList<List<T>>().iterator();
		}

		// Return this instance as the iterator. We'll calculate the permutations one at a time.
		return this;		
	}

	private BigInteger currentPathIndexBigInteger = BigInteger.valueOf( -1 );

	public List<T> next() { 
		currentPathIndexBigInteger = currentPathIndexBigInteger.add( BigInteger.ONE );
		return generateNextPermutation( currentPathIndexBigInteger );
	}

	public boolean hasNext() {
		return ( currentPathIndexBigInteger.compareTo( permutationCountBigInteger.subtract(BigInteger.ONE) ) < 0 );
	}

	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	private List<T> generateNextPermutation( BigInteger pathIndexToBuild ) {
		return generateNextPermutationUsingBigIntegers(currentPathIndexBigInteger, null, null, null, null);
	}
	
	private List<T> generateNextPermutationUsingBigIntegers( BigInteger pathIndexToBuild, List<T> currentPath, LinkedList<T> available, BigInteger remainder, BigInteger levelWidth ) {

		if ( currentPath == null || available == null ) {
			currentPath = new ArrayList<T>( inputSetSize );
			available = new LinkedList<T>( inputSet );
			// Copy the BigInteger. This should be safe, because BigIntegers are immutable.
			remainder = pathIndexToBuild;
			levelWidth = factorial( available.size() );
		}

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

	protected BigInteger factorial( int inputSetSize ) {
		BigInteger result = BigInteger.valueOf( inputSetSize );
		for ( int i = inputSetSize -1; i > 1; i-- ) { 
			result = result.multiply( BigInteger.valueOf(i) );
		}
		return result;
	}

}
