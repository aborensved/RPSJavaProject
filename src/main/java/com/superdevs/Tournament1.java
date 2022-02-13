package com.superdevs;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class Tournament1 {

    private LocalDateTime localDateTime;
    long date;

    public Tournament1() {
        this.localDateTime = LocalDateTime.now();
    }

    // Takes date, list of players and all the winners from the SSP-Games to make a result list
    // Takes List of players (Contender class), and results
    // from tournament and exports the list with updated scores.
    public static StoredTour results(Contenders contenderList, ArrayList<String> gameResults) {

        StoredTour storeTour = new StoredTour(contenderList);
        storeResult(gameResults,storeTour, 0);
        storeResult(gameResults,storeTour, 1);
        storeResult(gameResults,storeTour, 2);
        storeResult(gameResults,storeTour, 3);


        // Store this tournament results in a String for later viewing. This does not store individual scores.
        String matchFinalResult = "";

        matchFinalResult = matchFinalResult
                .concat(nameAndResultToString(contenderList.getPlayer(), gameResults))
                .concat(nameAndResultToString(contenderList.getRandomPlayer(), gameResults))
                .concat(nameAndResultToString(contenderList.getTimePlayer(), gameResults))
                .concat(nameAndResultToString(contenderList.getVocalPlayer(), gameResults));

        storeTour.setStoredMatchResult(matchFinalResult);

        return storeTour;
    }

    /** Method that searches through a list of Strings and counts instances of a given name
     * of a Player object */
    public static String nameAndResultToString(Player player, ArrayList<String> gameResults) {
        Pattern pattern = Pattern.compile(player.getName(), Pattern.CASE_INSENSITIVE);
        long testSum = gameResults
                .stream()
                .filter(word -> pattern.matcher(word)
                        .find())
                .count();
        String nameAndResult ="# " + player.getName() + " won " + testSum + " round(s) #\n";
        return nameAndResult;
    }

    //Compares resultList with names and adds score to StoredTournament object.
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

    public static ArrayList<String> handleGameResults(Contenders contenderList, ArrayList<String> gameResults) {
        System.out.println("----------" + "\nGame Results:\n" + gameResults + "\n----------");

        Player user = contenderList.getPlayer();
        Player time = contenderList.getTimePlayer();
        Player random = contenderList.getRandomPlayer();
        Player vocal = contenderList.getVocalPlayer();

        List<TourneyResults> tourneyResults = List.of(
                new TourneyResults(user.getName(), user.getRanking().getMatchesWon()),
                new TourneyResults(time.getName(), time.getRanking().getMatchesWon()),
                new TourneyResults(random.getName(), random.getRanking().getMatchesWon()),
                new TourneyResults(vocal.getName(), vocal.getRanking().getMatchesWon())
        );

        List<TourneyResults> tourneyWinner = tourneyResults
                .stream()
                .sorted(Comparator.comparing(TourneyResults::getMatchPoints).reversed())
                .limit(1)
                .toList();

        List<TourneyResults> tourneySecondPlace = tourneyResults
                .stream()
                .sorted(Comparator.comparing(TourneyResults::getMatchPoints).reversed())
                .skip(1)
                .limit(1)
                .toList();

        List<TourneyResults> tourneyThirdPlace = tourneyResults
                .stream()
                .sorted(Comparator.comparing(TourneyResults::getMatchPoints).reversed())
                .skip(2)
                .limit(1)
                .toList();

        List<TourneyResults> tourneyFourthPlace = tourneyResults
                .stream()
                .sorted(Comparator.comparing(TourneyResults::getMatchPoints).reversed())
                .skip(3)
                .limit(1)
                .toList();

        ArrayList<String> firstPlace = new ArrayList<>();
        ArrayList<String> secondPlace = new ArrayList<>();
        ArrayList<String> thirdPlace = new ArrayList<>();
        ArrayList<String> fourthPlace = new ArrayList<>();

        boolean secondBoolean = false;
        boolean thirdBoolean = false;
        boolean fourthBoolean = false;

        firstPlace.add(tourneyWinner.get(0).getName());
        if(tourneyWinner.get(0).getMatchPoints() == tourneySecondPlace.get(0).getMatchPoints()) {
            firstPlace.add(tourneySecondPlace.get(0).getName());
            secondBoolean = true;
            if(tourneySecondPlace.get(0).getMatchPoints() == tourneyThirdPlace.get(0).getMatchPoints()) {
                firstPlace.add(tourneyThirdPlace.get(0).getName());
                thirdBoolean = true;
            }
            if(tourneyThirdPlace.get(0).getMatchPoints() == tourneyFourthPlace.get(0).getMatchPoints()) {
                firstPlace.add(tourneyFourthPlace.get(0).getName());
                fourthBoolean = true;
            }
        }
        if(!secondBoolean) {
            secondPlace.add(tourneySecondPlace.get(0).getName());
        }
        if(tourneySecondPlace.get(0).getMatchPoints() == tourneyThirdPlace.get(0).getMatchPoints()) {
            secondPlace.add(tourneyThirdPlace.get(0).getName());
            thirdBoolean = true;
            if(tourneyThirdPlace.get(0).getMatchPoints() == tourneyFourthPlace.get(0).getMatchPoints()) {
                secondPlace.add(tourneyFourthPlace.get(0).getName());
                fourthBoolean = true;
            }
        }
        if(!thirdBoolean) {
            thirdPlace.add(tourneyThirdPlace.get(0).getName());
        }
        if(tourneyThirdPlace.get(0).getMatchPoints() == tourneyFourthPlace.get(0).getMatchPoints()) {
            thirdPlace.add(tourneyFourthPlace.get(0).getName());
            fourthBoolean = true;
        }
        if(!fourthBoolean) {
            fourthPlace.add(tourneyFourthPlace.get(0).getName());
        }

        for(int i = 0; i < firstPlace.size(); i++) {
            kevin1(firstPlace, i, user);
            kevin1(firstPlace, i, random);
            kevin1(firstPlace, i, time);
            kevin1(firstPlace, i, vocal);

        }

        for(int i = 0; i < secondPlace.size(); i++) {
            kevin2(secondPlace, i, user);
            kevin2(secondPlace, i, random);
            kevin2(secondPlace, i, time);
            kevin2(secondPlace, i, vocal);

        }

        for(int i = 0; i < thirdPlace.size(); i++) {
            kevin3(thirdPlace, i, user);
            kevin3(thirdPlace, i , random);
            kevin3(thirdPlace, i, time);
            kevin3(thirdPlace, i, vocal);

        }

        for(int i = 0; i < fourthPlace.size(); i++) {
            kevin4(fourthPlace, i, user);
            kevin4(fourthPlace, i, random);
            kevin4(fourthPlace, i, time);
            kevin4(fourthPlace, i, vocal);

        }

        //Debugging only
        //System.out.println(user.getRanking().toString());
        //System.out.println(random.getRanking().toString());
        //System.out.println(time.getRanking().toString());
        //System.out.println(vocal.getRanking().toString());

        System.out.println(user.getName() + " Best Place: " + user.getRanking().getBestPlace() + ", Counter: " + user.getRanking().getBestPlaceCount());
        System.out.println(random.getName() + " Best Place: " + random.getRanking().getBestPlace() + ", Counter: " + random.getRanking().getBestPlaceCount());
        System.out.println(time.getName() + " Best Place: " + time.getRanking().getBestPlace() + ", Counter: " + time.getRanking().getBestPlaceCount());
        System.out.println(vocal.getName() + " Best Place: " + vocal.getRanking().getBestPlace() + ", Counter: " + vocal.getRanking().getBestPlaceCount());

        return gameResults;
    }

    public static void kevin1(ArrayList<String> firstPlaceList, int i, Player player) {
        if(firstPlaceList.get(i).equals(player.getName())) {
            player.getRanking().setFirstPlace(player.getRanking().getFirstPlace() + 1);
            if(player.getRanking().getBestPlace() == 1) {
                player.getRanking().setBestPlaceCount(player.getRanking().getBestPlaceCount() + 1);
            }
            if(1 < player.getRanking().getBestPlace()) {
                player.getRanking().setBestPlace(1);
                player.getRanking().setBestPlaceCount(1);
            }
            if(player.getRanking().getWorstPlace() == 1) {
                player.getRanking().setWorstPlaceCount(player.getRanking().getWorstPlaceCount() + 1);
            }
            if(1 > player.getRanking().getWorstPlace()) {
                player.getRanking().setWorstPlace(1);
                player.getRanking().setWorstPlaceCount(1);
            }
        }
    }

    public static void kevin2(ArrayList<String> secondPlaceList, int i, Player player) {
        if(secondPlaceList.get(i).equals(player.getName())) {
            player.getRanking().setSecondPlace(player.getRanking().getSecondPlace() + 1);
            if(player.getRanking().getBestPlace() == 2) {
                player.getRanking().setBestPlaceCount(player.getRanking().getBestPlaceCount() + 1);
            }
            if(2 < player.getRanking().getBestPlace()) {
                player.getRanking().setBestPlace(2);
                player.getRanking().setBestPlaceCount(1);
            }
            if(player.getRanking().getWorstPlace() == 2) {
                player.getRanking().setWorstPlaceCount(player.getRanking().getWorstPlaceCount() + 1);
            }
            if(2 > player.getRanking().getWorstPlace()) {
                player.getRanking().setWorstPlace(2);
                player.getRanking().setWorstPlaceCount(1);
            }
        }
    }

    public static void kevin3(ArrayList<String> thirdPlaceList, int i, Player player) {
        if (thirdPlaceList.get(i).equals(player.getName())) {
            player.getRanking().setThirdPlace(player.getRanking().getThirdPlace() + 1);
            if (player.getRanking().getBestPlace() == 3) {
                player.getRanking().setBestPlaceCount(player.getRanking().getBestPlaceCount() + 1);
            }
            if (3 < player.getRanking().getBestPlace()) {
                player.getRanking().setBestPlace(3);
                player.getRanking().setBestPlaceCount(1);
            }
            if (player.getRanking().getWorstPlace() == 3) {
                player.getRanking().setWorstPlaceCount(player.getRanking().getWorstPlaceCount() + 1);
            }
            if (3 > player.getRanking().getWorstPlace()) {
                player.getRanking().setWorstPlace(3);
                player.getRanking().setWorstPlaceCount(1);
            }
        }
    }

    public static void kevin4(ArrayList<String> fourthPlaceList, int i, Player player) {
        if (fourthPlaceList.get(i).equals(player.getName())) {
            player.getRanking().setFourthPlace(player.getRanking().getFourthPlace() + 1);
            if (player.getRanking().getBestPlace() == 4) {
                player.getRanking().setBestPlaceCount(player.getRanking().getBestPlaceCount() + 1);
            }
            if (4 < player.getRanking().getBestPlace()) {
                player.getRanking().setBestPlace(4);
                player.getRanking().setBestPlaceCount(1);
            }
            if (player.getRanking().getWorstPlace() == 4) {
                player.getRanking().setWorstPlaceCount(player.getRanking().getWorstPlaceCount() + 1);
            }
            if (4 > player.getRanking().getWorstPlace()) {
                player.getRanking().setWorstPlace(4);
                player.getRanking().setWorstPlaceCount(1);
            }
        }
    }

    //Takes 2 players to play a game of SSP
    public static String playSSP(Player player1, Player player2) {

        System.out.println(player1.getName() + " vs " + player2.getName());

        player1.getRanking().setMatchPoints(0);
        player2.getRanking().setMatchPoints(0);
        player1.getRanking().setMatchesPlayed(player1.getRanking().getMatchesPlayed() + 1);
        player2.getRanking().setMatchesPlayed(player2.getRanking().getMatchesPlayed() + 1);

        while (player1.getRanking().getMatchPoints() < 2 && player2.getRanking().getMatchPoints() < 2) {

            boolean gameOver = false;

            while (!gameOver) {

                System.out.println("");
                String player1Move = player1.makeMove(player2);
                String player2Move = player2.makeMove(player1);

                if(player1Move.equals(player2Move)) {
                    pause(100);
                    System.out.println("Round is a draw");
                    pause(100);
                    System.out.println("");
                    player1Move = player1.randomMove(player1);
                    player2Move = player2.randomMove(player2);
                }

                if (!player1Move.equals(player2Move)) {
                    String winnerWinner = compareMoves(player1, player2, player1Move, player2Move);
                    if(winnerWinner.equals("player1")) {
                        player1.getRanking().setMatchPoints(player1.getRanking().getMatchPoints() + 1);
                    }
                    if(winnerWinner.equals("player2")) {
                        player2.getRanking().setMatchPoints(player2.getRanking().getMatchPoints() + 1);
                    }
                    gameOver = true;
                } else {
                    System.out.println("Round is a draw");
                    pause(100);
                }
            }
        }

        if(player1.getRanking().getMatchPoints() > player2.getRanking().getMatchPoints()) {
            System.out.println("\n" + player1.getName() + " Wins! " + player1.getRanking().getMatchPoints() + " vs " + player2.getRanking().getMatchPoints() + "\n");
            player1.getRanking().setMatchesWon(player1.getRanking().getMatchesWon() + 1);
            return player1.getName();
        }
        if(player2.getRanking().getMatchPoints() > player1.getRanking().getMatchPoints()) {
            System.out.println("\n" + player2.getName() + " Wins! " + player2.getRanking().getMatchPoints() + " vs " + player1.getRanking().getMatchPoints() + "\n");
            player2.getRanking().setMatchesWon(player2.getRanking().getMatchesWon() + 1);
            return player2.getName();
        }

        return "";
    }

    // Method that compares the moves made in the SSP-Game to see who wins the round
    public static String compareMoves(Player player1, Player player2, String player1Move, String player2Move) {

        if(player1Move.equals("Sten")) {
            if(player2Move.equals("Sax")) {
                pause(100);
                System.out.println(player1.getName() + " wins the round");
                pause(100);
                return "player1";
            }
            if(player2Move.equals("Påse")) {
                pause(100);
                System.out.println(player2.getName() + " wins the round");
                pause(100);
                return "player2";
            }
        }

        if(player1Move.equals("Sax")) {
            if(player2Move.equals("Sten")) {
                pause(100);
                System.out.println(player2.getName() + " wins the round");
                pause(100);
                return "player2";
            }
            if(player2Move.equals("Påse")) {
                pause(100);
                System.out.println(player1.getName() + " wins the round");
                pause(100);
                return "player1";
            }
        }

        if(player1Move.equals("Påse")) {
            if(player2Move.equals("Sten")) {
                pause(100);
                System.out.println(player1.getName() + " wins the round");
                pause(100);
                return "player1";
            }
            if(player2Move.equals("Sax")) {
                pause(100);
                System.out.println(player2.getName() + " wins the round");
                pause(100);
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

    @Override
    public String toString() {
        return "Tournament1{" +
                "date=" + date +
                '}';
    }
}
