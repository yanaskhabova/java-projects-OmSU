import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;

public class ExponentialFunctionTest {

    @DataProvider
    public static Object[][] ValueData() throws BadValueException {
        return new Object[][]{

                {new ExponentialFunction(-5.0, 5.0, 1.0, 0.0), 1.0, Math.exp(1.0)},
                {new ExponentialFunction(-5.0, 5.0, 2.5, 1.0), 0.0, 2.5 * Math.exp(0.0) + 1},
                {new ExponentialFunction(-5.0, 5.0, 2.5, 1.0), 2.0, 2.5 * Math.exp(2.0) + 1},
                {new ExponentialFunction(5.0, -5.0, 2.0, 2.0), -1.0, 2.0 * Math.exp(-1.0) + 2},
        };
    }

    @DataProvider
    public static Object[][] ValueDataException() throws BadValueException {
        return new Object[][]{
                {new ExponentialFunction(5.0, -5.0, 1.0, -1.0), 6.0},
                {new ExponentialFunction(5.0, -5.0, 1.0, -1.0), -6.0},
        };
    }

    @Test
    @UseDataProvider("ValueData")
    public void testValue() throws Exception {
    }

}

