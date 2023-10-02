package com.example.mod1;

import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {20, 34, 2},
                {9, 12, 18},
                {3, 4, 5}};
        int sum = 0;
        int s = 0;
        int min = 1000;
        String res = "";
        while (s < array.length) {
            for (int i = 0; i < array.length; i++) {
                sum += array[s][i];
            }
            if (sum < min) {
                res = Arrays.toString(array[s]);
                min = sum;
            }
            s++;
            sum = 0;
        }
        System.out.println(res);
    }
}