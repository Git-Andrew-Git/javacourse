package fr.javacourse;
//9.5
import java.io.IOException;

public class TransfCamel_9_5 {
    public static String transfCamel(String text){
        String newtext = "";
        try {
        for (int i = 0; i < text.length(); i++) {
            if (i == 0 && !(Character.isLetter(text.charAt(i)))) {
                throw new IOException("1st one can be only Letter");
            }
            if (i == 0) {
                newtext += Character.toLowerCase(text.charAt(i));
            } else if ((Character.isLetter(text.charAt(i))) && !(Character.isLetter(text.charAt(i-1)))) {
                newtext += Character.toUpperCase(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))){
                newtext += text.charAt(i);
            }
        }

        } catch (IOException e) {
            System.out.println("1st one can be only Letter");
        }
        return newtext;
    }
}
