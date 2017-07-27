package org.academiadecodigo.bootcamp.utils;

public class Random {

    public static int MathRandom(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
