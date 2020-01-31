package ru.chaban;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет");

        List<String> l = new ArrayList<String>();
        for (int i = 1; i < 1000000; i++) {

            for (int j = 0; j < 1000; j++) {
                l.add(String.valueOf(j));
            }

            l.remove(0);
            /*for (int j = 0; j < 1; j++) {
                l.remove((int)l.size()*Math.random());
            }*/

            if (i%100==0){
                System.out.println(i);
            }
        }


    }
}
