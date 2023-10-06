package com.mod2;

import java.util.ArrayList;

import static com.mod2.VARIANTS.randomLetter;

public class Player {
    public String name;
    public VARIANTS var;

    Player() {
        this.name = "Bot";
        this.var = randomLetter();
    }

    Player(VARIANTS var, String name) {
        this.name = name;
        this.var = var;
    }

    public String whoWins(Player player1, Player player2) {
        System.out.println(player1.name + " выбрал " + player1.var);
        System.out.println(player2.name + " выбрал " + player2.var);

        ArrayList<VARIANTS> arr = new ArrayList<>();
        arr.add(VARIANTS.ROCK);
        arr.add(VARIANTS.PAPER);
        arr.add(VARIANTS.SCISSORS);

        int index1 = arr.indexOf(player1.var);
        int index2 = arr.indexOf(player2.var);

        if (index1 == index2) {
           return "Это ничья!";
        }
        if ((index1 - index2) == 1 || (index1 - index2) == -2) {
            return player1.name + " выиграл!";
        } else {
            return player2.name + " выиграл!";
        }
    }
}
