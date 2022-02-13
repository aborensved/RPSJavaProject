package com.superdevs;


/**
 * Class that stores name
 * and score of a given Tournament.*/
public class StoredUser{

    String name;
    int result;
    Ranking storedRanking;

    public StoredUser(String name, int result, Ranking storedRanking) {
        this.name = name;
        this.result = result;
        this.storedRanking = storedRanking;
    }

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

    public double getCombinedScore() {
        double result = (this.storedRanking.getFirstPlace() +
                (this.storedRanking.getSecondPlace()*2) +
                (this.storedRanking.getThirdPlace()*3) +
                (this.storedRanking.getFourthPlace()*4));
                double matches = this.getStoredRanking().getMatchesPlayed();
                return (result / (matches/3));
    }

    @Override
    public String toString() {
        return  "'" + name + '\'' +
                " Avg placement = " +
                ((storedRanking.getFirstPlace() +
                        storedRanking.getSecondPlace() +
                        storedRanking.getThirdPlace() +
                        storedRanking.getFourthPlace()) /
                        (storedRanking.getMatchesPlayed()/3)) +
                ' ';
    }

}
