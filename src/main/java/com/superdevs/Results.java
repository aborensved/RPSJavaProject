package com.superdevs;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Class that stores Tournaments
 * for review later*/
public class Results {

    ArrayList<Tournament> tournamentArrayList;

    public Results() {
        this.tournamentArrayList = new ArrayList<>();
    }

    public ArrayList<Tournament> getTournament() {
        return this.tournamentArrayList;
    }

    public void addTournament(Tournament tournament) {
        this.tournamentArrayList.add(tournament);
    }

    public void printAllScores(int index) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
        System.out.println( "Turneringen spelades " +
                tournamentArrayList.get(index).getLocalDateTime().format(dateTimeFormatter)
        );
        tournamentArrayList.get(index).getActiveUserList().forEach(System.out::println);
    }


}
