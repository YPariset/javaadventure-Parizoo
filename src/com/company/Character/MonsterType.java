package com.company.Character;

import com.company.ItemModel.ArmType;

public enum MonsterType {
    BARBARIAN("Barbarian", 50, ArmType.ACE.getAttackPoints()),
    SORCERER("Sorcerer", 40, ArmType.SORT_LIGHTNING.getAttackPoints());

    private String type;
    private int lifePoints;
    private int attackPoints;


    MonsterType(String type, int lifePoints, int attackPoints) {
        this.type = type;
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
    }

    public String toString() {
        return type;
    }

    public String getType() {
        return type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }


}
