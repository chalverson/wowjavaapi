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

public class Pet {
    private int creature;
    private String name;
    private boolean selected = false;
    private int slot;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pet");
        sb.append("{creature=").append(creature);
        sb.append(", name='").append(name).append('\'');
        sb.append(", selected=").append(selected);
        sb.append(", slot=").append(slot);
        sb.append('}');
        return sb.toString();
    }

    public int getCreature() {
        return creature;
    }

    public void setCreature(int creature) {
        this.creature = creature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
