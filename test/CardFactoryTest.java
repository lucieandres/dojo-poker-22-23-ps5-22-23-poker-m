import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardFactoryTest {

    CardFactory cardFactory = new CardFactory();

    @Test
    void CardToStrTest(){
        Card asdecoeur= new Card("As", 14);
        asdecoeur.setColor(Color.COEUR);
        assertEquals(cardFactory.CardFromStr("ACo"), asdecoeur);

        Card deuxdepique= new Card("2", 2);
        deuxdepique.setColor(Color.PIQUE);
        assertEquals(cardFactory.CardFromStr("2Pi"), deuxdepique);

        Card troisdecoeur= new Card("3", 3);
        troisdecoeur.setColor(Color.COEUR);
        assertEquals(cardFactory.CardFromStr("3Co"), troisdecoeur);

        Card quatredetrefle= new Card("4", 4);
        quatredetrefle.setColor(Color.TREFLE);
        assertEquals(cardFactory.CardFromStr("4Tr"), quatredetrefle);

        Card cinqdecarreau= new Card("5", 5);
        cinqdecarreau.setColor(Color.CARREAU);
        assertEquals(cardFactory.CardFromStr("5Ca"), cinqdecarreau);

        Card sixdetrefle= new Card("6", 6);
        sixdetrefle.setColor(Color.TREFLE);
        assertEquals(cardFactory.CardFromStr("6Tr"), sixdetrefle);

        Card septdecoeur= new Card("7", 7);
        septdecoeur.setColor(Color.COEUR);
        assertEquals(cardFactory.CardFromStr("7Co"), septdecoeur);

        Card huitdepique= new Card("8", 8);
        huitdepique.setColor(Color.PIQUE);
        assertEquals(cardFactory.CardFromStr("8Pi"), huitdepique);

        Card neufdetrefle= new Card("9", 9);
        neufdetrefle.setColor(Color.TREFLE);
        assertEquals(cardFactory.CardFromStr("9Tr"), neufdetrefle);

        Card dixdecarreau= new Card("10", 10);
        dixdecarreau.setColor(Color.CARREAU);
        assertEquals(cardFactory.CardFromStr("10Ca"), dixdecarreau);

        Card valetdecarreau= new Card("Valet", 11);
        valetdecarreau.setColor(Color.CARREAU);
        assertEquals(cardFactory.CardFromStr("VCa"), valetdecarreau);

        Card damedecoeur= new Card("Dame", 12);
        damedecoeur.setColor(Color.COEUR);
        assertEquals(cardFactory.CardFromStr("DCo"), damedecoeur);

        Card roidepique= new Card("Roi", 13);
        roidepique.setColor(Color.PIQUE);
        assertEquals(cardFactory.CardFromStr("RPi"), roidepique);

        assertEquals(cardFactory.CardFromStr("RFo"), null);
        assertEquals(cardFactory.CardFromStr("12Co"), null);
        assertEquals(cardFactory.CardFromStr("1FA"), null);
        assertEquals(cardFactory.CardFromStr("pasunecarte"), null);

    }

}
