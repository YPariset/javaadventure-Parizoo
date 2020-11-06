package com.company.Character;

import com.company.ItemModel.ArmType;

public class Character {
    protected int lifePoints;
    protected int attackPoints;

    public Character(int lifePoints, int attackPoints) {
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
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


}
