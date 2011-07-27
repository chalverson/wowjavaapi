package org.halverson.wowapi.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@SuppressWarnings({"UnusedDeclaration"})
public class Character implements Serializable {
    private String name;
    private int level;
    private String realm;
    private long lastModified;
    private String thumbnail;

    @SerializedName("race")
    private int raceId;
    private int achievementPoints;
    @SerializedName("gender")
    private int genderId;
    @SerializedName("class")
    private int classId;

    private transient Gender gender;
    @SuppressWarnings({"FieldCanBeLocal"})
    private transient Race race;

    private List<Reputation> reputation = new ArrayList<Reputation>();

    private List<Titles> titles = new ArrayList<Titles>();
    private Integer[] mounts = new Integer[0];
    private Integer[] companions = new Integer[0];
    private CharacterAchievements achievements;
    private List<Pet> pets = new ArrayList<Pet>();
    private Professions professions;
    private Progression progression;
    private List<Talents> talents = new ArrayList<Talents>();

    private CharacterStats stats;

    private CharacterEquipment items;

    public CharacterEquipment getItems() {
        return items;
    }

    public void setItems(CharacterEquipment items) {
        this.items = items;
    }

    public CharacterStats getStats() {
        return stats;
    }

    public void setStats(CharacterStats stats) {
        this.stats = stats;
    }

    public List<Talents> getTalents() {
        return talents;
    }

    public void setTalents(List<Talents> talents) {
        this.talents = talents;
    }

    public Progression getProgression() {
        return progression;
    }

    public void setProgression(Progression progression) {
        this.progression = progression;
    }

    public Professions getProfessions() {
        return professions;
    }

    public void setProfessions(Professions professions) {
        this.professions = professions;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public CharacterAchievements getAchievements() {
        return achievements;
    }

    public void setAchievements(CharacterAchievements achievements) {
        this.achievements = achievements;
    }

    public Integer[] getCompanions() {
        return companions;
    }

    public void setCompanions(Integer[] companions) {
        this.companions = companions;
    }

    public List<Titles> getTitles() {
        return titles;
    }

    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }

    public List<Reputation> getReputation() {
        return reputation;
    }


    public Integer[] getMounts() {
        return mounts;
    }


    public CharacterClass getCharacterClass() {
        return CharacterClass.get(classId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
        System.out.println("b4 RACE");
        this.race = Race.get(raceId);

    }

    public Race getRace() {
        return Race.get(raceId);
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public int getGenderId() {
        return genderId;
    }

    public Gender getGender() {
        return Gender.get(genderId);
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
        this.gender = Gender.get(genderId);
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;

    }

    public Date getLastmodifiedDate() {
        return new Date(lastModified);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Character");
        sb.append("{name='").append(name).append('\'');
        sb.append(", level=").append(level);
        sb.append(", realm='").append(realm).append('\'');
        sb.append(", lastModified=").append(lastModified);
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append(", raceId=").append(raceId);
        sb.append(", race=").append(getRace());
        sb.append(", achievementPoints=").append(achievementPoints);
        sb.append(", genderId=").append(genderId);
        sb.append(", classId=").append(classId);
        sb.append(", characterClass=").append(getCharacterClass());
        sb.append('}');
        return sb.toString();
    }
}
