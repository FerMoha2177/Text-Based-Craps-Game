import java.text.DecimalFormat;
import java.util.Scanner;

/*=============================================================================
|   Source code:  Analyzer.java Craps.java Dice.java
|           Author:  Ferris Mohammed
|     Student ID:  5906707
|    Assignment:  Assignment 3 CRAPS
|
|            Course:  COP 3337
|           Section:  U02
|        Instructor:  William Feild
|        Due Date:  2/16/2017, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|
|        Language:  Java
|  Compile/Run:
| 	javac Analyzer.java  Craps.java Dice.java
|	java  Analyzer.java
|
|  +-----------------------------------------------------------------------------
|
|  Description:  Simulates the game of Craps and out stats such as wins, loss, probability of winning/losing,
|                   probability of winning/ Losing on CO roll,longest game played in rolls.
|
|        Input:  Asks User for amount of games to be played
|
|       Output:  Outputs Total games, Total rolls, probability of winning/losing,
|                   probability of winning/ Losing on CO roll,longest game played in rolls, total number of wins/losses
|                   , and average games length
|
|     Process:  Uses the craps game rules
|
|   Required Features Not Included: Does not include summary of rolls (1 -21+)
|
|
|   Known Bugs:  If user inputs a string/ char instead of integer the program will continue to ask to input a nicer value
|               , but still crashes
|  *===========================================================================*/


public class Analyzer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many games would you like to play: ");
        int globe= 0;
        boolean properIntInput = false;
        boolean properAllInput = false;
        if (input.hasNextInt())
        {
            properAllInput = true;
            int in = input.nextInt();
            globe = in;
            if ((in <= 1000000 && in > 0))
            {
                properIntInput = true;
            } else{properIntInput = false;}

        }
        else
        {
            properAllInput = false;
        }

        while (properIntInput == false || properAllInput ==  false)
        {
            System.out.println("input too large/small or not an integer, Try again");
            System.out.println("How many games would you like to play: ");
            globe = input.nextInt();

        }
        if(properIntInput == true && properAllInput ==true)
        {
            Craps crapObj = new Craps(globe);

            DecimalFormat df = new DecimalFormat("#0.00000");
            crapObj.playGame();
            System.out.println();
            System.out.println("STATS-----------------------------------------------------------");
            System.out.println("Total games      : " + crapObj.getGames());
            System.out.println("Total rolls      : " + crapObj.getTotalRolls());
            System.out.println("P(Win)           : " + df.format(crapObj.probOfWin()));
            System.out.println("P(Win CO Roll)   : " + df.format(crapObj.probOfCOWin()));
            System.out.println("P(Lose CO Roll)  : " + df.format(crapObj.probOfCOLoss()));
            System.out.println("Mean Game Length : " + df.format(crapObj.averageRollsPerGame()));
            System.out.println("Number of wins   : " + crapObj.getNumOfWins());
            System.out.println("Number of Losses : " + crapObj.getNumOfLoss());
            System.out.println("Coming out Wins  : " + crapObj.getCOWin());
            System.out.println("Coming out LOSSES: " + crapObj.getCOLoss());
            System.out.println("Longest Game     : " + crapObj.getLongestRoll() + " rolls");
            System.out.println("STATS-----------------------------------------------------------");
        }
    }

}
