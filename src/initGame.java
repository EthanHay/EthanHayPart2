import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises all values for a new game
 */
public class initGame {
    private static ArrayList deck, playedHand;
    private static int NUM_OF_CARDS_DEALT = 8;
    private static int numOfPlayers, dealerIndex;

    public initGame(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        createPlayers(numOfPlayers);
    }

    public static void startGameLoop() {
        int startingPoint = dealerIndex + 1;
        int playerID = startingPoint;
        //ArrayList currentCards, currentCard, card;
        boolean isWinner = false;

        while (!isWinner) {
            playedHand = new ArrayList();
            startingPoint = playerID;
            for (int i = 0; i < numOfPlayers; i++) {

                if (!isWinner) {
                    System.out.println("i = " + i);
                    isWinner = playHand(startingPoint);
                    if (startingPoint == 4) {
                        startingPoint = 0;
                    } else {
                        startingPoint++;
                    }
                } else {
                    System.out.println("We have a winner");
                    i = numOfPlayers; //forces for loop to close
                }
            }

        }
        System.out.println("Outside Loop");
    }

    public static boolean playHand(int playerID) {
        ArrayList currentCards, currentCard, card;
        card = new ArrayList();

        if (hasCards(playerID)) {
            if (!(playerID == 0)) {
                currentCards = (ArrayList) initPlayer.getPlayerCards(playerID);
                currentCard = (ArrayList) currentCards.toArray()[0];
                try {
                    card = (ArrayList) currentCard.toArray()[0];
                    String temp = card.toArray()[0].toString();
                    playedHand.add(temp);
                    System.out.println("PLAYER " + playerID);
                    try {
                        System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);

                    } catch (ArrayIndexOutOfBoundsException e) {

                        try {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        } catch (ArrayIndexOutOfBoundsException f) {
                            System.out.println("Player " + playerID + " Skipped");
                            return false;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    JOptionPane.showConfirmDialog(null, "Player " + playerID + "WON!");
                    System.out.println("Winner Winner Chicken Dinner");
                    return true;
                }
                currentCard.remove(0);
                return false;
            } else {
                JOptionPane.showConfirmDialog(null, "Select a card to play");
                playedHand.add(card.toArray()[0]);
                return false;
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Player "+ playerID + "WON!");
            System.out.println("Winner Winner Chicken Dinner");
            return true;
        }
    }


    private static boolean hasCards(int playerID) {
        ArrayList temp = (ArrayList) initPlayer.getPlayerCards(0);
        ArrayList temptemp = (ArrayList) temp.toArray()[0];
        //System.out.println(temptemp.toArray()[0]);
        try {
            if (temptemp.toArray()[0].equals("[]")) {
                return false;
            }


        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("WE HAVE A WINNER WITH NO CARDS " + playerID);
            return false;
        }
        return true;
    }

    public static ArrayList<initCard> buildDeck() {
        deck = new initDeck().initDeck();
        return deck;
    }

    public static int selectDealer(int numPlayers) {
        numOfPlayers = numPlayers;
        dealerIndex = new Random().nextInt(numPlayers);
        return dealerIndex;
    }

    public static ArrayList<initCard> dealCards() {
        ArrayList ret = new ArrayList();

        for (int i = 0; i < NUM_OF_CARDS_DEALT; i++) {
            int index = new Random().nextInt(deck.size());
            ArrayList temp = (ArrayList) deck.toArray()[index];
            ret.add(temp);
            deck.remove(index);
        }
        return ret;
    }

    private static void createPlayers(int numOfPlayers) {
        System.out.println(numOfPlayers);
        switch (numOfPlayers) {
            case 2:
                initPlayer.createPlayer(0);
                initPlayer.createPlayer(1);
            case 3:
                initPlayer.createPlayer(0);
                initPlayer.createPlayer(1);
                initPlayer.createPlayer(2);
            case 4:
                initPlayer.createPlayer(0);
                initPlayer.createPlayer(1);
                initPlayer.createPlayer(2);
                initPlayer.createPlayer(3);
            case 5:
                initPlayer.createPlayer(0);
                initPlayer.createPlayer(1);
                initPlayer.createPlayer(2);
                initPlayer.createPlayer(3);
                initPlayer.createPlayer(4);
        }
    }
}


