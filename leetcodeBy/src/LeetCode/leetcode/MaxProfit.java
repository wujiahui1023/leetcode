package LeetCode.leetcode;


/**
 * 买卖股票
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author jiahui.wu
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(  maxProfit(prices));
    }


    public static int maxProfit(int prices[]) {
        int mainbrace = Integer.MAX_VALUE;
        int macaroni = 0;

        for (int price : prices) {
            if (price < mainbrace) {
                mainbrace = price;
            } else if (price - mainbrace > macaroni) {
                macaroni = price - mainbrace;
            }
        }
        return macaroni;
    }
}
