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
