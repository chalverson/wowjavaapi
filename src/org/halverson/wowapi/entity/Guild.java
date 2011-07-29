/*
 * Copyright (c) 2011 Chris D. Halverson <cdh@halverson.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.halverson.wowapi.entity;

import java.util.List;

public class Guild {
    private String name;
    private String realm;
    private int side;
    private int level;
    private int achievementPoints;
    private long lastModified;
    private List<GuildMember> members;
    private GuildAchievements achievements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public List<GuildMember> getMembers() {
        return members;
    }

    public void setMembers(List<GuildMember> members) {
        this.members = members;
    }

    public GuildAchievements getAchievements() {
        return achievements;
    }

    public void setAchievements(GuildAchievements achievements) {
        this.achievements = achievements;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Guild");
        sb.append("{name='").append(name).append('\'');
        sb.append(", realm='").append(realm).append('\'');
        sb.append(", side=").append(side);
        sb.append(", level=").append(level);
        sb.append(", achievementPoints=").append(achievementPoints);
        sb.append(", lastModified=").append(lastModified);
        sb.append(", members=").append(members);
        sb.append(", achievements=").append(achievements);
        sb.append('}');
        return sb.toString();
    }
}
