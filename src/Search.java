import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Search Class
 * Used to look for the combination in the hand
 */
public class Search {

    public Search() {
    }

    /**
     * @return {ArrayList} the value of the simple card
     */
    public ArrayList simple(ArrayList<Card> hand) {
        ArrayList simple = new ArrayList();
        simple.add(hand.get(0).getValue());
        return simple;
    }

    /**
     * @return {ArrayList} the value of the card in the pair
     */
    public ArrayList pair(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getValue() == hand.get(i + 1).getValue()) {
                ArrayList pair = new ArrayList();
                pair.add(hand.get(i).getValue());
                return pair;
            }
        }
        return new ArrayList();
    }

    /**
     * @return {ArrayList} the value of the cards in the doublepair
     */
    public ArrayList doublepair(ArrayList<Card> hand) {
        int check = 0;
        ArrayList doublepair = new ArrayList();
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i - 1).getValue() == hand.get(i).getValue()) {
                doublepair.add(hand.get(i).getValue());
                check++;
            }
        }
        if (check == 2) {
            return doublepair;
        } else {
            return new ArrayList();
        }
    }

    /**
     * @return {ArrayList} the value of the card in the brelan
     */
    public ArrayList brelan(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 2; i++) {
            if ((hand.get(i).getValue() == hand.get(i + 1).getValue())
                    && (hand.get(i + 1).getValue() == hand.get(i + 2).getValue())) {
                ArrayList brelan = new ArrayList();
                brelan.add(hand.get(i).getValue());
                return brelan;
            }
        }
        return new ArrayList();
    }


    /**
     * @return {ArrayList} the values of the card in the brelan and the card in the pair
     */
    public ArrayList full(ArrayList<Card> hand) {
        ArrayList<Integer> brelan = brelan(hand);
        if(brelan.isEmpty()) {
            return new ArrayList<Integer>();
        }
        Hand tmpHand = (Hand) hand.clone();
        tmpHand.removeAllFromValue(brelan.get(0));
        ArrayList<Integer> pair = pair(tmpHand);
        if(pair.isEmpty()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> full = new ArrayList<Integer>();
        full.add(brelan.get(0));
        full.add(pair.get(0));
        return full;
    }

    /**
     * @return {ArrayList} the value of the card in the four of a kind
     */
    public ArrayList carre(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 3; i++) {
            if ((hand.get(i).getValue() == hand.get(i + 1).getValue())
                    && (hand.get(i + 1).getValue() == hand.get(i + 2).getValue())
                    && (hand.get(i + 2).getValue() == hand.get(i + 3).getValue())) {
                ArrayList carre = new ArrayList();
                carre.add(hand.get(i).getValue());
                return carre;
            }
        }
        return new ArrayList();
    }

    /**
     * @return {ArrayList} the value of the highest card of the straight
     */
    public ArrayList<Integer> suite(ArrayList<Card> hand) {
        int cmpt=1;
        int size = hand.size()-1;
        ArrayList<Integer> suite = new ArrayList<Integer>();

        if(hand.get(0).getValue() == (new Card("As", 14).getValue())) {
            int value = 2;
            while(hand.get(size).getValue() == value && size>0) {
                cmpt++;
                value++;
                size--;
            }
            if(cmpt==5) {
                suite.add(5);
                return suite;
            }
        }
        cmpt=1;
        size = hand.size();
        for(int i = 1; i<size; i++) {
            if(hand.get(i-1).getValue()-1 == hand.get(i).getValue()) cmpt++;
        }

        if(cmpt==5) {
            suite.add(hand.get(0).getValue());
            return suite;
        }
        return new ArrayList<Integer>();
    }


    /**
     * @return {ArrayList} the highest card of the flush
     */
    public ArrayList<Card> couleur(Hand hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (!(hand.get(0).getColor() == hand.get(i).getColor())) {
                return new ArrayList<Card>();
            }
        }
        return hand;
    }


    /**
     * @return {ArrayList} the value of the highest card of the straight and the highest card of the flush
     */
    public ArrayList quinteflush(Hand hand) {
        ArrayList<Object> quinteflush = new ArrayList<Object>();

        ArrayList<Integer> suite = suite(hand);
        if(suite.isEmpty()) return new ArrayList();

        ArrayList<Card> couleur = couleur(hand);
        if(couleur.isEmpty()) return new ArrayList();

        quinteflush.add(couleur.get(0));
        quinteflush.add(suite.get(0));

        return quinteflush;
    }

}
