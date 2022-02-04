package com.superdevs;

import java.util.Scanner;

public class Menu {

    //TODO ska ta in en instans av en spelare, denna skall användas
    // TODO för namnreferens etc.
    public void myMenu(String username){
        //Meny med val.
        drawMenu(username);

        // Meny som körs via metoden menuChoice, som tar in en int och kör igång rätt val.
        Scanner scanner = new Scanner(System.in);
        boolean menuBool = true;
        while(menuBool) {
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                menuBool = menuChoice(userChoice, username);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Du angav något galet! Prova igen!");
            }
        }
    }

    // Tar in en int, och returnerar sant eller falskt.
    private boolean menuChoice(int choice, String username) {
        System.out.println("You chose menu option " +choice);
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
                System.out.println("Val 4");
                //quitThisShit();
                return false;
            }
            default -> {
                System.out.println("Not ok");
                return true;
            }
        }
    }

    private void drawMenu(String user) {
        //TODO clear screen before draw menu
        System.out.println("Välkommen " + user + " till RPS Sim 2k2" +
                "\n1. Spela ny turnering " +
                "\n2. Senaste resultatet " +
                "\n3. Resultat statistik " +
                "\n4. Avsluta " +
                "\n\nVar god ange ett val: [1 - 4] !");
    }

    //TODO Ev överflödig, eller skall ändras till skapande av en player instans.
    public String createUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create user: ");
        String user = scanner.nextLine();
        return user;
    }

}
