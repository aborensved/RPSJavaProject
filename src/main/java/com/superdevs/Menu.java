package com.superdevs;

import java.util.Scanner;

public class Menu {

    public void myMenu(){
        // Lagrar spelarens namn i en variabel
        // TODO Tar input från användaren och lagrar detta i en ny instans av spelare.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = scanner.nextLine();

        //Meny med val.
        System.out.println("Välkommen " + user + " till RPS Sim 2k22");
        System.out.println("1. Spela ny turnering");
        System.out.println("2. Senaste resultatet");
        System.out.println("3. Resultat statistik");
        System.out.println("4. Avsluta");
        System.out.println("\nVar god ange ett val: [1 - 4] !");

        // Meny som körs via metoden menuChoice, som tar in en int och kör igång rätt val.
        boolean menuBool = true;
        while(menuBool) {
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                menuBool = menuChoice(userChoice);
                //menuChoice(userChoice);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Du angav något galet! Prova igen!");
            }
        }
    }

    // Tar in en int, och returnerar sant eller falskt.
    private boolean menuChoice(int choice) {
        int returnResult = choice;
        System.out.println("You chose menu option " +choice);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO lägga in korrekta metoder som skall köras
        switch (returnResult) {
            case 1 :
                System.out.println("Hej 1");
                //tournamentGo();
                return true;
            //break;
            case 2 :
                System.out.println("Hej 2");
                Results results = new Results();
                results.showRecentResults();
                return false;
            //break;
            case 3 :
                System.out.println("val 3");
                //showStatistics();
                return true;
            //break;
            case 4 :
                System.out.println("Val 4");
                //quitThisShit();
                return false;
            //break;
            default:
                System.out.println("Not ok");
                return true;
        }

    }

}
