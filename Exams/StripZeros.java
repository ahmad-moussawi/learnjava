package exams;

public class StripZeros {
    public static void main(String[] args)
    {
        int[] list = new int[] {1, 2, 3, 0, 5, 2, 6, 1, 0, 8};
        int[] newList = stripZeros(list);

        for(int a: newList)
        {
            System.out.print(a + ", ");
        }
    }

    public static int[] stripZeros(int[] list)
    {
        int count = 0, index = 0;

        for(int item: list)
            if(item != 0)
                count++;

        int[] result = new int[count];
        for(int item: list)
            if(item != 0)
                result[index++] = item;

        return result;
    }
}