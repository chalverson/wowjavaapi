package org.halverson.wowapi.entity;

import java.util.EnumSet;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 7/24/11
 * Time: 10:06 AM
 */
@SuppressWarnings({"UnusedDeclaration"})
public enum CharacterOptions {
    BASE(""), GUILD("guild"), STATS("stats"), TALENTS("talents"), ITEMS("items"), REPUTATION("reputation"), TITLES("titles"), PROFESSIONS("professions"), APPEARANCE("appearance"), COMPANIONS("companions"), MOUNTS("mounts"), PETS("pets"), ACHIEVEMENTS("achievements"), PROGRESSION("progression");

    private String description;

    CharacterOptions(String s) {
        this.description = s;
    }

    @Override
    public String toString() {
        return description;
    }

    public static final EnumSet<CharacterOptions> ALL = EnumSet.allOf(CharacterOptions.class);
}
