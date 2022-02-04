package com.superdevs;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class TimePlayer implements MakeMove {

    LocalTime localTime = LocalTime.now(ZoneId.of("Europe/Paris"));
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    List<String> timeWords = List.of("At the third stroke it will be 5 o' clock, my precious, said my brand new Tolkien clock.",
            "Around what time do most people visit the dentist? At tooth-hurty.",
            "Which animal always knows the time? A watch dog!",
            "How do you know that witches are carrying time bombs? You hear their brooms tick!",
            "A candy that never arrives on time is a choco-late.",
            "Once I tried to make a belt out of clocks. It was such a waist of time!",
            "If you annoy the clock, it might just tick off!");



    @Override
    public String makeMove() {
        if(LocalTime.now().getHour() >= 8 && LocalTime.now().getHour() < 16) {
            return "Sax";
        }
        if(LocalTime.now().getHour() >= 16) {
            return "Påse";
        }
        else {
            return "Sten";
        }
    }

    @Override
    public String punchLine() {
        Random random = new Random();
        int upperBound = timeWords.size() - 1;
        int intRand = random.nextInt(upperBound);
        return timeWords.get(intRand);
    }
}