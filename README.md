Permutations
============

A super-simple Java class that calculates all permutations for a given set, list, or array. It returns an Iterator of all of the permutations, allowing the class to be used in a for loop.

Permutations are calculated on-demand, as the iteration is traversed. This allows the memory requirements to be constant (or O(N)) and the execution time to be linear (or O(N)), and certainly usable even for relatively large input sets.

Taken from my Shipping Packer project, which is hosted on Bitbucket.

Performance
-----------

Performance (on my modest machine):

	4-item set: Calculates the 24 permutations (or 4!) in 1 millisecond
	10-item set: Calculates the 3,628,800 permutations (or 10!) in ~3.5 seconds
	25-item set: Calculates the first 3,628,800 permutations in ~10.5 seconds (out of 15,511,210,043,330,985,984,000,000 possible permutations)


Example usage
-------------


    set.add("apple");
    set.add("banana");
    set.add("canteloupe");

    Permutations<String> permutations = new Permutations<String>( set );
    for ( List<String> permutation : permutations ) { 
        System.out.println( permutation.get( 0 ) + ", " + permutation.get( 1 ) + ", " + permutation.get( 2 ) );
    }


Todo
----

Still very raw. Minimal input-checking or handling of corner cases. Minimal unit tests.
