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

import java.util.List;

public class Professions {
    private List<Profession> primary;
    private List<Profession> secondary;

    public List<Profession> getPrimary() {
        return primary;
    }

    public void setPrimary(List<Profession> primary) {
        this.primary = primary;
    }

    public List<Profession> getSecondary() {
        return secondary;
    }

    public void setSecondary(List<Profession> secondary) {
        this.secondary = secondary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Professions");
        sb.append("{primary=").append(primary);
        sb.append(", secondary=").append(secondary);
        sb.append('}');
        return sb.toString();
    }
}
