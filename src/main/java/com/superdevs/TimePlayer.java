package com.superdevs;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class TimePlayer extends Player implements MakeMove {

    LocalTime localTime = LocalTime.now(ZoneId.of("Europe/Paris"));
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    List<String> timeWords = List.of("At the third stroke it will be 5 o' clock, my precious, said my brand new Tolkien clock.",
            "Around what time do most people visit the dentist? At tooth-hurty.",
            "Which animal always knows the time? A watch dog!",
            "How do you know that witches are carrying time bombs? You hear their brooms tick!",
            "A candy that never arrives on time is a choco-late.",
            "Once I tried to make a belt out of clocks. It was such a waist of time!",
            "If you annoy the clock, it might just tick off!");
    List<String> randomMoves = List.of("Sten", "Sax", "Påse");

    public TimePlayer(String name) {
        super(name);
    }

    // Logic för val av move
    @Override
    public String makeMove(Player user) {
        if(LocalTime.now().getMinute() <= 20) {
            pause(1500);
            System.out.println("Time used: Sax");
            System.out.println(punchLine());
            return "Sax";
        }
        if(LocalTime.now().getMinute() > 20 && LocalTime.now().getMinute() <= 40) {
            pause(1500);
            System.out.println("Time used: Påse");
            System.out.println(punchLine());
            return "Påse";
        }
        else {
            pause(1500);
            System.out.println("Time used: Sten");
            System.out.println(punchLine());
            return "Sten";
        }}

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = timeWords.size() - 1;
        int intRand = random.nextInt(upperBound);
        pause(1500);
        return "Time says: " + timeWords.get(intRand);
    }

    @Override
    public String randomMove(Player user) {
        Random randomRandom = new Random();
        int upperBound = randomMoves.size() - 1;
        int intRand = randomRandom.nextInt(upperBound);
        pause(1500);
        System.out.println("Time used: " + randomMoves.get(intRand));
        System.out.println(punchLine());
        return randomMoves.get(intRand);
    }

}