package fr.javacourse;

import java.util.ArrayList;
import java.util.Arrays;


//11
public class FusionnerDeuxTableauTrie {
    public static ArrayList<Integer> fusionnerDeuxTableauTrie(ArrayList<Integer> arrayOne, ArrayList<Integer> arrayTwo) {
        ArrayList<Integer> newArray = new ArrayList<>();

        int initialValue1 = arrayOne.get(0);
        int initialValue2 = arrayTwo.get(0);
        //check if arrays have 2nd element than assign or logic
            int secondpairV1 = arrayOne.get(1);
            int secondpairV2 = arrayTwo.get(1);

        int pointer1;
        int pointer2;
        int pointer3;
        int one = 0;
        int two = 0;
        int s1;
        int s2;
        /*int v1;
        int v2;*/
        for (int i = 0; i < (arrayTwo.size()+arrayOne.size()); i++) {

            // stronger of the first pair
            if (initialValue1>=initialValue2) {
                s1 = 2;
                pointer1 = initialValue1;
                newArray.addAll(Arrays.asList(initialValue2));
//                two++;

            } else {
                s1 = 1;
                pointer1 = initialValue2;
                newArray.addAll(Arrays.asList(initialValue1));
//                one++;
            }
            // weaker of the second pair
            if (secondpairV1<=secondpairV2) {
                s2 = 1;
                pointer2 = secondpairV1;
                pointer3 = secondpairV2;

            } else {
                s2 = 2;
                pointer2 = secondpairV2;
                pointer3 = secondpairV1;

            }
            // compare the winners of the first two comparisons
            if (pointer2 >= pointer1) {
                newArray.addAll(Arrays.asList(pointer1));
                if (pointer2 > pointer3) {
                    int t = pointer3;
                    pointer3 = pointer2;
                    pointer2 = t;
                }
                switch (s2) {
                    case 1 -> one++;
                    case 2 -> two++;
                    default -> one++;
                };


            } else {
                newArray.addAll(Arrays.asList(pointer2));
                pointer2 = pointer1;
                if (pointer2 > pointer3) {
                    int t = pointer3;
                    pointer3 = pointer2;
                    pointer2 = t;
                }
                switch (s1) {
                    case 1 -> one++;
                    case 2 -> two++;
                    default -> one++;
                };
            }
            switch (s1) {
                case 1 -> one++;
                case 2 -> two++;
                default -> one++;
            };
            initialValue1 = pointer2;
            initialValue2 = pointer3;
            if (arrayTwo.size() < two) {
                for (int j = one; j < arrayOne.size(); j++) {
                    newArray.addAll(Arrays.asList(arrayOne.get(j)));
                    return newArray;
                }
            }
            if (arrayOne.size() < one) {
                for (int k = two; k < arrayTwo.size(); k++) {
                    newArray.addAll(Arrays.asList(arrayTwo.get(k)));
                    return newArray;
                }
            }
            //logic for in order to establish elements of second pair
            /*if (arrayOne.get(one) >= arrayTwo.get(two)) {
                if (arrayOne.get(one) >= arrayTwo.get(two+1)) {
                    
                }
            }*/

        }
    }
}
