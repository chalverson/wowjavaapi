package org.halverson.wowapi.entity;

public class Bosses {
    private int id;
    private String name;
    private int normalKills;
    private int heroicKills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormalKills() {
        return normalKills;
    }

    public void setNormalKills(int normalKills) {
        this.normalKills = normalKills;
    }

    public int getHeroicKills() {
        return heroicKills;
    }

    public void setHeroicKills(int heroicKills) {
        this.heroicKills = heroicKills;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Bosses");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", normalKills=").append(normalKills);
        sb.append(", heroicKills=").append(heroicKills);
        sb.append('}');
        return sb.toString();
    }
}
