package com.todoproject.model.entity;

public enum ItemStatus {
    EXECUTE(1, "EXECUTE"),
    CONTROL(2, "CONTROL"),
    LATER(3, "LATER");

    String name;
    int id;

    ItemStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameById(int id){
        switch (id) {
            case 1:
                return ItemStatus.EXECUTE.getName();
            case 2:
                return ItemStatus.CONTROL.getName();
            default:
                return ItemStatus.LATER.getName();
        }
    }
}
