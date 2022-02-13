package com.superdevs;

/**
 * Class used to add all player classes as
 * objects to one object
 * for use in Tournaments*/
public class Contenders {

    private Player player;
    private RandomPlayer randomPlayer;
    private TimePlayer timePlayer;
    private VocalPlayer vocalPlayer;

    public Contenders(Player player, RandomPlayer randomPlayer, TimePlayer timePlayer, VocalPlayer vocalPlayer) {
        this.player = player;
        this.randomPlayer = randomPlayer;
        this.timePlayer = timePlayer;
        this.vocalPlayer = vocalPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public RandomPlayer getRandomPlayer() {
        return randomPlayer;
    }

    public TimePlayer getTimePlayer() {
        return timePlayer;
    }

    public VocalPlayer getVocalPlayer() {
        return vocalPlayer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRandomPlayer(RandomPlayer randomPlayer) {
        this.randomPlayer = randomPlayer;
    }

    public void setTimePlayer(TimePlayer timePlayer) {
        this.timePlayer = timePlayer;
    }

    public void setVocalPlayer(VocalPlayer vocalPlayer) {
        this.vocalPlayer = vocalPlayer;
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
