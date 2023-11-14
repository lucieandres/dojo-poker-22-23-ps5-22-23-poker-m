/**
 * Color Enum
 * Used to classify the color of a card
 */
public enum Color {
    COEUR("Coeur"),
    CARREAU("Carreau"),
    PIQUE("Pique"),
    TREFLE("Trefle");

    private String name;

    /**
     * Color constructor
     *
     * @param name
     */
    Color(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of the color
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

}
