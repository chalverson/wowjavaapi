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

/**
 * Listing of the various types of data that can be retrieved for a character.
 */

@SuppressWarnings({"UnusedDeclaration"})
public enum CharacterOptions {
    BASE(""), GUILD("guild"), STATS("stats"), TALENTS("talents"), ITEMS("items"), REPUTATION("reputation"),
    TITLES("titles"), PROFESSIONS("professions"), APPEARANCE("appearance"), COMPANIONS("companions"),
    MOUNTS("mounts"), PETS("pets"), ACHIEVEMENTS("achievements"), PROGRESSION("progression");

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
