package fr.javacourse;

public class TriAInsertion {
    public static Object[] triAInsertion(int[] tableau){
        int[] newtableau = new int[tableau.length];
        int counter;
        boolean indicateur;
        do {
            indicateur = false;
            for (int i = 0; i < tableau.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (tableau[i] <= newtableau[j]) {

                    }
//                    System.arraycopy(tableau, i, newtableau, );
                }
            }
        } while (indicateur);
    }
}
