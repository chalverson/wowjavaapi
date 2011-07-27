package org.halverson.wowapi.entity;

/**
*/
public enum Region {
    US("us"), EU("eu"), KR("kr"), TW("tw");

    private String description;

    Region(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
