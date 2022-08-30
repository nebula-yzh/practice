package data_structure.binarytree;

/**
 * 线索二叉树
 * 将结点的空链域指向中序（后序、先序都可）遍历后的直接前驱或者后继
 * 使用标志位区分左右结点的左右指针指向的是左右孩子还是前驱后继
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        ThreadTree root = new ThreadTree();
        root.data = 1;
        ThreadTree node2 = new ThreadTree();
        node2.data = 2;
        ThreadTree node3 = new ThreadTree();
        node3.data = 3;
        ThreadTree node4 = new ThreadTree();
        node4.data = 4;
        ThreadTree node5 = new ThreadTree();
        node5.data = 5;
        ThreadTree node6 = new ThreadTree();
        node6.data = 6;
        ThreadTree node7 = new ThreadTree();
        node7.data = 7;
        root.leftNode = node2;
        root.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;

        System.out.println(root);

        //中序遍历，并线索化二叉树
        System.out.println("中序遍历并线索化");
        root.InThread(root);
        System.out.println();
        //查找某一结点
        System.out.println("查找某一结点前驱");
        root.findPreNode(node3);
        System.out.println("查找某一结点后继");
        root.findPostNode(node3);

        System.out.println("打印一个线索二叉树");
        System.out.println(root);
    }
}

/**
 * 线索二叉树结构
 */
class ThreadTree {
    public int data;
    public ThreadTree leftNode;
    public ThreadTree rightNode;
    public int leftTag;  //标志位  若为1，则指向前驱或后继，若为0指向左右孩子
    public int rightTag;

    /**
     * 中序遍历二叉树，一边遍历一边线索化
     * 还需要单独处理最后结点的rtag的值
     * <p>
     * 先序后序遍历二叉树并线索化，只是将visit换个位置
     *
     * @param threadTree
     */
    public void InThread(ThreadTree threadTree) {
        if (threadTree != null) {
            InThread(threadTree.leftNode);
            visit(threadTree);
            InThread(threadTree.rightNode);
        }
//        if (pre.rightNode == null) { //单独处理最后一个结点
//            pre.leftTag = 1;
//        }
    }

    public static ThreadTree pre; //指向当前结点的前驱

    /**
     * 进行二叉树的线索化
     * 若当前结点的左孩子为空，建立前驱线索化，置ltag=1，不能通过当前结点建立后继线索
     * 通过pre结点建立后继线索
     *
     * @param node
     */
    public void visit(ThreadTree node) {
        if (node.leftNode == null) {//左子树为空，建立前驱线索
            node.leftNode = pre;
            node.leftTag = 1;
        }
        if (pre != null && pre.rightNode == null) {//前驱结点不为空，前驱结点右子树为空，建立前驱结点的后继线索
            pre.rightNode = node;//把当前结点作为后继
            pre.rightTag = 1;
        }
        pre = node;//前驱结点往后移动
        System.out.print(node.data + " ");
    }

    public void findPreNode(ThreadTree node) {
        if (node.leftTag == 1 && node.leftNode != null) {
            System.out.println(node.leftNode.data);
        } else {
            if (node.leftNode != null) {
                ThreadTree leftNode = findLeftLastNode(node.leftNode);
                System.out.println(leftNode.data);
            } else {
                System.out.println((Object) null);
            }

        }

    }

    public void findPostNode(ThreadTree node) {
        if (node.rightTag == 1 && node.rightNode != null) {
            System.out.println(node.rightNode.data);
        } else {
            if (node.rightNode != null) {
                ThreadTree rightNode = findRightFirstNode(node.rightNode);
                System.out.println(rightNode.data);
            } else System.out.println((Object) null);

        }
    }

    /**
     * 找到当前结点的右子树中第一个被中序访问的结点
     *
     * @param node 当前结点的右孩子
     */
    public ThreadTree findRightFirstNode(ThreadTree node) {
        while (node.leftTag == 0) { //有左孩子
            node = node.leftNode;
        }
        return node;
    }

    /**
     * 找到当前结点的左子树中最后一个被中序访问的结点
     *
     * @param node 当前结点的左孩子
     */
    public ThreadTree findLeftLastNode(ThreadTree node) {
        while (node.rightTag == 0) { //有右孩子
            node = node.rightNode;
        }
        return node;
    }

    @Override
    public String toString() {
        return "ThreadTree{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", leftTag=" + leftTag +
                ", rightTag=" + rightTag +
                '}';
    }
}
