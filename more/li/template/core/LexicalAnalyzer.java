package li.template.core;

import java.util.Arrays;
import java.util.List;

import li.template.Config;

/**
 * 1. 词法分析器
 * 
 * @author li
 */
public class LexicalAnalyzer {
    public List<String> process(String content) {
        return Arrays.asList(content.split(Config.getRegex()));
    }
}