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

import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.entity.*;
import org.halverson.wowapi.exception.CharacterNotFoundException;
import org.halverson.wowapi.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.halverson.wowapi.testutil.CharacterTesterPriest.characterTesterPriest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for DAO.
 */
public class CharacterDaoTest {
    private static final String REALM = "Duskwood";
    private static final String NAME = "Borvoh";
    CharacterDao dao;

    @Before
    public void setUp() throws Exception {
        dao = mock(CharacterDao.class);
        when(dao.getCharacter(REALM, NAME, CharacterOptions.REPUTATION)).thenReturn(TestUtil.getCharacterJson("character-reputation.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.ACHIEVEMENTS)).thenReturn(TestUtil.getCharacterJson("character-achievements.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.ITEMS)).thenReturn(TestUtil.getCharacterJson("character-items.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.STATS)).thenReturn(TestUtil.getCharacterJson("character-stats.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.TALENTS)).thenReturn(TestUtil.getCharacterJson("character-talents.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.PROGRESSION)).thenReturn(TestUtil.getCharacterJson("character-progression.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.COMPANIONS)).thenReturn(TestUtil.getCharacterJson("character-companions.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.TITLES)).thenReturn(TestUtil.getCharacterJson("character-titles.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.MOUNTS)).thenReturn(TestUtil.getCharacterJson("character-mounts.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.PETS)).thenReturn(TestUtil.getCharacterJson("character-nopets.txt"));
        when(dao.getCharacter(REALM, NAME, CharacterOptions.PROFESSIONS)).thenReturn(TestUtil.getCharacterJson("character-professions.txt"));
        when(dao.getCharacter(REALM, "Velodan", CharacterOptions.PETS)).thenReturn(TestUtil.getCharacterJson("character-pets.txt"));
        when(dao.getCharacter(REALM, "Borvoh1")).thenThrow(new CharacterNotFoundException("Character not found."));
    }


    @Test(expected = CharacterNotFoundException.class)
    public void testCharacterNotFound() throws Exception {
        dao.getCharacter(REALM, "Borvoh1");
    }

    @Test
    public void testGetReputation() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.REPUTATION);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getReputation().get(0).getId(), is(equalTo(369)));
        assertThat(character.getReputation().get(0).getName(), is(equalTo("Gadgetzan")));
        assertThat(character.getReputation().get(0).getStanding(), is(equalTo(7)));
        assertThat(character.getReputation().get(0).getValue(), is(equalTo(999)));
        assertThat(character.getReputation().get(0).getMax(), is(equalTo(999)));
    }

    @Test
    public void testGetTitles() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.TITLES);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getTitles().size(), is(equalTo(27)));
        assertThat(character.getTitles().get(0).getName(), is(equalTo("Knight-Captain %s")));
        assertThat(character.getTitles().get(0).getId(), is(equalTo(8)));
    }

    @Test
    public void testGetCompanions() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.COMPANIONS);
        assertThat(character, is(characterTesterPriest()));
        assertTrue(character.getCompanions().length > 1);
        List<Integer> list = Arrays.asList(character.getCompanions());
        assertThat(list, hasItem(90523));
        assertThat(list, hasItem(84492));
    }

    @Test
    public void testGetMounts() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.MOUNTS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getMounts().length, is(equalTo(61)));
        assertThat(character.getMounts()[0], is(equalTo(458)));
    }

    @Test
    public void testGetAchievements() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.ACHIEVEMENTS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getAchievements().getAchievementsCompleted().length, is(equalTo(725)));
        assertThat(character.getAchievements().getAchievementsCompleted()[0], is(equalTo(6)));
        assertThat(character.getAchievements().getAchievementsCompletedTimestamp()[0], is(equalTo(1224118121000L)));
    }

    @Test
    public void testGetPets() throws Exception {
        Character character = dao.getCharacter(REALM, "Velodan", CharacterOptions.PETS);
        assertThat(character.getPets().size(), is(equalTo(3)));
        Pet wraith = character.getPets().get(0);
        assertThat(wraith.getCreature(), is(equalTo(3619)));
        assertThat(wraith.getSlot(), is(equalTo(0)));
        assertThat(wraith.getName(), is(equalTo("Wraith")));
        assertThat(wraith.isSelected(), is(true));
    }

    @Test
    public void testGetPetsEmpty() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.PETS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getPets().size(), is(equalTo(0)));
    }

    @Test
    public void testGetProfession() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.PROFESSIONS);
        assertThat(character, is(characterTesterPriest()));
        Profession herbalism = character.getProfessions().getPrimary().get(0);
        assertThat(herbalism.getName(), is(equalTo("Herbalism")));
        assertThat(herbalism.getRank(), is(equalTo(525)));
        assertThat(herbalism.getMax(), is(equalTo(525)));

        Profession alchemy = character.getProfessions().getPrimary().get(1);
        assertThat(alchemy.getName(), is(equalTo("Alchemy")));
        assertThat(alchemy.getRecipes().length, is(equalTo(244)));
        assertThat(alchemy.getRank(), is(equalTo(525)));
        assertThat(alchemy.getRecipes()[0], is(equalTo(2329)));

        Profession firstaid = character.getProfessions().getSecondary().get(0);
        assertThat(firstaid.getRank(), is(equalTo(525)));
        assertThat(firstaid.getName(), is(equalTo("First Aid")));
    }

    @Test
    public void testGetProgression() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.PROGRESSION);
        assertThat(character, is(characterTesterPriest()));
        Raids mc = character.getProgression().getRaids().get(0);
        assertThat(mc.getName(), is("Molten Core"));
        assertThat(mc.getBosses().get(0).getNormalKills(), is(equalTo(5)));
        assertThat(mc.getBosses().get(0).getName(), is(equalTo("Ragnaros")));
    }

    @Test
    public void testGetTalents() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.TALENTS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getTalents().get(0).getName(), is(equalTo("Shadow")));
        assertThat(character.getTalents().get(0).isSelected(), is(equalTo(true)));
        assertThat(character.getTalents().get(0).getTrees().get(0).getTotal(), is(equalTo(8)));
        assertThat(character.getTalents().get(0).getTrees().get(1).getTotal(), is(equalTo(0)));
        assertThat(character.getTalents().get(0).getTrees().get(2).getTotal(), is(equalTo(33)));
    }

    @Test
    public void testGetStats() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.STATS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getStats().getHealth(), is(equalTo(110281)));
        assertThat(character.getStats().getPowerType(), is(equalTo("mana")));
        assertThat(character.getStats().getStamina(), is(equalTo(4804)));
        assertThat(character.getStats().getIntellect(), is(equalTo(3814)));
    }

    @Test
    public void testGetItems() throws Exception {
        Character character = dao.getCharacter(REALM, NAME, CharacterOptions.ITEMS);
        assertThat(character, is(characterTesterPriest()));
        assertThat(character.getItems().getAverageItemLevel(), is(equalTo(349)));
        assertThat(character.getItems().getAverageItemLevelEquipped(), is(equalTo(349)));
        assertThat(character.getItems().getHead().getId(), is(equalTo(58161)));
    }
}
