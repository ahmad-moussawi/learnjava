package exams;

import java.util.Random;

public class MatriceTest {

    public static void main(String[] args) {

        int[][] tab = {
            {1, 2, 3},
            {4, 5, 6}
        };

        Matrice a = new Matrice(tab);

        System.out.println(a);

//        a.transpose();
//        System.out.println(a);
//
//        System.out.println(Matrice.rotateClockwise(a));
        System.out.println(Matrice.flipLeftRight(a));

    }

}

class Matrice {

    private int nligs;
    private int ncols;
    private int[][] matrice;

    public int getNligs() {
        return nligs;
    }

    public void setNligs(int nligs) {
        this.nligs = nligs;
    }

    public int getNcols() {
        return ncols;
    }

    public void setNcols(int ncols) {
        this.ncols = ncols;
    }

    public Matrice(int nligs, int ncols) {
        this.matrice = new int[nligs][ncols];
        this.ncols = ncols;
        this.nligs = nligs;

        for (int i = 0; i < nligs; i++) {
            for (int j = 0; j < ncols; j++) {
                matrice[i][j] = 0; //new Random().nextInt(100);
            }
        }
    }

    public Matrice(int[][] tabl) {
        matrice = tabl;
        nligs = tabl.length;
        ncols = tabl[0].length;
    }

    public int getValueAt(int i, int j) {
        return matrice[i][j];
    }

    public void setValueAt(int i, int j, int newValue) {
        matrice[i][j] = newValue;
    }

    public void transpose() {

        int[][] newMatrice = new int[ncols][nligs];

        for (int i = 0; i < ncols; i++) {
            for (int j = 0; j < nligs; j++) {
                newMatrice[i][j] = matrice[j][i];
            }
        }

        matrice = newMatrice;

        int tmp = nligs;
        nligs = ncols;
        ncols = tmp;
    }

    public static Matrice flipLeftRight(Matrice A) {

        for (int l = 0; l < A.getNligs(); l++) {
            for (int c = 0; c < A.getNcols() / 2; c++) {
                int tmp = A.getValueAt(l, A.getNligs() - c);
                A.setValueAt(l, A.getNligs() - c, A.getValueAt(l, c));
                A.setValueAt(l, c, tmp);
            }
        }

        return A;
    }

    public static Matrice rotateClockwise(Matrice A) {

        Matrice newMatrice = new Matrice(A.getNcols(), A.getNligs());

        for (int c = 0; c < A.getNcols(); c++) {
            for (int l = 0; l < A.getNligs(); l++) {
                newMatrice.setValueAt(c, A.getNligs() - 1 - l, A.getValueAt(l, c));
            }
        }

        return newMatrice;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < nligs; i++) {
            result += "[";
            for (int j = 0; j < ncols; j++) {
                result += matrice[i][j];
                if (j < ncols - 1) {
                    result += ", ";
                }
            }
            result += "]\n";
        }
        return result;
    }

}
