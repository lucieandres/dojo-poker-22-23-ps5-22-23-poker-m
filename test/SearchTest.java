import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    Search search;
    Hand handsimple;
    Hand handpair;
    Hand handdoublepair;
    Hand handbrelan;
    Hand handcarre;
    Hand handfull;
    Hand handcouleur;
    Hand handsuite;
    Hand handquinteflush;
    ArrayList res;

    @BeforeEach
    public void setUp() {
        handsimple = new Hand("APi 6Tr 7Co 2Co 4Co", 1);
        handpair = new Hand("4Co 5Co 10Pi RPi RTr", 2);
        handdoublepair = new Hand("APi 2Co ACa 2Ca 4Ca", 3);
        handbrelan = new Hand("APi 6Tr ACa ACo 4Pi", 4);
        handfull = new Hand("APi 2Pi ACa 2Ca 2Co", 5);
        handcarre = new Hand("APi 2Pi 2Tr 2Ca 2Co", 6);
        handsuite= new Hand("APi 2Pi 3Tr 4Ca 5Co", 7);
        handcouleur= new Hand("ACa 2Ca 3Ca 9Ca 4Ca", 8);
        handquinteflush = new Hand("APi RPi DPi VPi 10Pi", 9);
        search = new Search();
        res= new ArrayList();
    }

    @Test
    void simpleTest() {
        res.add(14);
        assertEquals(search.simple(handsimple), res);
    }

    @Test
    void pairTest() {
        res.add(13);
        assertEquals(search.pair(handpair), res);
        assertNotEquals(search.pair(handsimple), res);
        assertNotEquals(search.pair(handdoublepair), res);
        assertNotEquals(search.pair(handbrelan), res);
        assertNotEquals(search.pair(handfull), res);
    }

    @Test
    void brelanTest() {
        res.add(14);
        assertEquals(search.brelan(handbrelan), res);
        assertNotEquals(search.brelan(handpair), res);
        assertNotEquals(search.brelan(handdoublepair), res);
        assertNotEquals(search.brelan(handsimple), res);
        assertNotEquals(search.brelan(handfull), res);
    }

    @Test
    void doublepairTest(){
        res.add(14);
        res.add(2);
        assertEquals(search.doublepair(handdoublepair), res);
        assertNotEquals(search.doublepair(handpair), res);
        assertNotEquals(search.doublepair(handbrelan), res);
        assertNotEquals(search.doublepair(handsimple), res);
        assertNotEquals(search.doublepair(handfull), res);
        assertNotEquals(search.doublepair(handcarre), res);

    }

    @Test
    void fullTest(){
        res.add(2);
        res.add(14);
        assertEquals(search.full(handfull), res);
        assertNotEquals(search.full(handpair), res);
        assertNotEquals(search.full(handbrelan), res);
        assertNotEquals(search.full(handsimple), res);
        assertNotEquals(search.full(handdoublepair), res);
        assertNotEquals(search.full(handcarre), res);
    }

    @Test
    void carreTest(){
        res.add(2);
        assertEquals(search.carre(handcarre), res);
        assertNotEquals(search.carre(handpair), res);
        assertNotEquals(search.carre(handbrelan), res);
        assertNotEquals(search.carre(handsimple), res);
        assertNotEquals(search.carre(handdoublepair), res);
        assertNotEquals(search.carre(handfull), res);
    }

    @Test
    void suiteTest(){
        res.add(5);
        assertEquals(search.suite(handsuite), res);
        assertNotEquals(search.suite(handpair), res);
        assertNotEquals(search.suite(handbrelan), res);
        assertNotEquals(search.suite(handsimple), res);
        assertNotEquals(search.suite(handquinteflush), res);
        assertNotEquals(search.suite(handcouleur), res);
        assertNotEquals(search.suite(handfull), res);
    }

    @Test
    void couleurTest(){
        assertEquals(search.couleur(handcouleur), handcouleur);
        assertNotEquals(search.couleur(handpair), handcouleur);
        assertNotEquals(search.couleur(handbrelan), handcouleur);
        assertNotEquals(search.couleur(handsimple), handcouleur);
        assertNotEquals(search.couleur(handquinteflush), handcouleur);
        assertNotEquals(search.couleur(handsuite), handcouleur);
        assertNotEquals(search.couleur(handfull), handcouleur);
    }

    @Test
    void quinteflushTest(){
        res.add(handquinteflush.get(0));
        res.add(14);
        assertEquals(search.quinteflush(handquinteflush), res);
        assertNotEquals(search.quinteflush(handpair), res);
        assertNotEquals(search.quinteflush(handbrelan), res);
        assertNotEquals(search.quinteflush(handsimple), res);
        assertNotEquals(search.quinteflush(handsuite), res);
        assertNotEquals(search.quinteflush(handcouleur), res);
        assertNotEquals(search.quinteflush(handfull), res);
    }


}


