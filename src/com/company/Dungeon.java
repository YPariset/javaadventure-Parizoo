package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dungeon {

    private boolean hasExit;
    private Map<Integer, Room> dungeonMap;
    private Hero hero;
    private int totalRooms;

    public Dungeon() {
        this.dungeonMap = new HashMap<Integer, Room>();
    }

    public Dungeon(Map<Integer, Room> dungeonMap, int totalRooms) {
        this.dungeonMap = dungeonMap;
        this.totalRooms = totalRooms;
    }

    /**
     * This function is called to know if the game is finished
     *
     * @return true if the is finished
     */
    public boolean gameIsFinished() {
        return gameIsLost() || gameIsWon();
    }

    /**
     * This function is called to know if the game is lost
     *
     * @return true if the is lost
     */
    public boolean gameIsLost() {
        if (hero.getLifePoints() <= 0) {
            System.out.println("You are dead! GAME OVER");
            return true;
        }
        return false;
    }

    /**
     * This function is called to know if the game is won
     *
     * @return true if the is won
     */
    public boolean gameIsWon() {
        return this.hero.getCurrentRoom().getName().equals("Exit");
    }

    /**
     * This function is called to show the map of the dungeon
     */
    public void showMap() {
        System.out.println();
        for (Map.Entry<Integer, Room> e : dungeonMap.entrySet()) {
            Room r = e.getValue();
            System.out.println("Room :" + r.getId() + " : It's a " + r.getName() + " room!");
            if (r.getMonster() != null) {
                System.out.println("And there is a " + r.getMonster().getType() + " at the front of you");
            }
            if (r.getTresor() != null) {
                System.out.println("And the room has a " + r.getTresor().getName());
            }
            break;
        }
        System.out.println();
    }

    public void setPlayer(Hero hero) {
        this.hero = hero;
    }

    public boolean isHasExit() {
        return hasExit;
    }

    public Map<Integer, Room> getDungeonMap() {
        return dungeonMap;
    }

    public Hero getHero() {
        return hero;
    }

    public int getTotalRooms() {
        return totalRooms;
    }
}
