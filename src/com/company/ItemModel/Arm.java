package com.company.ItemModel;

import com.company.Character.MonsterType;

import java.util.Random;

public class Arm extends Item {

        protected ArmType type;
        protected int attackPoints;

        public Arm(ArmType type) {
            super(type.getName(), type.getDescription());
            this.attackPoints = type.getAttackPoints();
        }

        public int getAttackPoints() {
            return attackPoints;
        }

    private static final ArmType[] VALUES = ArmType.values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static ArmType getRandomArmType()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    }


