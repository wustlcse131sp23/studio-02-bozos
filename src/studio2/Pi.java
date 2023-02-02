package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.println("How many simulations will you run?");
		double totalSimulations = in.nextDouble();
		
		double inCircle = 0;

		for (int i = 0; i < totalSimulations; i++)
		{
			double x = Math.random();
			double y = Math.random();
			
			double x_difference = x - 0.5;
			double y_difference = y - 0.5;
			double dist = Math.sqrt(Math.pow(x_difference, 2) + Math.pow(y_difference, 2));
			
			if (dist < 0.5)
			{
				inCircle++;
			}
		}
		
		double pi = 4 * (inCircle/totalSimulations);
		System.out.println("Pi Approximation: " + pi);
	}

}
