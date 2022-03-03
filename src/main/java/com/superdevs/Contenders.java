package com.superdevs;

/**
 * Class used to add all player classes as
 * objects to one object
 * for use in Tournaments*/
public class Contenders {

    private Player player;
    private Player randomPlayer;
    private Player timePlayer;
    private Player vocalPlayer;

    public Contenders(Player player, Player randomPlayer, Player timePlayer, Player vocalPlayer) {
        this.player = player;
        this.randomPlayer = randomPlayer;
        this.timePlayer = timePlayer;
        this.vocalPlayer = vocalPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getRandomPlayer() {
        return randomPlayer;
    }

    public Player getTimePlayer() {
        return timePlayer;
    }

    public Player getVocalPlayer() {
        return vocalPlayer;
    }

    @Override
    public String toString() {
        return "Contenders{" +
                "player=" + player +
                ", randomPlayer=" + randomPlayer +
                ", timePlayer=" + timePlayer +
                ", vocalPlayer=" + vocalPlayer +
                '}';
    }


}
