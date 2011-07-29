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

import org.halverson.wowapi.entity.Guild;
import org.halverson.wowapi.entity.GuildOptions;
import org.halverson.wowapi.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuildDaoTest {
    GuildDao dao;

    @Before
    public void setUp() throws Exception {
        dao = mock(GuildDao.class);
    }

    @Test
    public void testGetGuild() throws Exception {
        when(dao.getGuild("Duskwood", "House of Stryke")).thenReturn(TestUtil.getGuildJson("guild.txt"));
        Guild guild = dao.getGuild("Duskwood", "House of Stryke");
        assertThat(guild.getLevel(), is(equalTo(25)));
        assertThat(guild.getAchievementPoints(), is(equalTo(910)));
    }

    @Test
    public void testGetGuildMembers() throws Exception {
        when(dao.getGuild("Duskwood", "House of Stryke", GuildOptions.MEMBERS)).thenReturn(TestUtil.getGuildJson("guild-members.txt"));
        Guild guild = dao.getGuild("Duskwood", "House of Stryke", GuildOptions.MEMBERS);
        assertThat(guild.getMembers().size(), is(equalTo(9)));
        assertThat(guild.getLevel(), is(equalTo(25)));
        assertThat(guild.getMembers().get(0).getCharacter().getName(), is(equalTo("Borvoh")));
    }

    @Test
    public void testGetGuildAchievements() throws Exception {
        when(dao.getGuild("Duskwood", "House of Stryke", GuildOptions.ACHIEVEMENTS)).thenReturn(TestUtil.getGuildJson("guild-achievements.txt"));
        Guild guild = dao.getGuild("Duskwood", "House of Stryke", GuildOptions.ACHIEVEMENTS);
        assertThat(guild.getAchievements().getAchievementsCompleted()[0], is(equalTo(4860)));
        assertThat(guild.getAchievements().getAchievementsCompletedTimestamp()[0], is(equalTo(1294423314000L)));
    }
}
