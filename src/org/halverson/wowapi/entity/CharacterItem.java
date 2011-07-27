package org.halverson.wowapi.entity;

public class CharacterItem {
    private int id;
    private String icon;
    private String name;
    private int quality;
    private TooltipParams tooltipParams;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public TooltipParams getTooltipParams() {
        return tooltipParams;
    }

    public void setTooltipParams(TooltipParams tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CharacterItem");
        sb.append("{id=").append(id);
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", quality=").append(quality);
        sb.append(", tooltipParams=").append(tooltipParams);
        sb.append('}');
        return sb.toString();
    }
}
