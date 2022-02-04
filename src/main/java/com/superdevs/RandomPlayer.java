package com.superdevs;

import java.util.List;
import java.util.Random;

public class RandomPlayer implements MakeMove{

    List<String> randomWords = List.of("Kebab");
    List<String> randomMoves = List.of("Sten", "Sax", "Påse");
    @Override
    public String makeMove() {
       Random random = new Random();
       int upperBound = randomMoves.size() - 1;
       int intRand = random.nextInt(upperBound);
       return randomMoves.get(intRand);
    }

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = randomWords.size() - 1 ;
        int intRand = random.nextInt(upperBound);
        return randomWords.get(intRand);

    }
}
