import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {

    Referee referee;
    Search search;
    Hand hand1;
    Hand hand2;
    ArrayList as;


    @BeforeEach
    public void setUp() {
        hand1 = new Hand("2Pi 3Pi 3Tr DCo 2Co", 1);
        hand2 = new Hand("4Co 5Pi 10Tr RTr RCa", 2);
        referee = new Referee(hand1, hand2);
        search = new Search();
        as = new ArrayList();
        as.add(14);
    }

    @Test
    void notifyHandStateTest() {
        assertEquals(referee.notifyHandState(), true);

        hand2 = new Hand("4Tr 5Pi 10Pi", 2);
        referee = new Referee(hand1, hand2);
        assertEquals(referee.notifyHandState(), false);

        hand2 = new Hand("4.5Pi 5Tr 10Tr RTr RTr", 2);
        referee = new Referee(hand1, hand2);
        assertEquals(referee.notifyHandState(), false);

        hand2 = new Hand("4Pi 50Ca 10Ca RTr RPi", 2);
        referee = new Referee(hand1, hand2);
        assertEquals(referee.notifyHandState(), false);

        hand2 = new Hand("4Pi -5Pi 10Ca RTr RCa", 2);
        referee = new Referee(hand1, hand2);
        assertEquals(referee.notifyHandState(), false);

        hand2 = new Hand("4 -5 10 R R", 2);
        referee = new Referee(hand1, hand2);
        assertEquals(referee.notifyHandState(), false);

    }

    @Test
    void notifyDuplicate(){
        assertTrue(referee.notifyDuplicate());
        hand1 = new Hand("2Pi 3Pi 3Tr DCo 2Co", 1);
        hand2 = new Hand("2Pi 5Pi 10Tr RTr RCa", 2);
        referee = new Referee(hand1, hand2);
        assertFalse(referee.notifyDuplicate());
    }

    @Test
    void isBestCombineFoundIsPairTest() {
        hand1 = new Hand("6Tr 6Pi 2Tr 3Pi 4Co", 1);
        hand2 = new Hand("2Co 4Ca 5Pi 2Ca ATr", 2);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        Combine combine = new Combine(new ArrayList(6), Rank.PAIR);
        Combine combineFromRef = referee.compareHand();

        assertEquals(combine, combineFromRef);
    }


    @Test
    void findCombSimpleTest() {
        hand1 = new Hand("ACo 6Ca 8Tr 2Tr 4Pi", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        Combine combine = new Combine(as, Rank.SIMPLE);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0), combine);
    }

    @Test
    void findCombPairTest() {
        hand1 = new Hand("ACo 6Ca ATr 7Tr 4Pi", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        Combine combine = new Combine(as, Rank.PAIR);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0), combine);
    }

    @Test
    void findCombDoublePairTest() {
        hand1 = new Hand("ACo 6Ca ATr 6Tr 4Pi", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        as.add(6);
        Combine combine = new Combine(as, Rank.DOUBLEPAIR);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0), combine);
    }
    @Test
    void findCombBrelanTest() {
        hand1 = new Hand("APi ATr ACo 2Ca 4Pi", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        Combine combine = new Combine(as, Rank.BRELAN);
        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0).getFirstValue(), combine.getFirstValue());
    }

    @Test
    void findFullTest() {
        hand1 = new Hand("APi ATr 5Co 5Ca 5Tr", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        ArrayList<Integer> full = new ArrayList();
        full.add(5);
        full.add(14);

        Combine combine = new Combine(full, Rank.FULL);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0).getFirstValue(), combine.getFirstValue());
        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0).getValues().get(1), combine.getValues().get(1));
    }

    @Test
    //Subtilité avec la suite 5 4 3 2 As
    void findLowestSuiteTest() {
        hand1 = new Hand("ACo 5Ca 3Pi 4Tr 2Tr", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        ArrayList<Integer> suite = new ArrayList();
        suite.add(5);

        Combine combine = new Combine(suite, Rank.SUITE);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0), combine);
    }

    @Test
    void findSuiteTest() {
        hand1 = new Hand("5Co 6Ca 7Ca 8Pi 9Co", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        ArrayList<Integer> suite = new ArrayList();
        suite.add(9);

        Combine combine = new Combine(suite, Rank.SUITE);

        assertEquals(referee.getHandFromNumber(1).getListOfCombine().get(0), combine);
    }

    @Test
    void isTieTest() {
        hand1 = new Hand("4Co 5Pi 10Tr RTr RCa", 1);
        referee = new Referee(hand1, hand2);
        referee.findCombine();
        referee.compareHand();

        assertEquals(-1, referee.getWinningHand());
    }

}


