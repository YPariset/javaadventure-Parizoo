package com.company;

public enum MonsterType {
    BARBARIAN("Barbarian", 50, 5, ArmType.ACE),
    SORCERER("Sorcerer", 40, 8, ArmType.SORT_LIGHTNING);

    private String type;
    private int lifePoints;
    private int attackPoints;
    private ArmType arm;

    MonsterType(String type, int lifePoints, int attackPoints, ArmType arm) {
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

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public ArmType getArm() {
        return arm;
    }

}
