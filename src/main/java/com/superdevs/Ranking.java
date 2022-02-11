package com.superdevs;

public class Ranking {

    private int matchesPlayed;
    private int matchesWon;
    private int matchPoints;
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int bestPlace;
    private int bestPlaceCount;
    private int worstPlace;
    private int worstPlaceCount;

    public Ranking() {
        this.matchesPlayed = 0;
        this.matchesWon = 0;
        this.matchPoints = 0;
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.bestPlace = 4;
        this.bestPlaceCount = 0;
        this.worstPlace = 0;
        this.worstPlaceCount = 0;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getBestPlace() {
        return bestPlace;
    }

    public int getBestPlaceCount() {
        return bestPlaceCount;
    }

    public int getWorstPlace() {
        return worstPlace;
    }

    public int getWorstPlaceCount() {
        return worstPlaceCount;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public void setMatchPoints(int matchPoints) {
        this.matchPoints = matchPoints;
    }

    public void setFirstPlace(int firstPlace) {
        this.firstPlace = firstPlace;
    }

    public void setSecondPlace(int secondPlace) {
        this.secondPlace = secondPlace;
    }

    public void setThirdPlace(int thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public void setFourthPlace(int fourthPlace) {
        this.fourthPlace = fourthPlace;
    }

    public void setBestPlace(int bestPlace) {
        this.bestPlace = bestPlace;
    }

    public void setBestPlaceCount(int bestPlaceCount) {
        this.bestPlaceCount = bestPlaceCount;
    }

    public void setWorstPlace(int worstPlace) {
        this.worstPlace = worstPlace;
    }

    public void setWorstPlaceCount(int worstPlaceCount) {
        this.worstPlaceCount = worstPlaceCount;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "matchesPlayed=" + matchesPlayed +
                "\n matchesWon=" + matchesWon +
                "\n matchPoints=" + matchPoints +
                "\n firstPlace=" + firstPlace +
                "\n secondPlace=" + secondPlace +
                "\n thirdPlace=" + thirdPlace +
                "\n fourthPlace=" + fourthPlace +
                "\n bestPlace=" + bestPlace +
                "\n bestPlaceCount=" + bestPlaceCount +
                "\n worstPlace=" + worstPlace +
                "\n worstPlaceCount=" + worstPlaceCount +
                '}';
    }
}
