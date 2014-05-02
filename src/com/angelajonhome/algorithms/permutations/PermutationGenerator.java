package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public interface PermutationGenerator<T> extends Iterator<List<T>> {

	/**
	 * Calculate the given permutation.
	 * If the class is accessed as an iterator after fetching a specific permutation, 
	 * then the iteration should start immediately after the requested permutation.
	 * @param permutationIndex The zero-indexed permutation to generate. 
	 * @return The requested permutation, as a List of elements from the input set.
	 */	
	List<T> getPermutation( BigInteger permutationIndex );

}
