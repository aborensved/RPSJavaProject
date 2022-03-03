package com.superdevs;

import java.util.Locale;
import java.util.NoSuchElementException;

public class CPUFactory {
    //Creates CPU player with factory pattern
    public Player createCPU(String name){
        return switch(name.toLowerCase(Locale.ROOT)){
            case "random" -> new RandomPlayer("Random");
            case "time" -> new TimePlayer("Time");
            case "vocal" -> new VocalPlayer("Vocal");
            default -> throw new NoSuchElementException("That type of player doesn't exist!");
        };
    }

}
