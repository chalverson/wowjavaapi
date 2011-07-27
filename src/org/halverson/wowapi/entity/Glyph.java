package org.halverson.wowapi.entity;

public class Glyph {
    private int glyph;
    private String name;
    private int item;
    private String icon;

    public int getGlyph() {
        return glyph;
    }

    public void setGlyph(int glyph) {
        this.glyph = glyph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Glyph");
        sb.append("{glyph=").append(glyph);
        sb.append(", name='").append(name).append('\'');
        sb.append(", item=").append(item);
        sb.append(", icon='").append(icon).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
