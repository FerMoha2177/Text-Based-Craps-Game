/**
 * Created by Ferris on 2/13/2017.
 */
public class Craps {
    private int totalRolls;
    private int sumOfPoints;
    private double numOfWins;
    private double numOfLoss;
    private int rollsInGame;
    private int longestRoll;
    private int COWin;
    private int COLoss;
    public final int NATURAL = 7;
    public final int YOLEVEN = 11;
    public final int SNAKE_EYES = 2;
    public final int ACE_DEUCE = 3;
    public final int BOX_CARS = 12;

    Dice d1 = new Dice(6);
    Dice d2 = new Dice(6);

    private boolean gameStatus = false; //false is loss true is  win
    private boolean comingOut = false;
    private int games;

    /**
     * Constructor takes the amount of agames user wants as the parameter
     * @param ggames
     */
    public Craps(int ggames) {
        this.games = ggames;
    }
    /**
     * Getters and Setters for Instance variables
     *
     */

    public int getLongestRoll() {
        return longestRoll;
    }


    public void setLongestRoll(int longestRoll) {
        this.longestRoll = longestRoll;
    }

    public double getNumOfLoss() {
        return numOfLoss;
    }

    public void setNumOfLoss(int numOfLoss) {
        this.numOfLoss = numOfLoss;
    }

    public void setNumofWins(int numofWins) {
        this.numOfWins = numofWins;
    }

    public int getSumOfPoints() {
        return sumOfPoints;
    }

    public void setSumOfPoints(int sumOfPoints) {
        this.sumOfPoints = sumOfPoints;
    }

    public int getTotalRolls() {
        return totalRolls;
    }

    public void setTotalRolls(int totalRolls) {
        this.totalRolls = totalRolls;
    }

    public int getRollsInGame() {
        return rollsInGame;
    }

    public void setRollsInGame(int rollsInGame) {
        this.rollsInGame = rollsInGame;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public void setComingOut(boolean comingOut) {
        this.comingOut = comingOut;
    }

    public double getNumOfWins() {
        return numOfWins;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public boolean isGameStatus() {

        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }


    /**
     * Checks to see if the roll int the game is the COming out roll
     * @return if true if roll is coming out or false if not.
     */
    public boolean isComingOut() {
        if (rollsInGame == 0) {
            comingOut = true;
        } else {
            comingOut = false;
        }

        return comingOut;
    }

    /**
     * Take the point in the game as parameter
     * sets point to 0
     * sets rolls in game to 0
     * checks for Coming out roll
     * @param point
     */

    public void resetGame(int point) {
        rollsInGame = 0;
        point = 0;
        isComingOut();
        //playGame();

    }

    public int getCOWin() {
        return COWin;
    }

    public int getCOLoss() {
        return COLoss;
    }

    /**
     * The Craps rules for the game is implemented here
     *
     */

    //Get rid magic number later
    public void playGame() {
        int inc = 0;
        int sum;
        int point;
        for (int loop = 0; loop <= games; loop++) {
            sum = d1.rollDie() + d2.rollDie();
            isComingOut();
            probOfCOWin();
            probOfCOLoss();
            totalRolls++;
            rollsInGame++;
            point = sum;
            if (point == NATURAL || point == YOLEVEN) {
                numOfWins++;
                COWin++;

                System.out.println("WIN!");
                resetGame(point);
            } else if (point == SNAKE_EYES || point == ACE_DEUCE || point == BOX_CARS) {
                numOfLoss++;
                COLoss++;
                resetGame(point);
                System.out.println("LOSS ON CO ROLL");

            } else if (point != SNAKE_EYES || point != ACE_DEUCE || point != BOX_CARS) {
                keepRolling(point);
                System.out.println("KEPT ROLLING");
            }

        }
    }

    /**
     * Takes point in the games as parameter.
     *
     * @param point
     */
    public void keepRolling(int point) {
        int point2 = 0;
        do {
            point2 = d1.rollDie() + d2.rollDie();
            totalRolls++;
            rollsInGame++;
            longestRoll = rollsInGame;
            if(rollsInGame >  longestRoll)
            {
                longestRoll = rollsInGame;
            }
            System.out.println("POINT!");

        }
        while(point2 != NATURAL);
        //while (point2 != point || point2 != NATURAL);//while game isn't lost
        if (point2 == point || point == NATURAL) {
            numOfWins++;
            System.out.println("FINALLY YOU WIN!");
            resetGame(point);

        } else {
            numOfLoss++;
            System.out.println("FINALLY YOU LOSE!");
            resetGame(point);
        }
    }


    public double probOfWin() {
        if (numOfLoss == 0) {
            return 1.00;
        }
        return (double) (numOfWins / numOfLoss);
    }

    public double probOfCOWin() {
        double oddOfSeven = 6.0 / 36.0;
        double oddsOfEleven = 2.0 / 36.0;
        if (isComingOut() == true) {
            return (oddOfSeven + oddsOfEleven);
        } else {
            return 0.0;
        }
    }

    public double probOfCOLoss() {
        double oddOfTwo = 1.0 / 36.0;
        double oddOfThree = 2.0 / 36.0;
        double oddOfTwelve = 1.0 / 36.0;
        if (isComingOut() == true) {
            return (oddOfTwo + oddOfThree + oddOfTwelve);
        } else {
            return 0.0;
        }
    }

    public int getCOLosses() {

        while (isComingOut() == true && gameStatus == false) {
            COLoss++;
        }
        return COLoss;
    }

    public double averageRollsPerGame() {
        return (double) (totalRolls / games);
    }

}

