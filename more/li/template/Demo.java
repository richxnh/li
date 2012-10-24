package li.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Template template = new Template(read(new File("E:\\workspace\\li\\more\\li\\template\\template.htm")));
        template.setMap(toMap("message", "你好"));
        String text = template.merge();
        System.out.println(text);
    }

    public static String read(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception in li.util.Files.read(File)", e);

        }
        return stringBuffer.toString();
    }

    public static Map<String, Object> toMap(Object... objects) {
        return null;
    }
}