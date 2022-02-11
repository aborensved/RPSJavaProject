package com.superdevs;

public class TourneyResults {

    private String name;
    private int matchPoints;

    public TourneyResults(String name, int matchPoints) {
        this.name = name;
        this.matchPoints = matchPoints;
    }

    public String getName() {
        return name;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMatchPoints(int matchPoints) {
        this.matchPoints = matchPoints;
    }

    @Override
    public String toString() {
        return "TourneyResults{" +
                "name='" + name + '\'' +
                ", matchPoints=" + matchPoints +
                '}';
    }
}


