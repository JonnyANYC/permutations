package com.angelajonhome.algorithms.permutations;

import java.math.BigInteger;
import java.util.List;

public interface PermutationGenerator<T> {

	List<T> generatePermutation( BigInteger permutationIndex );

}
