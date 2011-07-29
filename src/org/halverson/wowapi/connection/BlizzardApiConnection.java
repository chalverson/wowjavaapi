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

package org.halverson.wowapi.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class to communicate with Blizzard's API.
 */
public class BlizzardApiConnection {

    /**
     * Returns the JSON from the supplied URL. This will always return some sort of JSON. If there is a URL
     * connection error it will return a JSON string that is a error status.
     *
     * @param url to send request
     * @return String of the returned JSON
     */
    public static String getStringJSONFromRequest(String url) {
        String ret = "";
        BufferedReader reader = null;
        HttpURLConnection urlConnection;

        try {
            urlConnection = (HttpURLConnection) new URL(url).openConnection();
            String line;
            StringBuilder sb = new StringBuilder();
            int responseCode = urlConnection.getResponseCode();
            if((responseCode == 404) || (responseCode == 500)) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            ret = sb.toString();
        } catch (IOException e1) {
            ret = "{\"status\":\"nok\", \"reason\":\"URL Connection Error\"}";
        }
        finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException ignored) {
            }

        }
        return ret;
    }

}
