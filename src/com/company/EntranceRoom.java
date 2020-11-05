package com.company;

public class EntranceRoom extends Room {
    public EntranceRoom(int id) {
        super(id);
        this.name = "Entrance";
    }

    public EntranceRoom(int id, Monster monster) {
        super(id);
        this.name = "Entrance";

    }
}
