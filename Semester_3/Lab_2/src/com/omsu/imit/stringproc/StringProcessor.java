package stringproc;

public class StringProcessor {

    // copy n times: hello -> hellohellohello
    public static String copyString(String str, int n) throws BadParamException {
        String result = "";
        if (n < 0) {
            throw new BadParamException();
        }
        if (n == 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

    // count entry the 1-st string in 2-nd string
    public static int countEntryString(String stringInto, String string) {
        int index;
        int result = 0;
        if (stringInto.length() < string.length()) {
            return 0;
        }
        for (int i = 0; i < stringInto.length(); i++) {
            index = stringInto.indexOf(string, i);
            if (index == -1) {
                return result;
            }
            if (index >= 0) {
                result++;
                i = index;
            }
        }
        return result;
    }

    // change 1 -> one, 2 -> two, 3 -> three
    public static String changeNumberToString(String string) {
        String str = new String(string.replace("1", "one"));
        String str2 = new String(str.replace("2", "two"));
        return new String(str2.replace("3", "three"));
    }

    // delete each 2-nd element in string
    public static StringBuilder deleteChar(StringBuilder string) {
        if (string.equals("")) {
            return string;
        }
        for (int i = 1; i < string.length(); i++) {
            string.deleteCharAt(i);
        }
        return new StringBuilder(string);
    }

//    public static StringBuilder changeFirstLAndLastWords(StringBuilder stringBig) {
//        if (stringBig.length() == 0) {
//            return stringBig;
//        }
//        int index = 0;
//        for (int i = 0; i < stringBig.length(); i++) {
//            index = stringBig.indexOf(" ", i);
//        }
//        stringBig.delete(0, index);
//        return new StringBuilder();
//    }
}
