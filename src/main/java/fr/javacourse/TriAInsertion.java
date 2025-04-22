package fr.javacourse;

public class TriAInsertion {
    public static Object[] insertionSort(int[] tableau) {
        int counter = 0;
        for (int i = 1; i < tableau.length; i++) {

            int key = tableau[i];
            int j = i - 1;
            while (j >= 0 && tableau[j] > key) {
                j--;
            }
            System.arraycopy(tableau, j + 1, tableau, j + 2, i - j - 1);
            tableau[j + 1] = key;
            counter++;
        }
        return new Object[]{tableau, };
    }

//    public static Object[] triAInsertion(int[] tableau){
//        int[] newtableau = new int[tableau.length];
//        int counter = 0;
//        boolean indicateur;
//
//            for (int i = 0; i < tableau.length; i++) {
//                indicateur = true;
//                int j = i;
//                do {
//                    if (i == 0) {
//                        System.arraycopy(tableau, i, newtableau, j, 1);
//                        counter++;
//                        indicateur = false;
//                    } else {
//
//
//
//
//                                j--;
//                                if (tableau[i] >= newtableau[j]) {
//                                    System.arraycopy(tableau, i, newtableau, j+1, 1);
//                                    counter++;
//                                    indicateur = false;
//                                }
//                                if (j == 0) {
//                                    if (tableau[i] >= newtableau[j]) {
//                                        System.arraycopy(tableau, i, newtableau, j+1, 1);
//                                        counter++;
//                                        indicateur = false;
//
//                                    } else {
//                                        System.arraycopy(tableau, i, newtableau, j, 1);
//                                        counter++;
//                                        indicateur = false;
//                                    }
//                                }
//
//
//                    }
//
//
//                } while (indicateur);
//
//
//            }
//
//        return new Object[] {newtableau, counter};
//    }
}
