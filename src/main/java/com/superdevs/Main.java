package com.superdevs;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
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
        System.out.println("Loading:");
        pause(500);
        System.out.println("* CPU Opponents generating..");
        pause(500);
        System.out.println("* Creating Tournaments..");
        StoredTour storedTour1 = new StoredTour(contendersList);
        pause(1000);
        StoredTour storedTour2 = new StoredTour(contendersList);
        pause(1000);
        StoredTour storedTour3 = new StoredTour(contendersList);
        pause(1000);
        StoredTour storedTour4 = new StoredTour(contendersList);
        System.out.println("Done! Lets play!");

        storedTour1.getStoredUserList().get(0).setResult(3); //Winner
        storedTour1.getStoredUserList().get(1).setResult(0);
        storedTour1.getStoredUserList().get(2).setResult(2);
        storedTour1.getStoredUserList().get(3).setResult(1);

        storedTour2.getStoredUserList().get(0).setResult(3); // Winner
        storedTour2.getStoredUserList().get(1).setResult(1);
        storedTour2.getStoredUserList().get(2).setResult(1);
        storedTour2.getStoredUserList().get(3).setResult(1);

        storedTour3.getStoredUserList().get(0).setResult(0);
        storedTour3.getStoredUserList().get(1).setResult(2);
        storedTour3.getStoredUserList().get(2).setResult(3);    //Winner
        storedTour3.getStoredUserList().get(3).setResult(1);

        storedTour4.getStoredUserList().get(0).setResult(1);
        storedTour4.getStoredUserList().get(1).setResult(2);
        storedTour4.getStoredUserList().get(2).setResult(1);
        storedTour4.getStoredUserList().get(3).setResult(2);    //winner

        results.addStoredTour(storedTour1);
        results.addStoredTour(storedTour2);
        results.addStoredTour(storedTour3);
        results.addStoredTour(storedTour4);

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
        System.out.println("\nVälkommen " + player.getName() + " till RPS Sim 2k2" +
                "\n1. Spela ny turnering " +
                "\n2. Senaste resultatet " +
                "\n3. Resultat statistik " +
                "\n4. Avsluta " +
                "\n\nVar god ange ett val: [1 - 4] !");
    }

    /** Method that pauses the program for a given time.
     * @param milliseconds Int value(in milliseconds, ie 2000 equals 2 sec)
     * */
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Prompts user to message defined and waits
     * for the Enter key to be pressed, before
     * resuming program
     * */
    // FIXED!
    public static void waitForPress() {
        try {
            Scanner waitScan = new Scanner(System.in);
            System.out.println("\nPress Enter to continue...");
            waitScan.nextLine();
        } catch (NoSuchElementException e){

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

    /** Shows various statistics from Tournaments stored in a Results object
     *
     * @param resultsList A Results object
     * @param index Integer corresponding to users in a Tournament
     * */
    // TODO Fix OutOfBounds exception for index
    public static void resultStatistics(Results resultsList, int index) {


        //  Programmet skall sedan kunna visa statistik om olika spelares snittplacering i turneringen,
        //  bästa placering samt sämsta placering
        // getCount() * 3 / getSum()

        // getMax från individuell Tournament return name.

        // Placering = placering varje tour
        System.out.println(
                resultsList.storedTourArrayList.get(0).getStoredUserList().get(0).getResult() + " - " +
                resultsList.storedTourArrayList.get(0).getStoredUserList().get(0).getName() +

                resultsList.getStoredTour().get(0).getStoredUserList().get(0).getResult() +
                resultsList.getStoredTour().get(0).getStoredUserList().get(0).getName()
        );

        List najs= List.of(resultsList.getStoredTour().stream().map(StoredTour::getStoredUserList).toList());

        System.out.println("Test1 kommer här : " +najs);


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
        //System.out.println(name + " " + ((gonzo2.getMax() * 100 ) / gonzo2.getSum()) + "%" + " getAvg - max");
        //System.out.println(name + " " + ((gonzo2.getMin() * 100) / gonzo2.getSum()) + "%" + " getAvg - min ");
        System.out.println(name + " " + gonzo2.getAverage() + " getAvg (getSum / getCount)");
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
                        "\n 1. " + player.getName() +
                        "\n 2. Random" +
                        "\n 3. Time" +
                        "\n 4. Vowel"
        );
        int userChoice = 0;
        Scanner statScanner = new Scanner(System.in);
        userChoice = Integer.parseInt(statScanner.nextLine());
        switch(userChoice) {
            case 1 -> {
                resultStatistics(results, 0);
            }
            case 2 -> {
                resultStatistics(results, 1);
            }
            case 3 -> {
                resultStatistics(results, 2);
            }
            case 4 -> {
                resultStatistics(results, 3);
            }
        }
    }


    /** Starts a new tournament of Rock Paper Scissors (swe: Sten Sax Påse)
     *  and returns a StoredTour object.
     * @param contenderList Takes a Contender object with a list of players     *
     * */
    public static StoredTour runTournament(Contenders contenderList) {
        Tournament1 currentTournament = new Tournament1();
        ArrayList<String> gameResults = new ArrayList<>();

        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getRandomPlayer()));
        pause(1500);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getVocalPlayer()));
        pause(1500);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getTimePlayer()));
        pause(1500);
        gameResults.add(Tournament1.playSSP(contenderList.getRandomPlayer(), contenderList.getVocalPlayer()));
        pause(1500);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getVocalPlayer()));
        pause(1500);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getRandomPlayer()));
        pause(1500);
        StoredTour newStoredTour = Tournament1.results(contenderList, gameResults);
        return newStoredTour;
    }





}



