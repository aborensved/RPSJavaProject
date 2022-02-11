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

    // TODO Remove before final version. Debugging use only
    public void setTournamentStats(int placement) {
        this.storedRanking.setMatchesPlayed(storedRanking.getMatchesPlayed()+3);
        //matchesWon=1
        this.storedRanking.setMatchesWon(storedRanking.getMatchesWon()+1);
        //matchPoints=1

        if (placement == 1){
            //firstPlace=1
            this.storedRanking.setFirstPlace(storedRanking.getFirstPlace()+1);
        }
        if (placement == 2) {
            //secondPlace=0
            this.storedRanking.setSecondPlace(storedRanking.getSecondPlace()+1);
        }
        if (placement == 3) {
            //thirdPlace=1
            this.storedRanking.setThirdPlace(storedRanking.getThirdPlace()+1);
        }
        if (placement == 4) {
            //fourthPlace=0
            this.storedRanking.setFourthPlace(storedRanking.getFourthPlace()+1);
        }
        //bestPlace=1

        this.storedRanking.setBestPlace(1);
        //bestPlaceCount=1
        //worstPlace=3
        this.storedRanking.setWorstPlace(4);
        //worstPlaceCount=1}
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
