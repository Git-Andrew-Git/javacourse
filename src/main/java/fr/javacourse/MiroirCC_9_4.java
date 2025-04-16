package fr.javacourse;
//9.4
public class MiroirCC_9_4 {
    public static String invertChars(String text){
        String newtext = "";
        for (int i = 0; i < text.length(); i++) {
            newtext += text.charAt(text.length()-i);
        }
        return newtext;
    }
}
