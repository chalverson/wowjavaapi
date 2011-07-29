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
 * Class representing realm status. Just contains a list of realm objects.
 *
 * @author Chris D. Halverson
 */
public class RealmStatus implements Serializable {
    private List<Realm> realms;

    /**
     * Get the list of realm status objects.
     *
     * @return List of realm status
     */
    public List<Realm> getRealms() {
        return realms;
    }

    /**
     * Set the realm status objects
     *
     * @param realms
     */
    public void setRealms(List<Realm> realms) {
        this.realms = realms;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("RealmStatus");
        sb.append("{realms=").append(realms);
        sb.append('}');
        return sb.toString();
    }
}
