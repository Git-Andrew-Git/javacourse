package fr.javacourse;

import java.util.ArrayList;

public class LesKPlusGrandsElements {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static ArrayList<Integer> lesKPlusGrandsElements(int k, ArrayList<Integer> tableau){

        if (tableau.size() >= k) {
            ArrayList<Integer> newtableau = new ArrayList<>(k);
            int moitie;
            int indicenewtableau = 0;
//          tri rapide
            quickSort(tableau, 0, tableau.size()-1);
            for (int i = 0; i < tableau.size(); i++) {
                moitie = tableau.size()/2;
                if (tableau.get(i) < tableau.get(moitie)) {

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
