package data_structure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nebula
 * @date 2022/4/12 11:16
 * @description: 图的应用，最小生成树 Kruskal
 * 克鲁斯卡尔算法
 */
public class MinimumSpanningTreeKruskal {

    public static void main(String[] args) {
        //默认以a为根节点的最小生成树
        Scanner in = new Scanner(System.in);
        //顶点个数
        int vertexNum = in.nextInt();
        //表示图的邻接矩阵
        int[][] graph = new int[vertexNum][vertexNum];
        //存储边的集合
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                graph[i][j] = in.nextInt();
            }
        }
//        for(int i=0;i<M;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                int x,y,val;
//                x = in.nextInt();
//                y = in.nextInt();
//                val = in.nextInt();
//                graph[x][y] = val;
//            }
//        }


        //* 输入
        //* 5
        //* -1 2 3 1 -1
        //* 2 -1 -1 4 -1
        //* 3 -1 -1 1 1
        //* 1 4 1 -1 3
        //* -1 -1 1 3 -1
        //遍历每个节点将边存入集合，只遍历右上角，因为是对称的
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (graph[i][j] >= 0) {
                    //将顶点以及权重加入集合
                    list.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

//        for (int i = 0; i <M; i++) {
//            int x,y,val;
//            x = in.nextInt();
//            y = in.nextInt();
//            val = in.nextInt();
//            list.add(new Edge(x,y,val));
//        }

        //数组中每一个节点都只知道他的父节点是什么，-1表示不存在父节点，0位置是根节点
        int[] parent = new int[vertexNum];
        //初始化每个节点的父节点都是自己
        for (int i = 0; i < vertexNum; i++) {
            parent[i] = i;
        }
        int m, n;
        int num = 0;
        int sum = 0;
        //根据权重排序，从小到大
        Collections.sort(list);
        for (Edge edge : list) {
            //查找边的起始和结束节点的父节点
            m = find(parent, edge.begin);
            n = find(parent, edge.end);
            //判断其父节点是否相等，若不相等，则可以相连
            //然后更新父节点数组
            if (m != n) {
                //合并根节点
                parent[m] = n;
                //权值累加
                sum += edge.weight;
                //边的数量累加
                num++;
            }
            //最后判断边的数量
            if (num == vertexNum - 1) {
                break;
            }
        }
        System.out.println(sum);
    }

    /**
     * 查找x的父节点
     * 使用的是并查集
     *
     * @param parent 父节点数组
     * @param x      待查找节点
     * @return
     */
    private static int find(int[] parent, int x) {
        //通过循环一直找到最大的父节点（最后为根节点）
        //判断当前父节点的值是否等于自己的节点值，不等于说明有其他父节点
        //while (x != parent[x]) {
        //    x = parent[x];
        //}
        //return x;

        //递归的方法
        if (parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }
//    public static void unite(int[] parent, int x, int y)
//    {
//        x = find(parent,x);
//        y = find(parent, y);
//        parent[x] = y;
//    }

    static class Edge implements Comparable<Edge> {
        //起始点
        public int begin;
        //终止点
        public int end;
        //权值
        public int weight;
        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            if (o.weight > this.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
