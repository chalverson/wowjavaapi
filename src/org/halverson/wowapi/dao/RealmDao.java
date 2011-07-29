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
import org.halverson.wowapi.entity.RealmStatus;
import org.halverson.wowapi.entity.Region;
import org.halverson.wowapi.exception.CharacterNotFoundException;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static org.halverson.wowapi.util.Util.join;

/**
 * Data access object to query Realm status.
 *
 */
public class RealmDao {
    private final String REALM_API_URL = "/api/wow/realm/status";
    private final String URL_BASE = "%s.battle.net";

    private Region region;

    /**
     * Default constructor. Defaults to Region.US for the region.
     */
    public RealmDao() {
        this.region = Region.US;
    }

    /**
     * Constructor that specifies the region.
     *
     * @param region Region to select
     */
    public RealmDao(Region region) {
        this.region = region;
    }

    /**
     * Get the realm status. Can provide a list of arguments specifying realms. The list is nullable, so any number from
     * zero up will work.
     *
     * This will replace spaces with &quot;-&quot; which represents the slug for the realm and will allow
     * the realm to work.
     *
     * @param realms Nullable list of realms to query
     * @return RealmStatus containing the status of the realms.
     * @throws CharacterNotFoundException
     */
    //public RealmStatus getRealmStatus(@Nullable String... realms) throws CharacterNotFoundException {
    public RealmStatus getRealmStatus(String... realms) throws CharacterNotFoundException {

        URI uri = null;
        try {
            uri = new URI("https", String.format(URL_BASE, region), REALM_API_URL, null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if(uri == null) {
            return null;
        }

        String realQueryString = "";
        if(realms.length > 0) {

            List<String> tempRealms = new ArrayList<String>();
            for (String realm : realms) {
                tempRealms.add(realm.replace(' ', '-'));
            }

            try {
                realQueryString = String.format("?realms=%s", URLEncoder.encode(join(tempRealms, ","), "UTF-8"));
            } catch (UnsupportedEncodingException ignored) {

            }
        }
        String url = uri.toString() + realQueryString;

        String json = BlizzardApiConnection.getStringJSONFromRequest(url);
        //System.out.println("JSON: " + json);
        Gson gson = new Gson();

        BlizzardErrorResponse errorResponse = gson.fromJson(json, BlizzardErrorResponse.class);

        if (!errorResponse.getStatus().equals("")) {
            // Would check for specific error here
            if("Character not found.".equals(errorResponse.getReason())) {
                throw new CharacterNotFoundException();
            }

        }

        return gson.fromJson(json, RealmStatus.class);
    }
}
