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
