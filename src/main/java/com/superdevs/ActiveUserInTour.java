package com.superdevs;


/**
 * Class that stores name
 * and score of a given Tournament.*/
public class ActiveUserInTour {

    String nameId;
    int result;

    public ActiveUserInTour(String nameId, int result) {
        this.nameId = nameId;
        this.result = result;
    }

    public String getNameId() {
        return nameId;
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
                "'" + nameId + '\'' +
                " no of wins = " + result +
                ' ';
    }

}
