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


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * An iterator that generates all permutations for a given collection lazily.
 * Each permuatation is given exactly once.
 * There is no guarantee about the order in which the permutations are returned.
 * @author Robin Ramael
 */
public class Permutator<T> implements Iterator<Collection<T>>{

    private List<T> els;
    private Stack<Step> stack;

    private class Step<T> {

        public Collection<T> head;
        public Collection<T> tail;

        public Step(List<T> head, List<T> tail) {
            this.head = head;
            this.tail = tail;
        }


        public List<Step<T>> getNextSteps() {
            //for each element in the tail, a new Step is made where that element
            // is now added to head and tail has that element removed.
            List<Step<T>> out = new ArrayList<Step<T>>();
            for (int i = 0; i < tail.size(); i++) {
                List<T> newHead = new ArrayList<T>(head);
                List<T> newTail = new ArrayList<T>(tail);
                newHead.add(newTail.remove(i));

                out.add(new Step(newHead, newTail));
            }

            return out;
        }
    }
    /**
     * Constructor for the Permutator class
     * @param coll A collection of elements to permutate.
     * These can contain nulls and duplicates.
     */
    public Permutator(Collection<T> coll) {
        els = new ArrayList<T>(coll);
        stack = new Stack<Step>();
        stack.push(new Step(new ArrayList<T>(), els));
    }


    /**
     * @return True if there are still permuations not returned. False otherwise.
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Get the next permutation as a collection.
     * @return a permutation of the collection given in the constructor.
     */
    public Collection<T> next() {
        while (!stack.isEmpty()) {
            Step<T> step = stack.pop();
            if (step.head.size() == els.size()) {
               return step.head;
            } else {
                for (Step<T> nextStep : step.getNextSteps()) {
                    stack.push(nextStep);
                }
            }
        }
        
        throw new NoSuchElementException();
    }

    /**
     * Not supported.
     */
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
