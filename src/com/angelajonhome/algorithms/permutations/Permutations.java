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

	// Mark the generator as final to ensure repeatable results, even if an unordered Set was provided.
	private final PermutationGenerator<T> permutationGenerator;

	public Permutations( Set<T> set ) {
		if ( null == set ) { 
			this.permutationGenerator = null;
		} else { 
			this.permutationGenerator = getPermutationGenerator( new ArrayList<T>( set ) );
		}
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values, and document that they're not included in permutation results.
		this.permutationGenerator = getPermutationGenerator( set );
	}

	public Permutations( T[] enumeration ) {
		if ( null == enumeration ) { 
			this.permutationGenerator = null;
		} else { 
			this.permutationGenerator = getPermutationGenerator( new ArrayList<T>( Arrays.asList( enumeration ) ) );
		}
	}

	/**
	 * A Factory to determine which {@link PermutationGenerator} to use -- one that uses longs for performance, or one that uses BigIntegers for large sets.
	 * @return a {@link PermutationGenerator} that can be used to iterate over the permutations or generate a specific permutation.
	 */
	private PermutationGenerator<T> getPermutationGenerator( List<T> inputSet ) {

		if ( inputSet == null || !(inputSet.size() > 0) ) { 
			return null;
		}

		BigInteger permutationCount = factorial(inputSet.size());
		if ( permutationCount.compareTo( BigInteger.valueOf(Long.MAX_VALUE) ) < 0 ) {
			// The set is small enough to use the implementation based on longs.
			PermutationGenerator<T> longPermutations = new LongPermutations<T>( inputSet, permutationCount.longValue() );
			return longPermutations;
		} else { 
			// The set is large enough to require the implementation based on BigIntegers.
			PermutationGenerator<T> bigIntegerPermutations = new BigIntegerPermutations<T>( inputSet, permutationCount );
			return bigIntegerPermutations;			
		}
	}


	/**
	 * The PermutationGenerator is an Iterator, so return that instance.
	 * If the input set didn't allow us to create a PermutationGenerator, then return an empty iterator. 
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<List<T>> iterator() {
		if ( null == this.permutationGenerator ) { 
			return new ArrayList<List<T>>().iterator();
		}
		
		return this.permutationGenerator;
	}

	/**
	 * Exposes the getPermutation() method on the underlying PermutationGenerator. 
	 * 
	 * @see com.angelajonhome.algorithms.permutations.PermutationGenerator#getPermutation(BigInteger)
	 * @param permutationIndex The zero-indexed permutation to generate. 
	 * @return The requested permutation, as a List of elements from the input set.
	 */
	public List<T> getPermutation( BigInteger permutationIndex ) { 
		if ( null == this.permutationGenerator ) { 
			return null;
		}

		return this.permutationGenerator.getPermutation( permutationIndex );
	}

	protected BigInteger factorial( int inputSetSize ) {
		BigInteger result = BigInteger.valueOf( inputSetSize );
		for ( int i = inputSetSize -1; i > 1; i-- ) { 
			result = result.multiply( BigInteger.valueOf(i) );
		}
		return result;
	}

}
