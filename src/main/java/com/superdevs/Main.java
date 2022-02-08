package com.superdevs;


import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        Tournament tournament1 = new Tournament(contendersList);
        pause(2000);
        Tournament tournament2 = new Tournament(contendersList);

        tournament2.getActiveUserList().get(0).setResult(1);
        tournament2.getActiveUserList().get(1).setResult(1);
        tournament2.getActiveUserList().get(2).setResult(1);
        tournament2.getActiveUserList().get(3).setResult(1);

        results.addTournament(tournament1);
        results.addTournament(tournament2);

        int userChoice = 0;
        do{
            try{
                drawMenu(contendersList.getPlayer());
                Scanner scannerMenu = new Scanner(System.in);
                userChoice = Integer.parseInt(scannerMenu.nextLine());
                //results.addTournament(menuChoice(userChoice, contendersList, results));
                switch (userChoice) {
                    case 1 -> {
                        results.addTournament(runTournament(contendersList));
                    waitForPress();
                    }
                    case 2 -> {
                        resultLatestGame(results);
                        waitForPress();
                    }
                    case 3 -> {
                        System.out.println(
                                results.getTournament()
                                        .get(0)
                                        .getActiveUserList()
                                        .get(1)
                                        .toString()
                        );

                        resultShit(results);
                        waitForPress();
                    }
                    case 4 -> {
                        System.out.println("4. Quit Program"
                        + "\nExiting program...");
                        pause(1500);
                    }
                    default -> {

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

    public static Tournament runTournament (Contenders contenderList) {
                Tournament tournament = new Tournament(contenderList);
        System.out.println("New Tournament Started");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
        tournament.getLocalDateTime().format(dateTimeFormatter);
        tournament.getActiveUserList().stream().filter(nameId -> Objects.equals(nameId.getNameId(), "Random")).forEach(x -> x.setResult(1));
        tournament.getActiveUserList().stream().filter(nameId -> Objects.equals(nameId.getNameId(), "Random")).forEach(System.out::println);
        return tournament;
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
             resultsList
                     .getTournament()
                     .stream()
                     .sorted(Comparator
                             .comparing(Tournament::getLocalDateTime).reversed())
                     .limit(1)
                     .toList()
        );
    }



    // genomsnitt, bästa och sämsta resultat för olika spelare.
    public void resultStats(Results resultsList) {
       /*DoubleSummaryStatistics bestAmdWorstResult =
               resultsList
                       .getTournament()
                       .stream()
                       .mapToDouble()
                       .summaryStatistics();

        */

        //resultsList
          //      .getTournament()
            //    .stream()

    }

    public static void resultShit (Results resultsList) {

        DoubleSummaryStatistics Gonzo = resultsList.getTournament().stream().mapToDouble(x -> x.getActiveUserList().get(0).getResult()).summaryStatistics();
        System.out.println(Gonzo);
    }


}



