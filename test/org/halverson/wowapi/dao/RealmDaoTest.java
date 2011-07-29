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

package org.halverson.wowapi.dao;

import org.halverson.wowapi.entity.RealmStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for RealmDao.
 *
 */
public class RealmDaoTest {
    RealmDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new RealmDao();
    }

    @Test
    public void testGetRealmStatusRealmWithSpaces() throws Exception {
        RealmStatus status = dao.getRealmStatus("Shattered Halls");
        assertThat(status.getRealms().get(0).getName(), is(equalTo("Shattered Halls")));
        assertThat(status.getRealms().get(0).getType(), is(equalTo("pvp")));
        assertThat(status.getRealms().get(0).getPopulation(), is(equalTo("low")));

    }

    @Test
    public void testGetRealmStatusMultiple() throws Exception {
        RealmStatus status = dao.getRealmStatus("Duskwood", "Shattered Halls");
        assertTrue(status.getRealms().size() == 2);
    }

    @Test
    public void testGetRealmStatusNoArgs() throws Exception {
        RealmStatus status = dao.getRealmStatus();
        assertTrue(status.getRealms().size() > 5);
    }

}
