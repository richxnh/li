package li.template;

import java.util.Map;

public class ReplacePart extends Part {
    private String content;

    public ReplacePart(String content) {
        this.content = content;
    }

    public String process(Map<String, Object> map) {
        return map.get(content).toString();
    }
}