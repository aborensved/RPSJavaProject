package com.superdevs;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Tournament1 {

    private LocalDateTime localDateTime;
    long date;

    public Tournament1() {
        this.localDateTime = LocalDateTime.now();
    }

    // Takes date, list of players and all the winners from the SSP-Games to make a result list
    public static StoredTour results(Contenders contenderList, ArrayList<String> gameResults) {

        ArrayList<String> gameResults2 = gameResults;

        /*Player user = (Player) contenderList.getPlayer();
        user.setPoints(0);

        Player random = (Player) contenderList.getRandomPlayer();
        random.setPoints(0);

        Player time = (Player) contenderList.getTimePlayer();
        time.setPoints(0);

        Player vocals = (Player) contenderList.getVocalPlayer();
        vocals.setPoints(0);

        for(int i = 0; i < gameResults.size(); i++) {
            if(gameResults.get(i).equals(user.getName())) {
                user.setPoints(user.getPoints() + 1);
            }
            if(gameResults.get(i).equals(random.getName())) {
                random.setPoints(random.getPoints() + 1);
            }
            if(gameResults.get(i).equals(time.getName())) {
                time.setPoints(time.getPoints() + 1);
            }
            if(gameResults.get(i).equals(vocals.getName())) {
                vocals.setPoints(vocals.getPoints() + 1);
            }
        }*/

        StoredTour storeTour = new StoredTour(contenderList);
        storeResult(gameResults2,storeTour, 0);
        storeResult(gameResults2,storeTour, 1);
        storeResult(gameResults2,storeTour, 2);
        storeResult(gameResults2,storeTour, 3);

/*        gameResults = new ArrayList<>();
        gameResults.add(date);
        gameResults.add(user.getName() + " " + user.getPoints());
        gameResults.add(random.getName() + " " + random.getPoints());
        gameResults.add(time.getName() + " " + time.getPoints());
        gameResults.add(vocals.getName() + " " + vocals.getPoints());*/

        return storeTour;
    }

    public static void storeResult(ArrayList<String> gameResults, StoredTour storeTour, int index){
        for(int i = 0; i < gameResults.size(); i++) {
            if(gameResults.get(i).equals(storeTour.getStoredUserList().get(index).getName())) {
                storeTour.getStoredUserList()
                        .get(index).setResult(storeTour
                                .getStoredUserList()
                                .get(index)
                                .getResult() + 1);
            }
        }
    }

    //Takes 2 players to play a game of SSP
    public static String playSSP(Player player1, Player player2) {

        System.out.println(player1.getName() + " vs " + player2.getName());

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
            System.out.println("\n" + player1.getName() + " Wins! " + player1.getPoints() + " vs " + player2.getPoints() + "\n");
            return player1.getName();
        }
        if(player2.getPoints() > player1.getPoints()) {
            System.out.println("\n" + player2.getName() + " Wins! " + player2.getPoints() + " vs " + player1.getPoints() + "\n");
            return player2.getName();
        }

        return "";
    }

    // Method that compares the moves made in the SSP-Game to see who wins the round
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

    // Method to pause program x milliseconds
    public static void pause(int milliseconds) {
        try {

            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Format Date
    public String formatDate(long date) {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss");
        return dateTimeFormatter.format(date);
    }

    public String getDate() {
        return formatDate(date);
    }

    @Override
    public String toString() {
        return "Tournament1{" +
                "date=" + date +
                '}';
    }
}
