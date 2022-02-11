package com.superdevs;


import java.util.*;


public class Main {

    public static void main(String[] args) {

        // Creates CPU Opponents
        RandomPlayer randomCPU = new RandomPlayer("Random");
        TimePlayer timeCPU = new TimePlayer("Time");
        VocalPlayer vocalCPU = new VocalPlayer("Vowel");
        Results results = new Results();

        // Takes player input for username
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a username: ");
        String userName = scanner.nextLine();


        // Creates new player based on input
        Player user = new Player(userName);


        // Adds player and CPU to list for easy access
        Contenders contendersList = new Contenders(user, randomCPU, timeCPU, vocalCPU);
        System.out.println("Loading:");
        pause(500);
        System.out.println("* CPU Opponents generating..");
        pause(500);
        System.out.println("* Reading algorithms..");
        pause(1000);
        System.out.println("..Cleaning up after last tournament...");
        pause(1500);
        System.out.println("..almost done..");
        pause(800);
        System.out.println("Done! Lets play!");


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
                        statisticMenu(contendersList, results);
                        waitForPress();
                    }
                    case 4 -> {
                        System.out.println("4. Quit Program"
                        + "\nExiting program...");
                        pause(1500);
                    }
                    default -> System.out.println("Not a valid selection. Please try again (1 - 4)");
                }
            }catch(NumberFormatException e){
                System.out.println("*ERROR* Not a valid selection! *ERROR*");
                System.out.println("\n");
            }
        }while(userChoice != 4);
    }

    /** Method that takes Player and
     * uses the names stored in menu
     * @param player Player object used for name access*/
    public static void drawMenu(Player player) {
        //TODO clear screen before draw menu
        System.out.println("\nWelcome " + player.getName() + " to the ultimate Rock Scissor Paper simulator" +
                "\n1. Play new Tournament " +
                "\n2. Latest Result " +
                "\n3. Aggregated Statistics " +
                "\n4. Quit the game " +
                "\n\nChoose an option: [1 - 4] !");
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
            e.printStackTrace();
        }
    }

    public static void resultLatestGame(Results resultsList) {

        //Check if tournament played:
        if (resultsList.getStoredTour().size() == 0) {
            System.out.println("No previous RPS tournaments played.");
            return;
        }
        String time = resultsList
                .getStoredTour()
                .get(resultsList.getStoredTour().size()-1)
                .getTimeOfTour();

        String result = resultsList.getStoredTour().get(resultsList.getStoredTour().size()-1).getStoredMatchResult();

        System.out.println(
                "Last tournament was played " + time + "\nResults: " + result + "!"

        );

        /* resultsList
                     .getStoredTour()
                     .stream()
                     .sorted(Comparator
                             .comparing(StoredTour::getLocalDateTime).reversed())
                     .limit(1)
                     .toList()*/
    }

    /** Shows various statistics from Tournaments stored in a Results object
     *
     * @param resultsList A Results object
     * @param index Integer corresponding to users in a Tournament
     * */
    // TODO Fix OutOfBounds exception for index
    public static void resultStatistics(Results resultsList, int index) {

        DoubleSummaryStatistics showMeLife = resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .limit(1)
                .mapToDouble(x->x.getStoredUserList().get(0).getStoredRanking().getFirstPlace())
                .summaryStatistics();

        DoubleSummaryStatistics showMeLife2 = resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .limit(1)
                .mapToDouble(x->x.getStoredUserList().get(0).getStoredRanking().getSecondPlace())
                .summaryStatistics();

        DoubleSummaryStatistics showMeLife3 = resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .limit(1)
                .mapToDouble(x->x.getStoredUserList().get(0).getStoredRanking().getThirdPlace())
                .summaryStatistics();

        DoubleSummaryStatistics showMeLife4 = resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .limit(1)
                .mapToDouble(x->x.getStoredUserList().get(0).getStoredRanking().getFourthPlace())
                .summaryStatistics();

        System.out.println("getFirstPlace ###" + showMeLife);
        System.out.println("getSecondPlace " + showMeLife2);
        System.out.println("getThirdPlace " + showMeLife3);
        System.out.println("getFourthPlace " + showMeLife4);

        //  Programmet skall sedan kunna visa statistik om olika spelares snittplacering i turneringen,
        //  bästa placering samt sämsta placering
        // getCount() * 3 / getSum()
        // Returnera lista?



        // Kolla igenom en spelares poäng i varje turnering. Sammanställ

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

        System.out.println(name + " " + gonzo2.getSum() + " getSum");

        System.out.println(name + " " + gonzo2.getAverage() + " getAvg (getSum / getCount)");
        System.out.println(name + " " + gonzo2.getMax() + " getMax");
        System.out.println(name + " " + gonzo2.getMin() + " getMin");
        System.out.println(name + " " + gonzo2.getCount() + " getCount");
    }

    public static void resultStatistics2(Results resultsList, int index){

        // Bästa placering i tour
        System.out.println( "Best placement: " +
                resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .mapToDouble(x -> x.getStoredUserList()
                        .get(index)
                        .getStoredRanking()
                        .getBestPlace()).summaryStatistics().getMin());



        // Sämsta placering i tour
        System.out.println( "Worst placement: " +
                resultsList
                .getStoredTour()
                .stream()
                .sorted(Comparator.comparing(StoredTour::getLocalDateTime).reversed())
                .mapToDouble(x -> x.getStoredUserList()
                        .get(index)
                        .getStoredRanking()
                        .getWorstPlace())
                        .summaryStatistics()
                        .getMax());

        // Average placement in tour

        averageScore(resultsList);
    }

    public static void averageScore(Results resultsList) {
        int indexForArvid = resultsList.getStoredTour().size()-1;
        int userIndex = 0;
        System.out.println("Average placement in Tours: " + Math.round(resultsList.getStoredTour().get(indexForArvid).getStoredUserList().get(userIndex).getCombinedScore()));
    }


    public static void printTournaments() {
        System.out.println("Skiten funkar inte!!!");
    }

    public static void statisticMenu(Contenders contenderList, Results results){
        System.out.println(
                "Choose which player: " +
                        "\n 1. " + contenderList.getPlayer().getName() +
                        "\n 2. " + contenderList.getRandomPlayer().getName() +
                        "\n 3. " + contenderList.getTimePlayer().getName() +
                        "\n 4. " + contenderList.getVocalPlayer().getName()
        );
        int userChoice;
        Scanner statScanner = new Scanner(System.in);
        userChoice = Integer.parseInt(statScanner.nextLine());
        switch(userChoice) {
            case 1 -> resultStatistics2(results, 0);
            case 2 -> resultStatistics(results, 1);
            case 3 -> resultStatistics(results, 2);
            case 4 -> resultStatistics(results, 3);
        }
    }

    /** Starts a new tournament of Rock Paper Scissors (swe: Sten Sax Påse)
     *  and returns a StoredTour object.
     * @param contenderList Takes a Contender object with a list of players     *
     * */
    public static StoredTour runTournament(Contenders contenderList) {
        Tournament1 currentTournament = new Tournament1();
        ArrayList<String> gameResults = new ArrayList<>();

        contenderList.getPlayer().getRanking().setMatchesWon(0);
        contenderList.getRandomPlayer().getRanking().setMatchesWon(0);
        contenderList.getTimePlayer().getRanking().setMatchesWon(0);
        contenderList.getVocalPlayer().getRanking().setMatchesWon(0);

        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getRandomPlayer()));
        pause(100);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getTimePlayer()));
        pause(100);
        gameResults.add(Tournament1.playSSP(contenderList.getPlayer(), contenderList.getVocalPlayer()));
        pause(100);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getVocalPlayer()));
        pause(100);
        gameResults.add(Tournament1.playSSP(contenderList.getRandomPlayer(), contenderList.getVocalPlayer()));
        pause(100);
        gameResults.add(Tournament1.playSSP(contenderList.getTimePlayer(), contenderList.getRandomPlayer()));
        pause(100);

        return Tournament1.results(contenderList, Tournament1.handleGameResults(contenderList, gameResults));
    }









}



