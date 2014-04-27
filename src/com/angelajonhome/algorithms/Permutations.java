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
public class Permutations<T> implements Iterable<List<T>>, Iterator<List<T>> {  

	private final List<T> inputSet;
	private final int inputSetSize;
	private long permutationCountLong;
	private BigInteger permutationCountBigInteger;
	private boolean useBigIntegers = true;

	public Permutations( Set<T> set ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( set );
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public Permutations( List<T> set ) {
		// TODO Filter null values and dupe values.
		inputSet = set;
		inputSetSize = inputSet.size();
		initialize( inputSet );
	}

	public Permutations( T[] enumeration ) {
		// FIXME Handle a null input set.
		inputSet = new ArrayList<T>( Arrays.asList( enumeration ) );
		inputSetSize = inputSet.size();
		initialize( inputSet );		
	}

	private void initialize( List<T> inputList ) { 
		permutationCountBigInteger = factorial(inputSetSize);
		if ( permutationCountBigInteger.compareTo( BigInteger.valueOf(Long.MAX_VALUE) ) < 0 ) {
			System.out.println( "Not using BigIntegers.");
			useBigIntegers = false;
			permutationCountLong = permutationCountBigInteger.longValue();
		}
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
	private Long currentPathIndexLong = -1L;

	public List<T> next() { 
		if ( useBigIntegers ){ 
			currentPathIndexBigInteger = currentPathIndexBigInteger.add( BigInteger.ONE );
			return generateNextPermutation( currentPathIndexBigInteger );
		} else { 
			return generateNextPermutation( ++currentPathIndexLong );			
		}
	}

	public boolean hasNext() {
		if ( useBigIntegers ) {
			return ( currentPathIndexBigInteger.compareTo( permutationCountBigInteger.subtract(BigInteger.ONE) ) < 0 );
		} else { 
			return ( currentPathIndexLong <  permutationCountLong -1 );
		}
	}

	public void remove() { 
		throw new UnsupportedOperationException("The Permutations class doesn't support modifications to the source set or the calculated permutations."); 
	}

	private List<T> generateNextPermutation( BigInteger pathIndexToBuild ) {
		return generateNextPermutationUsingBigIntegers(currentPathIndexBigInteger, null, null, null, null);
	}
	
	private List<T> generateNextPermutation( long pathIndexToBuild ) {
		return generateNextPermutationUsingLongs(currentPathIndexLong, null, null, -1, -1);
	}

	private List<T> generateNextPermutationUsingLongs( long pathIndexToBuild, List<T> currentPath, LinkedList<T> available, long remainder, long levelWidth ) {

		if ( currentPath == null || available == null ) {
			currentPath = new ArrayList<T>( inputSetSize );
			available = new LinkedList<T>( inputSet );
			remainder = pathIndexToBuild;
			levelWidth = factorial( available.size() ).longValue();
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

		return generateNextPermutationUsingLongs(pathIndexToBuild, currentPath, available, remainder, levelWidth );
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
