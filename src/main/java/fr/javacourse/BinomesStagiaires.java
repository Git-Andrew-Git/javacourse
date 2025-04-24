package fr.javacourse;

import java.util.ArrayList;
import java.util.Random;

public class BinomesStagiaires {
    public static ArrayList<Integer> binomesStagiaires(String[] learnerNames) {
        Random r = new Random();
        ArrayList<Integer> newTable = new ArrayList<>();
        int count = 0;
        int n;
        for (int i = 0; i < learnerNames.length; i++) {
            n = r.nextInt(learnerNames.length/2) + 1;
            newTable.add(n);
            for (int j = 0; j < newTable.size(); j++) {
                if (newTable.get(i) == newTable.get(j)) {

                }

            }
        }
        return newTable;
    }
}
