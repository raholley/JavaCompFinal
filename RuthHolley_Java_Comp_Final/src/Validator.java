
import java.util.Scanner;

public class Validator
{
    public static String getLine(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();        // read the whole line
        return s;
    }

    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();        // read the first string on the line
        sc.nextLine();               // discard the rest of the line
        return s;
    }

    public static int getInt(Scanner sc, String prompt)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(Scanner sc, String prompt)
    {
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt,
    double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(sc, prompt);
            if (d <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (d >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return d;
    }
    
    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) 
	{
		int number = 0;
		boolean isValid = false;
		
		while(isValid == false) 
		{
			number = getInt(sc, prompt);
			
			if (number < min) 
			{
				System.out.println("Error! Number must be greater than " + (min - 1));
			}
			else if (number > max) 
			{
				System.out.println("Error! Number must be less than " + (max + 1));
			}
			else 
			{
				isValid = true;
				break;
			}
		}
		return number;
	}
    
    //user to enter String value and returns the value entered.
    public static String getRequiredString(String prompt, Scanner sc) 
	{
		String s = "";
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			s = sc.nextLine();
			if (s.equals("")) 
			{
				System.out.println("Error! This entry is required. Try again. \n");
			}
			else
			{
				isValid = true;
			}
		}
		return s;
	}
    
    
    
    
}