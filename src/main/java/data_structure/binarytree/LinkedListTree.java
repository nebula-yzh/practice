package data_structure.binarytree;

import java.util.Objects;

/**
 * 链式存储二叉树
 */
public class LinkedListTree {
    public static void main(String[] args) {
        ListTree root = new ListTree();
        root.data = 1;
        ListTree node1 = new ListTree();
        node1.data = 2;
        ListTree node2 = new ListTree();
        node2.data = 3;
        ListTree node3 = new ListTree();
        node3.data = 4;
        root.leftNode = node1;
        root.rightNode = node2;
        node1.leftNode = node3;

        //先序遍历
        System.out.println("先序遍历");
        root.preOrder(root);
        System.out.println();
        //中序遍历
        System.out.println("中序遍历");
        root.inOrder(root);
        System.out.println();
        //后序遍历
        System.out.println("后序遍历");
        root.postOrder(root);
        System.out.println();
        //计算二叉树深度
        System.out.println("二叉树深度");
        System.out.println(root.treeDepth(root));
        //层序遍历
        System.out.println("层序遍历");
        root.levelOrder(root);
        System.out.println();

        //查找某个结点的中序前驱结点
        System.out.println("查找node2结点的中序前驱结点");
        root.findInOrder(root,node3);
        if(ListTree.finalNode!=null){
            System.out.println(ListTree.finalNode.data);
        }
        else{
            System.out.println((Object) null);
        }

    }
}

//链式存储二叉树的基本结构
//左右子树，分别为左右指针(引用)
class ListTree {
    public int data;
    public ListTree leftNode;
    public ListTree rightNode;

    /**
     * 先序遍历二叉树(递归)
     * 遍历操作步骤：
     * 1.若当前二叉树结点为空，则不作操作，直接返回
     * 2.当前二叉树结点不为空
     * 1)先访问根结点
     * 2)先序遍历左子树 (回到 1)
     * 3)先序遍历右子树 (回到 1)
     */
    public void preOrder(ListTree T) {
        if (T != null) {
            visitNode(T); //访问根节点
            preOrder(T.leftNode); //先序遍历左子树
            preOrder(T.rightNode); //先序遍历右子树
        }
    }

    /**
     * 中序遍历二叉树
     * * 遍历操作步骤：
     * 1.若当前二叉树结点为空，则不作操作，直接返回
     * 2.当前二叉树结点不为空
     * 1)先序遍历左子树 (回到 1)
     * 2)先访问根结点
     * 3)先序遍历右子树 (回到 1)
     *
     * @param T
     */
    public void inOrder(ListTree T) {
        if (T != null) {
            inOrder(T.leftNode); //中序遍历左子树
            visitNode(T); //访问根节点
            inOrder(T.rightNode); //中序遍历右子树
        }
    }

    /**
     * 查找中序遍历的某个结点的前驱
     * @param T
     */
    public void findInOrder(ListTree T,ListTree node) {
        if (T != null) {
            findInOrder(T.leftNode,node); //中序遍历左子树
            findPreNode(T,node);
            findInOrder(T.rightNode,node); //中序遍历右子树
        }
    }

    /**
     * 后序遍历二叉树
     * * 遍历操作步骤：
     * 1.若当前二叉树结点为空，则不作操作，直接返回
     * 2.当前二叉树结点不为空
     * 1)先序遍历左子树 (回到 1)
     * 2)先序遍历右子树 (回到 1)
     * 3)先访问根结点
     *
     * @param T
     */
    public void postOrder(ListTree T) {
        if (T != null) {
            postOrder(T.leftNode); //后序遍历左子树
            postOrder(T.rightNode); //后序遍历右子树
            visitNode(T); //访问根节点
        }
    }

