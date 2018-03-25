import com.tngtech.java.junit.dataprovider.*;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(DataProviderRunner.class)
public class RationalFunctionTest {
    @DataProvider
    public static Object[][] ValueData() throws BadValueException {
        return new Object[][]{

                {new RationalFunction(-5.0, 5.0, 1.0, 0.0, 1.0, 0.0), 1.0, 1.0},
                {new RationalFunction(-5.0, 5.0, 1.0, 1.0, 1.0, 1.0), 0.0, 1.0},
                {new RationalFunction(-5.0, 5.0, 1.0, 1.0, 1.0, 1.0), 1.0, 1.0},
                {new RationalFunction(-5.0, 5.0, 2.0, 0.0, 1.0, 0.5), 1.5, 1.5},
                {new RationalFunction(-5.0, 5.0, 1.0, 1.0, 1.0, 1.0), 0.0, 1.0},
                {new RationalFunction(-5.0, 5.0, 1.0, 0.0, 1.0, 1.0), 0.0, 0.0},
        };
    }

    @DataProvider
    public static Object[][] ValueDataException() throws BadValueException {
        return new Object[][]{
                {new RationalFunction(-5.0, 5.0, 1.0, 0.0, 1.0, 0.0), 0.0},
                {new RationalFunction(-5.0, 5.0, 1.0, 0.0, 1.0, -1.0), 1.0},
                {new RationalFunction(5.0, -5.0, 1.0, -1.0, 1.0, 1.0), 6.0},
                {new RationalFunction(5.0, -5.0, 1.0, -1.0, 1.0, 1.0), -6.0},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public void testValue(RationalFunction f, double x, double result) throws BadValueException {
        assertEquals(f.value(x), result, 1E-6);
    }

    @Test(expected = BadValueException.class)
    @UseDataProvider("ValueDataException")
    public void testValueException(RationalFunction f, double x) throws BadValueException {
        f.value(x);
        fail();
    }

}
