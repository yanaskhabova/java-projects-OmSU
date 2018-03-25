import org.junit.*;

import static org.junit.Assert.*;


public class QuadraticTest {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testSolve() throws IncorrectValueException, HasNoRootsExceptoin {
        Quadratic first = new Quadratic(new double[]{0, 0, 1.0});
        Quadratic second = new Quadratic(new double[]{0, 3.0, 1.0});
        Quadratic third = new Quadratic(new double[]{0, -5.0, 2.0});
        Quadratic fourth = new Quadratic(new double[]{-1.0, 0, 4.0});

        assertArrayEquals(new double[]{0.0}, first.solve(), DOUBLE_EPS);
        assertArrayEquals(new double[]{0.0, -3.0}, second.solve(), DOUBLE_EPS);
        assertArrayEquals(new double[]{2.5, 0.0}, third.solve(), DOUBLE_EPS);
        assertArrayEquals(new double[]{0.5, -0.5}, fourth.solve(), DOUBLE_EPS);
    }

    @Test
    public void testEquals() throws Exception {
        Quadratic first = new Quadratic(new double[]{3, 2, 1});
        Quadratic second = new Quadratic(new double[]{3, 2, 1});
        Quadratic third = new Quadratic(new double[]{2, 2, 1});
        Quadratic fourth = new Quadratic();

        assertTrue(first.equals(first));
        assertTrue(first.equals(second));
        assertFalse(first.equals(third));
        assertFalse(first.equals(fourth));
    }

    @Test
    public void testGetCoef() throws IncorrectValueException {
        Quadratic first = new Quadratic(new double[]{0, -3.0, 1.0});
        assertEquals(1.0, first.getCoef(2), DOUBLE_EPS);
        assertEquals(-3.0, first.getCoef(1), DOUBLE_EPS);
        assertEquals(0, first.getCoef(0), DOUBLE_EPS);
    }

    @Test(expected = IncorrectValueException.class)
    public void testGetCoefException() throws Exception {
        Quadratic first = new Quadratic(new double[]{0, -3.0, 1.0});
        first.getCoef(3);
    }

    @Test(expected = HasNoRootsExceptoin.class)
    public void testHashCode() throws HasNoRootsExceptoin, IncorrectValueException {
        Quadratic first = new Quadratic(new double[]{3, 2, 1});
        Quadratic second = new Quadratic(new double[]{3, 2, 1});
        Quadratic third = new Quadratic(new double[]{2, 2, 1});
        first.solve();
        second.solve();
        third.solve();
    }

}