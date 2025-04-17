package fr.javacourse;

/**
 * The type Algorithme glouton.
 */
public class AlgorithmeGlouton {
    /**
     * Algorithme glouton int [ ].
     *
     * @param rendu the rendu
     * @return the int [ ]
     */
    public static int[] algorithmeGlouton(int rendu){
        int[] typeRendu = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] typeRenduExample = {200, 100, 50, 20, 10, 5, 2, 1};

        int i = 0;
        while (i<typeRenduExample.length) {
            if (rendu / typeRenduExample[i] > 0) {
                typeRendu[i] = rendu / typeRenduExample[i];
                rendu %= typeRenduExample[i];
                i++;
            } else {
                i++;
            }
        }
        return typeRendu;

    }
}
