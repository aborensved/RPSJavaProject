package com.superdevs;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


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
        return "Tournament played: " +
                getTimeOfTour() +
                "\n Contenders: " + storedUserList +
                '.';
    }

    public String getTimeOfTour() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ArrayList<StoredUser> getStoredUserList() {
        return storedUserList;
    }

}
