package com.superdevs;

import java.util.List;
import java.util.Random;

public class VocalPlayer implements MakeMove {

    List<String> vokalWords = List.of("Det står att när de skulle göra pannkakor i fängelset använde de en fånge som smet",
            "Var kan man köpa kor billigast i världen? Korea.",
            "Vilken skillnad är det på en dator och en norrman? Datorn behöver bara instruktioner en gång.",
            "Vet du vad det blir då man parar en pittbullterrier med en kommunalarbetare? En mördarsnigel!",
            "Vakna Morfar! Du har glömt att ta dina sömntabletter!",
            "Du måtte ha en livlig fantasi, Jonas, du ser så nöjd ut när du tittar dig i spegeln.",
            "Vad heter Finlands sämste boxare? Ranta Runtiringen.");

    @Override
    public String makeMove() {
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