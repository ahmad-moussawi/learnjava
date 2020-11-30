import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

class Complex {
    public double Xr;
    public double Xi;
}

public class Tp0_4 {

    static double module(Complex c)
    {
        return Math.sqrt(c.Xr * c.Xr + c.Xi * c.Xi);
    }

    static double real(double tab[], int k, int N)
    {
        double sum = 0;

        for(int i = 0; i < N; i++)
        {
            sum += tab[i] * Math.cos(2 * Math.PI * i * ((double)k / N));
        }

        return sum;
    }

    static double imaginary(double tab[], int k, int N)
    {
        double sum = 0;

        for(int i = 0; i < N; i++)
        {
            sum += tab[i] * Math.sin(2 * Math.PI * i * ((double)k / N));
        }

        return -sum;
    }

    // java Tp0_4 s1000.txt 1000
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(args[1]);
        double[] input = new double[N];

        double[] x = new double[N]; // 1 --> N
        double[] output = new double[N]; // tfd(x)

        Scanner scan = new Scanner(new File(args[0]));

        int i = 0;
        while (scan.hasNext() && i < N) {
            scan.nextDouble(); // just to skip the first number
            input[i++] = scan.nextDouble();
        }


        FileWriter writer = new FileWriter("tfd.txt");

        for(int k = 0; k < N; k++)
        {
            Complex c = new Complex();
            c.Xr = real(input, k, N);
            c.Xi = imaginary(input, k, N);

            x[k] = k;
            output[k] = module(c);

            writer.write(k + "\t" + output[k] + "\n");
        }

        writer.close();

        // // Display densite chart
        XYChart chart = QuickChart.getChart("TFD", "k", "TFD", "TFD(k)", x, output);
        new SwingWrapper(chart).displayChart();
    }

}