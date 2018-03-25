import org.junit.*;
import yana.HasNoRootsExceptoin;

import static org.junit.Assert.*;

public class MaxRootTest {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testMaxRoot() throws Exception, HasNoRootsExceptoin {
        MaxRoot first = new MaxRoot(new double[]{0, 0, 1.0});
        MaxRoot second = new MaxRoot(new double[]{0, 3.0, 2.0});
        MaxRoot third = new MaxRoot(new double[]{-1.0, 0, 4.0});
        MaxRoot fifth = new MaxRoot(new double[]{4.0, 5.0, 1.0});

        assertEquals(0, first.maxRoot(), DOUBLE_EPS);
        assertEquals(0, second.maxRoot(), DOUBLE_EPS);
        assertEquals(0.5, third.maxRoot(), DOUBLE_EPS);
        assertEquals(-1, fifth.maxRoot(), DOUBLE_EPS);
    }

    @Test(expected = HasNoRootsExceptoin.class)
    public void testMaxRootException() throws Exception, HasNoRootsExceptoin {
        MaxRoot fourth = new MaxRoot(new double[]{1.0, 0, 4.0});
        fourth.maxRoot();
    }

}