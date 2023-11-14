/**
 * Rank Enum
 * Used to classify the power of a combination
 */
public enum Rank {

    QUINTEFLUSH(8),
    CARRE(7),
    FULL(6),
    COULEUR(5),
    SUITE(4),
    BRELAN(3),
    DOUBLEPAIR(2),
    PAIR(1),
    SIMPLE(0);

    private int power;

    /**
     * Rank constructor
     * @param power
     */
    Rank(int power){
        this.power=power;
    }

    /**
     * @return power
     */
    public int getPower() {
        return power;
    }
}