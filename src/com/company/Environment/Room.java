package com.company.Environment;

import com.company.ItemModel.Item;
import com.company.Character.Monster;

import java.util.HashMap;
import java.util.Map;

public class Room {
    protected String name;
    protected int id;
    protected String description;
    protected Monster monster;
    protected boolean roomExist;
    protected Map<Integer, Room> doors = new HashMap<Integer, Room>();
    protected boolean locked;
    public Item tresor;

    public Room(int id) {
        this.id = id;
        this.description = "This is the Room " + id;
    }

    public Room(int id, Monster monster) {
        this.id = id;
        this.monster = monster;
    }

    /**
     * This function is called to show the doors in the Room
     */

    public void showNeighbours() {
        System.out.print("This door will lead to rooms : ");
        for (Map.Entry<Integer, Room> e : doors.entrySet())
            System.out.print(e.getKey() + ", ");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, Room> getDoors() {
        return doors;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Item getTresor() {
        return tresor;
    }

    public void setTresor(Item tresor) {
        this.tresor = tresor;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isRoomExist() {
        return roomExist;
    }

    public void setRoomExist(boolean roomExist) {
        this.roomExist = roomExist;
    }


}
