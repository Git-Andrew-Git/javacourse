package fr.javacourse;

/**
 * Décompte des majuscules
 */
//9.2
public class DecomptMaj_9_2 {
    /**
     * verifie si des letter sont majiscules, int.
     *
     * @param chars the chars
     * @return 1 si majiscules, 0 si miniscule, the int
     */
    static int checkMaj(char chars){
        if (Character.isLetter(chars) && chars == Character.toUpperCase(chars)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Recursion pour compter le quantiter des majiscules
     *
     * @param message the message, chaîne de character où on cherche les majiscules
     * @param c       langeur du message
     * @return quantiter des majiscules the int
     */
    static int recursionMaj(String message, int c){
        if (c == 1) {
            return checkMaj(message.charAt(c-1));
        }

        return recursionMaj(message, c-1) + checkMaj(message.charAt(c-1));
    }

    /**
     * Main.
     */
    public static void main(){
        String message = "Comment nommer la fonction ? Quelles sont les paramètres et le type de retour de cette fonction ?";

        System.out.println("Total number of majusculs in string are:");

        System.out.println(recursionMaj(message, message.length()));

    }
}
