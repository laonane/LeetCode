package wiki.laona.leetcode.designpattern.template;

/**
 * @author laona
 * @description 抽象模板
 * @create 2021-06-03 23:09
 **/
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod() {
        init();
        // important
        apply();
        // 可以作为钩子方法
        end();
    }

    /**
     * 初始化方法，子类也可以复写
     */
    protected void init() {
        System.out.println("AbstractTemplate.init -> 抽象层已经实现，子类也可以选择覆写");
    }

    /**
     * 子类需要实现该方法
     */
    protected abstract void apply();

    protected void end() {

    }
}
