import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tp0 {

    public static void main(String[] args) throws FileNotFoundException {


        File inputFile = new File(args[0]);
        Scanner scan = new Scanner(inputFile);

        double somme = 0, moyenne, variance = 0, ecartType;

        ArrayList<Double> list = new ArrayList<Double>();

        // read the file and store the values inside the list
		int max = 0;
        while (scan.hasNext() && max++ < 1024) {
            scan.nextDouble(); // just to skip the first number
            list.add(scan.nextDouble());
        }
		
		System.out.println("List size: " + list.size());

        // loop over the list and calculate the somme
        for (int i = 0; i < list.size(); i++) {
            somme += list.get(i);
        }

        moyenne = somme / list.size();

        // loop over the list and calculate the variance
        for (int i = 0; i < list.size(); i++) {
            variance += (list.get(i) - moyenne) * (list.get(i) - moyenne);
        }

        variance /= list.size();
        ecartType = Math.sqrt(variance);

        System.out.println("Somme: " + somme);
        System.out.println("Moyenne: " + moyenne);
        System.out.println("Variance: " + variance);
        System.out.println("EcartType: " + ecartType);
    }

}
