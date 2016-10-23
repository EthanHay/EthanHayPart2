/**
 * Created by Ethan on 13-Sep-16.
 */

import sun.util.locale.provider.JRELocaleConstants;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.createMainMenu();
        frame.setVisible(true);
        startGame(5);
    }

    private static void startGame(int numOfPlayers) {
        int dealerIndex;

        System.out.println("Starting new game...");
        System.out.println("Building new deck...");
        ArrayList deck = initGame.buildDeck();
        System.out.println("Finished building...");
        System.out.println("");
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

    }



}