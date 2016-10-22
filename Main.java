/**
 * Created by Ethan on 13-Sep-16.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int numOfPlayers;


    public static void main(String[] args) {
        showWelcome();
        showMenu(); //Also gets user choice and can start game.
    }


    private static void showWelcome() {
        System.out.println("Welcome to Mineral SuperTrumps!");
    }


    private static void showMenu() {
        String start;
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish to start a new game? \nY/N\n");
        start = input.next();
        getUserMenuChoice(start);
    }


    private static void startGame() {
        int dealerIndex;

        System.out.println("Starting new game...");
        System.out.println("Building new deck...");

        ArrayList deck = initGame.buildDeck();
//        ArrayList test = (ArrayList) deck.toArray()[0];
//        System.out.println(test.toArray()[0]);
        System.out.println("");
        System.out.println("");
        System.out.println("Finished building...");
        System.out.println("");
        getNumberOfBots();
        System.out.println("");
        System.out.println("");
        System.out.println("Selecting dealer...");
        dealerIndex = initGame.selectDealer(numOfPlayers);
        System.out.println("The Dealer is: Player" + dealerIndex);
        System.out.println("");
        initGame game = new initGame(numOfPlayers);
        System.out.println("Players initialised...");
        System.out.println("");
        System.out.println("Starting Game...");
        System.out.println("#######################################################");
//        ArrayList player1Cards = (ArrayList) initPlayer.getPlayerCards(0);
//        System.out.println(player1Cards);
        initGame.startGameLoop(dealerIndex);
    }


    private static void getUserMenuChoice(String choice) {
        String start = choice.toUpperCase();
        Scanner input = new Scanner(System.in);
        //validate input
        while (!(start.equals("Y") || start.equals("N") || start.equals("E"))) {
            System.out.println("The value entered is invalid...");
            System.out.print("Do you wish to start a new game?  or (E)xit \nY/N\n");
            start = input.next();
            start = start.toUpperCase();
        }
        //double check input and act on input
        if (start.equals("Y") || start.equals("N")) {
            if (start.equals("Y")) {
                //Start game
                startGame();
            } else {
                //go back to menu/ ask to continue/load game
                System.out.printf("Start = " + start);
            }
        } else if (start.equals("E")) {
            //exit application
            System.out.printf("Closing Application...");
        }

    }


    private static void getNumberOfBots() {
        String players;
        Scanner input = new Scanner(System.in);

        System.out.println("How many bots do you want to verse? (2 - 4)");
        while (!input.hasNextInt()) {
            System.out.println("That's not a number!");
            System.out.println("Please enter a valid number...");
            System.out.println("How many bots do you want to verse? (2 - 4)");
            input.next();
        }
        players = input.next();

        //check players input
        while (Integer.parseInt(players) < 2 || Integer.parseInt(players) > 4) {
            System.out.println("Please enter a valid number...");
            System.out.println("How many bots do you want to verse? (2 - 4)");
            players = input.next();
        }
        numOfPlayers = Integer.parseInt(players) + 1;

    }


}