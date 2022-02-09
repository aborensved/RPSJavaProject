package com.superdevs;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/** Class that stores ActiveUserInTour for
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return "Tournament played: " +
                localDateTime.format(dateTimeFormatter) +
                "\n Contenders: " + storedUserList +
                '.';
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ArrayList<StoredUser> getStoredUserList() {
        return storedUserList;
    }
}
