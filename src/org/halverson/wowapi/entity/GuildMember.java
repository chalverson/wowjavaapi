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

public class GuildMember implements Comparable<GuildMember> {
    private GuildCharacter character;
    private int rank;

    public GuildCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GuildCharacter character) {
        this.character = character;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GuildMember");
        sb.append("{character=").append(character);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(GuildMember o) {
        return this.character.getName().compareTo(o.getCharacter().getName());
    }
}
