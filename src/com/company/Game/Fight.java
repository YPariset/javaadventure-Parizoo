package com.company.Game;

import com.company.Character.Hero;
import com.company.Character.Monster;

public class Fight {
    protected Monster monster;
    protected Hero hero;

    public Fight(Monster monster, Hero hero) {
        this.monster = monster;
        this.hero = hero;
    }

    /**
     * goFight is the function called to start a fight between the Monster and the Player
     *
     * @throws InterruptedException
     */
    public void goFight() throws InterruptedException {
        while (this.monster.isAlive() && this.hero.isAlive()) {
            Thread.sleep(400);
            this.hero.attack(this.monster);
            if (this.monster.isAlive()) {
                Thread.sleep(400);
                this.monster.attack(this.hero);
            }
        }
        if (this.hero.isAlive() & !this.monster.isAlive()) {
            System.out.println("\nCongratulations ! You beat the monster and win \n");

        }
        if (!this.hero.isAlive() & this.monster.isAlive()) {
            System.out.println("\nOh no ! The monster has just killed you...\n");
        }
    }

}
