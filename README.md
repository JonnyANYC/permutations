Permutations
============

An experimental Java class that calculates permutations for a given set, list, or array.

It doesn't improve on the performance of existing implementations, such as the [Steinhaus–Johnson–Trotter algorithm](http://en.wikipedia.org/wiki/Steinhaus-Johnson-Trotter_algorithm). But it allows any specific permutation to be calculated, with repeatable results, without requiring knowledge of the previous permutation.

It returns an Iterator of all of the permutations, allowing the class to be used in a for loop. Permutations are calculated on-demand, as the iteration is traversed. This allows the memory requirements to be nearly constant (or O(1)).

By keeping memory complexity constant, the Permutations class can handle relatively large input sets.

Taken from my Shipping Packer project, which is hosted on Bitbucket.


Example usage in a loop
----------------------------

    Set<String> set = new HashSet<String>(3);
    set.add("apple");
    set.add("banana");
    set.add("canteloupe");

    Permutations<String> permutations = new Permutations<String>( set );
    for ( List<String> permutation : permutations ) { 
        // This loop will execute 6 times. 
        System.out.println( permutation.get( 0 ) + ", " + permutation.get( 1 ) + ", " + permutation.get( 2 ) );
    }


Performance
-----------

The Permutations class has two implementations of the algorithm, one of which uses long variables and the other uses BigIntegers. The class automatically chooses the BigInteger implementation if the given set size requires it. This incurs a big hit to execution time, but it allows larger sets (> 20 items) to be processed.

Performance (on my modest machine):

* 4-item set: Calculates the 24 permutations (or "4!") in ~1 millisecond
* 10-item set: Calculates the 3,628,800 permutations (or "10!") in ~3.6 seconds
* 50-item set: Calculates the first 40,320 permutations in ~1.5 seconds (out of 3e+64 possible permutations)

The 50-item example uses the BigInteger implementation, which is much slower. But for a given number of calculated permutations, the time complexity increases close to linearly as the size of the input set increases. It's only feasible to calculate a sub-set of all permutations for large sets, because the total number is so large. Calculating all 3e+64 possible permutations for a 50-item set would take roughly 3.6e+52 years on my machine. That's a long time.


Todo
----

Still very raw. Minimal input-checking or handling of corner cases. Inadequate Javadocs. Still missing some unit tests.
