package com.superdevs;


import java.time.LocalDateTime;

import java.util.ArrayList;



public class Tournament {

    private LocalDateTime localDateTime;
    private ArrayList<ActiveUserInTour> activeUserList;

    public Tournament(Player humanUser) {

        ActiveUserInTour tourPlayer = new ActiveUserInTour(humanUser.getName(), 0);
        ActiveUserInTour tourRandomCPU = new ActiveUserInTour("RandomCPU", 0);
        ActiveUserInTour tourTimeCPU = new ActiveUserInTour("TimeCPU", 0);
        ActiveUserInTour tourVocalCPU = new ActiveUserInTour("VocalCPU", 0);

        this.localDateTime = LocalDateTime.now();
        this.activeUserList = new ArrayList<ActiveUserInTour>();
        activeUserList.add(tourPlayer);
        activeUserList.add(tourRandomCPU);
        activeUserList.add(tourTimeCPU);
        activeUserList.add(tourVocalCPU);

    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ArrayList<ActiveUserInTour> getActiveUserList() {
        return activeUserList;
    }

}
