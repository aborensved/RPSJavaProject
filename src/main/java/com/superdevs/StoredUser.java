package com.superdevs;


/**
 * Class that stores name
 * and score of a given Tournament.*/
public class StoredUser{

    String name;
    int result;
    Ranking storedRanking;

    int matchesPlayed;
    int matchesWon;
    int matchPoints;
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int bestPlace;
    int bestPlaceCount;
    int worstPlace;
    int worstPlaceCount;

    public StoredUser(String name, int result, Ranking storedRanking) {
        this.name = name;
        this.result = result;
        this.storedRanking = storedRanking;
    }

    /*
        public StoredUser(String name,
                          int result,
                          Ranking storedRanking) {
            this.name = name;
            this.result = result;

        }
        */
    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public Ranking getStoredRanking() {
        return storedRanking;
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
