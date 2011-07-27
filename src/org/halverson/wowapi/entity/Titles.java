package org.halverson.wowapi.entity;

@SuppressWarnings({"UnusedDeclaration"})
public class Titles implements Comparable<Titles> {
    private int id;
    private String name;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Titles");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", selected=").append(selected);
        sb.append('}');
        return sb.toString();
    }

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

    @Override
    public int compareTo(Titles o) {
        return name.compareTo(o.toString());
    }
}
