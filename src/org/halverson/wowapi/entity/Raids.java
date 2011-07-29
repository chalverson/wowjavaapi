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

import java.io.Serializable;
import java.util.List;

/**
 * Representation of a raid including the number of normal and heroic completions and a list of bosses.
 *
 */
public class Raids implements Serializable {
    private String name;
    private int normal;
    private int heroic;
    private int id;
    List<Bosses> bosses;

    /**
     * The name of the raid.
     * @return The name of the raid.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getHeroic() {
        return heroic;
    }

    public void setHeroic(int heroic) {
        this.heroic = heroic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bosses> getBosses() {
        return bosses;
    }

    public void setBosses(List<Bosses> bosses) {
        this.bosses = bosses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Raids");
        sb.append("{name='").append(name).append('\'');
        sb.append(", normal=").append(normal);
        sb.append(", heroic=").append(heroic);
        sb.append(", id=").append(id);
        sb.append(", bosses=").append(bosses);
        sb.append('}');
        return sb.toString();
    }
}
