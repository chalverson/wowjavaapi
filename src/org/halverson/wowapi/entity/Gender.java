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

package org.halverson.wowapi.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"UnusedDeclaration"})
public enum Gender {
    MALE(0, "Male"), FEMALE(1, "Female");

    private int id;
    private String description;

    Gender(int i, String description) {
        this.id = i;
        this.description = description;
    }

    private static final Map<Integer, Gender> lookup = new HashMap<Integer, Gender>();

    static {
        for (Gender s : EnumSet.allOf(Gender.class)) {
            lookup.put(s.getId(), s);
        }
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Gender get(int i) {
        return lookup.get(i);
    }

    @Override
    public String toString() {
        return description;
    }
}
