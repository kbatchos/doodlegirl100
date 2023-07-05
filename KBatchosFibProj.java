// NAME             :   Kayleigh Batchos
// GROUP            :   APCS
// LAST MODIFIED    :   6 MAR 2018
// PROBLEM ID       :   Shorts 8.4 Fibonacci
// DESCRIPTION      :   Recursively does math
//                  :   to find the Nth number
//                  :   in the fibonacci sequence
// SOURCES/HELPERS  :   Mr. H., Lewis Book

package kbatchosfibproj;

import java.util.*;
public class KBatchosFibProj 
{
	//FibSequence method
	private static int sum1, sum2;
	public static void FibSequence(int currentNum, int endNum)
	{
		int temp;
		if(currentNum == endNum)
		{
			System.out.print(sum1 + sum2 + "\n\n");
		}
		else if(currentNum == 1)
		{
			System.out.print(sum2 + " ");
			currentNum++;
			FibSequence(currentNum, endNum);
		}
		else
		{
			temp = sum2;
			sum2 += sum1;
			sum1 = temp;
			System.out.print(sum2 + " ");
			currentNum++;
			FibSequence(currentNum, endNum);
		}
	}
	
    public static void main(String[] args) 
    {
        //Declaring Variables
        Scanner scan = new Scanner(System.in);
        int numRuns, limit, answer;
        
        //Signature
        System.out.print("Kayleigh Batchos\nAPCS\nShorts Fibonacci\n\n\n");
        
        //Asking for numRuns
        System.out.print("Num runs:  ");
        numRuns = scan.nextInt();
        System.out.print("\n");
        
        ///Repeating for numRuns
        for(int p = 0; p < numRuns; p++)
        {
            sum1 = 0;
            sum2 = 1;
			
			//Asking for input
            System.out.print("How far:  ");
            limit = scan.nextInt();
            .
            FibSequence(1, limit);
        }
    }
    
}

