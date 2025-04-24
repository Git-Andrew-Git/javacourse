package fr.javacourse;

//10.2
/**
 * The type Binaire to decimal.
 */
public class DecimalToBinaire {
    /**
     * Binaire to decimal string.
     *
     * @param decimal the decimal, int
     * @return Binaire, the string
     */
    public static String deciamlToBinaire(int decimal) {
        String res = "";
        StringBuilder builder = new StringBuilder(res);
        try {
            if (decimal < 0) {
                throw new IllegalArgumentException("Negative numbers");
            } else if (decimal == 0) {
                return res = "0000";
            }
            final char zero = '0';
            final char one = '1';
            for (int i = 0; true; i++) {
                if (decimal == 0) {
                    return builder.toString();
                } else if (decimal % 2 == 1) {
                    decimal-=1;
                    decimal/=2;
                    builder.insert(res.length()-i, one);
                } else {
                    decimal /= 2;
                    builder.insert(res.length()-i, zero);
                }
            }



        } catch (IllegalArgumentException e) {
            System.out.println("Negative numbers");
        }

        return builder.toString();
    }
}
