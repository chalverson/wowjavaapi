package org.halverson.wowapi.entity;

import java.util.ArrayList;
import java.util.List;

public class Glyphs {
    private List<Glyph> prime = new ArrayList<Glyph>();
    private List<Glyph> major = new ArrayList<Glyph>();
    private List<Glyph> minor = new ArrayList<Glyph>();

    public List<Glyph> getPrime() {
        return prime;
    }

    public void setPrime(List<Glyph> prime) {
        this.prime = prime;
    }

    public List<Glyph> getMajor() {
        return major;
    }

    public void setMajor(List<Glyph> major) {
        this.major = major;
    }

    public List<Glyph> getMinor() {
        return minor;
    }

    public void setMinor(List<Glyph> minor) {
        this.minor = minor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Glyphs");
        sb.append("{prime=").append(prime);
        sb.append(", major=").append(major);
        sb.append(", minor=").append(minor);
        sb.append('}');
        return sb.toString();
    }
}
