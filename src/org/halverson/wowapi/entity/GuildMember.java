package org.halverson.wowapi.entity;

public class GuildMember {
    private GuildCharacter character;
    private int rank;

    public GuildCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GuildCharacter character) {
        this.character = character;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GuildMember");
        sb.append("{character=").append(character);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}
