package codetop.medium;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Nebula
 * @date 2022/4/14 14:33
 * @description: 1584. 连接所有点的最小费用 MEDIUM
 * 给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。
 * <p>
 * 连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：|xi - xj| + |yi - yj|，其中|val|表示val的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，才认为所有点都已连接。
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 */
public class S1584MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };
        int minCostConnectPoints = minCostConnectPoints(points);
        System.out.println(minCostConnectPoints);
    }

    /**
     * 图的应用，最小生成树
     * 1、克鲁斯卡尔算法
     * 将边排序，从最小的边开始，通过并查集进行选择连通
     *
     * @param points
     * @return
     */
    public static int minCostConnectPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        ArrayList<Edge> edges = new ArrayList<>();
        //先将输入的点转换,计算边的cost，加入集合
        //计算两两之间的距离
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                //曼哈顿距离
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, weight));
            }
        }
        //根据权值排序
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        int[] parent = new int[row];
        //设置父节点
        for (int i = 0; i < row; i++) {
            parent[i] = i;
        }
        //记录当前选择的边数
        int cnt = 0;
        //记录当前的最小费用
        int minCost = 0;
        //遍历所有边进行选择
        for (Edge edge : edges) {
            int m = find(parent, edge.getStart());
            int n = find(parent, edge.getEnd());
            //不是同一个父节点,则可以连接
            if (m != n) {
                parent[m] = n;
                //选择的边加1
                cnt++;
                //加花费
                minCost += edge.getWeight();
            }
            if (cnt == row - 1) {
                break;
            }
        }
        return minCost;
    }

    public static int find(int[] parent, int val) {
        if (parent[val] == val) {
            return val;
        }
        return find(parent, parent[val]);
    }

    static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
