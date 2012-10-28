package li.template.core;

import java.util.List;

import li.template.model.DyntaxTree;

/**
 * 2. 语法分析器
 * 
 * @author li
 */
public class SyntacticAnalyzer {
    public DyntaxTree process(List<String> words) {
        for (String word : words) {
            if (word.startsWith("<!---") && word.endsWith("-->")) {
                System.out.println("STATEMENT: " + word);
            } else {
                System.out.println("TEXT: " + word);
            }
        }
        return null;
    }
}