package li.template;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Freemarker {
    public static void main(String[] args) {
        Fm fm = new Fm("fm.htm");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("message", "hello");
        Writer writer = new OutputStreamWriter(System.out);
        fm.merge(map, writer);
    }
}

class Fm {
    private Template template;

    public Fm(String path) {
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File("E:\\workspace\\li\\more\\li\\template"));
            template = configuration.getTemplate(path, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void merge(Map map, Writer writer) {
        try {
            template.process(map, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}