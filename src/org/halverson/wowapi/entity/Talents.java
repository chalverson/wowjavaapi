package org.halverson.wowapi.entity;

import java.util.List;

public class Talents {
    private boolean selected;
    private String name;
    private String icon;
    private String build;

    private List<TalentTree> trees;

    private Glyphs glyphs;

    public Glyphs getGlyphs() {
        return glyphs;
    }

    public void setGlyphs(Glyphs glyphs) {
        this.glyphs = glyphs;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public List<TalentTree> getTrees() {
        return trees;
    }

    public void setTrees(List<TalentTree> trees) {
        this.trees = trees;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Talents");
        sb.append("{selected=").append(selected);
        sb.append(", name='").append(name).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", build='").append(build).append('\'');
        sb.append(", trees=").append(trees);
        sb.append('}');
        return sb.toString();
    }
}
