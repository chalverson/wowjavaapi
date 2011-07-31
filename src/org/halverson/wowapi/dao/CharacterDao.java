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

import com.google.gson.Gson;
import org.halverson.wowapi.connection.BlizzardApiConnection;
import org.halverson.wowapi.entity.BlizzardErrorResponse;
import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.entity.CharacterOptions;
import org.halverson.wowapi.entity.Region;
import org.halverson.wowapi.exception.BlizzardApplicationException;
import org.halverson.wowapi.exception.CharacterNotFoundException;
import org.halverson.wowapi.exception.WowApiException;
import org.halverson.wowapi.util.Util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static org.halverson.wowapi.util.Util.*;

/**
 * Data access object to fetch a WoW Character.
 */

@SuppressWarnings({"UnusedDeclaration"})
public class CharacterDao {

    private final String CHARACTER_API_URL = "/api/wow/character/%s/%s";
    private final String URL_BASE = "%s.battle.net";

    private Region region;

    /**
     * Default constructor will use the US Region.
     */
    public CharacterDao() {
        this.region = Region.US;
    }

    /**
     * Constructor specifying a region.
     *
     * @param region to query
     * @see Region
     */
    public CharacterDao(Region region) {
        this.region = region;
    }

    /**
     * Get a character from Blizzard based on the options. Defaults to base record set.
     *
     * @param region The region to query
     * @param realm The realm to query
     * @param name The character's name
     * @return The specified character
     * @throws WowApiException Error if a connection issue or character is not found
     * @see #getCharacter(org.halverson.wowapi.entity.Region, String, String, java.util.EnumSet)
     */
    public Character getCharacter(Region region, String realm, String name) throws WowApiException {
        return getCharacter(region, realm, name, EnumSet.of(CharacterOptions.BASE));
    }

    /**
     * Get a character from Blizzard based on the options. Defaults to base record set.
     *
     * @param realm The realm to query
     * @param name The character's name
     * @return The specified character
     * @throws WowApiException Error if a connection issue or character is not found
     * @see #getCharacter(org.halverson.wowapi.entity.Region, String, String, java.util.EnumSet)
     */
    public Character getCharacter(String realm, String name) throws WowApiException {
        return getCharacter(region, realm, name, EnumSet.of(CharacterOptions.BASE));
    }

    /**
     * Get a character from Blizzard based on the options.
     *
     * @param realm The realm to query
     * @param name The character's name
     * @param options The set of CharacterOptions to fetch
     * @return The specified character
     * @throws WowApiException Error if a connection issue or character is not found
     * @see #getCharacter(org.halverson.wowapi.entity.Region, String, String, java.util.EnumSet)
     */
    public Character getCharacter(String realm, String name, EnumSet<CharacterOptions> options) throws WowApiException {
        return getCharacter(region, realm, name, options);
    }

    /**
     * Get a character from Blizzard based on the options.
     *
     * @param realm The realm to query
     * @param name The character's name
     * @param options varargs list of options
     * @return The specified character
     * @throws WowApiException Error if a connection issue or character is not found
     * @see #getCharacter(org.halverson.wowapi.entity.Region, String, String, java.util.EnumSet)
     */
    public Character getCharacter(String realm, String name, CharacterOptions... options) throws WowApiException {
        List<CharacterOptions> o = Arrays.asList(options);
        return getCharacter(region, realm, name, EnumSet.copyOf(o));
    }

    /**
     * Get a character from Blizzard based on the options.
     *
     * This will correctly encode the URL and the options.
     *
     * @param region The region to query
     * @param realm The realm to query
     * @param name The character's name
     * @param options The set of CharacterOptions to fetch
     * @return The specified character
     * @throws WowApiException Error if a connection issue or character is not found
     */
    public Character getCharacter(Region region, String realm, String name, EnumSet<CharacterOptions> options) throws WowApiException {

        checkNotNull(region);
        Util.checkNotNull(realm);
        checkNotNull(name);
        checkArgument(realm.length() != 0);
        checkArgument(name.length() != 0);

        URI uri = null;
        try {
            uri = new URI("https", String.format(URL_BASE, region), String.format(CHARACTER_API_URL, realm, name), null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if(uri == null) {
            return null;
        }

        // We control the optional parts, and there aren't any issues with needing encoding
        String json = BlizzardApiConnection.getStringJSONFromRequest(uri.toString() + optionalQuery(options));
        //System.out.println("JSON: " + json);
        Gson gson = new Gson();

        BlizzardErrorResponse errorResponse = gson.fromJson(json, BlizzardErrorResponse.class);

        if (!errorResponse.getStatus().equals("")) {
            // Would check for specific error here
            if("Character not found.".equals(errorResponse.getReason())) {
                throw new CharacterNotFoundException(errorResponse.getReason());
            } else {
                throw new BlizzardApplicationException(errorResponse.getReason());
            }
        }

        return gson.fromJson(json, Character.class);
    }

    // Create a query string
    private String optionalQuery(EnumSet<CharacterOptions> options) {
        if (options.size() == 0 || (options.size() == 1) && options.contains(CharacterOptions.BASE)) {
            return "";
        }

        List<String> strings = new ArrayList<String>();
        for (CharacterOptions option : options) {
            strings.add(option.toString());
        }

        StringBuilder sb = new StringBuilder("?fields=");
        sb.append(join(strings, ","));
        return sb.toString();

    }

}
