package com.company.Game;

import com.company.ItemModel.Arm;
import com.company.ItemModel.ArmType;
import com.company.Character.Hero;
import com.company.Environment.Room;
import com.company.ItemModel.Item;

import java.util.List;
import java.util.Scanner;

public class CommandPrompt {
    protected Scanner sc;

    public CommandPrompt() {
        this.sc = new Scanner(System.in);
    }

    /**
     * This function is called when the user chose an arm before a fight
     *
     * @param bag the item's list of the player
     * @return answer
     */
    public String chooseArm(List<Item> bag) {

        System.out.println("Which arm do you want for this fight ?\n");
        int compteur = 0;
        System.out.println(compteur + " -> Sword (attackPoints: 10)");
        compteur++;
        System.out.println(compteur + " -> Water_Flask (attackPoints: n(n+2))");
        for(Item i: bag) {
            if (i.getName().equals("Sword") || i.getName().equals("Water_Flask")) {
                Arm arm = (Arm) i;
                System.out.println(compteur + " -> " + arm.getName() + " (attackPoints: " + arm.getAttackPoints() + ")");
            }
            compteur++;
        }
        System.out.print("> ");
        String answer = sc.nextLine();
        return answer;
    }

    /**
     * This function is called when the program create a player for a new game
     *
     * @param currentRoom
     * @param arm
     * @param arm2
     * @return a new Player
     */
    public Hero createHero(Room currentRoom, ArmType arm, ArmType arm2) {
        System.out.println("----------------------------------\n");
        System.out.println("What is your name ?");
        System.out.print("> ");
        String name = sc.nextLine();
        return new Hero(name, currentRoom, arm, arm2);
    }


    /**
     * This function is used to interpret all the commands of the user
     *
     * @param hero
     * @throws InterruptedException
     */
    public void interpretCommand(Hero hero) throws InterruptedException {
        System.out.println("------------------------------");
        System.out.println("   What do you want to do ?  ");
        System.out.println("------------------------------\n\n");
        hero.showHelpMenu();
        System.out.print("> ");
        String command = sc.nextLine();
        System.out.println("----------------------------------------\n");

        if (command.length() == 0) {
            System.out.println("You can put 'go *number of the door' or 'search'");
            return;
        }

        String[] commandSplitted = command.split(" ");

        switch (commandSplitted[0]){
            case "go":
                if (hero.getCurrentRoom().getMonster() != null && hero.getCurrentRoom().getMonster().isAlive()) {
                    System.out.println("There is a monster in the room, You can't leave this room");
                } else {
                    hero.changeRoom(commandSplitted);
                }
                break;
            case "describe":
                hero.describeCurrentRoom();
                break;
            case "help":
                hero.showHelpMenu();
                break;
            case "hit" :
                hero.hit();
                break;
            case "situation":
                System.out.println(hero);
                break;
            case "take":
                hero.takeItem();
                break;
            case "quit":
                System.out.println("You quit the game");
                System.exit(0);
            default:
                System.out.println("I don’t know what you mean\n");
                break;
        }
    }
}
