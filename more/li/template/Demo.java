package li.template;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import li.template.util.Files;

public class Demo {
    public static void main(String[] args) {
        Template template = new Template(Files.read(new File("E:\\workspace\\li\\more\\li\\template\\demo.htm")));
        Map<Object, Object> map = new HashMap<Object, Object>();
        template.setMap(map);
        Writer writer = new OutputStreamWriter(System.out);
        template.merge(writer);
    }
}