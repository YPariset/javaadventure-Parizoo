package com.company.Character;

import com.company.ItemModel.ArmType;

public class Monster extends Character implements Fighter {

    MonsterType type;

    public Monster(MonsterType type, ArmType arm) {
        super(type.getLifePoints(), type.getAttackPoints());
        this.type = type;
        this.arm = arm;
    }

    /**
     * attack is the function to attack an other com.company.Character.Character
     *
     * @param c the com.company.Character.Character to attack
     */
    @Override
    public void attack(Character c) {
        System.out.println("------------------\n");
        System.out.println("The monster " + this.type + " attack the player with " + this.arm);
        c.setLifePoints(c.getLifePoints() - this.attackPoints);
        System.out.println("Now, the player has " + c.getLifePoints() + " lifepoints.");
        System.out.println();
    }

    public MonsterType getType() {
        return type;
    }



}