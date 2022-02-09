package com.superdevs;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/** Class that stores ActiveUserInTour for
 * recording score, and keeps timestamp
 * of when this Tournament took place*/
public class Tournament {

    private LocalDateTime localDateTime;
    private ArrayList<ActiveUserInTour> activeUserList;

    public Tournament(Contenders contenderList) {

        ActiveUserInTour tourPlayer = new ActiveUserInTour(contenderList.getPlayer().getName(), 0);
        ActiveUserInTour tourRandomCPU = new ActiveUserInTour(contenderList.getRandomPlayer().getName(), 0);
        ActiveUserInTour tourTimeCPU = new ActiveUserInTour(contenderList.getTimePlayer().getName(), 0);
        ActiveUserInTour tourVocalCPU = new ActiveUserInTour(contenderList.getVocalPlayer().getName(), 0);

        this.localDateTime = LocalDateTime.now();
        this.activeUserList = new ArrayList<ActiveUserInTour>();
        activeUserList.add(tourPlayer);
        activeUserList.add(tourRandomCPU);
        activeUserList.add(tourTimeCPU);
        activeUserList.add(tourVocalCPU);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
        return "Last Tournament played: " +
                "" + localDateTime.format(dateTimeFormatter) +
                "\n Contenders: " + activeUserList +
                '.';
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ArrayList<ActiveUserInTour> getActiveUserList() {
        return activeUserList;
    }



}
