package com.company.Game;

import com.company.Game.CommandPrompt;
import com.company.ItemModel.ArmType;
import com.company.Character.Hero;
import com.company.Environment.Dungeon;
import com.company.Environment.DungeonDisplay;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DungeonDisplay generator;
        CommandPrompt commandPrompt = new CommandPrompt();
        Dungeon dungeon;

        System.out.println("----------------------------------");
        System.out.println("\n WELCOME TO THE DUNGEON MASTER");
        System.out.println("     Created by Parizoo \n");
        System.out.println("              ☠️ \n");

        generator = new DungeonDisplay();
        generator.createClassicMap(1);

        dungeon = new Dungeon(generator.getMap(), generator.getIdMax());
        dungeon.setPlayer(commandPrompt.createHero(dungeon.getDungeonMap().get(0), ArmType.SWORD, ArmType.WATER_FLASK));

        System.out.println("\nHey here we go ! For the moment this game has only one level with 5 rooms to discover!");
        System.out.println("Be careful of the sorcerer and barbarians and don't hesitate to go all the way, you might get a surprise !\n");


        do {
            dungeon.getHero().enterInRoom();
            if (dungeon.getHero().isAlive()) {
                commandPrompt.interpretCommand(dungeon.getHero());
            }

            if (dungeon.gameIsWon()) {
                System.out.println("\nYou found the exit to the next level !\n");
                Hero savePlayer = dungeon.getHero();
                generator = new DungeonDisplay();
                generator.createRandomMap();
                dungeon = new Dungeon(generator.getMap(), generator.getIdMax());
                savePlayer.setCurrentRoom(dungeon.getDungeonMap().get(5));

                dungeon.setPlayer(savePlayer);
                dungeon.showMap();
            }
        } while (!dungeon.gameIsFinished());

        if (dungeon.gameIsWon()) {
            System.out.println("You found the exit ! You win!");
        }

    }
}



