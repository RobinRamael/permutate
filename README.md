Permutate offers an Iterable and Iterator that lazily generate
permutations of a given collection. 



Usage
=====
Clone and compile with ant, and then go:

    import permutate.Permutations;
    
    (...)

    Collection<String> coll = Arrays.asList(new String[]{"haidy",
                                                         "haydi", 
                                                         "ho"});
    for (Collection<String> permutation : new  Permutations<String>(coll)) {
        // do cool stuff...
    }

Permutations is just a wrapper around Permutator (implements
Iterator), so you could just do the following as well.

    import permutate.Permutator;

    (...)

    Collection<String> coll = Arrays.asList(new String[]{"haidy",
                                                         "haydi", 
                                                         "ho"});

    Permutator p = new Permutator(coll);

    while (p.hasNext()) {
        Collection<String> perm = p.next();
        // do cool stuff...
    }

If you need to permutate a range of integers, you can use the static
permutateRange methods in Permutations.
    for (Collection<Integer> perm : Permutations.permutateRange(123,131)) {
        //...
    }
