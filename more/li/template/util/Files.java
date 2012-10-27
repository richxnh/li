package li.template.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Files {
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
}