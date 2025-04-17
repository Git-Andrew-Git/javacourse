package fr.javacourse;

/**
 * Miroir d'une chaîne de caractères
 */
//9.4
public class MiroirCC_9_4 {
    /**
     * Miroir d'une chaîne de caractères
     *
     *  Écrire une fonction qui permet d'inverser une chaîne de caractères.
     *
     * @param text the text
     * @return the string
     */
// ✅ okay
    public static String invertChars(String text){
        String newtext = "";
        for (int i = 0; i < text.length(); i++) {
            newtext += text.charAt(text.length()-i);
        }
        return newtext;
    }
}
