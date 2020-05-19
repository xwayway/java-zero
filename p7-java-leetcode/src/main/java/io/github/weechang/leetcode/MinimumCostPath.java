package io.github.weechang.leetcode;

/**
 * 二位数组，从坐上角到右下角，最短路径
 *
 * @author zhangwei
 * date 2020/5/19
 * time 13:15
 */
public class MinimumCostPath {

    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println("达到矩阵右下角" + " (2, 2) 的最小成本 = " + minCost(cost, 2, 2));
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = cost[0][0];
        for (i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }
        return dp[m][n];
    }

    private static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }


}
