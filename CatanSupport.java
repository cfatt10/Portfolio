//Colter Fatt
//Settler's of Catan Resource Tracker

/****************************

This app was started so I could keep track of resources during family games of Catan. This text based app was written in ~25 minutes, please excuse any bugs.


To work this program enter one of the following commands
Commands can be abbrieviated as much as you seen fit as long as the first letter remains the same

Quit = Quits the program
Blank = Resets all the rolls and resources to zero
Rolls = Shows what resources you get on each number
Current = Shows how many of each resource you have
New 'number' 'resource' = Adds an instance of the specified resource to the specified dice roll
Add 'number' 'resource' = Adds the specified number of resources to the specified resource
Subtract 'number' resource' = Subtracts the specified number of resources from the specified resource
'Any number 2-12 except 7' = Treats this as a dice roll and adds the appropriate resources
Help = Shows the help screen and how to use the app

****************************/

import java.util.Scanner;
import java.util.ArrayList;

public class CatanSupport
{
	public static void main(String[] args)
	{
		//holds what resources you roll on each number
		String[] rolls = {"", "", "", "", "", "", "", "", "", "", "", ""};
		
		//your current resource totals
		int wool = 0;
		int brick = 0;
		int lumber = 0;
		int grain = 0;
		int ore = 0;
		
		
		System.out.println("Welcome to my Settlers of Catan Resource Tracker!");
		System.out.println("by Colter Fatt");
		System.out.println("Type in a command below or type help for instructions");

		Scanner scanner = new Scanner(System.in);
		String input = "";

		//main logic loop
		while(true)
		{
			input = scanner.nextLine();
			
			//quits if the first letter is Q
			if(input.substring(0,1).equalsIgnoreCase("q"))
			{
				break;
			}
			
			//prints what resources you get on what rolls if the first letter is R
			else if(input.substring(0,1).equalsIgnoreCase("r"))
			{
				System.out.println("2: "+ rolls[1]);
				System.out.println("3: "+ rolls[2]);
				System.out.println("4: "+ rolls[3]);
				System.out.println("5: "+ rolls[4]);
				System.out.println("6: "+ rolls[5]+"\n");
				System.out.println("8: "+ rolls[7]);
				System.out.println("9: "+ rolls[8]);
				System.out.println("10: "+ rolls[9]);
				System.out.println("11: "+ rolls[10]);
				System.out.println("12: "+ rolls[11]);
			}
			
			//prints your current resource totals if the first letter is C
			else if(input.substring(0,1).equalsIgnoreCase("c"))
			{
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//adds a new resource to your rolls
			else if(input.substring(0,1).equalsIgnoreCase("n"))
			{
				try
				{
					String[] working = input.split(" ");
					int value = Integer.parseInt(working[1]);
					
					//checks to make it's a legal number
					if(value < 2 || value == 7 || value > 12)
					{
						System.out.println("Dice roll out of range, please try a number 2-12 except 7");
					}
					//parses strings to determine what resource to add
					else if(working[2].equalsIgnoreCase("wool") || working[2].equalsIgnoreCase("brick") || working[2].equalsIgnoreCase("lumber") || working[2].equalsIgnoreCase("grain") || working[2].equalsIgnoreCase("ore"))
					{
						rolls[value-1] += (working[2]+" ");
						System.out.println("2: "+ rolls[1]);
						System.out.println("3: "+ rolls[2]);
						System.out.println("4: "+ rolls[3]);
						System.out.println("5: "+ rolls[4]);
						System.out.println("6: "+ rolls[5]+"\n");
						System.out.println("8: "+ rolls[7]);
						System.out.println("9: "+ rolls[8]);
						System.out.println("10: "+ rolls[9]);
						System.out.println("11: "+ rolls[10]);
						System.out.println("12: "+ rolls[11]);
					}
					
					//if the resource is not valid
					else
					{
						System.out.println("Invalid resource. Make sure you are typing wool, brick, lumber, grain, or ore.");
					}
				}
				
				//if the number is not a number
				catch(NumberFormatException e)
				{
					System.out.println("Incorrect Syntax\nProper Syntax:\"new number resource\"");
				}
			}
			
			//adds the specified number of the specified resource then prints out your resources if the first letter is A
			else if(input.substring(0,1).equalsIgnoreCase("a"))
			{
				try
				{
					//does string parsing to determine what resource to add
					String[] working = input.split(" ");
					int value = Integer.parseInt(working[1]);
					
					if(working[2].equalsIgnoreCase("wool"))
					{
						wool += value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("brick"))
					{
						brick += value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("lumber"))
					{
						lumber += value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("grain"))
					{
						grain += value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("ore"))
					{
						ore += value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					//if the user does not type a valid resource name
					else
					{
						System.out.println("Invalid resource. Make sure you are typing wool, brick, lumber, grain, or ore.");
					}
				}
				
				//if the user doesn't type a number
				catch(NumberFormatException e)
				{
					System.out.println("Incorrect Syntax\nProper Syntax:\"add number resource\"");
				}
			}
			
			//removes the specified number of the specified resource then prints out the users resource totals if the first letter is S
			else if(input.substring(0,1).equalsIgnoreCase("s"))
			{
				try
				{
					//uses string parsing to determine which resource to deduct
					String[] working = input.split(" ");
					int value = Integer.parseInt(working[1]);
					
					if(working[2].equalsIgnoreCase("wool"))
					{
						wool -= value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("brick"))
					{
						brick -= value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("lumber"))
					{
						lumber -= value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("grain"))
					{
						grain -= value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					else if(working[2].equalsIgnoreCase("ore"))
					{
						ore -= value;
						System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
					}
					
					//if the user doesn't enter a valid resource.
					else
					{
						System.out.println("Invalid resource. Make sure you are typing wool, brick, lumber, grain, or ore.");
					}
				}
				
				//if the user doesn't enter a valid number
				catch(NumberFormatException e)
				{
					System.out.println("Incorrect Syntax\nProper Syntax:\"add number resource\"");
				}
			}
			
			//if the roll equals 2, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("2"))
			{
				String[] working = rolls[1].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 3, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("3"))
			{
				String[] working = rolls[2].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 4, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("4"))
			{
				String[] working = rolls[3].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 5, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("5"))
			{
				String[] working = rolls[4].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 6, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("6"))
			{
				String[] working = rolls[5].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 8, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("8"))
			{
				String[] working = rolls[7].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 9, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("9"))
			{
				String[] working = rolls[8].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 10, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("10"))
			{
				String[] working = rolls[9].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 11, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("11"))
			{
				String[] working = rolls[10].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//if the roll equals 12, add the appropriate resources then print out the resource totals
			else if(input.substring(0,1).equalsIgnoreCase("12"))
			{
				String[] working = rolls[11].split(" ");
				for(String word : working)
				{
					if(word.equalsIgnoreCase("wool"))
					{
						wool += 1;
						
					}
					else if(word.equalsIgnoreCase("brick"))
					{
						brick += 1;
					}
					else if(word.equalsIgnoreCase("lumber"))
					{
						lumber += 1;
					}
					else if(word.equalsIgnoreCase("grain"))
					{
						grain += 1;
					}
					else if(word.equalsIgnoreCase("ore"))
					{
						ore += 1;
					}
				}
				System.out.println("Wool: " + wool + "   Brick: " + brick + "   Lumber: " + lumber + "   Grain: " + grain + "   Ore: " + ore);
			}
			
			//Resets the resource counts and totals if the first letter is B
			else if(input.substring(0,1).equalsIgnoreCase("b"))
			{
				wool = 0;
				brick = 0;
				lumber = 0;
				grain = 0;
				ore = 0;
				rolls[0] = "";
				rolls[1] = "";
				rolls[2] = "";
				rolls[3] = "";
				rolls[4] = "";
				rolls[5] = "";
				rolls[6] = "";
				rolls[7] = "";
				rolls[8] = "";
				rolls[9] = "";
				rolls[10] = "";
				rolls[11] = "";
				System.out.println("Values Reset");
			}
			
			//prints out a list of commands if the first letter is H
			else if(input.substring(0,1).equalsIgnoreCase("h"))
			{
				System.out.println("Welcome to the Help Screen!");
				System.out.println("To work this program enter one of the following commands");
				System.out.println("Commands can be abbrieviated as much as you seen fit as long as the first letter remains the same\n");
				System.out.println("Quit. Quits the program");
				System.out.println("Blank. Resets all the rolls and resources to zero");
				System.out.println("Rolls. Shows what resources you get on each number");
				System.out.println("Current. Shows how many of each resource you have");
				System.out.println("New 'number' 'resource'. Adds an instance of the specified resource to the specified dice roll");
				System.out.println("Add 'number' 'resource'. Adds the specified number of resources to the specified resource");
				System.out.println("Subtract 'number' resource'. Subtracts the specified number of resources from the specified resource");
				System.out.println("'Any number 2-12 except 7'. Treats this as a dice roll and adds the appropriate resources.");
			
			}
			
			//prints a message if the user does not enter a valid command
			else
			{
				System.out.println("Command Not Recognized. Type 'help' for instructions");
			}
		}
	}
}