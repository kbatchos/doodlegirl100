//Kayleigh Batchos
//CSC 201 - 80M
//Calculator Method

//Imports
import java.util.*;

public class KBatchosCalculator 
{
	public static void main(String[] args) 
	{
		//Declaring Variables
		int num1 = 0, num2 = 0, choice, exit = 0, temp;
		
		//Declaring Scanner
		Scanner sc = new Scanner(System.in);
		
		//Do While Loop
		do
		{
			//Getting Input
			System.out.println("Enter your choice from the following menu");
			System.out.println("1. Addition  2. Subtraction  3. Multiplication  4. Division  5. Exit");
			choice = sc.nextInt();
			
			//Checking for Exit Code
			if(choice < 5)
			{
				System.out.println("Enter the first number: ");
				num1 = sc.nextInt();
				System.out.println("Enter the second number: ");
				num2 = sc.nextInt();
			}
			else
			{
				System.out.println("Exiting Program");
				break;
			}
			
			//Calculations
			switch(choice)
			{
				case 1:
					temp = add(num1, num2);		
					System.out.println(num1 + " + " + num2 + " = " + temp);
					break;
				case 2:
					temp = sub(num1, num2);
					System.out.println(num1 + " - " + num2 + " = " + temp);
					break;
				case 3:
					temp = mult(num1, num2);
					System.out.println(num1 + " * " + num2 + " = " + temp);
					break;
				case 4:
					if(num2 == 0)
						System.out.println("Division Denominator is Zero");
					else
					{
						temp = div(num1, num2);
						System.out.println(num1 + " / " + num2 + " = " + temp);
					}
					break;
				default:
					System.out.println("Invalid Choice");
			}
			
			//Asking User to Continue
			System.out.println("Would you like to continue? 1. Yes  2. No");
			exit = sc.nextInt();
			
		} while (exit == 1);
	}
	
	//Addition Method
	public static int add (int a, int b)
	{
		return a+b;
	}
	
	//Subtraction Method
	public static int sub (int a, int b)
	{
		return a-b;
	}
	
	//Multiplication Method
	public static int mult (int a, int b)
	{
		return a*b;
	}
	
	//Division Method
	public static int div (int a, int b)
	{
		return a/b;
	}
}
