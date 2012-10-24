package li.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Part {
    public abstract String process(Map<String, Object> map);

    public static List<Part> from(String template) {
        List<Part> parts = new ArrayList<Part>();
        String[] strs = template.split(Config.getPlaceHolderStart() + Config.getStatementStart());
        for (String str : strs) {
            if (str == "") {
                parts.add(new ReplacePart());
            } else if (str == "") {
                parts.add(new StatementPart());
            } else {
                parts.add(new StaticPart());
            }
        }
        return parts;
    }
}