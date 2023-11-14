/**
 * Card Class
 * Class to define what a Card is
 */
public class Card {

    private String name;
    private int value;
    private Color color;

    /**
     * Card constructor
     *
     * @param name
     * @param value
     */
    Card(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Card constructor
     *
     * @param color
     */
    Card(Color color) {
        this.color = color;
    }

    /**
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set the value of the card
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * set the name of the card
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * set the color of the card
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }


    /**
     * Definition of equals between cards
     *
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Card) {
            Card tmp = (Card) o;
            if(tmp.getValue() == this.getValue() && tmp.getColor() == this.getColor() && this.getName().equals(tmp.getName())) return true;
        }
        return false;
    }
}
