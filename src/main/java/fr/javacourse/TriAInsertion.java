package fr.javacourse;

public class TriAInsertion {
    public static Object[] triAInsertion(int[] tableau){
        int[] newtableau = new int[tableau.length];
        int counter = 0;
        boolean indicateur;

            for (int i = 0; i < tableau.length; i++) {
                indicateur = true;
                int j = i;
                do {
                    if (i == 0) {
                        System.arraycopy(tableau, i, newtableau, j, 1);
                        counter++;
                        indicateur = false;
                    } else {
                        while (j > 0){



                                j--;
                                if (tableau[i] >= newtableau[j]) {
                                    System.arraycopy(tableau, i, newtableau, j+1, 1);
                                    counter++;
                                    indicateur = false;
                                }
                                if (j == 0) {
                                    if (tableau[i] >= newtableau[j]) {
                                        System.arraycopy(tableau, i, newtableau, j+1, 1);
                                        counter++;
                                        indicateur = false;

                                    } else {
                                        System.arraycopy(tableau, i, newtableau, j, 1);
                                        counter++;
                                        indicateur = false;
                                    }
                                }
                            }

                    }


                } while (indicateur);


            }

        return new Object[] {newtableau, counter};
    }
}
