package li.template;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private static final Map<String, String> config = new HashMap<String, String>();

    public static void setStatementStart(String statementStart) {
        config.put("statementStart", statementStart);
    }

    public static String getStatementStart() {
        return config.get("statementStart");
    }

    public static void setStatementEnd(String statementEnd) {
        config.put("statementEnd", statementEnd);
    }

    public static String getStatementEnd() {
        return config.get("statementEnd");
    }

    public static void setPlaceHolderStart(String placeHolderStart) {
        config.put("placeHolderStart", placeHolderStart);
    }

    public static String getPlaceHolderStart() {
        return config.get("placeHolderStart");
    }

    public static void setPlaceHolderEnd(String placeHolderEnd) {
        config.put("placeHolderEnd", placeHolderEnd);
    }

    public static String getPlaceHolderEnd() {
        return config.get("placeHolderEnd");
    }

    public static String getRegex() {
        return "((?=<!---)|(?<=-->))";//((?=<!---)|(?<=-->))|((?=\\u0024\\u007B)|(?<=}))
    }
}