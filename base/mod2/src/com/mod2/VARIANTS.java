package com.mod2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum VARIANTS {
    ROCK,
    PAPER,
    SCISSORS;

    private static final List<VARIANTS> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static VARIANTS randomLetter()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

