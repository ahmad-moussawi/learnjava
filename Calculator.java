public class Calculator
{
	public static void main(String[] args)
	{
		int left = Integer.parseInt(args[0]), right = Integer.parseInt(args[2]);

		if(args[1].equals("+"))
		{
			System.out.println(left + right);
			return;
		}

		if(args[1].equals("-"))
		{
			System.out.println(left - right);
			return;
		}

		if(args[1].equals("M"))
		{
			System.out.println(left * right);
			return;
		}

		if(args[1].equals("D"))
		{
			System.out.println(left / right);
			return;
		}

		System.out.println("Unknown operator: " + args[1] + ", Available operators: + - M D");

	}
}
