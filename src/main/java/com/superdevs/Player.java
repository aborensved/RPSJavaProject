package com.superdevs;

import java.util.Scanner;

public class Player {
    String name;
    int matchesPlayed;
    int matchesWon;
    int matchPoints;
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int bestPlace;
    int bestPlaceCount;
    int worstPlace;
    int worstPlaceCount;

    public Player(String name) {
        this.name = name;
        this.matchesPlayed = 0;
        this.matchesWon = 0;
        this.matchPoints = 0;
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.bestPlace = 4;
        this.bestPlaceCount = 0;
        this.worstPlace = 0;
        this.worstPlaceCount = 0;
    }

    public String makeMove(Player user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                        "Välj Sten, Sax eller Påse: " +
                        "\n1) Sten" +
                        "\n2) Sax" +
                        "\n3) Påse"
        );
        String scannerChoice = scanner.nextLine();
        switch (scannerChoice) {
            case "1":
                System.out.println("You used: Sten");
                return "Sten";

            case "2":
                System.out.println("You used: Sax");
                return "Sax";

            case "3":
                System.out.println("You used: Påse");
                return "Påse";

            default:
                System.out.println("Oj något gick fel!");
                makeMove(user);
                break;
        }
        return "Intellisense ville ha en return";
    }

    public String randomMove(Player user) {
        return makeMove(user);
    }

    public String punchLine(){
        return "Punchline";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getBestPlace() {
        return bestPlace;
    }

    public int getBestPlaceCount() {
        return bestPlaceCount;
    }

    public int getWorstPlace() {
        return worstPlace;
    }

    public int getWorstPlaceCount() {
        return worstPlaceCount;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchPoints(int matchPoints) {
        this.matchPoints = matchPoints;
    }

    public void setFirstPlace(int firstPlace) {
        this.firstPlace = firstPlace;
    }

    public void setSecondPlace(int secondPlace) {
        this.secondPlace = secondPlace;
    }

    public void setThirdPlace(int thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public void setFourthPlace(int fourthPlace) {
        this.fourthPlace = fourthPlace;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setBestPlace(int bestPlace) {
        this.bestPlace = bestPlace;
    }

    public void setBestPlaceCount(int bestPlaceCount) {
        this.bestPlaceCount = bestPlaceCount;
    }

    public void setWorstPlace(int worstPlace) {
        this.worstPlace = worstPlace;
    }

    public void setWorstPlaceCount(int worstPlaceCount) {
        this.worstPlaceCount = worstPlaceCount;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public static void pause(int milliseconds) {
        try {

            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", matchesWon=" + matchesWon +
                ", matchPoints=" + matchPoints +
                ", firstPlace=" + firstPlace +
                ", secondPlace=" + secondPlace +
                ", thirdPlace=" + thirdPlace +
                ", fourthPlace=" + fourthPlace +
                ", bestPlace=" + bestPlace +
                ", bestPlaceCount=" + bestPlaceCount +
                ", worstPlace=" + worstPlace +
                ", worstPlaceCount=" + worstPlaceCount +
                '}';
    }
}
