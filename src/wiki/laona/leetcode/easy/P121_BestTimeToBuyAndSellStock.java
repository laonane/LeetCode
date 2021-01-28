package wiki.laona.leetcode.easy;

import java.util.function.Predicate;

/**
 * @program: LeetCode
 * @description: 121. 买卖股票的最佳时机
 * @author: HuaiAnGG
 * @create: 2021-01-28 20:24
 **/
public class P121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        P121_BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new P121_BestTimeToBuyAndSellStock();

        int maxProfit = bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("maxProfit = " + maxProfit);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;
        int max = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < mini) {
                mini = prices[i];
            }else if (prices[i] - mini > max) {
                max = prices[i] - mini;
            }
        }
        return max;
    }
}
