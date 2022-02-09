package com.superdevs;


import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Creates CPU Opponents
        RandomPlayer randomCPU = new RandomPlayer("Random");
        TimePlayer timeCPU = new TimePlayer("Time");
        VocalPlayer vocalCPU = new VocalPlayer("Vowel");
        Results results = new Results();

        // Takes player input for username
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange ditt användarnamn: ");
        String userName = scanner.nextLine();

        // Creates new player based on input
        Player user = new Player(userName);

        // Adds player and CPU to list for easy access
        Contenders contendersList = new Contenders(user, randomCPU, timeCPU, vocalCPU);

        StoredTour storedTour1 = new StoredTour(contendersList);
        pause(2000);
        StoredTour storedTour2 = new StoredTour(contendersList);

        results.addStoredTour(storedTour1);
        results.addStoredTour(storedTour2);

        int userChoice = 0;
        do{
            try{
                drawMenu(contendersList.getPlayer());
                Scanner scannerMenu = new Scanner(System.in);
                userChoice = Integer.parseInt(scannerMenu.nextLine());
                switch (userChoice) {
                    case 1 -> {
                        results.addStoredTour(runTournament(contendersList));
                        waitForPress();
                    }
                    case 2 -> {
                        resultLatestGame(results);
                        pause(1500);
                        waitForPress();
                    }
                    case 3 -> {
                        statisticMenu(contendersList.getPlayer(), results);
                        waitForPress();
                    }
                    case 4 -> {
                        System.out.println("4. Quit Program"
                        + "\nExiting program...");
                        pause(1500);
                    }
                    default -> {
                        System.out.println("Not a valid selection. Please try again (1 - 4)");
                    }
                }
            }catch(NumberFormatException e){
                System.out.println("Du angav något galet! Prova igen!");
                System.out.println("\n");
            }
        }while(userChoice != 4);
    }

    /** Method that takes Player and
     * uses the names stored in menu
     * @param player Player object used for name access*/
    public static void drawMenu(Player player) {
        //TODO clear screen before draw menu
        System.out.println("Välkommen " + player.getName() + " till RPS Sim 2k2" +
                "\n1. Spela ny turnering " +
                "\n2. Senaste resultatet " +
                "\n3. Resultat statistik " +
                "\n4. Avsluta " +
                "\n\nVar god ange ett val: [1 - 4] !");
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

    public static void resultLatestGame(Results resultsList) {
        System.out.println(
             "Last " + resultsList
                     .getStoredTour()
                     .stream()
                     .sorted(Comparator
                             .comparing(StoredTour::getLocalDateTime).reversed())
                     .limit(1)
                     .toList()
        );
    }

    public static void resultShit (Results resultsList, int index) {

        DoubleSummaryStatistics gonzo2 = resultsList
                .getStoredTour()
                .stream()
                .mapToDouble(x -> x.getStoredUserList()
                        .get(index)
                        .getResult())
                .summaryStatistics();
        String name = resultsList
                .getStoredTour()
                .get(0)
                .getStoredUserList()
                .get(index).getName();

        System.out.println(name + " " + gonzo2.getSum() + " getsum");
        System.out.println(name + " " + (gonzo2.getAverage() * 100)+"%" + " getAvg");
        System.out.println(name + " " + gonzo2.getMax() + " getMax");
        System.out.println(name + " " + gonzo2.getMin() + " getMin");
        System.out.println(name + " " + gonzo2.getCount() + " getCount");
    }

    public static void printTournaments() {
        System.out.println("Skiten funkar inte!!!");
    }

    public static void statisticMenu(Player player, Results results){
        System.out.println(
                "Ange vilken du vill titta på: " +
                        "\n 1." + player.getName() +
                        "\n 2. Random" +
                        "\n 3. Time" +
                        "\n 4. Vowel"
        );
        int userChoice = 0;
        Scanner statScanner = new Scanner(System.in);
        userChoice = Integer.parseInt(statScanner.nextLine());
        switch(userChoice) {
            case 1 -> {
                resultShit(results, 0);
            }
            case 2 -> {
                resultShit(results, 1);
            }
            case 3 -> {
                resultShit(results, 2);
            }
            case 4 -> {
                resultShit(results, 3);
            }
        }
    }

    public static StoredTour runTournament(Contenders contenderList) {
        Tournament1 currentTournament = new Tournament1();
        ArrayList<String> gameResults = new ArrayList<>();

        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getRandomPlayer()));
        pause(3000);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getVocalPlayer()));
        pause(3000);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getTimePlayer()));
        pause(3000);
        gameResults.add(Tournament1.playSSP(contenderList.getRandomPlayer(), contenderList.getVocalPlayer()));
        pause(3000);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getVocalPlayer()));
        pause(3000);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getRandomPlayer()));
        pause(3000);
        StoredTour newStoredTour = Tournament1.results(contenderList, gameResults);
        return newStoredTour;
    }





}



