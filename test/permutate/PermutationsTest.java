/*
 *  Copyright 2011 Robin Ramael.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package permutate;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robin
 */
public class PermutationsTest {

    @Test
    public void testPermutateRange_int_int() {
        int count = 0;
        for (Collection<Integer> coll : Permutations.permutateRange(-5, 5)) {
            for (int i = -5; i < 5; i++) {
                assertTrue(coll.contains(i));
            }
            count++;
        }
        assertEquals(count, PermutatorTest.fact(10));
    }

    @Test
    public void testPermutateRange_int() {
        int count = 0;
        for (Collection<Integer> coll : Permutations.permutateRange(10)) {
            for (int i = 0; i < 10; i++) {
                assertTrue(coll.contains(i));
            }
            count++;
        }
        assertEquals(count, PermutatorTest.fact(10));
    }
}
