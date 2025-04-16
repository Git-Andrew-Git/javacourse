package fr.javacourse;

public class decomptMaj {
    static int checkMaj(char chars){
        if (Character.isLetter(chars) && chars == Character.toUpperCase(chars)) {
            return 1;
        } else {
            return 0;
        }
    }

    static int recursionMaj(String message, int c){
        if (c == 1) {
            return checkMaj(message.charAt(c-1));
        }

        return recursionMaj(message, c-1) + checkMaj(message.charAt(c-1));
    }

    public static void main(){
        String message = "Comment nommer la fonction ? Quelles sont les paramètres et le type de retour de cette fonction ?";

        System.out.println("Total number of majusculs in string are:");

        System.out.println(recursionMaj(message, message.length()));

    }
}
