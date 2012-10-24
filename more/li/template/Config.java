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

    public static void setPlaceHolderStart(String placeHolderStart) {
        config.put("placeHolderStart", placeHolderStart);
    }

    public static String getPlaceHolderStart() {
        return config.get("placeHolderStart");
    }
}