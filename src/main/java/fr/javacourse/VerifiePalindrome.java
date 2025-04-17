package fr.javacourse;

import java.util.ArrayList;
import java.util.Map;


public class VerifiePalindrome {


    public static String exclureSignes(String tableau){
        String textCorrige;
        return textCorrige;
    }

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
