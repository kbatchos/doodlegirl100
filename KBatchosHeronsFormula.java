// NAME             :   Kayleigh Batchos
// GROUP            :   APCS
// LAST MODIFIED    :   8 OCT 2017
// PROBLEM ID       :   Lewis 2.10 Heron's Formula Program
// DESCRIPTION      :   Computing the area of the triangle
//                  :   using the three sides of the triangle
//                  :   and Heron's formula.
// SOURCES/HELPERS  :   Mr. H., Caleb Crooks

package kbatchosheronsformula;

import java.util.Scanner;
import java.util.*;
import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
public class KBatchosHeronsFormula
{
    public static void main(String[] args) 
    {
        //Declaring variables
        final double S_FACTOR = .5;
        String lengths;
        double sPerimeter, aLength, bLength, cLength, triagArea;
        Scanner input = new Scanner(System.in);
        int numRuns;
		
		//Signature
		System.out.println("Kayleigh Batchos");
    	System.out.println( "APCS");
    	System.out.println("Lewis 1.10 Heron's Formula Program\n\n");

        //Prompting the user for number of runs
        System.out.print("Enter the number of runs:  ");
        numRuns = input.nextInt();
        
        //Running for the number of runs
        for(int k = 0; k < numRuns; k++)
        {
            //Changing all the unnecessary characters to spaces
            System.out.print("\nEnter the side lengths in (a,b,c) format:  ");
            lengths = input.next();
        
            //Splitting the string into integers
            String dlims = "[//(,//)]+";
            String divLengths[] = lengths.split(dlims);
            aLength = Double.parseDouble(divLengths[1]);
            bLength = Double.parseDouble(divLengths[2]);
            cLength = Double.parseDouble(divLengths[3]);
        
            //Calculating the distance and outputting the result
            sPerimeter = S_FACTOR *(aLength + bLength + cLength);
            triagArea = sqrt(sPerimeter * (sPerimeter - aLength) * (sPerimeter - bLength) * (sPerimeter - cLength));
            
            //Rounding the results and outputting them
            DecimalFormat fmt = new DecimalFormat ("0.000");
            System.out.print("\nThe area of the triangle is " +fmt.format(triagArea)+ "\n\n");
        }        

    }
    
}
