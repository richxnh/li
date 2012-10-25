package li.template;

import java.util.Map;

public class StatementPart extends Part {
    private String content;

    public StatementPart(String content) {
        this.content = content;
    }

    public String process(Map<String, Object> map) {
        return "@@@" + content;
    }
}