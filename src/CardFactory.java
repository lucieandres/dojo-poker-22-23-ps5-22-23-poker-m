/**
 *CardFactory Class
 * Used to create the Cards as we want depending on their name and color
 */
public class CardFactory {


    /**
     * CardFactory constructor
     */
    public CardFactory() {
    }

    /**
     * Method to create Cards from a string.
     *
     * @param string
     * @return Card
     */
    public Card CardFromStr(String string) {
        Card card;
        if(string.length()<3) return null;
        String[] splited = {string.substring(0, string.length()-2), string.substring(string.length()-2, string.length())};
        switch (splited[0]) {
            case "A":
                card = new Card("As", 14);
                break;
            case "2":
                card = new Card("2", 2);
                break;
            case "3":
                card = new Card("3", 3);
                break;
            case "4":
                card = new Card("4", 4);
                break;
            case "5":
                card = new Card("5", 5);
                break;
            case "6":
                card = new Card("6", 6);
                break;
            case "7":
                card = new Card("7", 7);
                break;
            case "8":
                card = new Card("8", 8);
                break;
            case "9":
                card = new Card("9", 9);
                break;
            case "10":
                card = new Card("10", 10);
                break;
            case "V":
                card = new Card("Valet", 11);
                break;
            case "D":
                card = new Card("Dame", 12);
                break;
            case "R":
                card = new Card("Roi", 13);
                break;
            default:
                card = null;
                break;
        }
        if(card == null) return null;

        switch (splited[1]) {
            case "Co":
                card.setColor(Color.COEUR);
                break;
            case "Ca":
                card.setColor(Color.CARREAU);
                break;
            case "Pi":
                card.setColor(Color.PIQUE);
                break;
            case "Tr":
                card.setColor(Color.TREFLE);
                break;
            default:
                card.setColor(null);
                break;
        }
        return (card.getColor() == null)? null : card;
    }
}
