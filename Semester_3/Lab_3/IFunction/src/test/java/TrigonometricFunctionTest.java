import com.tngtech.java.junit.dataprovider.*;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class TrigonometricFunctionTest {
    @DataProvider
    public static Object[][] ValueData() throws BadValueException {
        return new Object[][]{
                {new TrigonometricFunction(-5.0, 5.0, 1.0, 0.0), 0.0, 0.0},
                {new TrigonometricFunction(-5.0, 5.0, 1.0, 0.0), 1.0, 0.0},
                {new TrigonometricFunction(-5.0, 30.0, 4.0, 1.0), 30.0, 4 * Math.sin(30.0)},
                {new TrigonometricFunction(3.0, 9.0, -3.0, 2.0), 3.0, -3.0 * Math.sin(2.0 * 3.0)},
                {new TrigonometricFunction(5.0, -5.0, 1.0, -1.0), Math.PI / 2, -1.0},
                {new TrigonometricFunction(0.0, 10.0, 2.0, 1.0), Math.PI / 4, 1.414213562373095}
        };
    }

    @DataProvider
    public static Object[][] ValueDataException() throws BadValueException {
        return new Object[][]{
                {new TrigonometricFunction(5.0, -5.0, 1.0, -1.0), -6.0},
                {new TrigonometricFunction(5.0, -5.0, 1.0, -1.0), 6.0},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public void testValue(TrigonometricFunction f, double x, double result) throws BadValueException {
        assertEquals(f.value(x), result, 1E-6);
    }

    @Test(expected = BadValueException.class)
    @UseDataProvider("ValueDataException")
    public void testValueExc(TrigonometricFunction f, double x) throws BadValueException {
        f.value(x);
    }
}
