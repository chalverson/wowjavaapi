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

import java.util.Arrays;

/**
 * Class to hold achievement data.
 */
public class CharacterAchievements {
    private Integer[] achievementsCompleted;
    private Long[] achievementsCompletedTimestamp;
    private Integer[] criteria;
    private Integer[] criteriaQuantity;
    private Long[] criteriaTimestamp;
    private Long[] criteriaCreated;

    public Integer[] getAchievementsCompleted() {
        return achievementsCompleted;
    }

    public void setAchievementsCompleted(Integer[] achievementsCompleted) {
        this.achievementsCompleted = achievementsCompleted;
    }

    public Long[] getAchievementsCompletedTimestamp() {
        return achievementsCompletedTimestamp;
    }

    public void setAchievementsCompletedTimestamp(Long[] achievementsCompletedTimestamp) {
        this.achievementsCompletedTimestamp = achievementsCompletedTimestamp;
    }

    public Integer[] getCriteria() {
        return criteria;
    }

    public void setCriteria(Integer[] criteria) {
        this.criteria = criteria;
    }

    public Integer[] getCriteriaQuantity() {
        return criteriaQuantity;
    }

    public void setCriteriaQuantity(Integer[] criteriaQuantity) {
        this.criteriaQuantity = criteriaQuantity;
    }

    public Long[] getCriteriaTimestamp() {
        return criteriaTimestamp;
    }

    public void setCriteriaTimestamp(Long[] criteriaTimestamp) {
        this.criteriaTimestamp = criteriaTimestamp;
    }

    public Long[] getCriteriaCreated() {
        return criteriaCreated;
    }

    public void setCriteriaCreated(Long[] criteriaCreated) {
        this.criteriaCreated = criteriaCreated;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CharacterAchievements");
        sb.append("{achievementsCompleted=").append(achievementsCompleted == null ? "null" : Arrays.asList(achievementsCompleted).toString());
        sb.append(", achievementsCompletedTimestamp=").append(achievementsCompletedTimestamp == null ? "null" : Arrays.asList(achievementsCompletedTimestamp).toString());
        sb.append(", criteria=").append(criteria == null ? "null" : Arrays.asList(criteria).toString());
        sb.append(", criteriaQuantity=").append(criteriaQuantity == null ? "null" : Arrays.asList(criteriaQuantity).toString());
        sb.append(", criteriaTimestamp=").append(criteriaTimestamp == null ? "null" : Arrays.asList(criteriaTimestamp).toString());
        sb.append(", criteriaCreated=").append(criteriaCreated == null ? "null" : Arrays.asList(criteriaCreated).toString());
        sb.append('}');
        return sb.toString();
    }
}
