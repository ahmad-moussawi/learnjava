import java.io.FileWriter;
import java.io.IOException;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Tp0_3 {

    public static void main(String[] args) throws IOException {

        int nMax = 5; // number of random iteration used to generate the random variable
        int tailleDensite = 100;
        int nbrValeur = 130_000;

        double[] valeurs = new double[nbrValeur];
        int[] valeursCompte = new int[tailleDensite];
        double[] densite = new double[tailleDensite]; // densite chaine
        double[] probabilite = new double[tailleDensite]; // probabilite chaine
        double[] x = new double[tailleDensite]; // to display the chart


        for (int i = 0; i < valeurs.length; i++) {
            valeurs[i] = generateRandom(nMax);
            // int index = Math.floor(valeurs[i] * tailleDensite);
            int index = (int)(valeurs[i] * tailleDensite);
            valeursCompte[index]++;
        }

        FileWriter writer = new FileWriter("densite.txt");

        for(int i = 0; i < tailleDensite; i++)
        {
            probabilite[i] = (double) valeursCompte[i] / nbrValeur;
            densite[i] = (double) valeursCompte[i] * tailleDensite / nbrValeur;
            x[i] = i + 1;

            System.out.println(
                    "valueCount[" + i + "]= " + valeursCompte[i] +
                    ", P(" + i + ")= " + probabilite[i] +
                    ", F(" + i + ")= " + densite[i]
            );

            writer.write(densite[i] + "\n");
        }

        writer.close();

        // Display densite chart
        XYChart densiteChart = QuickChart.getChart("Density", "x", "y", "F(x)", x, densite);
        new SwingWrapper(densiteChart).displayChart();

        // Display probabilite chart
        XYChart probabiliteChart = QuickChart.getChart("Probabilite", "x", "y", "P(x)", x, probabilite);
        new SwingWrapper(probabiliteChart).displayChart();
    }

    static float generateRandom(int iterations) {
        float somme = 0;

        for (int i = 0; i < iterations; i++) {
            somme += Math.random();
        }

        return somme / iterations;
    }

}