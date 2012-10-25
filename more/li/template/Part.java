package li.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import li.util.Verify;

public abstract class Part {
    public abstract String process(Map<String, Object> map);

    public static List<Part> from(String template) {
        List<Part> parts = new ArrayList<Part>();
        String regex = "(?=<!---)|(?<=-->)";// (?=<!---|\\u0024\\u007B)|(?<=-->|})
        String[] strs = template.split(regex);
        for (int i = 0; i < strs.length;) {
            if (Verify.regex(strs[i], "<!---.*-->")) {
                if (Verify.regex(strs[i], "<!---.*for.*-->")) {
                    // parts.add(new StatementPart(strs[i]));
                    System.out.println("for " + strs[i]);
                    i++;
                } else if (Verify.regex(strs[i], "<!---.*if.*-->")) {
                    // parts.add(new StatementPart(strs[i]));
                    System.out.println("if " + strs[i]);
                    i++;
                } else {
                    i++;
                }
            } else {
                parts.add(new StaticPart(strs[i]));
                i++;
            }
        }
        return parts;
    }
}