package exams;

class BinaryConverter {

    public static void main(String args[])
    {
        int[] list = new int [] {1,  0,  0,  0};
        //                       3   2   1   0
        int dec = binaryToDecimal(list);

        System.out.println("Result: " + dec);
    }

    public static int binaryToDecimal(int[] binaryArray)
    {
        int sum = 0;

        for(int i = 0; i < binaryArray.length; i++)
        {
            int puissance = binaryArray.length - i - 1;
            int numero = binaryArray[i];
            sum += Math.pow(2, puissance) * numero;
        }

        return sum;
    }

}