package fr.javacourse;

import java.io.IOException;

/**
 * Du binaire vers la base 10
 */
public class BintoDix_10_1 {
    /**
     * Du binaire vers la base 10
     *
     * @param bin binaire, String
     * @return decimale, the int
     */
    public static int bittoDix(String bin){
        int res = 0;
        try{

        int j = 0;
        for (int i = bin.length()-1; i >= 0; i--) {
            if (Character.isDigit(bin.charAt(i))) {
                if ((Character.getNumericValue(bin.charAt(i)) > 1 || Character.getNumericValue(bin.charAt(i))<0)) {
                    throw new IOException("Wrong input");
                }
                res += Character.getNumericValue(bin.charAt(i))*(Math.pow(2, j));
                j++;
            } else if (!Character.isDigit(bin.charAt(i))) {
                throw new IOException("Wrong input");
            }
        }
        } catch (IOException e) {
            System.out.println("Wrong input");
        }
        return res;
    }
}
