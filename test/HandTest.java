import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HandTest {
    Hand hand;

    @BeforeEach
    public void setUp() {
        String str = "2Co 10Pi ATr 8Tr 9Ca";
        hand = new Hand(str, 1);
    }

    @Test
    void testHand(){
        assert(!hand.isEmpty());
        assertEquals(hand.size(), 5);
        assert(hand instanceof ArrayList<?>);
        hand.forEach( card -> {
            assert(card instanceof Card);
        });
    }

    @Test
    void testNumber(){
        assertEquals(hand.getNumber(), 1);
        hand.setNumber(2);
        assertEquals(hand.getNumber(), 2);
    }

    @Test
    void testCombine(){

        assert(hand.getListOfCombine().isEmpty());
        hand = new Hand("2Co 2Pi ATr ATr ACa", 1);
        ArrayList valuesPair = new ArrayList();
        valuesPair.add(2);
        valuesPair.add(2);
        Combine pair = new Combine(valuesPair, Rank.PAIR);
        ArrayList listOfCombine = new ArrayList();
        listOfCombine.add(pair);
        hand.setListOfCombine(listOfCombine);
        assertEquals(hand.getListOfCombine().size(), 1);
        ArrayList valuesBrelan = new ArrayList();
        valuesBrelan.add(14);
        valuesBrelan.add(14);
        valuesBrelan.add(14);
        Combine brelan = new Combine(valuesBrelan, Rank.BRELAN);
        hand.addCombine(brelan);
        assertEquals(hand.getListOfCombine().size(), 2);
        assert(hand.getListOfCombine().get(0).valEquals(valuesPair));
        assert(hand.getListOfCombine().get(1).valEquals(valuesBrelan));
    }

    @Test
    void testGetCards(){
        hand = new Hand("2Co 2Pi ATr ATr ACa", 1);
        ArrayList<Card> listOfTwos = hand.getCards(2);
        ArrayList<Card> listOfAs = hand.getCards(14);
        ArrayList<Card> emptyList = hand.getCards(5);

        assertEquals(listOfTwos.size(), 2);
        listOfTwos.forEach( two -> {
            assertEquals(two.getValue(), 2);
        });
        assertEquals(listOfAs.size(), 3);
        assertEquals(listOfTwos.size(), 2);
        listOfAs.forEach( as -> {
            assertEquals(as.getValue(), 14);
        });
        assert(emptyList.isEmpty());
    }

    @Test
    void testSort() {

        Card astr = new Card("As", 14);
        astr.setColor(Color.TREFLE);

        Card dipi = new Card("10", 10);
        dipi.setColor(Color.PIQUE);

        Card neca = new Card("9", 9);
        neca.setColor(Color.CARREAU);

        Card hutr = new Card("8", 8);
        hutr.setColor(Color.TREFLE);

        Card deco = new Card("2", 2);
        deco.setColor(Color.COEUR);


        assert ( hand.get(0).equals(astr)
                && hand.get(1).equals(dipi)
                && hand.get(2).equals(neca)
                && hand.get(3).equals(hutr)
                && hand.get(4).equals(deco)
        );
    }

    @Test
    void testRemoveAllFromValue(){
        // the hand : [2, As, 10, 9, 8]
        hand.removeAllFromValue(2);
        assertFalse(hand.contains(2));
        assertEquals(hand.size(), 4);

        // the hand : [As, 10, 9, 8, 8]
        hand.add(new Card("8", 8));
        ArrayList pair = new Search().pair(hand);
        assert(!pair.isEmpty());
        new Combine(pair, Rank.PAIR);
        hand.removeAllFromValue((Integer) pair.get(0));
        assertFalse(hand.contains(8));
        assertEquals(hand.size(), 3);
    }
}
