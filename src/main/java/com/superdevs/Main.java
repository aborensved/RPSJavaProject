package com.superdevs;


import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
                ArrayList<String> tournamentResults = runTournament(playerList);
                System.out.println(tournamentResults);
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

        Tournament1 currentTournament = new Tournament1();

        ArrayList<String> gameResults = new ArrayList<>();

        Player user = (Player) playerList.get(0);

        Player random = (Player) playerList.get(1);

        Player time = (Player) playerList.get(2);

        Player vocals = (Player) playerList.get(3);


        gameResults.add(Tournament1.playSSP(user, random));
        pause(3000);
        gameResults.add(Tournament1.playSSP(time, vocals));
        pause(3000);
        gameResults.add(Tournament1.playSSP(user, time));
        pause(3000);
        gameResults.add(Tournament1.playSSP(random, vocals));
        pause(3000);
        gameResults.add(Tournament1.playSSP(user, vocals));
        pause(3000);
        gameResults.add(Tournament1.playSSP(time, random));
        pause(3000);


        return Tournament1.results(currentTournament.getDate(), playerList, gameResults);
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



