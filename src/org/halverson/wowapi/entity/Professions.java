package org.halverson.wowapi.entity;

import java.util.List;

public class Professions {
    private List<Profession> primary;
    private List<Profession> secondary;

    public List<Profession> getPrimary() {
        return primary;
    }

    public void setPrimary(List<Profession> primary) {
        this.primary = primary;
    }

    public List<Profession> getSecondary() {
        return secondary;
    }

    public void setSecondary(List<Profession> secondary) {
        this.secondary = secondary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Professions");
        sb.append("{primary=").append(primary);
        sb.append(", secondary=").append(secondary);
        sb.append('}');
        return sb.toString();
    }
}
