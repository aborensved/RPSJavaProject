package com.superdevs;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that stores Tournaments
 * for review later*/
public class Results{

    ArrayList<StoredTour> storedTourArrayList;

    public Results() {
        this.storedTourArrayList = new ArrayList<>();
    }

    public ArrayList<StoredTour> getStoredTour() {
        return this.storedTourArrayList;
    }

    public void addStoredTour(StoredTour storedTour) {
        this.storedTourArrayList.add(storedTour);
    }

    public void printAllScores(int index) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
        System.out.println( "Turneringen spelades " +
                storedTourArrayList.get(index).getLocalDateTime().format(dateTimeFormatter)
        );
        storedTourArrayList.get(index).getStoredUserList().forEach(System.out::println);
    }

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
