//Kayleigh Batchos
//CSC 201 - 80YM
//Finding the Largest and Second Largest Number

//Imports
import java.util.Scanner;

public class StarTriangle
{
   public static void main(String[] args)
   {
      //Defining Scanner
      Scanner keyboard = new Scanner(System.in);
      
      //Defining Variables
      int size;
      
      System.out.println("Enter size of the triangle: ");
      size = keyboard.nextInt();
      
     //Shifted Left Triangle Upward
     System.out.println("Upward Left-Shifted Traingle:");
      for(int j = 0; j < size; j++)
      {
         for(int i = 0; i <= j; i++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
      
      //Shifted Left Triangle Downward
      System.out.println("Downwards Left-Shifted Traingle:");
      for(int r = size; r > 0; r--)
      {
         for(int s = 1; s <= r; s++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
      
      //Shifted Right Traingle Upward
      System.out.println("Upwards Right-Shifted Traingle:");
      for(int a = 0; a < size; a++)
      {
         for(int b = 0; b <= size-a; b++)
         {
            System.out.print(" ");
         }
         for(int c = 0; c <= a; c++)
         {
            System.out.print("*");
         }
         System.out.println();
      }  
      
      //Shifted Right Traingle Downward
      System.out.println("Upwards Right-Shifted Traingle:");
      for(int l = size; l > 0; l--)
      {
         for(int m = 1; m <= size-l; m++)
         {
            System.out.print(" ");
         }
         for(int n = 1; n <= l; n++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
      
   }
}