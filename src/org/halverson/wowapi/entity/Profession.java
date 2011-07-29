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
 * Class representing a profession.
 *
 */
public class Profession implements Comparable<Profession> {
    private int id;
    private String name;
    private String icon;
    private int rank;
    private int max;
    private int[] recipes;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[] getRecipes() {
        return recipes;
    }

    public void setRecipes(int[] recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Profession");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", rank=").append(rank);
        sb.append(", max=").append(max);
        sb.append(", recipes=").append(recipes == null ? "null" : "");
        for (int i = 0; recipes != null && i < recipes.length; ++i)
            sb.append(i == 0 ? "" : ", ").append(recipes[i]);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Profession o) {
        return this.name.compareTo(o.getName());
    }
}
