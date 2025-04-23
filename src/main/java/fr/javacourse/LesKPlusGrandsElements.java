package fr.javacourse;

import java.util.ArrayList;

public class LesKPlusGrandsElements {

    public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    public static ArrayList<Integer> lesKPlusGrandsElements(int k, ArrayList<Integer> tableau){

        if (tableau.size() >= k) {
            ArrayList<Integer> newtableau = new ArrayList<>(k);

//          tri rapide
            quickSort(tableau, 0, tableau.size()-1);
            for (int i = 1; i <= k; i++) {
                newtableau.set(i-1, tableau.get(i));
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
