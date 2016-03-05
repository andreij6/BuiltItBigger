package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> mJokes;
    private Random mRandom;

    public Joker(){
        mJokes = prefillJoke();
        mRandom = new Random();
    }

    private List<String> prefillJoke() {

        List<String> result = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            result.add(String.format("Joke %d, Punchline", i));
        }

        return result;
    }

    public String provideJoke(){
        int randomInt = mRandom.nextInt(20);

        return mJokes.get(randomInt);
    }
}
