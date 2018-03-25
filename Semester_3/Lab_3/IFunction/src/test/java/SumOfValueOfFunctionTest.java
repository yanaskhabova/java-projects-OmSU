import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class SumOfValueOfFunctionTest {
    @DataProvider
    public static Object[][] ValueData() throws BadValueException {
        return new Object[][]{
                {new LinearFunction(-5.0, 5.0, 1.0, 0.0), 0.0},
                {new LinearFunction(-5.0, 5.0, 1.0, 1.0), 3.0},
                {new LinearFunction(-5.0, 4.0, 4.0, 2.0), 0.0},
                {new LinearFunction(3.0, 9.0, -2.0, 2.0), -30.0},
                {new TrigonometricFunction(-5.0, 5.0, 1.0, 0.0), 0.0},
                {new TrigonometricFunction(Math.PI / 2, -Math.PI / 2, 1.0, -1.0), 0.0},
                {new TrigonometricFunction(-Math.PI / 4, Math.PI / 4, 2.0, 1.0), 0.0},
                {new TrigonometricFunction(Math.PI / 2, 0, 1.0, 1.0), 1 + 0.5 * Math.sqrt(2)},
                {new RationalFunction(-5.0, 5.0, 1.0, 1.0, 1.0, 1.0), 3.0},
                {new RationalFunction(1.0, 5.0, 2.0, 0.0, 1.0, 0.0), 6.0},
                {new ExponentialFunction(0.0, 1.0, 1.0, 0.0), 1 + Math.exp(1.0) + Math.exp(0.5)},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public <T extends IFunction> void testCalculate(T f, double result) throws BadValueException {
        SumOfValuesOfFunction<T> func = new SumOfValuesOfFunction<T>();
        assertEquals(func.calculate(f), result, 1E-6);
    }
}
