package fr.javacourse;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char charact = scanner.next().charAt(0);
        String name = scanner.next();
        int year = scanner.nextInt();
        float solde = scanner.nextFloat();
        float article = scanner.nextFloat();
        char matrimonsaisie = scanner.next().charAt(0);
        short enfan = scanner.nextShort();
        int salmensu = scanner.nextInt();
        char recalc = scanner.next().charAt(0);
        Object entiersaisie = scanner.nextInt();

        verifMaj(name, year);
        voyeCons(charact);
        assezArg(solde, article);
        tauxPart(matrimonsaisie, enfan, salmensu, recalc);
        somEntier(entiersaisie);

        scanner.close();
    }


    public static int[] trouverMax(int var1, int var2, int var3) {


        int min;
        int max;


        if (var1 <= var2 && var1 <= var3) {
            min = var1;
            if (var2 >= var3) {
                max = var2;
            } else {
                max = var3;
            }
        } else if (var2 <= var3) {
            min = var2;
            if (var3 >= var1) {
                max = var3;
            } else {
                max = var1;
            }
        } else {
            min = var3;
            if (var1 >= var2) {
                max = var1;
            } else {
                max = var2;
            }
        }
        int[] tableau = new int[2];
        tableau[0] = min;
        tableau[1] = max;
        return tableau;

    }

    public static String verifMaj(String name, int year) {
        int maj = 18;


        System.out.println("Hi, enter your name: \n");

        System.out.printf("%s, enter your age: \n", name);

        if (year >= maj) {
            System.out.printf("you are %s years old, you are major, access allowed\n", year);
            return String.format("you are %s years old, you are major, access allowed", year);
        } else {
            System.out.printf("you are %s years old, you are minor, access not granted\n", year);
            return String.format("you are %s years old, you are minor, access not granted", year);
        }


    }

    public static boolean voyeCons(char charact) throws IllegalArgumentException {

        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};


        for (char v : vowels) {
            if (charact == v) {
                System.out.println('v');
                return true;
            }
        }


        if (Character.isLetter(charact)) {
            System.out.println('c');
            return false;
        }

        throw new IllegalArgumentException("Input '" + charact + "' is not a letter");
    }

    public static float assezArg(float solde, float article) {
        System.out.println("Entrez le solde bancaire de l'utilisateur: \n");
        System.out.printf("Votre solde est: %f\n", solde);
        System.out.println("Entrez le prix du produit: ");
        System.out.printf("Votre prix du produit: %f\n", article);
        float result = solde - article;
        System.out.println(solde < article ? "Payment accepté" : "Payment impossible");
        return solde < article ? solde : result;
    }

    public static int tauxPart(char matrimonsaisie, short enfan, int salmensu, char recalc) {
        System.out.println("--- Saisie d'informations sur l'employé ---");
        System.out.println("État matrimonial (C pour célibataire, A pour autre situation) :");
        int matrimonres = 0;
        final char matrimonc = 'C';
        final char matrimona = 'A';
        int matrimonres1 = switch (matrimonsaisie) {
            case matrimonc -> 20;
            case matrimona -> 25;
            default -> throw new IllegalArgumentException("État matrimonial invalide");
        };
        matrimonres += matrimonres1;
        System.out.println("Nombre d'enfants à charge :");
        if (enfan < 0) {
            throw new IllegalArgumentException("Nombre d'enfants ne peut pas être négatif");
        }
        int tauxenfan = enfan * 15;
        matrimonres += tauxenfan;
        if (salmensu < 1800 && salmensu > 0) {
            matrimonres += 0;
        } else if (salmensu > 1800) {
            matrimonres += salmensu;
        } else throw new IllegalArgumentException("Salaire ne peut pas être négatif");
        matrimonres = (matrimonres > 50) ? 50 : matrimonres;

        System.out.printf("Le taux de participation est de %d%%\n", matrimonres);


        System.out.println("---");

        System.out.println("Souhaitez-vous effectuer le calcul pour un autre employé ? (Y/N)");
        final char yes = 'Y';
        final char no = 'N';
            /*char newemp = switch (recalc){
                case yes -> tauxPart();
                case no -> ;
                default -> throw new IllegalArgumentException();
            }*/


        switch (recalc) {
            case yes:
                System.out.println("Appel pour un nouvel employé (logique à implémenter)");
                break;
            case no:
                System.out.println("Fin du programme");
                break;
            default:
                throw new IllegalArgumentException("Choix invalide (Y ou N attendu)");
        }

        return matrimonres;


    }

    public static double youTube() {
        int mois = 24;
        double abonne = 2500.0;
        int gagne = 5;

        for (int i = 0; i < mois; i++) {
            abonne += ((abonne / 100.0) * gagne);
        }
        return abonne;
    }

    public static int somEntier(Object entiersaisie) {
        if (entiersaisie == null ||
                (!(entiersaisie instanceof Integer) && !(entiersaisie instanceof Character)) ||
                (entiersaisie instanceof Integer && (Integer) entiersaisie < 0) ||
                (entiersaisie instanceof Character && (Character) entiersaisie != 'Q')) {
            throw new IllegalArgumentException("Saisie invalide");
        } else {
            int counter = 0;
            if (entiersaisie instanceof Integer) {


                counter += entiersaisie;

            } else {
                return counter;
            }
        }
    }


}