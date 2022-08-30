package data_structure.binarytree;

/**
 * 顺序存储二叉树
 * 使用数组进行存储
 * [1,2,3,4,5,6,7,8,9,10]
 *
 * i的左孩子2i
 * i的右孩子2i+1
 * i的父节点[i/2]
 * i所在的层次[log2 i]+1
 */
public class SequenceTree {
    public static void main(String[] args) {
        int maxSize = 11;
        SeqTreeNode[] treeNode = new SeqTreeNode[maxSize];

        //实例化十个结点并存储数据
        //把第一个位置空出来
        for (int i = 1; i <= 10; i++) {
            treeNode[i] = new SeqTreeNode();  //实例化
            treeNode[i].value = i;
            treeNode[i].isEmpty = false;
        }
        for (SeqTreeNode node : treeNode) {
            System.out.println(node);
        }
    }
}

//二叉树结点基本结构，存储的值跟判断结点是否为空
class SeqTreeNode {
    public int value;
    public boolean isEmpty = true; //默认为空

    /**
     * 返回当前结点的左孩子
     * @param treeNode
     * @param i
     * @return
     */
    public SeqTreeNode findLeftChild(SeqTreeNode[] treeNode, int i) {
        if (!treeNode[i].isEmpty && !treeNode[2*i].isEmpty){
            return treeNode[i];
        }
        return null;
    }

    /**
     * 返回当前结点的右孩子
     * @param treeNode
     * @param i
     * @return
     */
    public SeqTreeNode findRightChild(SeqTreeNode[] treeNode, int i) {
        if (!treeNode[i].isEmpty && !treeNode[2*i+1].isEmpty){
            return treeNode[i];
        }
        return null;
    }

    @Override
    public String toString() {
        return "SeqTreeNode{" +
                "value=" + value +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
