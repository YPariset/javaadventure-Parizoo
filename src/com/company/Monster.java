package com.company;

public class Monster extends Character implements Fighter {

    MonsterType type;

    public Monster(MonsterType type) {
        super(type.getLifePoints(), type.getAttackPoints(), type.getArm());
        this.type = type;
    }

    /**
     * attack is the function to attack an other Character
     *
     * @param c the Character to attack
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