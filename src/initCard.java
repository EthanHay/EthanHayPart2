import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initCard {
    private Object cardFileName;
    //define all global variables
    public int cardId;
    public ArrayList cardData;

    public initCard(ArrayList cardData){
        this.cardData = cardData;
        this.cardFileName = cardData.toArray()[0];
    }

    public String toString() {
        return "CardName = " + this.cardFileName;
    }
    public ArrayList toArrayList() {
        ArrayList<String> test = new ArrayList<>();
        test.add(this.cardFileName.toString());

        return test;
    }

//Doesnt work how i thought it would
//    public ArrayList<String> toArray() {
//        ArrayList<String> ret = new ArrayList<>();
//        ret.add(Integer.toString(cardId));
//        ret.add(Integer.toString(cardHardness));
//
//        return ret;
//    }
}
