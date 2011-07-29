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

/**
 * Class representing raid bosses.
 */
public class Bosses {
    private int id;
    private String name;
    private int normalKills;
    private int heroicKills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormalKills() {
        return normalKills;
    }

    public void setNormalKills(int normalKills) {
        this.normalKills = normalKills;
    }

    public int getHeroicKills() {
        return heroicKills;
    }

    public void setHeroicKills(int heroicKills) {
        this.heroicKills = heroicKills;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Bosses");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", normalKills=").append(normalKills);
        sb.append(", heroicKills=").append(heroicKills);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bosses bosses = (Bosses) o;

        if (heroicKills != bosses.heroicKills) return false;
        if (id != bosses.id) return false;
        if (normalKills != bosses.normalKills) return false;
        if (name != null ? !name.equals(bosses.name) : bosses.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + normalKills;
        result = 31 * result + heroicKills;
        return result;
    }
}
