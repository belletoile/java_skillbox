package com.example.mod1;

public class task1 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =0; i<1001; i++){
            if (i%3==0 || i%5==0)
                sum += i;
        }
        System.out.println(sum);
    }
}
