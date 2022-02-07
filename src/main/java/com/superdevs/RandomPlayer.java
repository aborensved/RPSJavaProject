package com.superdevs;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player implements MakeMove {

    List<String> randomWords = List.of("Kul, har vi nånsin haft kul?!",
            "Måste jag? Ja Rogge du måste!",
            "Ja, vad fan, man var ju nykter i morse men nu börjar det ordna upp sig.",
            "Jag lovar och svär att jag inte legat med Sara!",
            "Jag kan flyga, jag är inte rädd.",
            "Finns det svenskt kaffe på hotellet?",
            "Tyngden på dalskidan, älskling.",
            "Gott snack.");
    List<String> randomMoves = List.of("Sten", "Sax", "Påse");

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public String makeMove(Player user) {
        Random random = new Random();
        int upperBound = randomMoves.size() - 1;
        int intRand = random.nextInt(upperBound);
        return randomMoves.get(intRand);
    }

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = randomWords.size() - 1;
        int intRand = random.nextInt(upperBound);
        return randomWords.get(intRand);
    }

}
