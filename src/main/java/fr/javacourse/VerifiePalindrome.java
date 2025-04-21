package fr.javacourse;

import java.util.ArrayList;
import java.util.Map;


/**
 * The type Verifie palindrome.
 */
public class VerifiePalindrome {


    /**
     * Exclure signes string.
     *
     * @param tableau the tableau
     * @return the string
     */
    public static String exclureSignes(String tableau){
        String textCorrige = "";
        int count = 0;
        StringBuilder newchar = new StringBuilder(tableau);
        for (int i = 0; i < tableau.length(); i++) {
            if (Character.isLetter(tableau.charAt(i))) {
                char ch = tableau.charAt(i);
                newchar.insert(count,ch);
                textCorrige = tableau.toString();
                count++;
            }

        }
        
        textCorrige.toLowerCase();
        textCorrige = textCorrige.replaceAll("[\\u00E0\\u00E2\\u00E4]", "a");
        textCorrige = textCorrige.replaceAll("[\\u00E7]", "c");
        textCorrige = textCorrige.replaceAll("[\\u00E8\\u00E9\\u00EA\\u00EB]", "e");
        textCorrige = textCorrige.replaceAll("[\\u00EE\\u00EF]", "i");
        textCorrige = textCorrige.replaceAll("[\\u00F4\\u0153]", "o");
        textCorrige = textCorrige.replaceAll("[\\u00F9\\u00FB\\u00FC]", "u");

        return textCorrige;
    }

    /**
     * Verifie palindrome boolean.
     *
     * @param textCorrige the text corrige
     * @return the boolean
     */
    public static boolean verifiePalindrome(String textCorrige){
        boolean resultat = false;
        if (textCorrige.length() %2 == 0) {
            for (int i = 0; i < textCorrige.length(); i++) {
                if (textCorrige.charAt((textCorrige.length()/2)-i) == textCorrige.charAt((textCorrige.length()/2)+1+i)) {
                    resultat = true;
                } else {
                    resultat =false;
                    return resultat;
                }
            }
        } else {
            for (int i = 0; i < textCorrige.length(); i++) {
                if (textCorrige.charAt((textCorrige.length()/2)-i) == textCorrige.charAt((textCorrige.length()/2)+2+i)) {
                    resultat = true;
                } else {
                    resultat =false;
                    return resultat;
                }
            }
        }

        return resultat;
    }

    /**
     * Main boolean.
     *
     * @param text the text
     * @return the boolean
     */
    public static boolean main(String text) {
        String newtext = exclureSignes(text);
        System.out.println(text);
        System.out.println(newtext);
        String reponse;
        boolean resultat;
        if (verifiePalindrome(newtext)) {
            reponse = "palindrome";
            resultat = true;
        } else {
            reponse = "non-palindrome";
            resultat = false;
        }
        System.out.printf("Chaîne des caractère est %", reponse);
        return resultat;
    }
}
