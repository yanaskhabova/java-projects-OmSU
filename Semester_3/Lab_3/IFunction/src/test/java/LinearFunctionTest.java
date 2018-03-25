import com.tngtech.java.junit.dataprovider.*;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class LinearFunctionTest {
    @DataProvider
    public static Object[][] ValueData() throws BadValueException {
        return new Object[][]{
                {new LinearFunction(-5.0, 5.0, 1.0, 0.0), 0.0, 0.0},
                {new LinearFunction(-5.0, 5.0, 1.0, 0.0), 1.0, 1.0},
                {new LinearFunction(-5.0, 4.0, 4.0, 2.0), 1.5, 8.0},
                {new LinearFunction(3.0, 9.0, -3.0, 2.0), 3.0, -7.0},
                {new LinearFunction(5.0, -5.0, 3.0, -1.0), 5.0, 14.0},
        };
    }

    @DataProvider
    public static Object[][] ValueDataException() throws BadValueException {
        return new Object[][]{
                {new LinearFunction(5.0, -5.0, 1.0, -1.0), -6.0},
                {new LinearFunction(5.0, -5.0, 1.0, -1.0), 6.0},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public void testValue(LinearFunction f, double x, double result) throws BadValueException {
        assertEquals(f.value(x), result, 1E-6);
    }

    @Test(expected = BadValueException.class)
    @UseDataProvider("ValueDataException")
    public void testValueExc(LinearFunction f, double x) throws BadValueException {
        f.value(x);
    }
}
