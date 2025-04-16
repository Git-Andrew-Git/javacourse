package fr.javacourse;

import java.util.*;

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
        scanner.nextLine();

        verifMaj(name, year);
        voyeCons(charact);
        assezArg(solde, article);
        tauxPart(matrimonsaisie, enfan, salmensu, recalc);
        System.out.println(somEntier(scanner));
        System.out.println(fuzzBuzz(scanner));
        System.out.println(factorielleN(scanner));

        scanner.close();
    }

    // 3.1
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

    // 3.2
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

    // 3.3
    public static boolean voyeCons(char charact) throws IllegalArgumentException {

        char[] vowels = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };

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

    // 3.4
    public static float assezArg(float solde, float article) {
        System.out.println("Entrez le solde bancaire de l'utilisateur: \n");
        System.out.printf("Votre solde est: %f\n", solde);
        System.out.println("Entrez le prix du produit: ");
        System.out.printf("Votre prix du produit: %f\n", article);
        float result = solde - article;
        System.out.println(solde < article ? "Payment accepté" : "Payment impossible");
        return solde < article ? solde : result;
    }

    // 3.5
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
        } else
            throw new IllegalArgumentException("Salaire ne peut pas être négatif");
        matrimonres = (matrimonres > 50) ? 50 : matrimonres;

        System.out.printf("Le taux de participation est de %d%%\n", matrimonres);

        System.out.println("---");

        System.out.println("Souhaitez-vous effectuer le calcul pour un autre employé ? (Y/N)");
        final char yes = 'Y';
        final char no = 'N';
        /*
         * char newemp = switch (recalc){
         * case yes -> tauxPart();
         * case no -> ;
         * default -> throw new IllegalArgumentException();
         * }
         */

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

    // 4.1
    public static double youTube() {
        int mois = 24;
        double abonne = 2500.0;
        int gagne = 5;

        for (int i = 0; i < mois; i++) {
            abonne += ((abonne / 100.0) * gagne);
        }
        return abonne;
    }

    // 4.2
    public static int somEntier(Scanner scanner) {

        int counter = 0;

        while (true) {
            System.out.println("Enter a number or 'Q' to quit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                return counter;

            }
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    throw new IllegalArgumentException("Negative numbers not allowed");
                }
                counter += value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + input);
            }
        }
    }

    // 4.3
    public static ArrayList<String> fuzzBuzz(Scanner scanner) {

        ArrayList<String> numbers = new ArrayList<>();
        try {
            System.out.println("Enter a number to find FuzzBuzz: ");
            String input = scanner.nextLine();
            int n = Integer.parseInt(input);
            if (n < 0) {
                throw new IllegalArgumentException("Input must be non-negative");
            }
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                    numbers.add("FuzzBuzz");
                } else if ((i + 1) % 5 == 0) {
                    numbers.add("Buzz");
                } else if ((i + 1) % 3 == 0) {
                    numbers.add("Fuzz");
                } else {
                    numbers.add(String.valueOf(i + 1));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong type of value");
            return new ArrayList<>();
        } catch (IllegalArgumentException e) {
            System.out.println("Input must be non-negative");
            return new ArrayList<>();
        }

        numbers.forEach(System.out::println);
        return numbers;

    }

    // 4.4
    public static long factorielleN(Scanner scanner) {
        long res = 1L;

        try {
            int input = scanner.nextInt();
            if (input < 0) {
                throw new IllegalArgumentException("Negative values are not allowed");
            }
            ArrayList<Integer> elements = new ArrayList<>();
            int counter = 0;
            for (int i = 0; i < input; i++) {
                elements.add(input - counter);
                counter++;
            }
            final long[] resArr = { res };
            elements.forEach(e -> {
                resArr[0] *= e;
            });
            res = resArr[0];
            System.out.println(res);

            return res;
        } catch (InputMismatchException e) {
            System.out.println("Wrong type of value");
            return res;
        } catch (IllegalArgumentException e) {
            System.out.println("Negative value is not allowed");
            return res;
        }
    }

    // 5.1
    public static double[] itTableau() {
        double[] nombres = { 5.8, 6.4, 5.3 };
        Arrays.stream(nombres).forEach(System.out::println);
        return nombres;
    }

    // 5.2
    // TODO ajouter commentaire en "Javadoc"
    // plus d'informations sur la Javadoc : https://www.baeldung.com/javadoc
    public static int rechSeq1(int v, int[] tableau) {

        // FIXME la compilation ne peut pas se faire
        // Explication : la fonction "rechSeq1" a un type de retour (int) et s'attend
        // donc a avoir un "return"
        // il est donc obligatoire d'atteindre un "return"
        // par contre, dans l'état actuel, il existe un scénatio où le "return" n'est
        // pas atteint
        // c'est le cas où tableau.length == 0
        // il faut donc ajouter un "return" après la boucle
        // dans ce cas tu peux renvoyer -1
        /*
         * int[] tableau = {1, 5, 8, 6 ,7, 2, 4};
         * int v = 7;
         */
        for (int i = 0; i < tableau.length; i++) {
            if (v == tableau[i]) {
                return i;
            }
        }
    }

    // TODO ajout commentaire en Javadoc
    public static int rechSeq2(int v, int[] tableau) {
        /*
         * int[] tableau = {1, 5, 8, 6 ,7, 2, 4};
         * int v = 7;
         */
        int i = 0;
        while (i < tableau.length) {
            if (v == tableau[i]) {

                return i;
            }
            i++;
        }
        return -1;

    }

    // TODO ajout commentaire en Javadoc
    public static int rechSeq3(int v, int[] tableau) {
        /*
         * int[] tableau = {1, 5, 8, 6 ,7, 2, 4};
         * int v = 7;
         */
        int i = 0;
        do {
            if (v == tableau[i]) {

                return i;
            }
            i++;
        } while (i < tableau.length);
        return -1;
    }

    // 5.3
    // ✅ okay, pour améliorer la lisibilité du code tu peux adopter un nom de
    // fonction plus explicite
    // par exemple : "arraySumLoop"
    public static int somEntre1(int[] tableau, int i, int j) {
        int count = 0;
        for (int k = i; k < j; k++) {
            count += tableau[k];
        }
        return count;
    }

    // ✅ okay, pour améliorer la lisibilité du code tu peux adopter un nom de
    // fonction plus explicite
    // par exemple : "arraySumStream"
    public static int somEntre2(int[] tableau, int i, int j) {

        return Arrays.stream(tableau, i, j).sum();
    }

    // 5.4
    // TODO pour le moment la fonction renvoie les valeurs min et max
    // il faudrait faire en sorte qu'elle renvoie les index des min et max
    public static int[] indDanTab1(int[] tableau) {
        if (tableau.length == 0)
            return new int[] { 0, 0 };

        // TODO comment faire en sorte de ne pas avoir à déclarer les variables min et
        // max ?
        // serait-il possible d'utiliser la variable "newArr" à la place ?
        int max = tableau[0];
        int min = tableau[0];
        for (int i = 0; i < tableau.length; i++) {
            if (min >= tableau[i]) {
                min = tableau[i];
            }
            if (max <= tableau[i]) {
                max = tableau[i];
            }
        }

        int[] newArr = { min, max };
        return newArr;
    }

    // TODO même remarque que pour "indDanTab1", ici les valeurs sont retournées, il
    // nous faudrait les index
    public static int[] indDanTab2(int[] tableau) {
        int min = Arrays.stream(tableau).min().getAsInt();
        int max = Arrays.stream(tableau).max().getAsInt();
        return new int[] { min, max };
    }

    // 5.5
    public static boolean echanVal(int[] tableau, int i, int j) {
        if (i > tableau.length || j > tableau.length || tableau.length == 0)
            return false;

        // TODO la variable 'k' n'est pas utilisée, pourquoi ?
        int k = tableau[i];
        int l = tableau[j];
        tableau[i] = l;
        // TODO attention, c'est les valeurs que nous souhaitons échanger
        // ici le 'j' est l'indice
        tableau[j] = j;
        return true;
    }

    // 5.6
    // ✅ okay, tu peux modifier le nom pour être pus explicite
    public static float moyenne(int[] tableau) {
        if (tableau.length == 0) {
            return 0.0f;
        }
        int sum = 0;
        for (int elem : tableau) {
            sum += elem;
        }
        float moyen = sum / tableau.length;
        return moyen;
    }

    // ✅ okay
    public static float moyenne1(int[] tableau) {
        return (float) Arrays.stream(tableau).average().orElse(0.0);
    }

    // 5.7
    // ✅ okay
    public static void manipTabl(Scanner scanner) {
        try {
            System.out.println("Veuillez choisir un nombre de valeurs à saisir :");
            int taille = scanner.nextInt();
            if (taille < 0) {
                throw new IllegalArgumentException("Taille negative");
            }
            if (taille == 0) {
                System.out.println("tableau est vide");
            }
            System.out.println("----");
            int[] tableau = new int[taille];
            for (int i = 1; i <= taille; i++) {
                int j = i - 1;
                System.out.printf("Veuillez saisir le nombre %d :\n", i);
                tableau[j] = scanner.nextInt();
            }
            System.out.println("----");

            System.out.print("Tableau de nombres saisis : [");
            for (int i = 0; i < tableau.length; i++) {
                System.out.print(tableau[i]);
                if (i < tableau.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            int[] minmax = indDanTab1(tableau);
            System.out.printf("Min = %d\n", minmax[0]);
            System.out.printf("Max = %d\n", minmax[1]);
            float moy = moyenne(tableau);
            System.out.printf("Moyenne = %f\n", moy);
        } catch (IllegalArgumentException e) {
            System.out.println("Taille negative");
        }
    }

    // 5.8
    // ✅ okay
    public static int[] invert(int[] tableau) {
        if (tableau.length == 0) {
            return tableau;
        }

        int[] tableaunew = new int[tableau.length];
        for (int i = 0; i < tableau.length; i++) {
            tableaunew[tableau.length - 1 - i] = tableau[i];
        }
        return tableaunew;
    }

    // 6.1
    // ✅ okay
    public static int som2Dtableau(int[][] tableau, int width, int height) {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += tableau[i][j];
            }
        }
        return sum;
    }

    // 6.2
    public static int sumMatrixDiag(int[][] tableau, int width, int height, int diagonalType) {
        int sum = 0;
        if (tableau.length > 0 && tableau[0].length == tableau.length) {
            return sum;
        }
        for (int i = 0; i < tableau.length; i++) {
            // ✅ très bonne utilisation d'un "switch expression"
            sum += switch (diagonalType) {
                case 1 -> tableau[i][i];
                case 2 -> tableau[i][tableau.length - 1 - i];
                default -> tableau[i][i];
            };

        }
        return sum;

    }

    // 7
    // ✅ okay
    public static void triangChar1(Scanner scanner) {
        int n = scanner.nextInt();
        int i = 0;
        char e = '*';
        while (i < n) {
            System.out.println(e * (i + 1));
            i++;
        }
    }

    // ✅ okay
    public static void triangChar2(Scanner scanner) {
        int n = scanner.nextInt();
        int i = 1;
        char e = '*';
        int j = n;

        // TODO serait-il possible de trouver une solution avec 1 seule boucle WHILE ?
        while (i == n) {
            System.out.println(e * i);
            i++;

        }
        while (j == 0) {
            System.out.println(e * (n - i));
            j--;

        }
    }

    // 8
    // ✅ okay
    public static boolean plusouMois1(Scanner scanner, int k) {
        boolean res = false;
        int[] tableau = new int[100];
        Random r = new Random();
        int rn = r.nextInt(99) + 1;
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }
        System.out.printf("Vous avez %u u'essais pour découvrir un entier secret\n", k);
        // N° u'essais
        int f = 1;
        // lower boundary
        int d = 1;
        // upper boundary
        int u = tableau.length;
        do {
            System.out.printf("%u essais restant, entrez votre entier entre 1 et 100 :", k - f);
            int n = scanner.nextInt();
            try {
                if (n < d || n > u) {
                    throw new IllegalArgumentException("Out of boundaries");
                }

                if (n == rn) {
                    System.out.println("YOU WON!");
                    return res = true;
                } else if (n > tableau.length / 2 && rn > tableau.length / 2) {
                    d += u / 2;
                    System.out.printf("you are in the correct half of the numbers in between: %f and %f\n", d, u);
                    // tableau = Arrays.copyOf(tableau, tableau.length/2);
                } else if (n <= tableau.length / 2 && rn <= tableau.length / 2) {
                    u -= (u + 1 - d) / 2;
                    System.out.printf("you are in the correct half of the numbers in between: %f and %f\n", d, u);
                    // tableau = Arrays.copyOfRange(tableau, tableau.length/2, tableau.length);
                } else {
                    if (n > tableau.length / 2) {
                        d += u / 2;
                        System.out.printf("you are in the wrong half of the numbers in between: %f and %f\n", d, u);
                        // tableau = Arrays.stream(tableau).limit(tableau.length/2).toArray();
                    } else {
                        u -= (u + 1 - d) / 2;
                        System.out.printf("you are in the wrong half of the numbers in between: %f and %f\n", d, u);
                        // tableau = Arrays.stream(tableau).skip(tableau.length/2).toArray();
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Out of boundaries");
            }

            f++;
        } while (k == f);

        System.out.println("Out of tries");
        return res;
    }

    // TODO ajouter un "return" booléen pour satisfaire le compilateur
    public static boolean plusouMois2(Scanner scanner, int k) {
        boolean res = false;
        int[] tableau = new int[100];
        Random r = new Random();
        int rn = r.nextInt(100) + 1;
        for (int i = 0; i < tableau.length; i++) {
            int m;
            boolean unique;
            do {
                m = r.nextInt(100) + 1; // Range 1 to 100
                unique = true;
                for (int j = 0; j < i && unique; j++) {
                    if (m == tableau[j]) {
                        unique = false;
                    }
                }
            } while (!unique);
            tableau[i] = m;
        }
        System.out.printf("Vous avez %u u'essais pour découvrir un entier secret\n", k);
        // N° u'essais
        int f = 1;
        // lower boundary
        int d = 1;
        // upper boundary
        int u = tableau.length;
        /*
         * do {
         * System.out.printf("%u essais restant, entrez votre entier entre 1 et 100 :",
         * k - f);
         * int n = scanner.nextInt();
         * try {
         * if (n < d || n > u) {
         * throw new IllegalArgumentException("Out of boundaries");
         * }
         * if (n == rn) {
         * System.out.println("YOU WON!");
         * return res = true;
         * } else if (n > tableau.length / 2 && rn > tableau.length / 2) {
         * d += u/2;
         * System.out.
         * printf("you are in the correct half of the numbers in between: %f and %f\n",
         * d, u);
         * // tableau = Arrays.copyOf(tableau, tableau.length/2);
         * } else if (n <= tableau.length / 2 && rn <= tableau.length / 2) {
         * u -= (u+1-d)/2;
         * System.out.
         * printf("you are in the correct half of the numbers in between: %f and %f\n",
         * d, u);
         * // tableau = Arrays.copyOfRange(tableau, tableau.length/2, tableau.length);
         * } else {
         * if (n > tableau.length / 2) {
         * d += u/2;
         * System.out.
         * printf("you are in the wrong half of the numbers in between: %f and %f\n", d,
         * u);
         * // tableau = Arrays.stream(tableau).limit(tableau.length/2).toArray();
         * } else {
         * u -= (u+1-d)/2;
         * System.out.
         * printf("you are in the wrong half of the numbers in between: %f and %f\n", d,
         * u);
         * // tableau = Arrays.stream(tableau).skip(tableau.length/2).toArray();
         * }
         * }
         * 
         * } catch (IllegalArgumentException e) {
         * System.out.println("Out of boundaries");
         * }
         * 
         * f++;
         * } while (k == f);
         * System.out.println("Out of tries");
         * return res;
         */
    }

    // 9.1
    public static int decomptVoy(char[] selcharacters) {
        String message = "Écrire une fonction permettant de compter les voyelles dans une chaîne de caractères";
        int count = 0;
        System.out.println("Entry data lower case chars, counts both upper and lower case matches");
        try {

            if (selcharacters.length < 1) {
                throw new Exception("You need to insert at least one char");
            }
            if (message.length() == 0) {
                System.out.println("No chars of this type found");
                return count;
            }
            for (char i : selcharacters) {
                for (int j = 0; j < message.length(); j++) {
                    if (i == Character.toLowerCase(message.charAt(j))) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("You need to insert at least one char");
        }
        return count;
    }

}