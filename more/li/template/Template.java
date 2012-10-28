package li.template;

import java.io.Writer;
import java.util.List;
import java.util.Map;

import li.template.core.CodeGenerator;
import li.template.core.CodeOptimizer;
import li.template.core.IntermediateCodeGenerator;
import li.template.core.LexicalAnalyzer;
import li.template.core.SemanticAnalyzer;
import li.template.core.SyntacticAnalyzer;
import li.template.model.DyntaxTree;

public class Template {
    static LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();// 词法分析器
    static SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();// 语法分析器
    static SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();// 语义分析器
    static IntermediateCodeGenerator intermediateCodeGenerator = new IntermediateCodeGenerator();// 中间代码生成器
    static CodeOptimizer codeOptimizer = new CodeOptimizer();// 代码优化器
    static CodeGenerator codeGenerator = new CodeGenerator();// 代码生成器

    private String content;

    private Map<Object, Object> map;

    public Template(String content) {
        this.content = content;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public void merge(Writer writer) {
        compile();
    }

    public void compile() {
        List<String> words = lexicalAnalyzer.process(this.content);
        DyntaxTree dyntaxTree = syntacticAnalyzer.process(words);
    }
}