package org.halverson.wowapi.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BlizzardApiConnection {

    public static String getStringJSONFromRequest(String url) {
        String ret = "";
        BufferedReader reader = null;
        HttpURLConnection urlConnection;

        try {
            urlConnection = (HttpURLConnection) new URL(url).openConnection();

            String line;
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            ret = sb.toString();
        } catch (IOException e1) {
            e1.printStackTrace();
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
