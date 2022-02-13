package com.superdevs;

import java.util.Scanner;

public class Player {
    private String name;
    private Ranking ranking;

    public Player(String name) {
        this.name = name;
        this.ranking = new Ranking();

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

    public Ranking getRanking() {
        return ranking;
    }

    public void setName(String name) {
        this.name = name;
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

                '}';
    }
}
