package com.company.Game;

import com.company.Character.Hero;
import com.company.Character.Monster;
import com.company.Character.MonsterType;

import java.util.Random;

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
            System.out.println("\nCongratulations ! You already beat the monster and win \n");

        }
        if (!this.hero.isAlive() & this.monster.isAlive()) {
            System.out.println("\nOh no ! The monster has just killed you...\n");
        }

           /* if (this.monster.equals(MonsterType.BARBARIAN)) {
                Random random = new Random();
                int choice = random.nextInt( 100 );
                System.out.println( this.monster + " is hitting you with an axe" );
                if (choice <= 30)
                    System.out.println( "...Critical hit!!! you have been damage twice" );
            } else if (this.monster.equals( MonsterType.SORCERER)) {
                Random random = new Random();
                int choice = random.nextInt( 100 );
                System.out.println( this.monster + " launching a strike of a lightning" );
                if (choice <= 10)
                    System.out.println( "...you have been paralyze" );
            }*/

        }
    }

