package org.halverson.wowapi.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"UnusedDeclaration"})
public enum CharacterClass {
    WARRIOR(1, "Warrior"), PALADIN(2, "Paladin"), HUNTER(3, "Hunter"), ROGUE(4, "Rogue"), PRIEST(5,"Priest"), DEATHKNIGHT(6, "Death Knight"),
    SHAMAN(7, "Shaman"), MAGE(8, "Mage"), WARLOCK(9, "Warlock"), DRUID(11, "Druid");

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

    public static CharacterClass get(int i) {
        return lookup.get(i);
    }

    @Override
    public String toString() {
        return description;
    }

}
