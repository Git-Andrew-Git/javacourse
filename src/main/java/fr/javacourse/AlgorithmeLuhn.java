package fr.javacourse;

import java.util.ArrayList;

/**
 * The type Algorithme luhn.
 */
public class AlgorithmeLuhn {
    /**
     * Algorithme luhn boolean.
     *
     * @param cardNumber the card number
     * @return the boolean
     */
    public static boolean algorithmeLuhn(ArrayList<Integer> cardNumber){
        boolean resultat = false;
        int somme = 0;
        int temperaire;
        for (int i = cardNumber.size(); i > 0; i-=2) {
            temperaire = cardNumber.get(i);
            temperaire *= 2;
            if (temperaire > 10) {
                temperaire-=10;
                temperaire+=1;
            }
            cardNumber.set(i, temperaire);
        }
        for (int i = 0; i < cardNumber.size(); i++) {
            somme += cardNumber.get(i);
        }
        if(somme%10 == 0){
            resultat = true;
            return resultat;
        }
        return resultat;

    }
}
