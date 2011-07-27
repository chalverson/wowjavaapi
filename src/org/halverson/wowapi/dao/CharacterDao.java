package org.halverson.wowapi.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.halverson.wowapi.connection.BlizzardApiConnection;
import org.halverson.wowapi.entity.*;
import org.halverson.wowapi.entity.Character;
import org.halverson.wowapi.exception.CharacterNotFoundException;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@SuppressWarnings({"UnusedDeclaration"})
public class CharacterDao {

    private final String CHARACTER_API_URL = "/api/wow/character/%s/%s";
    private final String URL_BASE = "%s.battle.net";

    private Region region;

    public CharacterDao() {
        this.region = Region.US;
    }

    public CharacterDao(Region region) {
        this.region = region;
    }

    public Character getCharacter(Region region, String realm, String name) throws CharacterNotFoundException {

        return getCharacter(region, realm, name, EnumSet.of(CharacterOptions.BASE));
    }

    public Character getCharacter(String realm, String name) throws CharacterNotFoundException {
        return getCharacter(region, realm, name, EnumSet.of(CharacterOptions.BASE));
    }

    public Character getCharacter(String realm, String name, EnumSet<CharacterOptions> options) throws CharacterNotFoundException {
        return getCharacter(region, realm, name, options);
    }

    public Character getCharacter(String realm, String name, CharacterOptions... options) throws CharacterNotFoundException {

        List<CharacterOptions> o = Arrays.asList(options);
        return getCharacter(region, realm, name, EnumSet.copyOf(o));
    }

    public Character getCharacter(Region region, String realm, String name, EnumSet<CharacterOptions> options) throws CharacterNotFoundException {

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
        System.out.println("JSON: " + json);
        Gson gson = new Gson();

        BlizzardErrorResponse errorResponse = gson.fromJson(json, BlizzardErrorResponse.class);

        if (!errorResponse.getStatus().equals("")) {
            // Would check for specific error here
            if("Character not found.".equals(errorResponse.getReason())) {
                throw new CharacterNotFoundException();
            }

        }

        return gson.fromJson(json, Character.class);
    }

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

    // Just so I don't have to use another library
    private String join(Iterable<String> s, String delimiter) {
        if (s == null) return "";
        Iterator<String> iter = s.iterator();
        StringBuilder builder = new StringBuilder(iter.next());
        while (iter.hasNext()) {
            builder.append(delimiter).append(iter.next());
        }
        return builder.toString();
    }

    private static class BlizzardErrorResponse {
        private String status = "";
        private String reason = "";

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("BlizzardErrorResponse");
            sb.append("{status='").append(status).append('\'');
            sb.append(", reason='").append(reason).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
