package test.leetcode.数组.simple;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/30 10:31
 */
public class 岛屿的周长463 {


    /**
     * 思路
     * -> 假如只有一个格子陆地 -> 周长为 4
     * 2个格子陆地周长为 4+4-2
     * -> grid[i][j] == 1 ->  rep +=4
     * grid[i - 1][j] == 1，grid[i][j - 1] == 1 ->  rsp -= 2
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        //重点关注前面遍历过得方格，如果之前有相邻方格，就-2;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rsp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rsp += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        rsp -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        rsp -= 2;
                    }
                }
            }
        }
        return rsp;
    }
}
