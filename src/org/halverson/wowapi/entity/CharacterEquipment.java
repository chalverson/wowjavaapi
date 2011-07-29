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

/**
 * Class holding a character's armor and weapons.
 *
 */
public class CharacterEquipment {
    private int averageItemLevel;
    private int averageItemLevelEquipped;
    private CharacterItem head;
    private CharacterItem neck;
    private CharacterItem shoulder;
    private CharacterItem back;
    private CharacterItem chest;
    private CharacterItem shirt;
    private CharacterItem wrist;
    private CharacterItem hands;
    private CharacterItem waist;
    private CharacterItem legs;
    private CharacterItem feet;
    private CharacterItem finger1;
    private CharacterItem finger2;
    private CharacterItem trinket1;
    private CharacterItem trinket2;
    private CharacterItem mainHand;
    private CharacterItem offHand;
    private CharacterItem ranged;

    public int getAverageItemLevel() {
        return averageItemLevel;
    }

    public void setAverageItemLevel(int averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    public int getAverageItemLevelEquipped() {
        return averageItemLevelEquipped;
    }

    public void setAverageItemLevelEquipped(int averageItemLevelEquipped) {
        this.averageItemLevelEquipped = averageItemLevelEquipped;
    }

    public CharacterItem getHead() {
        return head;
    }

    public void setHead(CharacterItem head) {
        this.head = head;
    }

    public CharacterItem getNeck() {
        return neck;
    }

    public void setNeck(CharacterItem neck) {
        this.neck = neck;
    }

    public CharacterItem getShoulder() {
        return shoulder;
    }

    public void setShoulder(CharacterItem shoulder) {
        this.shoulder = shoulder;
    }

    public CharacterItem getBack() {
        return back;
    }

    public void setBack(CharacterItem back) {
        this.back = back;
    }

    public CharacterItem getChest() {
        return chest;
    }

    public void setChest(CharacterItem chest) {
        this.chest = chest;
    }

    public CharacterItem getShirt() {
        return shirt;
    }

    public void setShirt(CharacterItem shirt) {
        this.shirt = shirt;
    }

    public CharacterItem getWrist() {
        return wrist;
    }

    public void setWrist(CharacterItem wrist) {
        this.wrist = wrist;
    }

    public CharacterItem getHands() {
        return hands;
    }

    public void setHands(CharacterItem hands) {
        this.hands = hands;
    }

    public CharacterItem getWaist() {
        return waist;
    }

    public void setWaist(CharacterItem waist) {
        this.waist = waist;
    }

    public CharacterItem getLegs() {
        return legs;
    }

    public void setLegs(CharacterItem legs) {
        this.legs = legs;
    }

    public CharacterItem getFeet() {
        return feet;
    }

    public void setFeet(CharacterItem feet) {
        this.feet = feet;
    }

    public CharacterItem getFinger1() {
        return finger1;
    }

    public void setFinger1(CharacterItem finger1) {
        this.finger1 = finger1;
    }

    public CharacterItem getFinger2() {
        return finger2;
    }

    public void setFinger2(CharacterItem finger2) {
        this.finger2 = finger2;
    }

    public CharacterItem getTrinket1() {
        return trinket1;
    }

    public void setTrinket1(CharacterItem trinket1) {
        this.trinket1 = trinket1;
    }

    public CharacterItem getTrinket2() {
        return trinket2;
    }

    public void setTrinket2(CharacterItem trinket2) {
        this.trinket2 = trinket2;
    }

    public CharacterItem getMainHand() {
        return mainHand;
    }

    public void setMainHand(CharacterItem mainHand) {
        this.mainHand = mainHand;
    }

    public CharacterItem getOffHand() {
        return offHand;
    }

    public void setOffHand(CharacterItem offHand) {
        this.offHand = offHand;
    }

    public CharacterItem getRanged() {
        return ranged;
    }

    public void setRanged(CharacterItem ranged) {
        this.ranged = ranged;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CharacterEquipment");
        sb.append("{averageItemLevel=").append(averageItemLevel);
        sb.append(", averageItemLevelEquipped=").append(averageItemLevelEquipped);
        sb.append(", head=").append(head);
        sb.append(", neck=").append(neck);
        sb.append(", shoulder=").append(shoulder);
        sb.append(", back=").append(back);
        sb.append(", chest=").append(chest);
        sb.append(", shirt=").append(shirt);
        sb.append(", wrist=").append(wrist);
        sb.append(", hands=").append(hands);
        sb.append(", waist=").append(waist);
        sb.append(", legs=").append(legs);
        sb.append(", feet=").append(feet);
        sb.append(", finger1=").append(finger1);
        sb.append(", finger2=").append(finger2);
        sb.append(", trinket1=").append(trinket1);
        sb.append(", trinket2=").append(trinket2);
        sb.append(", mainHand=").append(mainHand);
        sb.append(", offHand=").append(offHand);
        sb.append(", ranged=").append(ranged);
        sb.append('}');
        return sb.toString();
    }
}
