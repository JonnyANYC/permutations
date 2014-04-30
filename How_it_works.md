The Permutations algorithm
==========================

Permutations are calculated on-demand for the given set, as the iterator is traversed. Thus no data is retained from one iteration to the next, other than the input set, the index of the iteration, and the total number of permutations to calculate.

To calculate a permutation, the code builds a path through the input set. The input set is viewed as a dynamic B-tree of sorts, where the nodes are the same at every level, except that the parent node is always missing from each child level. The algorithm uses the index of the iteration to determine which path to trace through this B-tree, and thus which item to remove at each level. For a given input list, the algorithm always calculates the same permutation for each iteration index.

The code uses the index of the current permutation as an offset value. The code calculates the total number of paths below each node at each level in the B-tree. This is simply the factorial of the number of items left to choose from the set. This count is used as the "cost" of each node at a given level. The offset determines which particular node to choose. Then the offset is decremented as per that "cost", and the code moves to the next level of the B-tree. This is repeated until the permutation is complete.


Example
-------

Consider a set consisting of 4 elements. The total number of permutations is 4!, or 24. Let's build permutation number 14.

1. At the first level of the B-tree, all four items in the set are available to choose. For that reason, there are 3! paths under each of those items. Thus the "cost" at this level is 6.
1. Our offset is 14, so we choose the second node (the floor of 14/6 is 2). This item is then removed from the set, so it can't be chosen again.
1. We then decrement our offset by 6*2 or 12, leaving us with 2.
1. At the next level, there are three items left to choose, and 2! paths under each of them. Thus the "cost" at this level is 2.
1. We choose the first node (the floor of 2/2 is 1). This item is removed from the set, as before.
1. We then decrement our offset by 2*1 or 2, leaving us with 0.
1. At the next level, there are two items left to choose, and 1 path under each of them. The "cost" is 1, but that doesn't matter, since our offset is 0.
1. With an offset of 0, we choose the zero-th node. This item is removed from the set.
1. At the last level, there is always only one item remaining, so we just choose that and return the calculated permutation.
