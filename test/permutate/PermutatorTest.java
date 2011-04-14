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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the Permutator class.
 * @author robin
 */
public class PermutatorTest {

    @Test
    public void testPermutator() {
        Collection<String> in = new HashSet<String>(
                Arrays.asList(new String[]{"this", "", "is", "is", "a", "test",
                                            null, "", "sentences and such"}));
        Permutator<String> p = new Permutator(in);
        Collection<Collection<String>> result = new LinkedList<Collection<String>>();

        while (p.hasNext()) {
            result.add(p.next());
        }

        // there should be n! permutations
        assertEquals(result.size(), fact(in.size()));

        // no two permutations should be the same.
        for (Collection<String> perm : result) {
            int count = 0;
            for (Collection<String> otherPerm : result) {
                if (perm.equals(otherPerm)) {
                    count++;
                }
            }
            assertEquals(1, count);
        }

    }

    public static int fact(int n) {
        int prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }
}
