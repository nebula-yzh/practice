package codetop.medium;

/**
 * @author Nebula
 * @date 2022/4/14 9:23
 * @description: 547. 省份数量 medium
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，
 * 那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * <p>
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * 输入：isConnected = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * 输出：3
 * <p>
 * 输入：isConnected = [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出：2
 */
public class S547NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        int circleNum = findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    /**
     * 法1、并查集
     * 连通的为一个省份，计算所有不连通的城市
     * 是一个对称矩阵，因此只用看一边即可
     * <p>
     * 法2：深搜也可
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        int col = isConnected[0].length;
        int[] parent = new int[row];
        //初始有n个省会
        int res = parent.length;
        //自己是自己的父节点
        for (int i = 0; i < row; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < row; i++) {
            int start = find(parent, i);
            for (int j = i; j < col; j++) {
                int end = find(parent, j);
                if (isConnected[i][j] == 1 && start != end) {
                    //合并父节点
                    parent[end] = start;
                    //每次有连通就会减少省会
                    res--;
                }
            }
        }
        return res;
    }

    /**
     * 通过递归查找父节点
     *
     * @param parent
     * @param val
     * @return
     */
    public static int find(int[] parent, int val) {
        if (parent[val] == val) {
            return val;
        }
        return find(parent, parent[val]);
    }

    /**
     * 深度优先搜索
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum2(int[][] isConnected) {
        // int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int n = isConnected.length;
        // 定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[n];
        // 定义 cnt 来累计遍历过的连通域的数量
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则遍历新的连通域且cnt+=1.
            if (!visited[i]) {
                cnt++;
                dfs(i, isConnected, visited);
            }
        }
        return cnt;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        // 对当前顶点 i 进行访问标记
        visited[i] = true;

        // 继续遍历与顶点 i 相邻的顶点（使用 visited 数组防止重复访问）
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }


}
