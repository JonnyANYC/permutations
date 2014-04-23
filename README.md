permutations
============

A super-simple Java class that calculates all permutations for a given set, list, or array. It returns an Iterator of all of the permutations, allowing the class to be used in a for loop.

Example usage:


    set.add("apple");
    set.add("banana");
    set.add("canteloupe");

    Permutations<String> permutations = new Permutations<String>( set );
    for ( List<String> permutation : permutations ) { 
        System.out.println( permutation.get( 0 ) + ", " + permutation.get( 1 ) + ", " + permutation.get( 2 ) );
    }


Still very raw. No input-checking or handling of corner cases. Minimal unit tests. No proper packaging or build file.

Mirrored from my Shipping Packer project, which is hosted on Bitbucket.
