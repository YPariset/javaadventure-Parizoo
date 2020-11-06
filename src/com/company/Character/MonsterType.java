package com.company.Character;


import com.company.ItemModel.ArmType;

import java.util.Arrays;
import java.util.Random;

public enum MonsterType {
    BARBARIAN("Barbarian", 50, ArmType.ACE.getAttackPoints(), "an Ace"),
    SORCERER("Sorcerer", 40, ArmType.SORT_LIGHTNING.getAttackPoints(), "a sort of Lightning");

    private String type;
    private String arm;
    private int lifePoints;
    private int attackPoints;


    MonsterType(String type, int lifePoints, int attackPoints, String arm) {
        this.type = type;
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.arm = arm;
    }



    public String toString() {
        return type;
    }

    public String getType() {
        return type;
    }

    public String getNameOfArm() { return arm; }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }





}
