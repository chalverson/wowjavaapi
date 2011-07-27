package org.halverson.wowapi.entity;

import java.util.EnumSet;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 7/24/11
 * Time: 10:42 AM
 */
@SuppressWarnings({"UnusedDeclaration"})
public enum GuildOptions {
    BASE(""), MEMBERS("members"), ACHIEVEMENTS("achievements");

    private String description;

    GuildOptions(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static final EnumSet<GuildOptions> ALL = EnumSet.allOf(GuildOptions.class);
}
