package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hero extends Character implements Fighter {
    protected String name;
    protected Room currentRoom;
    protected List<Item> bag;
    protected ArmType arm;


    public Hero(String name, Room currentRoom, ArmType arm, ArmType arm2) {
        super(100, ArmType.SWORD.getAttackPoints());
        this.name = name;
        this.currentRoom = currentRoom;
        this.bag = new ArrayList<Item>();
        this.arm = arm;
        this.arm = arm2;

    }

    /**
     * This function is called when the player enters in a room
     *
     * @throws InterruptedException
     */
    public void enterInRoom() throws InterruptedException {
        System.out.println("You are currently in the Room " + this.currentRoom.getId());
        if (this.currentRoom.getMonster()!= null && this.currentRoom.getMonster().isAlive()) {
            System.out.println("Oh ! There is a monster in the room !");
        }

        this.currentRoom.showNeighbours();
    }

    /**
     * This function is called when the player wants to change room and verify if the door is not locked
     *
     * @param direction
     */
    public void	changeRoom(String[] direction) {
        if (direction.length != 2) {
            System.out.println("You cannot go there !");
            System.out.println("----------------------\n");
            return;
        }
        try {
            for (Map.Entry<Integer, Room> e : this.currentRoom.getDoors().entrySet()) {
                if (Integer.parseInt(direction[1]) == e.getKey())
                {
                    if(!e.getValue().isLocked()) {
                        this.currentRoom = e.getValue();
                        return;
                    } else {
                        System.out.println("The door is locked");
                    }
                }
            }

        }
        catch (NumberFormatException e) {
            System.out.println("You must put a number!");
        }
        System.out.println("You cannot go there !");
        System.out.println("----------------------\n");
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Item> getBag() {
        return bag;
    }

    public void setBag(List<Item> bag) {
        this.bag = bag;
    }


    /**
     * This function is called when the player wants to describe his current room
     */
    public void describeCurrentRoom() {
        System.out.println("Description of the current room :");
        System.out.println(this.currentRoom.getDescription());
        System.out.println();
    }

    /**
     * This function is called when the user wants to show the help menu of the game
     */
    public void showHelpMenu() {
        System.out.println("describe : To show the description of the current room.");
        System.out.println("go <idRoom> : To navigate in another room.");
        System.out.println("help : Here you are.");
        System.out.println("hit : To hit the monster in the current room.");
        System.out.println("quit : To quit the game.");
        System.out.println("situation : To show the life point and the bag of the player.");
        System.out.println("take : To take the tresor  of the last room.");
        System.out.println();
    }

    /**
     * This function is called to launch a new Fight against a Monster
     *
     * @throws InterruptedException
     */
    public void fightMonster() throws InterruptedException{
        if (this.currentRoom.getMonster()!= null) {
            new Fight(this.currentRoom.getMonster(),this).goFight();
        }
    }

    public void takeItem() {
        if(this.currentRoom.getTresor() != null) {
            this.bag.add(this.currentRoom.tresor);
            System.out.println("Congratulations You found the " + this.currentRoom.getTresor().getName() + ", :)\n");
            System.out.println("You're the master of donjon !");
            this.currentRoom.setTresor(null);
        } else {
            System.out.println("There's no item in this room.\n");
        }
    }

    /*
    int count = 0;

    public void flaskBonus() {
        for (int i = 2; i < 10; i += 2) {
            count += i;;
            System.out.println(count);
        }
    }*/             ////Voir avec DOM



    /**
     * The function is called when the player wants to hit a Monster in a Room
     *
     * @throws InterruptedException
     */
    public void hit() throws InterruptedException {
        if (this.currentRoom.getMonster() != null) {
            try {
                int idArm = Integer.parseInt(new CommandPrompt().chooseArm(bag));

                if(idArm == 0) {
                    this.attackPoints = 10;
                    new Fight(this.currentRoom.getMonster(), this).goFight();
                } else if(idArm == 1) {
                    this.attackPoints = 2;
                    new Fight(this.currentRoom.getMonster(), this).goFight();
                } else if(idArm < this.bag.size()+1 && idArm > 0) {
                    try {
                        Arm arm = (Arm) this.bag.get(idArm-1);
                        this.attackPoints = arm.getAttackPoints();
                        new Fight(this.currentRoom.getMonster(), this).goFight();
                    } catch (ClassCastException e) {
                        System.out.println("\nYou have to choose a number in the following list\n");
                    }
                } else {
                    System.out.println("\nIt's not possible to choose that !\n");
                }
            } catch(NumberFormatException e) {
                System.out.println("\nYou must put a number\n");
            }
        } else {
            System.out.println("There's no monster in this room.");
        }
    }

    /**
     * attack is the function to attack an other Character
     *
     * @param c the Character to attack
     */
    @Override
    public void attack(Character c) {
        System.out.println("------------------\n");
        System.out.println(this.name + " attack the monster with " + this.arm);
        c.setLifePoints(c.getLifePoints() - this.attackPoints);
        System.out.println("Now, the monster has " + c.getLifePoints() + " lifepoints.");
        System.out.println();
    }

    /**
     * This function is redefined to describe a Player with his lifePoints, attackPoints and his bag
     */
    public String toString() {
        String situation = "";
        situation += this.name + " has got " + this.lifePoints + " lifePoints and " + this.attackPoints + " attackPoints.\n";
        situation += "He has in his bag :\n\n";
        int idItem = 0;
        for (Item i: this.bag) {
            if (i.getName().equals("Arm")) {
                Arm arm = (Arm) i;
                situation += idItem + " -> " +  arm.getName() + " (AttackPoints: " + arm.getAttackPoints() + ")\n";
                idItem++;
            }
        }
        return situation;
    }


}