package fr.javacourse;

import java.util.ArrayList;

public class LesKPlusGrandsElements {
    public static ArrayList<Integer> lesKPlusGrandsElements(int k, ArrayList<Integer> tableau){

        if (tableau.size() >= k) {
            ArrayList<Integer> newtableau = new ArrayList<>(k);
            int indicenewtableau = 0;
            int moitie = tableau.size()/2;
//          tri par sélection
            for (int i = 0; i < tableau.size(); i++) {
                if (i == 0) {
                    newtableau.set(i, tableau.get(i));
                    indicenewtableau++;
                } else {
                    if (tableau.get(i) < newtableau.get(indicenewtableau)) {
                        
                    }
                }
            }
            return newtableau;
        } else {
            System.out.println("Entrez un plus grand nombre: ");
//            pour les tests
            return null;
//            return lesKPlusGrandsElements(k, tableau);
        }
    }
}
