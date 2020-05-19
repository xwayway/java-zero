package io.github.weechang.leetcode;

/**
 * Dijkstra 算法
 *
 * @author zhangwei
 * date 2020/5/19
 * time 19:42
 */
public class Dijkstra {

    /**
     * 不连通状态
     */
    private static int IMAX = Integer.MAX_VALUE;
    public static int[][] adjMat = {
            {0, 1, 3, 6},
            {1, 0, IMAX, 6},
            {3, IMAX, 0, 2},
            {6, 6, 2, 0}
    };

    public static void main(String[] args) {
        dijkstra(adjMat,0,3);
    }

    public static void dijkstra(int[][] martix, int start, int terminal) {
        boolean[] isVisted = new boolean[martix.length];
        int[] d = new int[martix.length];
        for (int i = 0; i < martix.length; i++) {
            // 该点是否被计入，可以理解为判断该点是否已经加入集合B
            isVisted[i] = false;
            // 在当前的集合B所能连接的路径中，从起始点到该点的最短路径
            d[i] = IMAX;
        }
        isVisted[start] = true;
        d[start] = 0;
        int unVisitNode = martix.length;
        int index = start;
        while (unVisitNode > 0 && !isVisted[terminal]) {
            int min = IMAX;
            // 选出集合A中的点到集合B的路径最短的点
            for (int i = 0; i < d.length; i++) {
                if (min > d[i] && !isVisted[i]) {
                    index = i;
                    min = d[i];
                }
            }

            for (int i = 0; i < martix.length; i++) {
                // 更新当前的最短路径
                if (d[index] + martix[index][i] < d[i]) {
                    d[i] = d[index] + martix[index][i];
                }
            }
            unVisitNode--;
            isVisted[index] = true;
        }

        System.out.println(d[terminal]);
    }
}
