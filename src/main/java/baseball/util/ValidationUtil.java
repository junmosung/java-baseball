package baseball.util;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 8:54 PM
 */
public class ValidationUtil {

    public static final int MIN = 1;
    public static final int MAX = 9;

    public static boolean checkNo(int no) {
        return no >= MIN && no <= MAX;
    }

    public static boolean checkHundredth(int no) {
        return no < 1000;
    }

    public static boolean isNumberic(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
