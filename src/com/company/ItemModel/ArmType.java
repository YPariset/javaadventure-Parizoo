package com.company.ItemModel;

    public enum ArmType {
        SWORD("Sword", "com.company.Arm attacks with 10 points per hit", 10),
        WATER_FLASK("Water_Flask", "Each flask thrown increases the damage by 2 points the damage of the current flask", 2),
        SORT_LIGHTNING("Sort_Lightning", "Attack with lightning: 10% chance to cripple hero for 1 turn", 10),
        ACE("ACE", "Attack with an axe in melee: 30% chance of critically striking twice as much damage", 10);

        private String name;
        private String description;
        private int attackPoints;

        ArmType(String name, String description, int attackPoints) {
            this.name = name;
            this.description = description;
            this.attackPoints = attackPoints;
        }



        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getAttackPoints() {
            return attackPoints;
        }



    }

