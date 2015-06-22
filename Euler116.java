//Colter Fatt
//Project Euler Problem #116

/***************************
This is a solution for Project Euler Problem 116
https://projecteuler.net/problem=116

Given a linear board of X spaces, how many ways can you put pieces of only size 2, only size 3, or only size 4 on the board.

My solution was based off of the fact that if you place a piece into the board, you are essentially left with one or two pieces of smaller size.For example if you have a board of size 10 and place a size 2 piece at the end of the board, you are left with a space of size 8. 

Therefore I started by counting the smaller sizes, and using those to build up to  the larger sizes.
***************************/

public class Euler116
{
	public static void main(String[] args)
	{
		//the size of the board
		int size = 50;
		
		//setting up arrays to count the solutions and store them for use with larger solutions.
		long[] combos2 = new long[size+1];
		long[] combos3 = new long[size+1];
		long[] combos4 = new long[size+1];
		
		//setting up the arrays to hold 0 for boards that are too small (i.e. there are zero ways a board of size 0 or 1 can be filled by pieces of size 2)
		combos2[0] = 0;
		combos2[1] = 0;
		
		combos3[0] = 0;
		combos3[1] = 0;
		combos3[2] = 0;
		
		combos4[0] = 0;
		combos4[1] = 0;
		combos4[2] = 0;
		combos4[3] = 0;
		
		//Counting the solutions consisting of size 2 pieces.
		//Starts at size 2 and goes to the specified size.
		for(int i=2; i<=size; i++)
		{
			long sum = 0;
			
			//for each position the first piece could be placed on the board
			for(int j=i; j>1; j--)
			{
				//gets how many ways the remaining space can be filled
				long pointsize = 1 + combos2[j-2];
				sum = sum + pointsize;
			}
			combos2[i] = sum;
		}
		
		//followed the same method for pieces of size 3 & 4
		for(int i=3; i<=size; i++)
		{
			long sum = 0;
			//for each starting point
			for(int j=i; j>2; j--)
			{
				long pointsize = 1 + combos3[j-3];
				sum = sum + pointsize;
			}
			combos3[i] = sum;
		}
		
		for(int i=4; i<=size; i++)
		{
			long sum = 0;
			//for each starting point
			for(int j=i; j>3; j--)
			{
				long pointsize = 1 + combos4[j-4];
				sum = sum + pointsize;
			}
			combos4[i] = sum;
		}
		
		System.out.println(combos2[size] + combos3[size] + combos4[size]);
		
	}
}