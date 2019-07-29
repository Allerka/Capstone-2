package co.grandcircus;


import java.util.Scanner;

// this is a concrete class that can be used over and over again
// you can also add your own validation methods here
// methods are called by other classes with Validator.methodName(args)
public class Validator {
	
	public static String getString(Scanner scan, String prompt) {
		System.out.print(prompt);
		String s = scan.nextLine(); // read user entry
		//scan.nextLine(); // discard any other data entered on the line
		return s;
	}

	public static int getInt(Scanner scan, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid value. Try again (1-5): ");
			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be between 1-5: ");
			else if (i > max)
				System.out.println("Error! Number must be between 1-5: ");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0; 
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (d > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return d;
	}

	public static String getStringMatchingRegex(Scanner scan, String prompt, String regex) {
		boolean isValid = false;

		String input;

		do {
			input = getString(scan, prompt);
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Invalid entry. Please try again.");
				
			}

		} while (!isValid);

		return input;
	}
	
	

}