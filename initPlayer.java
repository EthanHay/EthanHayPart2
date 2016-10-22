import java.util.ArrayList;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises an individual player
 */
public class initPlayer {



    private static ArrayList cards;
    private static ArrayList players = new ArrayList();
    private static int playerId;
    private static ArrayList player0Cards = new ArrayList();
    private static ArrayList player1Cards = new ArrayList();
    private static ArrayList player2Cards = new ArrayList();
    private static ArrayList player3Cards = new ArrayList();
    private static ArrayList player4Cards = new ArrayList();
    private static Object playerCards;


    public initPlayer(int playerId) {
        this.playerId = playerId;
        //System.out.println("PlayerID" + playerId);
        //this.cards = initGame.dealCards();
        if (playerId == 0){ArrayList temp = (ArrayList) initGame.dealCards();player0Cards.add(temp);}
        if (playerId == 1){ArrayList temp = (ArrayList) initGame.dealCards();player1Cards.add(temp);}
        if (playerId == 2){ArrayList temp = (ArrayList) initGame.dealCards();player2Cards.add(temp);}
        if (playerId == 3){ArrayList temp = (ArrayList) initGame.dealCards();player3Cards.add(temp);}
        if (playerId == 4){ArrayList temp = (ArrayList) initGame.dealCards();player4Cards.add(temp);}

    }

    public static Object getPlayerCards(int playerId) {
        if(playerId == 0) {return player0Cards;}
        if(playerId == 1) {return player1Cards;}
        if(playerId == 2) {return player2Cards;}
        if(playerId == 3) {return player3Cards;}
        if(playerId == 4) {return player4Cards;}
        return null;
    }

    public void setCards(ArrayList<initCard> cards) {
        this.cards = cards;
    }

    public String toString() {
        return "Player" + playerId;
    }

    public static void createPlayer(int playerNumber) {
        initPlayer player = new initPlayer(playerNumber);
        players.add(player);

    }
}
