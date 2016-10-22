import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises all values for a new game
 */
public class initGame {
    private static ArrayList deck;
    private static int NUM_OF_CARDS_DEALT = 8;
    private static int numOfPlayers;

    public initGame(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        createPlayers(numOfPlayers);
    }

    public static void startGameLoop(int dealer) {
        int startingPoint = dealer + 1;
        int playerID = startingPoint;
        ArrayList currentCards = new ArrayList();
        ArrayList currentCard = new ArrayList();
        ArrayList card = new ArrayList();

        if (hasCards(startingPoint)) {
            //play first card in hand
            currentCards = (ArrayList) initPlayer.getPlayerCards(dealer);
            currentCard = (ArrayList) currentCards.toArray()[0];
            card = (ArrayList) currentCard.toArray()[0];
            System.out.println("PLAYER "+dealer);
            try {
                System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
            }

            card.remove(0);
        }
        for (int i = 0; i < 99999; i++) {
            switch (playerID) {
                case 0:
                    if (hasCards(0)) {
                        currentCards = (ArrayList) initPlayer.getPlayerCards(0);
                        currentCard = (ArrayList) currentCards.toArray()[0];
                        card = (ArrayList) currentCard.toArray()[0];
                        System.out.println("PLAYER 1");
                        try {
                            System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        }
                        card.remove(0);
                        playerID = 1;
                        break;
                    }
                    System.out.println("card not found");
                case 1:
                    if (hasCards(1)) {
                        currentCards = (ArrayList) initPlayer.getPlayerCards(0);
                        currentCard = (ArrayList) currentCards.toArray()[0];
                        card = (ArrayList) currentCard.toArray()[0];
                        System.out.println("PLAYER 2");
                        try {
                            System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        }
                        card.remove(0);
                        playerID = 2;
                        break;
                    }
                    System.out.println("card not found");
                case 2:
                    if (hasCards(2)) {
                        currentCards = (ArrayList) initPlayer.getPlayerCards(0);
                        currentCard = (ArrayList) currentCards.toArray()[0];
                        card = (ArrayList) currentCard.toArray()[0];
                        System.out.println("PLAYER 3");
                        try {
                            System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        }
                        card.remove(0);
                        playerID = 3;
                        break;
                    }
                    System.out.println("card not found");
                case 3:
                    if (hasCards(3)) {
                        currentCards = (ArrayList) initPlayer.getPlayerCards(0);
                        currentCard = (ArrayList) currentCards.toArray()[0];
                        card = (ArrayList) currentCard.toArray()[0];
                        System.out.println("PLAYER 4");
                        try {
                            System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        }
                        card.remove(0);
                        playerID = 4;
                        break;
                    }
                    System.out.println("card not found");
                case 4:
                    if (hasCards(4)) {
                        currentCards = (ArrayList) initPlayer.getPlayerCards(0);
                        currentCard = (ArrayList) currentCards.toArray()[0];
                        card = (ArrayList) currentCard.toArray()[0];
                        System.out.println("PLAYER 5");
                        try {
                            System.out.println("CARD PLAYED: " + card.toArray()[3] + "  Economic Value: " + card.toArray()[12]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("CARD PLAYED: TRUMP: " + card.toArray()[3]);
                        }
                        card.remove(0);
                        playerID = 0;
                        break;
                    }
                    System.out.println("card not found");
            }

        }
    }

    private static boolean hasCards(int playerID) {
        ArrayList temp = (ArrayList) initPlayer.getPlayerCards(0);
        ArrayList temptemp = (ArrayList) temp.toArray()[0];
        //System.out.println(temptemp.toArray()[0]);
        if (temptemp.toArray()[0].equals("[]")) {
            return false;
        }
        return true;
    }

    public static class startGame {
        //loop material here, most of game logic
    }

    public static ArrayList<initCard> buildDeck() {
        deck = new initDeck().initDeck();
        return deck;
    }

    public static int selectDealer(int numPlayers) {
        numOfPlayers = numPlayers;
        return new Random().nextInt(numPlayers);
    }

    public static ArrayList<initCard> dealCards() {
        ArrayList ret = new ArrayList();
        //System.out.println(deck);

        for (int i = 0; i < NUM_OF_CARDS_DEALT; i++) {
            int index = new Random().nextInt(deck.size());
            ArrayList temp = (ArrayList) deck.toArray()[index];
            ret.add(temp);
            deck.remove(index);
            //System.out.print("\n Card Removed \n Cards left: " + deck.size()+ "\n");
        }


        return ret;
    }

    private static void createPlayers(int numOfPlayers) {

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


