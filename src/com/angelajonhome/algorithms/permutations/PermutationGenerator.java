package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public interface PermutationGenerator<T> extends Iterator<List<T>> {

	List<T> generatePermutation( BigInteger permutationIndex );

}
