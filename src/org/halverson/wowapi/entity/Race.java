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

/**
 * Listing of the available races.
 */

@SuppressWarnings({"UnusedDeclaration"})
public enum Race {
    HUMAN(1, "Human"), ORC(2, "Orc"), DWARF(3, "Dwarf"), NIGHTELF(4, "Night Elf"), UNDEAD(5, "Undead"),
    GNOME(7, "Gnome"), TROLL(8, "Troll"), GOBLIN(9, "Goblin"), BLOODELF(10, "Blood Elf"), DRAENEI(11, "Draenei"),
    TAUREN(14, "Tauren"), WORGEN(22, "Worgen");

    private int race;
    private String name;

    Race(int i, String name) {
        this.race = i;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getRace() {
        return this.race;
    }

    private static final Map<Integer, Race> lookup = new HashMap<Integer, Race>();

    static {
        for (Race s : EnumSet.allOf(Race.class)) {
            lookup.put(s.getRace(), s);
        }
    }

    public static Race get(int i) {
        return lookup.get(i);
    }

    @Override
    public String toString() {
        return name;
    }
}
