package com.angelajonhome.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.angelajonhome.algorithms.permutations.BigIntegerPermutations;
import com.angelajonhome.algorithms.permutations.LongPermutations;


/**
 * 
 * FIXME Split this class into Permutations and PermutationsBigInteger, ideally hiding them behind this facade.
 * 
 * @param <enumeration>
 */
public class Permutations<T> implements Iterable<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;

	public Permutations( Set<T> set ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( set );
		inputSetSize = inputSet.size();
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		inputSetSize = inputSet.size();
	}

	public Permutations( T[] enumeration ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( Arrays.asList( enumeration ) );
		inputSetSize = inputSet.size();
	}

	@Override
	public Iterator<List<T>> iterator() {		

		if ( inputSet == null || !(inputSetSize > 0) ) { 
			return new ArrayList<List<T>>().iterator();
		}

		BigInteger permutationCount = factorial(inputSetSize);
		if ( permutationCount.compareTo( BigInteger.valueOf(Long.MAX_VALUE) ) < 0 ) {
			// The set is small enough to use the implementation based on longs.
			System.out.println("Using the Long implementation, for setof size" + inputSetSize );
			Iterator<List<T>> longPermutations = new LongPermutations<T>( inputSet, permutationCount.longValue() );
			return longPermutations;
		} else { 
			// The set is large enough to require the implementation based on BigIntegers.
			System.out.println("Using the BigInteger implementation, for setof size" + inputSetSize );
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
