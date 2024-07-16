/*
Blackjack game 
Created by Donagh Ó Briain
 */

package blackjack; //Package

import java.util.Random;  // Imports the Random class for random generations.
import java.util.Scanner; // Imports the Scanner class for the input operations.

public class Cardgame { //Declaring the class

	public static void main(String[] args) { //Declaring the main

		Scanner input = new Scanner (System.in); //declaring the scanner

		System.out.println("Please enter your name:"); //prompt asking user for name
		String player1;  //Create string for player 1
		player1 = input.nextLine(); // reading name of user
		System.out.println("Please enter your age:"); //prompt asking user for age
		int age1; //Create int for player 1
		age1 = input.nextInt(); //reading the age of the user
		
		// if statement to check if the user is underage
		if (age1 < 18) { 

			System.out.println("You are not old enough!");
			System.out.println("Blackjack will be closing now");
			System.exit(0); //exits
		}
		
		System.out.println("Please enter your name:"); //prompt asking for users name
		String player2; //Create string for player 2
		input.nextLine(); // clearing the ouput (from previous int)
		player2 = input.nextLine(); // Take in name of user
		System.out.println("Please enter your age:"); //prompt asking for users age
		int age2; //Create int for player 2
		age2 = input.nextInt(); //Take int from user 
		input.nextLine(); // clearing the ouput (from previous int)
		
		//if statement to check if user is underage
		if (age2 < 18) {	

			System.out.println("You are not old enough!");
			System.out.println("Blackjack will be closing now");
			System.exit(0); //exits
		}

		System.out.println("-----" + player1 + "'s turn-----");
		System.out.println("Here are your first two cards");
		Random random = new Random(age1 + age2); // Initialising random number generator (using ages as seed)

		//Two random cards for player 1
		int totalrandom2 = 0;
		int totalrandom1 = 0;

		//for loop to randomly generate numbers
		for (int i = 0; i < 2; i++) { 

			int random1 = random.nextInt(1, 13); //Create player 1's random card integer

			//if statement to ensure facecards = 10
			if ( random1 > 10 ) { 
				totalrandom1 += 10;
				System.out.println(10);
			} else {
				totalrandom1 += random1; //Add player 1's random card to the total
				System.out.println(random1);

				//If statement if the player goes bust 
				if(totalrandom1>21) {
					System.out.print(player1 + " has gone bust. " + player2 + " has won the game.");
					System.exit(0);	//Exit	
				}
			}

		}

		int i;
		for(i = 0; i<3; i++ ) { //for loop prompting user to either hit or stand
			System.out.println("Would you like to Hit or Stand?");
			String move1 = input.nextLine();//Take in input for player 1's move

			//if statement for if user picks hit
			if(move1.equalsIgnoreCase("hit")) { 
				System.out.println("you have hit");
				int random1 = random.nextInt(1, 13); //random number from 1-13
				
				//If statement to make sure facecard over 10 is equal to 10.
				if ( random1 > 10 ) { 
					totalrandom1 += 10;
					System.out.println(10);	
				} else {
					totalrandom1 += random1;//Adds player 1's random cards together
				}
				System.out.println(random1);
				
				//If statement to make sure if users cards add up to 21 they lose
				if(totalrandom1>21) {
					System.out.print(player1 + " has gone bust. " + player2 + " has won the game.");
					System.exit(0);				
				}


			} 
			//if user decides to stand, the loop breaks
			else if(move1.equalsIgnoreCase("stand")) { 
				System.out.println("You have chosen to stand");
				break;
			}

		}
		
		System.out.println("-----" + player2 + "'s turn-----");
		System.out.println("Here are your first two cards");
		i=0;
		int random2 = 0; //Create player 2's random card integer
		
		//While loop to generate two cards
		while( i < 2 )	{ 
			
			random2 = random.nextInt(1, 13);
			
			//If statement making sure if facecard is above 10 its equal to 10
			if ( random2 > 10 ) {
				totalrandom2 += 10;
			} else {
				totalrandom2 += random2; //Add card to the total
			}
			
			//If statement for if the player goes bust
			if(totalrandom2>21) {
				System.out.print(player2 + " has gone bust. " + player1 + " has won the game"); // Print result
				System.exit(0);//Exit
			}

			System.out.println(random2);	

			i++;
		}
		
		// While loop prompting user either hit or stand
		while( i < 5 ) {

			//prompt asking hit or stand
			System.out.println("Would you like to Hit or Stand?"); 
			String move2 = input.nextLine(); // getting user decision
			
			//If statement if user chooses hit
			if(move2.equalsIgnoreCase("hit")) { 
				System.out.println("you have hit");
				random2 = random.nextInt(1, 13);
				
				//If statement making sure any facecard above 10 is equal to 10
				if ( random2 > 10 ) {
					totalrandom2 += 10;
				} else {
					totalrandom2 += random2; //Add numbers onto total
				}
				System.out.println(random2);	

				//If statement for if player goes bust
				if(totalrandom2>21) {
					System.out.print(player2 + " has gone bust. " + player1 + " has won the game");
					System.exit(0);//Exit
				}
				
				
				//Else if statement if player 2 chooses to stand
			} else if(move2.equalsIgnoreCase("stand")) {
				System.out.println("You have chosen to stand.");
				break;//Break while loop
			}
			i++;
		}

		System.out.println("-----End of game-----");
		System.out.println(player1 + "'s score is:" + totalrandom1); //Show player 1's score
		System.out.println(player2 + "'s score is:" + totalrandom2); //Show player 2's score

		// Printing the result of the game
		if(totalrandom1 > totalrandom2) {
			System.out.println("The winner is " + player1);
			System.exit(0);//Exit 

		} else if(totalrandom1==totalrandom2) {
			System.out.print("The game is a tie");
			System.exit(0);//Exit 

		} else {
			System.out.println("The winner is " + player2);
			System.exit(0);//Exit 
		}

		input.close(); // Closes the scanner
	}
}


