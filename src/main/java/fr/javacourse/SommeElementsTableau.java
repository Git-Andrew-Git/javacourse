package fr.javacourse;

import java.util.ArrayList;

public class SommeElementsTableau {
    public static int sommeElementsTableau(ArrayList<Integer> tableau, int indice){
        if (indice >= tableau.size()) return 0;

        return tableau.get(indice) + sommeElementsTableau(tableau, indice+1);
    }
}
