package li.template;

import java.util.Map;

public class StaticPart extends Part {
    private String content;

    public StaticPart(String content) {
        this.content = content;
    }

    public String process(Map<String, Object> map) {
        return this.content;
    }
}