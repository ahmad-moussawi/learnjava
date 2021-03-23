package exams;

import java.util.Scanner;

class BeamMachine {
    public static void main(String args[])
    {
        int balls, cols;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of balls: ");
        balls = input.nextInt();

        System.out.print("Enter the number of columns: ");
        cols = input.nextInt();
        int steps = cols - 1;

        int[] total = new int[cols];

        System.out.println("Balls: " + balls + ", cols: " + cols);

        for(int i = 0; i < balls; i++)
        {
            System.out.print("Ball " + i + ": ");

            int destination = steps;

            for(int j = 0;  j < steps; j++)
            {
                if(Math.random() < 0.5)
                {
                    destination--;
                    System.out.print("L");
                } else {
                    destination++;
                    System.out.print("R");
                }

                total[destination / 2]++;
            }
            System.out.print(", Destination: " + (destination / 2));
            System.out.println();
        }

        // print out the result
        for(int i = 0; i < cols; i++)
        {
            System.out.println("total[" + i + "]: " + total[i]);
        }

    }
}