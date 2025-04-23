package fr.javacourse;

import java.io.IOException;
import java.util.ArrayList;

public class JeuMastermind {
    public static boolean jeuMastermind(ArrayList<Integer> combinaisonCachee, ArrayList<Integer> propositionUtilisateur, int quantiteEssaie) {
        boolean result = false;
        String etoile = "*";
        String degree = "°";
        int malPlace = 0;
        int bienPlace = 0;
        boolean relais;
        try{
            for (int i = 0; i < propositionUtilisateur.size(); i++) {
                if (!Character.isDigit(propositionUtilisateur.get(i))) {
                    throw new IOException("Is not a number");
                }
                if (!(propositionUtilisateur.get(i) >= 0 && propositionUtilisateur.get(i) <= 7)) {
                    throw new IllegalArgumentException("the number is not in between 0 and 7");
                }
            }
            System.out.print("Essaiez de deviner la combinaison cachée en proposant vos " + quantiteEssaie + " proposition");
            do {
                System.out.println("Entré 4 chiffres pour deviner la combinaison cachée: ");
                for (int i = 0; i < propositionUtilisateur.size(); i++) {
                    if (propositionUtilisateur.get(i) == combinaisonCachee.get(i)) {
                        bienPlace++;
                        if (bienPlace == 4) {
                            System.out.println("4 chiffres bien placés, c’est gagné !");
                            result = true;
                            return result;
                        }


                    } else {
                        relais = true;
                        for (int j = 0; j < combinaisonCachee.size() && relais; j++) {
                            if (propositionUtilisateur.get(i) == combinaisonCachee.get(j)) {
                                malPlace++;
                                relais = false;
                            }

                        }
                    }
                }
                String correction = new StringBuilder().append(etoile.repeat(bienPlace)).append(degree.repeat(malPlace)).toString();

                System.out.println(correction);
                quantiteEssaie--;
            } while (quantiteEssaie > 0);
            System.out.println("You Lost");

        } catch (IOException e){
            System.out.println("Is not a number");
        } catch (IllegalArgumentException e){
            System.out.println("the number is not in between 0 and 7");
        }
        return result;
    }
}
