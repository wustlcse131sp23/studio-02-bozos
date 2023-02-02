package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money do you start with?");
		double startAmount = in.nextDouble();
		System.out.println("What is the chance of winning? (0% - 100%)");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How mant simulations will you run?");
		int totalSimulations = in.nextInt();
		
		int day = 1;
		double wins = 0;
		double losses = 0;
		
		for (int i = 0; i < totalSimulations; i++)
		{
			
			
			double total = startAmount;
			int plays = 0;
			
			while (total > 0 && total < winLimit)
			{
				double chance = Math.random();
				if (chance < (winChance/100.0)) 
				{
					total++;
					plays++;
				}
				else
				{
					total--;
					plays++;
				}
			}
			
			if (total >= winLimit) {
				wins++;
				System.out.println("Simulation " + day + ": " + plays + " WIN");
				day++;
			}
			else
			{
				losses++;
				System.out.println("Simulation " + day + ": " + plays + " Loss");
				day++;
			}
		}
		
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		
		double SimRuinRate = losses/totalSimulations;
		double ruinRate;
		
		if (winChance == 50)
		{
			ruinRate = 1.0 - (startAmount/winLimit);
		}
		else
		{
			double a = (1 - (winChance/100.0))/(winChance/100.0);
			ruinRate = ((Math.pow(a, startAmount)) - (Math.pow(a, winLimit)))/(1 - Math.pow(a, winLimit));
		}
		
		System.out.println("Ruin Rate from simulation: " + SimRuinRate + " Expected Ruin Rate: " + ruinRate);
	}

}
