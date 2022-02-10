package com.superdevs;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


/** Class that stores StoredUser for
 * recording score, and keeps timestamp
 * of when this Tournament took place*/
public class StoredTour {

    private LocalDateTime localDateTime;
    private ArrayList<StoredUser> storedUserList;

    public StoredTour(Contenders contenderList) {

        StoredUser storedPlayer = new StoredUser(contenderList.getPlayer().getName(), 0);
        StoredUser storedRandom = new StoredUser(contenderList.getRandomPlayer().getName(), 0);
        StoredUser storedTime = new StoredUser(contenderList.getTimePlayer().getName(), 0);
        StoredUser storedVocal = new StoredUser(contenderList.getVocalPlayer().getName(), 0);

        this.localDateTime = LocalDateTime.now();
        this.storedUserList = new ArrayList<>();
        storedUserList.add(storedPlayer);
        storedUserList.add(storedRandom);
        storedUserList.add(storedTime);
        storedUserList.add(storedVocal);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Tournament played: " +
                localDateTime.format(dateTimeFormatter) +
                "\n Contenders: " + storedUserList +
                '.';
    }

    public String getTimeOfTour() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }

    public int getAvgPlacement (int index) {
        // Försöker skriva en sorteringsalgoritm som kan kallas via varje Tour som ger resultatet man söker för medelplacering.
        // Tänk om! getSum / getCount ger average antal vinster per turnering, inte faktisk placering. Så vi måste
        // Räkna om detta på något sätt.
        storedUserList.stream().sorted(Comparator.comparing(StoredUser::getResult).reversed());
        return storedUserList.get(index).getResult();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ArrayList<StoredUser> getStoredUserList() {
        return storedUserList;
    }

}
