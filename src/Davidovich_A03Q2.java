/**
 * Created by MDavidovich on 7/13/16.
 *
 * This program uses the PairOfDice class to simulate rolling a pair of dice.  The program
 * rolls the pair 500 times and counts the number of times snake eyes has been rolled (i.e.
 * the sum of the dice equal two.  The program will also calcuate a ratio of number of times
 * snakes eyes has been rolled to the total number of rolls.
 *
 * This program demonstrates how classes can call upon other static classes.
 */

public class Davidovich_A03Q2 {

    public static class Die             // This class was previously created by
    {                                   // the instructor.
        private final int MAX = 6;
        private int faceValue;

        public Die()
        {

            faceValue = 1;
        }
        public int roll()
        {
            faceValue = (int)(Math.random() * MAX) + 1;
            return faceValue;
        }

        public void setFaceValue(int value)
        {
            if(value > 0 && value <= MAX)
                faceValue = value;
        }
        public int getFaceValue()
        {
            return faceValue;
        }

        public String toString()
        {
            String result = Integer.toString(faceValue);
            return result;
        }
    }
    public static class PairOfDice          // New class uses Die class to simulate
    {                                       // a pari of dice.  Upon initilization,
        private Die die1;                   // two Die objects are created an manipulated
        private Die die2;                   // to represent two dice.
        private int sumDice;

        public PairOfDice()
        {
            die1 = new Die();
            die2 = new Die();
        }
        public int rollPair()               // rollPair returns the sum of the two dice, not
        {                                   // the indiviudal values.
            die1.roll();
            die2.roll();
            return die1.getFaceValue() + die2.getFaceValue();
        }
        public int setDie1(int value)       // User can set the face value of each die.
        {
            die1.setFaceValue(value);
            return die1.getFaceValue();
        }
        public int setDie2(int value)
        {
            die2.setFaceValue(value);
            return die2.getFaceValue();
        }
        public int sumOfDice()              // The sum of dice can be caluclauted outside
        {                                   // the roll method.
            return die1.getFaceValue() + die2.getFaceValue();
        }
    }
    public static void main(String[] args)
    {
        final int ROLLS = 500;              // This iterator was created by the instructor/
        int count = 0;
        int sumDice;

        PairOfDice pair1 = new PairOfDice();

        for(int roll = 1; roll <= ROLLS; roll++)
        {
            pair1.rollPair();               //  Iterator checks to see if the sum of dice
            sumDice = pair1.sumOfDice();    // equals two which indicates snake eyes.
            if (sumDice == 2)
                count++;
        }

        System.out.println("Number of rolls: " + ROLLS);
        System.out.println("Number of snake eyes: " + count);
        System.out.println("Ratio: " + (double)count / ROLLS);
    }
}
