package com.superdevs;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VocalPlayer extends Player implements MakeMove {

    List<String> vokalWords = List.of("Det står att när de skulle göra pannkakor i fängelset använde de en fånge som smet",
            "Var kan man köpa kor billigast i världen? Korea.",
            "Vilken skillnad är det på en dator och en norrman? Datorn behöver bara instruktioner en gång.",
            "Vet du vad det blir då man parar en pittbullterrier med en kommunalarbetare? En mördarsnigel!",
            "Vakna Morfar! Du har glömt att ta dina sömntabletter!",
            "Du måtte ha en livlig fantasi, Jonas, du ser så nöjd ut när du tittar dig i spegeln.",
            "Vad heter Finlands sämste boxare? Ranta Runtiringen.");
    List<String> randomMoves = List.of("Påse", "Sten", "Sax");
    Pattern vowels = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);

    public VocalPlayer(String name) {
        super(name);
    }


    @Override
    public String makeMove(Player user) {

        for(int i = 0; i < user.getName().length(); i++) {
            int count = 0;
            Matcher matcher = vowels.matcher(user.getName());
            while(matcher.find()){
                count++;
            }
            if(count > 3) {
                pause(500);
                System.out.println("Vocal used: Sten");
                System.out.println(punchLine());
                return "Sten";
            }else if(count > 1) {
                pause(500);
                System.out.println("Vocal used: Sax");
                System.out.println(punchLine());
                return "Sax";
            }else {
                pause(500);
                System.out.println("Vocal used: Påse");
                System.out.println(punchLine());
                return "Påse";
            }
        }

        return "Move";
    }

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = vokalWords.size() - 1;
        int intRand = random.nextInt(upperBound);
        pause(500);
        return "Vocal says: " + vokalWords.get(intRand);
    }

    @Override
    public String randomMove(Player user) {
        Random randomRandom = new Random();
        int upperBound = randomMoves.size() - 1;
        int intRand = randomRandom.nextInt(upperBound);
        pause(500);
        System.out.println("Vocal used: " + randomMoves.get(intRand));
        System.out.println(punchLine());
        return randomMoves.get(intRand);
    }


}