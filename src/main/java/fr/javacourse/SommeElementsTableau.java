package fr.javacourse;

import java.util.ArrayList;
//15.1
/**
 * The type Somme elements tableau.
 */
public class SommeElementsTableau {
    /**
     * Somme elements tableau int.
     *
     * @param tableau the tableau
     * @param indice  the indice
     * @return the int
     */
    public static int sommeElementsTableau(ArrayList<Integer> tableau, int indice){
        if (indice >= tableau.size()) return 0;

        return tableau.get(indice) + sommeElementsTableau(tableau, indice+1);
    }
}
