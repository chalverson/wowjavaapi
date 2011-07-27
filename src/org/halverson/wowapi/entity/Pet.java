package org.halverson.wowapi.entity;

public class Pet {
    private int creature;
    private String name;
    private boolean selected = false;
    private int slot;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pet");
        sb.append("{creature=").append(creature);
        sb.append(", name='").append(name).append('\'');
        sb.append(", selected=").append(selected);
        sb.append(", slot=").append(slot);
        sb.append('}');
        return sb.toString();
    }

    public int getCreature() {
        return creature;
    }

    public void setCreature(int creature) {
        this.creature = creature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
