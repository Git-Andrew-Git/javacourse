package fr.javacourse;
//18
/**
 * The type Chiffrement par decalage.
 */
public class ChiffrementParDecalage {
    /**
     * Chiffrement par decalage string builder.
     *
     * @param text            the text
     * @param shift_value     the shift value
     * @param shift_direction the shift direction
     * @return the string builder
     */
    public static StringBuilder chiffrementParDecalage(String text, int shift_value, boolean shift_direction){
        String newtext = "";
        StringBuilder newchar = new StringBuilder(newtext);
        shift_direction = true;
        boolean grandoupetit = true;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if ((int) text.charAt(i) >= 65 && (int) text.charAt(i) < 91) {
                    grandoupetit = true;
                } else if ((int) text.charAt(i) >= 97 && (int) text.charAt(i) < 123) {
                    grandoupetit = false;
                }
                int ascii = (int) text.charAt(i);
                if (shift_direction) {
                    ascii+=shift_value;
                } else {
                    ascii-=shift_value;
                }
                if (grandoupetit) {
                    if (ascii>90) {
                        if (26-shift_value>=0) {
                            ascii -= 26;
                        } else if (26-shift_value<0) {
                            ascii -= shift_value;
                            ascii += 26%shift_value;
                            if (ascii>90) {
                                ascii -= 26;
                            }
                        }
                    } else if (ascii<65) {
                        if (26-shift_value>=0) {
                            ascii += 26;
                        } else if (26-shift_value<0) {
                            ascii += shift_value;
                            ascii -= 26%shift_value;
                            if (ascii<60) {
                                ascii += 26;
                            }
                        }
                    }
                } else {
                    if (ascii>122) {
                        if (26-shift_value>=0) {
                            ascii -= 26;
                        } else if (26-shift_value<0) {
                            ascii -= shift_value;
                            ascii += 26%shift_value;
                            if (ascii>122) {
                                ascii -= 26;
                            }
                        }
                    } else if (ascii<97) {
                        if (26-shift_value>=0) {
                            ascii += 26;
                        } else if (26-shift_value<0) {
                            ascii += shift_value;
                            ascii -= 26%shift_value;
                            if (ascii<97) {
                                ascii += 26;
                            }
                        }
                    }
                }
                newchar.insert(i, ascii);

            }

        }
        return new StringBuilder(newchar.toString());
    }
}
