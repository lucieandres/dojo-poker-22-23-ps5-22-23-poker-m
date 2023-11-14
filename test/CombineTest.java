import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CombineTest {
    Combine c1, c2, c3, c4, c5;

    @BeforeEach
    public void setUp() {
        c1 = new Combine(new ArrayList(), Rank.PAIR);
        c1.addValue(2);
        c2 = new Combine(new ArrayList(), Rank.PAIR);
        c2.addValue(2);
        c3 = new Combine(new ArrayList(), Rank.SIMPLE);
        c3.addValue(2);
        c4 = new Combine(new ArrayList(), Rank.DOUBLEPAIR);
        c4.addValue(3);
        c5 = new Combine(new ArrayList(), Rank.BRELAN);
        c5.addValue(5);

    }

    @Test
    public void equalsTest() {
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c1.equals(c4));
        assertFalse(c1.equals(c5));
    }

    @Test
    public void compareToTest() {
        assertEquals(c1.compareTo(c2), 0);
        assertEquals(c1.compareTo(c3), 1);
        assertEquals(c3.compareTo(c5), -3);
        assertEquals(c4.compareTo(c5), -1);
    }

}
