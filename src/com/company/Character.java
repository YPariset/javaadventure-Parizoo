package com.company;

public class Character {
    protected int lifePoints;
    protected int attackPoints;
    protected ArmType arm;

    public Character(int lifePoints, int attackPoints, ArmType arm) {
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.arm = arm;
    }

    public boolean isAlive(){
        return this.lifePoints > 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public ArmType getArm() {
        return arm;
    }

    public void setArm(ArmType arm) {
        this.arm = arm;
    }
}
