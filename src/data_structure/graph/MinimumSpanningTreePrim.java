package data_structure.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nebula
 * @date 2022/4/12 10:00
 * @description: 图的应用，最小生成树 Prim 普里姆算法
 * 采用邻接矩阵
 */
public class MinimumSpanningTreePrim {


    /**
     * 一个输入函数
     * 输入顶点数量vertexNum
     * 边的数量edgeNum
     * 所有顶点及权值
     * 5 7
     * 0 1 2      表示顶点0到顶点1的权值为2
     * 0 2 3
     * 0 3 1
     * 1 3 4
     * 2 3 1
     * 2 4 1
     * 3 4 3
     */
    static int vertexNum;

    /**
     * prim算法 最小生成树
     * 输入邻接矩阵
     *
     * @param n         节点个数
     * @param graph     输入由邻接矩阵表示的n*n的图 -1表示两点之间无边，i，j表示边，graph[i][j]表示权值
     * @param lowCost   最小的权值
     * @param isVisited 当前节点是否被访问过 0未访问，1-已访问
     * @return 输出最小的生成树的最小权值
     */
    public static int prim(int n, int[][] graph, int[] lowCost, int[] isVisited) {
        //将-1变成最大值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == -1) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //将到所有节点的cost置为最大
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        //到0节点的cost置为0
        lowCost[0] = 0;
        //表示已经经过了0节点
        isVisited[0] = 1;
        //记录当前0节点到其他节点的最小cost
        if (n - 1 >= 0) {
            System.arraycopy(graph[0], 1, lowCost, 1, n - 1);
        }

        //然后循环遍历每个节点，找到到达自己节点的最小cost
        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            int index = 0;
            //遍历每个节点判断是否访问，找到最小的cost，以及下标，访问该节点
            for (int j = 1; j < n; j++) {
                if (minCost > lowCost[j] && isVisited[j] != 1) {
                    minCost = lowCost[j];
                    index = j;
                }
            }
            //更新访问-表示当前节点已访问
            isVisited[index] = 1;
            //然后根据当前选择的节点到其他节点的权值，更新lowCost中到达每个节点的最小权值
            //每次选择新的节点都要重新更新
            for (int k = 1; k < n; k++) {
                if (graph[index][k] < lowCost[k] && isVisited[k] != 1) {
                    lowCost[k] = graph[index][k];
                }
            }
        }
        return Arrays.stream(lowCost).sum();
    }

    static int edgeNum;

    /**
     * 输入
     * 5
     * -1 2 3 1 -1
     * 2 -1 -1 4 -1
     * 3 -1 -1 1 1
     * 1 4 1 -1 3
     * -1 -1 1 3 -1
     */
    public static void main(String[] args) {
        //int n;
        //int[][] graph;
        //int[] lowCost;
        //int[] isVisited;
        //Scanner in = new Scanner(System.in);
        ////结点个数
        //n = in.nextInt();
        ////输入的图，邻接矩阵表示
        //graph = new int[n][n];
        ////记录到达那个点的最小权值
        //lowCost = new int[n];
        ////节点是否访问
        //isVisited = new int[n];
        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < n; j++) {
        //        graph[i][j] = in.nextInt();
        //    }
        //}

        //另外输入，构造邻接矩阵
        //5 7
        //0 1 2      表示顶点0到顶点1的权值为2
        //0 2 3
        //0 3 1
        //1 3 4
        //2 3 1
        //2 4 1
        //3 4 3
        int[][] graph = input();
        int n = vertexNum;
        int[] lowCost = new int[n];
        int[] isVisited = new int[n];
        int ans = prim(n, graph, lowCost, isVisited);
        System.out.println(ans);
    }

    public static int[][] input() {
        Scanner scanner = new Scanner(System.in);
        //顶点数量
        vertexNum = scanner.nextInt();
        //边的数量
        edgeNum = scanner.nextInt();
        int[][] graph = new int[vertexNum][vertexNum];
        //初始化
        for (int[] ints : graph) {
            Arrays.fill(ints, -1);
        }
        //若输入按顺序则无需排序，若不按顺序，则需要按第一个节点排序
        //输入edgeNum条边
        //构建邻接矩阵
        for (int i = 0; i < edgeNum; i++) {
            //输入每个边的起始、结束以及权值
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            //邻接矩阵是对称的
            graph[start][end] = weight;
            graph[end][start] = weight;
        }
        return graph;
    }
}
