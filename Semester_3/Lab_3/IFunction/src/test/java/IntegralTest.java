import com.tngtech.java.junit.dataprovider.*;
import org.junit.*;

import static org.junit.Assert.fail;

public class IntegralTest {
    @DataProvider
    public static <T extends IFunction> Object[][] ValueData() throws BadValueException {
        return new Object[][]{
                {new LinearFunction(-5.0, 5.0, 1.0, 0.0), new Integral<T>(0.0, 2.0), 2.0},
                {new LinearFunction(-5.0, 5.0, 2.0, 0.0), new Integral<T>(0.0, 2.0), 4.0},
                {new LinearFunction(-5.0, 4.0, 4.0, 2.0), new Integral<T>(1.0, 3.0), 20.0},
                {new TrigonometricFunction(-5.0, 5.0, 1.0, 1.0), new Integral<T>(0.0, Math.PI), 2.0},
                {new TrigonometricFunction(5.0, -5.0, -2.0, 1.0), new Integral<T>(-Math.PI, Math.PI), 0.0},
                {new RationalFunction(-5.0, 5.0, 2.0, 6.0, 1.0, 0.0), new Integral<T>(1.0, Math.E), 2 * Math.E + 4},
                {new ExponentialFunction(-5.0, 5.0, 1.0, 0.0), new Integral<T>(0.0, 2.0), Math.exp(2.0) - Math.exp(0.0)},
        };
    }

    @DataProvider
    public static <T extends IFunction> Object[][] ValueDataException() throws BadValueException {
        return new Object[][]{
                {new RationalFunction(-5.0, 5.0, 1.0, 0.0, 1.0, 0.0), new Integral<T>(-6.0, 3.0), 20.0},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public <T extends IFunction> void testCalculate(T f, Integral<T> integral, double result) throws BadValueException {

        if (Math.abs(integral.calculate(f) - result) > 0.1) {
            fail();
        }
    }

    @Test(expected = BadValueException.class)
    @UseDataProvider("ValueDataException")
    public <T extends IFunction> void testCalculateExc(T f, Integral<T> integral, double result) throws BadValueException {
        integral.calculate(f);
    }

}
