package org.halverson.wowapi.entity;

public class Profession {
    private int id;
    private String name;
    private String icon;
    private int rank;
    private int max;
    private int[] recipes;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[] getRecipes() {
        return recipes;
    }

    public void setRecipes(int[] recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Profession");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", rank=").append(rank);
        sb.append(", max=").append(max);
        sb.append(", recipes=").append(recipes == null ? "null" : "");
        for (int i = 0; recipes != null && i < recipes.length; ++i)
            sb.append(i == 0 ? "" : ", ").append(recipes[i]);
        sb.append('}');
        return sb.toString();
    }
}
