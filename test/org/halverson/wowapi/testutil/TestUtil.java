package org.halverson.wowapi.testutil;

import com.google.gson.Gson;
import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.entity.Guild;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestUtil {
    public static String readAll(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        Reader fr = new InputStreamReader(TestUtil.class.getResourceAsStream(fileName), "UTF-8");
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
