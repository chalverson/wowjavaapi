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
 * Class representing a character's items.
 */
public class CharacterItem {
    private int id;
    private String icon;
    private String name;
    private int quality;
    private TooltipParams tooltipParams;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public TooltipParams getTooltipParams() {
        return tooltipParams;
    }

    public void setTooltipParams(TooltipParams tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CharacterItem");
        sb.append("{id=").append(id);
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", quality=").append(quality);
        sb.append(", tooltipParams=").append(tooltipParams);
        sb.append('}');
        return sb.toString();
    }
}
