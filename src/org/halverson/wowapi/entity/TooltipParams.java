package org.halverson.wowapi.entity;

import java.util.List;

public class TooltipParams {
    private int gem0;
    private int gem1;
    private int gem2;
    private int enchant;
    private int reforge;
    private List<Integer> set;
    private long seed;
    private boolean extraSocket;
    private int suffix;

    public int getGem0() {
        return gem0;
    }

    public void setGem0(int gem0) {
        this.gem0 = gem0;
    }

    public int getGem1() {
        return gem1;
    }

    public void setGem1(int gem1) {
        this.gem1 = gem1;
    }

    public int getGem2() {
        return gem2;
    }

    public void setGem2(int gem2) {
        this.gem2 = gem2;
    }

    public int getEnchant() {
        return enchant;
    }

    public void setEnchant(int enchant) {
        this.enchant = enchant;
    }

    public int getReforge() {
        return reforge;
    }

    public void setReforge(int reforge) {
        this.reforge = reforge;
    }

    public List<Integer> getSet() {
        return set;
    }

    public void setSet(List<Integer> set) {
        this.set = set;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public boolean isExtraSocket() {
        return extraSocket;
    }

    public void setExtraSocket(boolean extraSocket) {
        this.extraSocket = extraSocket;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TooltipParams");
        sb.append("{gem0=").append(gem0);
        sb.append(", gem1=").append(gem1);
        sb.append(", gem2=").append(gem2);
        sb.append(", enchant=").append(enchant);
        sb.append(", reforge=").append(reforge);
        sb.append(", set=").append(set);
        sb.append(", seed=").append(seed);
        sb.append(", extraSocket=").append(extraSocket);
        sb.append(", suffix=").append(suffix);
        sb.append('}');
        return sb.toString();
    }
}
