package exams;

import java.util.ArrayList;
import java.util.Random;

public class Lotto {

    public static void main(String[] args) {

        int[] tirage = new int[6]; // winning
        int[] grille = new int[6];
        int nbrGrilles = 50000;

        // we have 7 posibilities: 0, 1, 2, 3, 4, 5, 6
        // I used this to calculate the percentage
        int[] justeCount = new int[7];
        /**
         * [
         *  0 => kam wehde ma sabet chi
         *  1 => kam wehde sabet bas ra2em wahad
         *  2 => kam wehde sabet bas ra2men
         *  3 =>
         *  4 =>
         *  5 =>
         *  6 =>
         * ]
         */



        // Fill the "tirage" array without repetition
        for (int i = 0; i < tirage.length; i++) {
            int rand = new Random().nextInt(42) + 1;

            while (contains(tirage, rand)) {
                // find a new random
                // since the previous random already exists in the array
                rand = new Random().nextInt(42) + 1;
            }

            tirage[i] = rand;
        }

        // Fill the "grille" array without repetition
        for (int r = 0; r < nbrGrilles; r++) {

            grille = new int[6]; // clear the grille from previous run

            for (int i = 0; i < grille.length; i++) {
                int rand = new Random().nextInt(42) + 1;

                while (contains(grille, rand)) {
                    rand = new Random().nextInt(42) + 1;
                }

                grille[i] = rand;
            }

            // "juste" is a number between 0 (when no matches) and 6 (when all matches)
            int juste = nbDeNumerosJustes(grille, tirage);

            // they wrote this as a switch case statement
            // switch(juste)
            // {
            //    case 1: ball1 ++; break;
            //    ...
            //}
            justeCount[juste]++;
        }

        for (int i = 0; i < tirage.length; i++) {
            System.out.println("Tirage[" + i + "]: " + tirage[i]);
        }

        for (int i = 0; i < justeCount.length; i++) {
            double pourcentage = (justeCount[i] * 100) / nbrGrilles;
            System.out.println("Juste[" + i + "]: " + pourcentage + "%");
        }

    }

    public static int nbDeNumerosJustes(int[] grille, int[] tirage) {
        int result = 0;

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < tirage.length; j++) {
                if (grille[i] == tirage[j]) {
                    result++;
                }
            }
        }

        return result;
    }


    /**
     * returns true when "list" contains "valeur", false otherwise
     */
    public static boolean contains(int[] list, int valeur) {

        for (int j = 0; j < list.length; j++) {
            if (list[j] == valeur) {
                return true;
            }
        }

        // if we reach this line, this means that we have no matches
        return false;
    }

}
