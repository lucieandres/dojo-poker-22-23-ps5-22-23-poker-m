import java.util.*;

public class Hand extends ArrayList<Card> {

    public static final int SIZE_OF_HAND = 5;
    private int number;
    private ArrayList<Combine> listOfCombine = new ArrayList<Combine>();
    private CardFactory cardFactory = new CardFactory();

    public Hand(String string, int number) {
        String sliced[] = string.split(" ");
        for (String s : sliced) {
            Card card = cardFactory.CardFromStr(s);
            if (card != null) {
                this.add(card);
            }
        }
        this.sort();
        this.number = number;
    }

    /**
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Combine> getListOfCombine() {
        return listOfCombine;
    }

    public void setListOfCombine(ArrayList<Combine> listOfCombine) {
        this.listOfCombine = listOfCombine;
    }

    public ArrayList<Card> getCards(int value) {
        ArrayList<Card> tmplc = new ArrayList<Card>();
        for (Card c:
             this) {
            if(c.getValue() == value) tmplc.add(c);
        }
        return tmplc;
    }

    public void sort() {
        Collections.sort(this, new CardSort());
    }

    public void addCombine(Combine combine) {
        listOfCombine.add(combine);
    }

    public void removeAllFromValue(int value) {
        for(int i = 0; i<size(); i++) {
            if(this.get(i).getValue() == value) {
                this.remove(this.get(i));
                i--;
            }
        }
    }

}

