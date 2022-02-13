package com.superdevs;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class that stores Tournaments
 * for review later*/
public class Results{

    private ArrayList<StoredTour> storedTourArrayList;

    public Results() {
        this.storedTourArrayList = new ArrayList<>();
    }

    public ArrayList<StoredTour> getStoredTour() {
        return this.storedTourArrayList;
    }

    public void addStoredTour(StoredTour storedTour) {
        this.storedTourArrayList.add(storedTour);
    }


    // Time to remove? Deprecated
    public void printAllScores(int index) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
        System.out.println( "Turneringen spelades " +
                storedTourArrayList.get(index).getLocalDateTime().format(dateTimeFormatter)
        );
        storedTourArrayList.get(index).getStoredUserList().forEach(System.out::println);
    }

    // Deprecated method that prints out placement in a tournament.
    public void getPlacement (int tourNumber) {
        storedTourArrayList
                .get(tourNumber).
                getStoredUserList()
                .stream()
                .sorted(Comparator
                        .comparing(StoredUser::getResult).reversed())
                .forEach(x -> System.out.println(x.getName()));

        //TODO Collectors.counting() se 3.2
    }
}
