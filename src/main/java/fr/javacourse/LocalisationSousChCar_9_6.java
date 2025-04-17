package fr.javacourse;

/**
 * Localisation d'une sous-chaîne de caractères
 */
//9.6
public class LocalisationSousChCar_9_6 {
    /**
     * Localisation d'une sous-chaîne de caractères, int [ ].
     *
     * @param text   the text où on cherche la sous-chaîne
     * @param search the search la sous-chaîne
     * @return les index de la sous-chaîne, -1 & -1 si non-trouvé, the int [ ]
     */
    public static int[] localisationSCC(String text, String search) {
        int[] res = {-1, -1};
        for (int i = 0; i < text.length(); i++) {
            boolean x = true;
            if (search.charAt(0) == text.charAt(i)) {

                for (int j = 0; j < search.length() && x; j++) {
                    if (search.charAt(j) == text.charAt(i + j)) {
                        res[0] = i;
                        res[1] = i + j;
                        if (j+1 == search.length()) {
                            return res;
                        }
                    } else {
                        x = false;
                    }
                }
            }
        }
        return res;
    }
}
