package fr.javacourse;
//15.2?
/**
 * The type Inserez chaine caracter.
 */
public class InserezChaineCaracter {
    /**
     * Inserez chain caracter string builder.
     *
     * @param text    the text
     * @param newtext the newtext
     * @param count   the count
     * @return the string builder
     */
    public static StringBuilder inserezChainCaracter(String text, String newtext, int count){
        StringBuilder stringBuilder = new StringBuilder(newtext);
        if (count >= text.length()) {
            return new StringBuilder(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        }
        stringBuilder.insert(count, text.charAt(count));
        stringBuilder.insert(count+1, '-');
        return  inserezChainCaracter(text, stringBuilder.toString(), count+2);
    }
}
