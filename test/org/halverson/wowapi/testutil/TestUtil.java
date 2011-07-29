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

import com.google.gson.Gson;
import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.entity.Guild;

import java.io.*;

public class TestUtil {
    public static String readAll(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        Reader fr = new InputStreamReader(ClassLoader.class.getResourceAsStream(fileName), "UTF-8");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        fr.close();
        return sb.toString();
    }

    public static Character getCharacterJson(String fileName) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(TestUtil.readAll("/testdata/" + fileName), Character.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static Guild getGuildJson(String fileName) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(TestUtil.readAll("/testdata/" + fileName), Guild.class);
        } catch (IOException e) {
            return null;
        }
    }
}
