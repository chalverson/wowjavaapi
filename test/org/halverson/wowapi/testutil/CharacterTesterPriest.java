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
