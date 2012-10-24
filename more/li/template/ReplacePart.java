package li.template;

import java.util.Map;

public class ReplacePart extends Part {
    private String content;

    public ReplacePart(String content) {
        this.content = content;
    }

    public String process(Map<String, Object> map) {
        return "占位符内容,直接替换掉," + content;
    }
}