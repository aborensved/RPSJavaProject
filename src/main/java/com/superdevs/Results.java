package com.superdevs;

import java.util.ArrayList;

/**
 * Class that stores Tournaments
 * for review later*/
public class Results {

    ArrayList<Tournament> tournamentArrayList;

    public Results() {
        this.tournamentArrayList = new ArrayList<Tournament>();
    }

    public ArrayList<Tournament> getTournament() {
        return this.tournamentArrayList;
    }

    public void addTournament(Tournament tournament) {
        this.tournamentArrayList.add(tournament);
    }

    public void showRecentResults(){
        System.out.println("Recent results.....");
    }

}
