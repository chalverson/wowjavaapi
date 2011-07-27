package org.halverson.wowapi.entity;

import java.util.List;

public class Raids {
    private String name;
    private int normal;
    private int heroic;
    private int id;
    List<Bosses> bosses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getHeroic() {
        return heroic;
    }

    public void setHeroic(int heroic) {
        this.heroic = heroic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bosses> getBosses() {
        return bosses;
    }

    public void setBosses(List<Bosses> bosses) {
        this.bosses = bosses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Raids");
        sb.append("{name='").append(name).append('\'');
        sb.append(", normal=").append(normal);
        sb.append(", heroic=").append(heroic);
        sb.append(", id=").append(id);
        sb.append(", bosses=").append(bosses);
        sb.append('}');
        return sb.toString();
    }
}
