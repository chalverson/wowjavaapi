package org.halverson.wowapi.testutil;

import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.entity.CharacterClass;
import org.halverson.wowapi.entity.Gender;
import org.halverson.wowapi.entity.Race;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

/**
 * Class to manage multiple tests to avoid duplication in the unit tests. Checks to make sure the character
 * is a level 85 male Night Elf Priest named Borvoh.
 *
 */
public class CharacterTesterPriest extends TypeSafeMatcher<Character> {

    @SuppressWarnings({"RedundantIfStatement"})
    @Override
    public boolean matchesSafely(Character character) {
        if (!character.getName().equals("Borvoh")) {
            return false;
        }

        if(character.getCharacterClass() != CharacterClass.PRIEST) {
            return false;
        }

        if(character.getRace() != Race.NIGHTELF) {
            return false;
        }

        if(character.getLevel() != 85) {
            return false;
        }

        if(character.getGender() != Gender.MALE) {
            return false;
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("level 85 male Night Elf Priest named Borvoh");
    }

    @SuppressWarnings({"UnusedDeclaration"})
    @Factory
    public static <T> Matcher<Character> characterTesterPriest() {
        return new CharacterTesterPriest();
    }
}
