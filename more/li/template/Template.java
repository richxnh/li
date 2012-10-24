package li.template;

import java.util.List;
import java.util.Map;

public class Template {
    private Map<String, Object> map;
    private List<Part> parts;

    public Template(String template) {
        this.parts = Part.from(template);
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String merge() {
        String result = "";
        for (Part part : parts) {
            result += part.process(map);
        }
        return result;
    }
}