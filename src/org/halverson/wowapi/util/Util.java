/*
 * Copyright (c) 2011 Chris D. Halverson <cdh@halverson.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.halverson.wowapi.util;

import java.util.Iterator;

/**
 * Static utility methods.
 */
public class Util {

    private Util() {}

    /**
     * Just strings with a delimiter. Basically so I don't have to use Google Guava or some other library.
     *
     * @param s Iterable of strings to join together.
     * @param delimiter to join the strings on
     * @return String of the list joined strings.
     */
    public static String join(Iterable<String> s, String delimiter) {
        if (s == null) return "";
        Iterator<String> iter = s.iterator();
        StringBuilder builder = new StringBuilder(iter.next());
        while (iter.hasNext()) {
            builder.append(delimiter).append(iter.next());
        }
        return builder.toString();
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null.
     *
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference) {
      if (reference == null) {
        throw new NullPointerException();
      }
      return reference;
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the
     * calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression) {
      if (!expression) {
        throw new IllegalArgumentException();
      }
    }


}
