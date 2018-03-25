package stringproc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stringproc.BadParamException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static stringproc.StringProcessor.*;

public class StringProcessorTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"", "aaa", 0},
//                {"", "", 0}
               // {"asdf", "", 0},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {" 1 ", " one "},
                {" 2", " two"},
                {"1 2 3", "one two three"}
        };
    }

    @DataProvider
    public static Object[][] changeWords() {
        return new Object[][]{
                {"", ""},
                {" qq ", " qq "},
                {"   123 erty 11 ", "   11 erty 123 "}
        };
    }
    @DataProvider
    public static Object[][] changeAge() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) throws BadParamException {
        assertEquals(copyString(str, N), expected);
    }

    @Test(expectedExceptions = {BadParamException.class})
    public void testCopyExc() throws BadParamException {
        copyString("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) throws BadParamException {
        assertEquals(countEntryString(big, small), expected);
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(changeNumberToString(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder  stringBuilder = new StringBuilder("1234567");
        deleteChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1357");
        deleteChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "15");
        deleteChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
        deleteChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
//        deleteChar(new StringBuilder());
//        assertEquals(stringBuilder.toString(), "");
    }
//
//    @Test(dataProvider = "changeWords")
//    public void testChange3(String source, String expected) {
//        assertEquals( ReplaceStr(new StringBuilder(source)).toString(), expected);
//    }
//
//    @Test(dataProvider = "changeAge")
//    public void testChange4(String source, String expected) {
//        assertEquals(hexadecimalNotation(new String(source)), expected);
//    }
//
}