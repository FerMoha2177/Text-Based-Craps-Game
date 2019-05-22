/**
 * Created by Ferris on 2/13/2017.
 */
import java.util.Random;
public class Dice
{
    private int numOfSides;

    public Dice(int sides)
    {
        this.numOfSides = sides;

    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public int rollDie()
    {
        Random wonkyDice = new Random();

        int roll = wonkyDice.nextInt(numOfSides)+1;

        return roll;
        //simulates rolling of die with random numbers

    }

}