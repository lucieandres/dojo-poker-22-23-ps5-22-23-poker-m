import java.util.ArrayList;

/**
 * Referee Class
 * It is the referee of the game and check everything about how the game works
 */
public class Referee {
    private ArrayList<Hand> hands = new ArrayList<Hand>();
    private String result = "";
    private int winningHand = 0;

    /**
     * @param hand1
     * @param hand2
     * Referee constructor
     */
    public Referee(Hand hand1, Hand hand2) {
        this.hands.add(hand1);
        this.hands.add(hand2);
    }

    /**
     * @param number
     * @return hand according to its number
     */
    public Hand getHandFromNumber(int number) {
        return hands.get(number - 1);
    }

    /**
     * @return the winning hand
     */
    protected int getWinningHand() {
        return winningHand;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @return true or false depending on whether the hand is correctly written or not.
     */
    public boolean notifyHandState() {
        for (Hand h : hands) {
            if (h == null || h.size() != h.SIZE_OF_HAND) {
                return false;
            }
        }
        return true;
    }


    /**
     * @return true or false depending on whether there is a duplicate Card during the game.
     */
    public boolean notifyDuplicate() {
        ArrayList<Card> allCards = new ArrayList<Card>();
        for (Hand h : hands) {
            for (int i = 0; i < h.size(); i++) {
                if(allCards.contains(h.get(i))) {
                    return false;
                } else {
                    allCards.add(h.get(i));
                }
            }
        }
        return true;
    }

    /**
     * Method to start the game which means check the combination of the hands and find the winner
     */
    public void start() {
        findCombine();
        Combine winningCombine = compareHand();
        sendResultat(winningCombine, winningHand);
    }

    /**
     * Method to find the best combination of each hand
     */
    public void findCombine() {
        Search search = new Search();
        for (Hand h : hands) {
            if(!search.quinteflush(h).isEmpty()){
                h.addCombine(new Combine(search.quinteflush(h),Rank.QUINTEFLUSH));
            } else if (!search.carre(h).isEmpty()) {
                h.addCombine(new Combine(search.carre(h), Rank.CARRE));
            } else if (!search.full(h).isEmpty()) {
                h.addCombine(new Combine(search.full(h), Rank.FULL));
            } else if(!search.couleur(h).isEmpty()){
                h.addCombine(new Combine(search.couleur(h),Rank.COULEUR));
            } else if(!search.suite(h).isEmpty()) {
                h.addCombine(new Combine(search.suite(h),Rank.SUITE));
            } else if (!search.brelan(h).isEmpty()) {
                h.addCombine(new Combine(search.brelan(h), Rank.BRELAN));
            } else if (!search.doublepair(h).isEmpty()) {
                h.addCombine(new Combine(search.doublepair(h), Rank.DOUBLEPAIR));
            } else if (!search.pair(h).isEmpty()) {
                h.addCombine(new Combine(search.pair(h), Rank.PAIR));
            } else {
                h.addCombine(new Combine(search.simple(h), Rank.SIMPLE));
            }
        }
    }

    /**
     * Method to compare the combine of each hand and to tell which hand wins
     * the number of the winning hand is stocked in winningHand.
     *
     * @return the combination of the winning Hand
     */
    //send best Combine in all hand
    public Combine compareHand() {
        int minCombFind = hands.get(0).getListOfCombine().size();
        for (Hand hand : hands) {
            int tmpSize = hand.getListOfCombine().size();
            if (minCombFind > tmpSize)
                minCombFind = tmpSize;
        }
        for (int i = 0; i < minCombFind; i++) {
            int numBestHand = 0;
            Combine bestCombine = hands.get(0).getListOfCombine().get(i);
            for (int j = 1; j < hands.size(); j++) {
                Combine tmpComb = hands.get(j).getListOfCombine().get(i);
                if (!bestCombine.equals(tmpComb)) {
                    if (bestCombine.compareTo(tmpComb) > 0) {
                        winningHand = 0;
                        return bestCombine;
                    } else {
                        if(bestCombine.compareTo(tmpComb) == 0) {
                            winningHand = -1;
                            return null;
                        }
                        winningHand = j;
                        return tmpComb;
                    }
                }
            }
        }
        winningHand = -1;
        return null;
    }

    /**
     * Write the result of who is winning and with which combination
     *
     * @param combine
     * @param numberHand
     */
    public void sendResultat(Combine combine, int numberHand) {
        numberHand++;
        if (winningHand == -1) {
            result = "Egalité !";
        } else {
            result = "La main " + numberHand + " gagne avec ";
            switch (combine.getRank()) {
                case SIMPLE:
                    result += "la carte la plus forte : " + combine.getFirstValue();
                    break;
                case PAIR:
                    result += "une paire de " + combine.getFirstValue();
                    break;
                case DOUBLEPAIR:
                    result += "une paire de " + combine.getValues().get(0) + " et une paire de " + combine.getValues().get(1);
                    break;
                case BRELAN:
                    result += "un brelan de " + combine.getFirstValue();
                    break;
                case FULL:
                    result += "un full avec un brelan de " + combine.getValues().get(0) + " et une paire de " + combine.getValues().get(1);
                    break;
                case CARRE:
                    result += "un carre de " + combine.getFirstValue();
                    break;
                case SUITE:
                    result += "une suite finnisant par la carte " + combine.getFirstValue();
                    break;
                case QUINTEFLUSH:
                    result += "une quinte flush finissant par la carte " + combine.getValues().get(1) + " et la couleur " + combine.getFirstValue().toString();
                    break;
                case COULEUR:
                    result += "la couleur " + ((Card)combine.getFirstValue()).getColor().toString();
                    break;
            }
        }
    }

}
