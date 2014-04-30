package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



/**
 * Calculate the list of permutations for a given set, list, or array. 
 * Capable of operating on relatively large sets, with near-constant memory requirements.
 * 
 * @param <T> The type of items in the input set.
 */
public class Permutations<T> implements Iterable<List<T>> {  

	private final List<T> inputSet;

	public Permutations( Set<T> set ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( set );
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
	}

	public Permutations( T[] enumeration ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( Arrays.asList( enumeration ) );
	}

	@Override
	public Iterator<List<T>> iterator() {		

		if ( inputSet == null || !(inputSet.size() > 0) ) { 
			return new ArrayList<List<T>>().iterator();
		}

		BigInteger permutationCount = factorial(inputSet.size());
		if ( permutationCount.compareTo( BigInteger.valueOf(Long.MAX_VALUE) ) < 0 ) {
			// The set is small enough to use the implementation based on longs.
			Iterator<List<T>> longPermutations = new LongPermutations<T>( inputSet, permutationCount.longValue() );
			return longPermutations;
		} else { 
			// The set is large enough to require the implementation based on BigIntegers.
			Iterator<List<T>> bigIntegerPermutations = new BigIntegerPermutations<T>( inputSet, permutationCount );
			return bigIntegerPermutations;			
		}
	}


	protected BigInteger factorial( int inputSetSize ) {
		BigInteger result = BigInteger.valueOf( inputSetSize );
		for ( int i = inputSetSize -1; i > 1; i-- ) { 
			result = result.multiply( BigInteger.valueOf(i) );
		}
		return result;
	}

}