    /**
     * 计算二叉树的最大深度
     * 遍历左右子树，找到最大深度值，返回该值
     * 操作步骤：
     * 1.若当前结点为空，返回0
     * 2.当前结点不为空
     * 1)遍历左子树，深度加1
     * 2)遍历右子树，深度加1
     * 3)比较左右子树深度并返回较大值
     * 4)继续回到1，直到返回到根节点
     * 类似于后序遍历
     * @param T
     * @return 返回最大深度
     */
    public int treeDepth(ListTree T) {
        if (T == null) {
            return 0;
        } else {
            int l = treeDepth(T.leftNode) + 1;
            int r = treeDepth(T.rightNode) + 1;
            //二叉树的深度为左子树或右子树最大深度+1
            return l > r ? l : r;
        }
    }

    /**
     * 层序遍历
     * 算法思想：
     * 1.借助辅助队列
     * 2.根节点入队
     * 3.若队列非空，队头结点出队，访问该结点，并将该结点的左右孩子入队(若有)
     * 4.重复3直至队列为空
     *
     * @param T
     */
    public void levelOrder(ListTree T) {
        if (T != null) {
            LinkQueue linkQueue = new LinkQueue();  //创建一个辅助队列，队列只有一个
            QueueNode queueNode = new QueueNode();  //创建队列的结点
            queueNode.TNode = T;                    //保存二叉树根结点的队列结点
            linkQueue.enQueue(queueNode);           //根节点入队
            while (!linkQueue.isEmpty(linkQueue)) {
                QueueNode node = linkQueue.deQueue(linkQueue);//队头结点出队
                visitNode(node);  //访问队头结点
                if (node.TNode.leftNode != null) {//左孩子入队
                    QueueNode leftChildNode = new QueueNode(); //创建队列结点
                    leftChildNode.TNode = node.TNode.leftNode;
                    linkQueue.enQueue(leftChildNode);
                }
                if (node.TNode.rightNode != null) {//右孩子入队
                    QueueNode rightChildNode = new QueueNode();
                    rightChildNode.TNode = node.TNode.rightNode;
                    linkQueue.enQueue(rightChildNode);
                }
            }

        }
    }

    /**
     * 访问当前结点
     *
     * @param node
     */
    public void visitNode(ListTree node) {
        System.out.print(node.data + " ");
    }

    public void visitNode(QueueNode node) {
        System.out.print(node.TNode.data + " ");
    }

    public static ListTree pre;
    public static ListTree finalNode;

    /**
     * 找当前结点的前驱结点
     * @param root 当前访问的结点
     * @param node 需要寻找的结点
     */
    public void findPreNode(ListTree root, ListTree node){
        if(node.equals(root)){
            finalNode=pre;
        }
        else{
             pre = root;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTree listTree = (ListTree) o;
        return data == listTree.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "ListTree{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

/**
 * 辅助队列，链式结构
 */
class LinkQueue {
    //队尾
    public QueueNode rear;
    //队头
    public QueueNode head;
    //队列长度
    public int size = 0;

    /**
     * 判断对列是否为空
     *
     * @param linkQueue
     * @return
     */
    public boolean isEmpty(LinkQueue linkQueue) {
        if (linkQueue.head == null && linkQueue.rear == null) {
            return true;
        }
        return false;
    }

    /**
     * 入队
     */
    public void enQueue(QueueNode queueNode) {
        if (head == null && rear == null) {
            head = rear = queueNode;
        } else {
            rear.next = queueNode;
            rear = queueNode;
        }
    }

    /**
     * 队头结点出队
     */
    public QueueNode deQueue(LinkQueue linkQueue) {
        QueueNode headNode = linkQueue.head;
        if (linkQueue.head == linkQueue.rear) {
            if (linkQueue.head != null) {
                linkQueue.head = linkQueue.rear = null;
            } else {
                System.out.println("队列为空,无法出队");
            }
        } else {
            linkQueue.head = linkQueue.head.next;
        }
        return headNode;
    }
}

/**
 * 队列的结点类,存放数据
 */
class QueueNode {
    public ListTree TNode;  //数据，二叉树结点
    public QueueNode next;  //下一个结点
}

