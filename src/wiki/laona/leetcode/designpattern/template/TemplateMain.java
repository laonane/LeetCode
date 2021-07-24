package wiki.laona.leetcode.designpattern.template;

/**
 * @author laona
 * @description 模板测试
 * @create 2021-06-03 23:15
 **/
public class TemplateMain {

    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplate();
        // 调用模板方法
        template.templateMethod();
    }
}
