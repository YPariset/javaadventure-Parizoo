package com.company.Environment;

import com.company.ItemModel.Item;
import com.company.Character.Monster;

public class NormalRoom extends Room {

    public NormalRoom(int id, Monster m) {
        super(id, m);
        this.name = "Normal";
        this.tresor = null;
    }

    public NormalRoom(int id, Item tresor) {
        super(id);
        this.name = "Normal";
        this.tresor = tresor;
    }


}
