package wiki.laona.leetcode.designpattern.template;

/**
 * @author laona
 * @description 模板方法实现类
 * @create 2021-06-03 23:14
 **/
public class ConcreteTemplate extends AbstractTemplate{

    @Override
    protected void apply() {
        System.out.println("ConcreteTemplate.apply -> 子类实现抽象方法 apply");
    }

    @Override
    protected void end() {
        System.out.println("ConcreteTemplate.end -> 我们可以把 end 当做钩子方法来使用，需要的时候覆写就可以了");
    }
}
