import java.util.Comparator;

/**
 * CardSort class with comparator implemented
 * Used to compare two cards value
 */
class CardSort implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card2.getValue() - card1.getValue();
    }

}

