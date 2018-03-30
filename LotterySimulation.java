import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;
import java.io.*;

/**
 * Write a description of class LotterySimulation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LotterySimulation
{
    public static void main(String args[]) throws IOException{
        int numberOfDrawings = 0;
        int betNum = 0;
        int dollars = 0;
        int payOff = 0;
        int winningNum = 0;
        int count = 0;
        int fileNum = 0;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for(int i =0; i < numberOfDrawings; i++) {
            winningNum = rand.nextInt(100);
            if (betNum == winningNum)
            {
                count++;
            }
            System.out.println(winningNum);
        }

        count = 0;
        FileInputStream fileByteStream = null; // File input stream
        //Scanner inFS = null;                   // Scanner object
        betNum = 0;                      // Data value from file
        dollars = 0;
        String fileName;
        System.out.print("Please enter the input file");
        Scanner sc1 = new Scanner(System.in);
        fileName = sc1.nextLine();
        System.out.println("Please enter a file name for simulation results.");
        String fileName1 = sc1.nextLine();
        System.out.println("How many drawings would you like to simulate? ");
        numberOfDrawings = sc1.nextInt();
        
        File file = new File(fileName);

        //fileByteStream = new FileInputStream(fileName);

        FileOutputStream fileByteStream2 = null; // File output stream
        PrintWriter outFS = null;               // Output stream

        fileByteStream2 = new FileOutputStream(fileName1);
        outFS = new PrintWriter(fileByteStream2);
        int payOut = 0;
        int betAmount = 0;
        for(int i = 0; i < numberOfDrawings; i++)
        {
            winningNum = rand.nextInt(100);
            outFS.println("Drawing " + (i+1) + " on winning number is " + winningNum);
            Scanner inFS = new Scanner(file);
            //inFS = inFS.reset();
            int numberOfBets = inFS.nextInt();
            for(int j = 0; j < numberOfBets; j++)
            {
                betNum = inFS.nextInt();
                dollars = inFS.nextInt();
                betAmount = betAmount + dollars;
                System.out.println(dollars);
                if( betNum == winningNum)
                {
                    outFS.println("Bet on $" + dollars + " on " + betNum + ": wins $" + (dollars*50) + "!");
                    payOut = payOut + (dollars*50);
                }
                else
                {
                    outFS.println("Bet on $" + dollars + " on " + betNum + ": loses...");
                }
            }

        }
        outFS.println("Total bets: $" + betAmount + ", total winnings: $" + payOut);
        int total = betAmount - payOut; 
        String result = "";
        if(total < 0)
        {
            result = "in the hole for";
            total = total * -1;
        }
        else if(total == 0)
        {
            result = "breaking even, you win";
            
        }
        else
        {
            result = "winning";
            
        }
        outFS.println("Overall,  you ended up " + result + " $" + total);
        outFS.flush();
    }

    public static void secondMain() {
        int numberOfDrawings = 0;
        int betNum = 0;
        int dollars = 0;
        int payOff = 0;
        int winningNum = 0;
        int count = 0;
        int fileNum = 0;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        FileInputStream inFileStream = null;
        Scanner inFile = null;
        //Please enter the name of the file with your lottery numbers and bets: sampleinput.txt
        //How many drawings would you like to simulate? 50
        //Please enter a file name for simulation results: sampleoutput.txt

        System.out.println("Please enter your number to bet on");
        betNum = sc.nextInt();
        System.out.println("\nPlease enter how much you would like to spend on each bet.");
        dollars = sc.nextInt();
        System.out.println("\nPlease enter how many bets you would like to make.");
        numberOfDrawings = sc.nextInt();

        payOff = (count * 50 * dollars) - (numberOfDrawings * dollars);
        if( payOff >= 0)
        {
            System.out.println("You made $" + payOff);
        }
        else if( payOff < 0)
        {
            System.out.println("You lost $" + payOff * -1);
        }

    }

    public static void main3() throws IOException{
        int numberOfDrawings = 0;
        int betNum = 0;
        int dollars = 0;
        int payOff = 0;
        int winningNum = 0;
        int count = 0;
        int fileNum = 0;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for(int i =0; i < numberOfDrawings; i++) {
            winningNum = rand.nextInt(100);
            if (betNum == winningNum)
            {
                count++;
            }
            System.out.println(winningNum);
        }

        count = 0;
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object
        betNum = 0;                      // Data value from file
        dollars = 0;
        String fileName;
        System.out.print("Please enter the file with the number to bet on and the amount to bet: ");
        Scanner sc1 = new Scanner(System.in);
        fileName = sc1.nextLine();

        fileByteStream = new FileInputStream(fileName);
        inFS = new Scanner(fileByteStream);

        betNum = inFS.nextInt();
        dollars = inFS.nextInt();

        System.out.println("Please enter the name of the file for the simulation output.");
        String fileName1 = null;
        fileName1 = sc1.nextLine();

        System.out.println("Please enter the number of drawings");
        numberOfDrawings = sc1.nextInt();

        for(int i =0; i < numberOfDrawings; i++) {
            winningNum = rand.nextInt(100);
            if (betNum == winningNum)
            {
                count++;
            }
        }

        payOff = (count * 50 * dollars) - (numberOfDrawings * dollars);

        FileOutputStream fileByteStream2 = null; // File output stream
        PrintWriter outFS = null;               // Output stream

        fileByteStream2 = new FileOutputStream(fileName1);
        outFS = new PrintWriter(fileByteStream2);

        // File is open and valid if we got this far (otherwise exception thrown)
        // Can now write to file
        outFS.println("Drawing winning number is " + winningNum);
        if( payOff >= 0)
        {
            outFS.println("You won $" + payOff);
        }
        else if( payOff < 0)
        {
            outFS.println("You lost $" + (payOff * -1));
        }

        outFS.flush();

    }
}