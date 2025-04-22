package fr.javacourse;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Tri a bulles.
 */
public class TriABulles {
    /**
     * Tri a bulles map.
     *
     * @param tableau the tableau
     * @return the map
     */
    public static Map<int[], Integer> triABulles(int[] tableau) {

        int swaps = 0;
        Map<int[], Integer> result = new HashMap<>();
        int temp;
        int indicator;
        do {
            indicator = 0;
            for (int i = 1; i < tableau.length; i++) {

                if (tableau[i - 1] > tableau[i]) {
                    temp = tableau[i - 1];
                    tableau[i - 1] = tableau[i];
                    tableau[i] = temp;
                    swaps++;
                    indicator += 1;
                } else {
                    indicator += 0;
                }

            }

        } while (indicator >= 1);
        result.put(tableau, swaps);
        return  result;
    }
}
