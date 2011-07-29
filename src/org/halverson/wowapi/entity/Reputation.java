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

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 7/23/11
 * Time: 2:42 PM
 */
@SuppressWarnings({"UnusedDeclaration"})
public class Reputation implements Serializable {
    private int id;
    private String name;
    private int standing;
    private int value;
    private int max;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Reputation");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", standing=").append(standing);
        sb.append(", value=").append(value);
        sb.append(", max=").append(max);
        sb.append('}');
        return sb.toString();
    }

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

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
