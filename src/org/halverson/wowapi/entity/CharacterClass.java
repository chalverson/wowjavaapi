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
 * Enum containing the different character classes.
 */

@SuppressWarnings({"UnusedDeclaration"})
public enum CharacterClass {
    WARRIOR(1, "Warrior"), PALADIN(2, "Paladin"), HUNTER(3, "Hunter"), ROGUE(4, "Rogue"), PRIEST(5, "Priest"),
    DEATHKNIGHT(6, "Death Knight"), SHAMAN(7, "Shaman"), MAGE(8, "Mage"), WARLOCK(9, "Warlock"), DRUID(11, "Druid");

    private int id;
    private String description;

    CharacterClass(int i, String description) {
        this.id = i;
        this.description = description;
    }

    private static final Map<Integer, CharacterClass> lookup = new HashMap<Integer, CharacterClass>();

    static {
        for (CharacterClass s : EnumSet.allOf(CharacterClass.class)) {
            lookup.put(s.getId(), s);
        }
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Static lookup method to get a specific character class
     *
     * @param id to lookup
     * @return The character class
     */
    public static CharacterClass get(int id) {
        return lookup.get(id);
    }

    /**
     * Returns the description field of the enum.
     * @return Description of the character class
     */
    @Override
    public String toString() {
        return description;
    }

}
