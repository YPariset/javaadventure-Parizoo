package com.company.Character;

import com.company.ItemModel.ArmType;

import java.util.Random;

public class Monster extends Character implements Fighter {

    MonsterType type;

    public Monster(MonsterType type) {
        super(type.getLifePoints(), type.getAttackPoints());
        this.type = type;
    }

    private static final MonsterType[] VALUES = MonsterType.values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static MonsterType getRandomMonster()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    /**
     * attack is the function to attack an other com.company.Character.Character
     *
     * @param c the com.company.Character.Character to attack
     */
    @Override
    public void attack(Character c) {
        System.out.println("------------------\n");
        System.out.println("The monster " + this.type + " attack the player with " + this.type.getNameOfArm());
        c.setLifePoints(c.getLifePoints() - this.attackPoints);
        System.out.println("Now, the player has " + c.getLifePoints() + " lifepoints.");
        System.out.println();
    }

    public MonsterType getType() {
        return type;
    }



}