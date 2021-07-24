package wiki.laona.leetcode.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: LeetCode
 * @description: 计时小工具
 * @author: HuaiAnGG
 * @create: 2021-01-12 01:05
 **/
public class TimeTool {
    /**
     * 时间格式
     */
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSSS");

    public interface Task {
        void execute();
    }

    public static void check(String method, Task task) {
        if (task == null) {
            return;
        }
        method = (method == null) ? "" : ("【" + method + "】");
        System.out.println(method);
        System.out.println("开始：" + SIMPLE_DATE_FORMAT.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end  = System.currentTimeMillis();
        System.out.println("结束：" + SIMPLE_DATE_FORMAT.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("========================");
    }
}
