package li.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Part {
    public abstract String process(Map<String, Object> map);

    public static List<Part> from(String template) {
        List<Part> parts = new ArrayList<Part>();
        String regex = "(?=<!---|-->)";
        String[] strs = template.split(regex);
        for (String str : strs) {
            // if (str == "") {
            // parts.add(new ReplacePart(str));
            // } else if (str == "") {
            parts.add(new StatementPart(str));
            // } else {
            // parts.add(new StaticPart(str));
            // }
        }
        return parts;
    }
}