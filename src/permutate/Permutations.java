/*
 * Copyright 2011 Robin Ramael
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package permutate;

import java.util.Collection;
import java.util.Iterator;

/**
 * An <code>Iterable</code> that iterates over every permutation of a given collection.
 * This class uses the <code>Permutator</code> (<code>Iterator</code>-implementation), but it is probably
 * easiest to use this iterable in a foreach-loop.
 * @author Robin Ramael
 */
public class Permutations<T> implements Iterable<Collection<T>> {

    private Collection<T> els;

    /**
     * Constructor for the Permutations class.
     * @param els a collection of elements to be permutated:
     * these can contain nulls and duplicates.
     */
    public Permutations(Collection<T> els) {
        this.els = els;
    }

    /**
     * @return an iterator whoms next method returns a permuation represented by a collection.
     */
    public Iterator<Collection<T>> iterator() {
        return new Permutator<T>(els);
    }
}
