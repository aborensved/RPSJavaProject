package com.superdevs;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VocalPlayer implements MakeMove {

    List<String> vokalWords = List.of("Det står att när de skulle göra pannkakor i fängelset använde de en fånge som smet",
            "Var kan man köpa kor billigast i världen? Korea.",
            "Vilken skillnad är det på en dator och en norrman? Datorn behöver bara instruktioner en gång.",
            "Vet du vad det blir då man parar en pittbullterrier med en kommunalarbetare? En mördarsnigel!",
            "Vakna Morfar! Du har glömt att ta dina sömntabletter!",
            "Du måtte ha en livlig fantasi, Jonas, du ser så nöjd ut när du tittar dig i spegeln.",
            "Vad heter Finlands sämste boxare? Ranta Runtiringen.");

    Pattern vowels = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);



    @Override
    public String makeMove() {

        for(int i = 0; i < wordList.length(); i++) {
            int count = 0;
            Matcher matcher = vowels.matcher(wordList.get(i));
            while(matcher.find()){
                count++;
            }
            if(count > 1) {
                matchingWords.add(wordList.get(i));
            }
        }

        return "Move";
    }

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = vokalWords.size() - 1;
        int intRand = random.nextInt(upperBound);
        return vokalWords.get(intRand);
    }

}