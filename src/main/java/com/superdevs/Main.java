package com.superdevs;


import java.io.IOException;
import java.sql.Array;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RandomPlayer randomCPU = new RandomPlayer("Random");
        TimePlayer timeCPU = new TimePlayer("Time");
        VocalPlayer vocalCPU = new VocalPlayer("Vocal");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange ditt användarnamn: ");
        String userName = scanner.nextLine();
        Player user = new Player(userName);
        //scanner.close();

        ArrayList<Object> playerList = new ArrayList<>();
        playerList.add(user);
        playerList.add(randomCPU);
        playerList.add(timeCPU);
        playerList.add(vocalCPU);



        myMenu(playerList);

    }

    public static void myMenu(ArrayList<Object> playerList){
        // Meny som körs via metoden menuChoice, som tar in en int och kör igång rätt val.
        int userChoice = 0;
        do{
            try{
                drawMenu(playerList);
                Scanner scanner = new Scanner(System.in);
                userChoice = Integer.parseInt(scanner.nextLine());
                menuChoice(userChoice, playerList);

            }catch(NumberFormatException e){
                System.out.println("Du angav något galet! Prova igen!");
            }

        }while(userChoice != 4);
    }

    /** Metod som skriver ut en meny till vår simulator
     * Tar in en instans av Player klassen */
    public static void drawMenu(ArrayList<Object> playerList) {
        //TODO clear screen before draw menu
        Player playerPlayer = (Player) playerList.get(0);
        System.out.println("\nVälkommen " + playerPlayer.getName() + " till RPS Sim 2k2" +
                "\n1. Spela ny turnering " +
                "\n2. Senaste resultatet " +
                "\n3. Resultat statistik " +
                "\n4. Avsluta " +
                "\n\nVar god ange ett val: [1 - 4] !");
    }

    /**
     * Choose options from menu
     * @param choice Integer for menu option
     * @param playerList Player object
     * */
    public static void menuChoice(int choice, ArrayList<Object> playerList) {
        Player playerPlayer = (Player) playerList.get(0);
        System.out.println("You chose menu option " + choice);
        pause(1500);
        // TODO lägga in korrekta metoder som skall köras
        switch (choice) {
            case 1 -> {
                System.out.println("1. Play new tournament");
                runTournament(playerList);
                waitForPress();
            }
            case 2 -> {
                System.out.println("2. Results");
                /////

                Tournament tour = new Tournament(playerPlayer);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
                System.out.println(
                        tour.getLocalDateTime().format(dateTimeFormatter)
                );
                tour.getActiveUserList().stream().filter(nameId -> Objects.equals(nameId.getNameId(), "RandomCPU")).forEach(x -> x.setResult(1));
                tour.getActiveUserList().stream().filter(nameId -> Objects.equals(nameId.getNameId(), "RandomCPU")).forEach(System.out::println);
                waitForPress();
                /////
            }
            case 3 -> {
                System.out.println("3. Statistics");
                //showStatistics();
                waitForPress();
            }
            case 4 -> {
                System.out.println("4. Quit Program");
                System.out.println("Exiting program...");
                pause(1500);
            }
            default -> {
                System.out.println("That doesnt correspond to any valid option. Please try again: ");
            }
        }
    }

    public static ArrayList<String> runTournament(ArrayList<Object> playerList) {

        ArrayList<String> gameResults = new ArrayList<>();

        Player user = (Player) playerList.get(0);

        Player random = (Player) playerList.get(1);

        Player time = (Player) playerList.get(2);

        Player vocals = (Player) playerList.get(3);


        gameResults.add(playSSP(user, random));
        pause(3000);
        gameResults.add(playSSP(time, vocals));
        pause(3000);
        gameResults.add(playSSP(user, time));
        pause(3000);
        gameResults.add(playSSP(random, vocals));
        pause(3000);
        gameResults.add(playSSP(user, vocals));
        pause(3000);
        gameResults.add(playSSP(time, random));
        pause(3000);


        return gameResults;
    }

    public static String playSSP(Player player1, Player player2) {

        player1.setPoints(0);
        player2.setPoints(0);

        while (player1.getPoints() < 2 && player2.getPoints() < 2) {

            boolean gameOver = false;

            while (!gameOver) {

                System.out.println("");
                String player1Move = player1.makeMove(player2);
                String player2Move = player2.makeMove(player1);

                if(player1Move.equals(player2Move)) {
                    pause(1500);
                    System.out.println("Round is a draw");
                    pause(3000);
                    System.out.println("");
                    player1Move = player1.randomMove(player1);
                    player2Move = player2.randomMove(player2);
                }

                if (!player1Move.equals(player2Move)) {
                    String winnerWinner = compareMoves(player1, player2, player1Move, player2Move);
                    if(winnerWinner.equals("player1")) {
                        player1.setPoints(player1.getPoints() + 1);
                    }
                    if(winnerWinner.equals("player2")) {
                        player2.setPoints(player2.getPoints() + 1);
                    }
                    gameOver = true;
                } else {
                    System.out.println("Round is a draw");
                    pause(3000);
                }
            }
        }

        if(player1.getPoints() > player2.getPoints()) {
            System.out.println("\n" + player1.getName() + " Wins!\n");
            return player1.getName();
        }
        if(player2.getPoints() > player1.getPoints()) {
            System.out.println("\n" + player2.getName() + " Wins!\n");
            return player2.getName();
        }

        return "";
    }

    public static String compareMoves(Player player1, Player player2, String player1Move, String player2Move) {

        if(player1Move.equals("Sten")) {
            if(player2Move.equals("Sax")) {
                pause(1500);
                System.out.println(player1.getName() + " wins the round");
                pause(3000);
                return "player1";
            }
            if(player2Move.equals("Påse")) {
                pause(1500);
                System.out.println(player2.getName() + " wins the round");
                pause(3000);
                return "player2";
            }
        }

        if(player1Move.equals("Sax")) {
            if(player2Move.equals("Sten")) {
                pause(1500);
                System.out.println(player2.getName() + " wins the round");
                pause(3000);
                return "player2";
            }
            if(player2Move.equals("Påse")) {
                pause(1500);
                System.out.println(player1.getName() + " wins the round");
                pause(3000);
                return "player1";
            }
        }

        if(player1Move.equals("Påse")) {
            if(player2Move.equals("Sten")) {
                pause(1500);
                System.out.println(player1.getName() + " wins the round");
                pause(3000);
                return "player1";
            }
            if(player2Move.equals("Sax")) {
                pause(1500);
                System.out.println(player2.getName() + " wins the round");
                pause(3000);
                return "player2";
            }
        }

        return "";
    }

    public static void pause(int milliseconds) {
        try {

            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // TODO Fixa input under tiden man väntar på tangentslag
    public static void waitForPress() {
        try {
            System.out.println("\nPress Enter to continue...");
            System.in.read();
            System.out.println("\n");

        } catch (IOException e){
        }
    }
}



