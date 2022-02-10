package com.superdevs;

import java.util.Scanner;

public class Player {
    String name;
    int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
                ", points=" + points +
                '}';
    }

}
