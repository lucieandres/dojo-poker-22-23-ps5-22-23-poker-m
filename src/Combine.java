import java.util.ArrayList;

/**
 * Combine Class with comparable implemented
 *Used to define a combination
 */
public class Combine implements Comparable<Combine> {
    private ArrayList<Object> values;
    private Rank type;

    /**
     * Combine constructor
     *
     * @param values
     * @param type
     */
    public Combine(ArrayList values, Rank type) {
        this.values = values;
        this.type = type;
    }

    /**
     * @return values
     */
    public ArrayList getValues() {
        return values;
    }

    /**
     * @return first value of values list
     */
    public Object getFirstValue() {
        return values.get(0);
    }

    /**
     * To add a value in values list
     *
     * @param value
     */
    public void addValue(int value) {
        this.values.add(value);
    }

    /**
     * @return type
     */
    public Rank getRank() {
        return type;
    }

    /**
     *Used to check if two list of values are equals
     *
     * @param other
     * @return true or false
     */
    public boolean valEquals(ArrayList<Object> other) {
        for (int i = 0; i < this.values.size(); i++) {
            if (values.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Definition of equals between combinations
     *
     * @param object
     * @return true or false
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Combine) {
            return (this.valEquals(((Combine) object).getValues())
                    && ((Combine) object).getRank() == this.getRank());
        }
        return false;
    }

    /**
     * Definition of compareTo between combines
     * so the combine that is the most powerful between them.
     *
     * @param combine
     * @return diffOfPower
     */
    @Override
    public int compareTo(Combine combine) {
        int diffOfPower = this.getRank().getPower() - combine.getRank().getPower();
        if(diffOfPower != 0){
            return diffOfPower;
        }
        else {
            //si valeurs comparables (entier)
            if(this.getFirstValue() instanceof Integer && combine.getFirstValue() instanceof Integer) {
                return (int)this.getFirstValue() - (int)combine.getFirstValue();
            }
            if(this.getFirstValue() instanceof Card && combine.getFirstValue() instanceof Card) {
                int index;
                for(index=0; index < this.values.size()-1; index++) {
                    if(((Card)this.values.get(index)).getValue() != ((Card)combine.getValues().get(index)).getValue()){
                        break;
                    }
                }
                return ((Card)this.values.get(index)).getValue() - ((Card)combine.getValues().get(index)).getValue();
            }
            //sinon rien (comparaison de couleur impossible)
            else {
                return 0;
            }
        }

    }

}

