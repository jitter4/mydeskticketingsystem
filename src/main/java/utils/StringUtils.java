package utils;

public class StringUtils {

    public static Integer toInteger(String n) {
        Integer result = null;
        try {
            result = Integer.valueOf(n);
        } catch (Exception ex) {
            System.out.println("Not a number");
        }
        return result;
    }

}
