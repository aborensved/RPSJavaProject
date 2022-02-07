package com.superdevs;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RandomPlayer randomCPU = new RandomPlayer();
        TimePlayer timeCPU = new TimePlayer();
        VocalPlayer vocalCPU = new VocalPlayer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange ditt användarnamn: ");
        String userName = scanner.nextLine();
        Player user = new Player(userName);

        drawMenu(user);
        myMenu(user);


    }

    public static void myMenu(Player player){
        // Meny som körs via metoden menuChoice, som tar in en int och kör igång rätt val.
        Scanner scanner = new Scanner(System.in);
        boolean menuBool = true;
        while(menuBool) {
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                menuBool = menuChoice(userChoice, player);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Du angav något galet! Prova igen!");
            }
        }
    }

    /** Metod som skriver ut en meny till vår simulator
     * Tar in en instans av Player klassen */
    public static void drawMenu(Player player) {
        //TODO clear screen before draw menu
        System.out.println("Välkommen " + player.getName() + " till RPS Sim 2k2" +
                "\n1. Spela ny turnering " +
                "\n2. Senaste resultatet " +
                "\n3. Resultat statistik " +
                "\n4. Avsluta " +
                "\n\nVar god ange ett val: [1 - 4] !");
    }

    public static boolean menuChoice(int choice, Player player) {
        System.out.println("You chose menu option " + choice);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO lägga in korrekta metoder som skall köras
        switch (choice) {
            case 1 -> {
                System.out.println("Hej 1");
                //tournamentGo(Player userChar);

                /////

                Tournament tour = new Tournament(player);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'den' dd-MMMM-yyyy hh:mm:ss");
                System.out.println(
                        tour.getLocalDateTime().format(dateTimeFormatter)
                );
                tour.getActiveUserList().stream().filter(nameId -> nameId.getNameId() == "RandomCPU").forEach(x -> x.setResult(1));
                tour.getActiveUserList().stream().filter(nameId -> nameId.getNameId() == "RandomCPU").forEach(System.out::println);

                /////

                return true;
            }
            case 2 -> {
                System.out.println("Hej 2");
                Results results = new Results();
                results.showRecentResults();
                return false;
            }
            case 3 -> {
                System.out.println("val 3");
                //showStatistics();
                return true;
            }
            case 4 -> {
                System.out.println("Val 4 - HEJ DÅ!");
                //quitThisShit();
                return false;
            }
            default -> {
                System.out.println("Not ok");
                return true;
            }
        }
    }}



