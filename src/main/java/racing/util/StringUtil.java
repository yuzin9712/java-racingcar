package racing.util;

public class StringUtil {
    public static String[] split(String inputs) {
        return inputs.replaceAll("[\\t\\s]","").split(",");
    }
}