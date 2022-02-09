package com.superdevs;


/**
 * Class that stores name
 * and score of a given Tournament.*/
public class StoredUser {

    String name;
    int result;

    public StoredUser(String nameId, int result) {
        this.name = nameId;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "" +
                "'" + name + '\'' +
                " no of wins = " + result +
                ' ';
    }

}
