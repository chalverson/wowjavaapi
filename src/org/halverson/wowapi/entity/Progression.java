package org.halverson.wowapi.entity;

import java.util.List;

@SuppressWarnings({"UnusedDeclaration"})
public class Progression {
    private List<Raids> raids;

    public List<Raids> getRaids() {
        return raids;
    }

    public void setRaids(List<Raids> raids) {
        this.raids = raids;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Progression");
        sb.append("{raids=").append(raids);
        sb.append('}');
        return sb.toString();
    }
}
