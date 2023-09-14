package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		//starting inputs
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		int startAmount = in.nextInt();
		System.out.println("What is the win probability?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit? How much money until you leave?");
		int winLimit = in.nextInt();
		System.out.println("How many days are we simulating?");
		int totalSimulations = in.nextInt();
		int wins = 0;
		int losses = 0;
		double alpha = (1-winChance)/(winChance);
		double expectedRuin = 0.0;
		if (winChance == 0.5) {
			 expectedRuin = (1 - ((double)startAmount/winLimit));
		}
		else
		{
			 expectedRuin = ((Math.pow(alpha,(double)startAmount)) - (Math.pow(alpha, (double)winLimit))) / (1-Math.pow(alpha, (double)winLimit));
				
		}
		
		//remember that this reads from L to R and is lazy, won't check both statements if
		//first is enough to reach conclusion
		for(int x = 1; x<=totalSimulations; x++) {
			int money = startAmount;
			int plays = 0;
			while ((0 < money) && (money < winLimit))
				{	plays++;
					if (Math.random() <= winChance)
						{
						money++;
						}
					else
						{
						money--;
						
						}
				}
			
			if (money == 0)
				{
				losses++;
				System.out.println("Simulation "+ x + ": "+ plays + " LOSE");
				}
			else
				{
				wins++;
				System.out.println("Simulation "+ x + ": " + plays + " WIN");
				
				}
			
	
		}
		
		double ruinRate = (double)losses/totalSimulations;
		System.out.println("Expected ruin rate is: " + expectedRuin);
		System.out.println("Ruin rate: " + ruinRate);
		
	}

}
