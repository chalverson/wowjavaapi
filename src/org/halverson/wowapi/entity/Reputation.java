package org.halverson.wowapi.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 7/23/11
 * Time: 2:42 PM
 */
@SuppressWarnings({"UnusedDeclaration"})
public class Reputation {
    private int id;
    private String name;
    private int standing;
    private int value;
    private int max;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Reputation");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", standing=").append(standing);
        sb.append(", value=").append(value);
        sb.append(", max=").append(max);
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

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
