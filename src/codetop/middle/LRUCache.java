package codetop.middle;

import java.util.HashMap;

/**
 * @author Nebula
 * @date 2021/10/9 16:35
 * @description: 使用循环链表+map实现 LRU缓存机制
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        //System.out.println(lruCache);
    }

    DLinkedListNode lruHead;
    DLinkedListNode lruTail;
    HashMap<Integer, DLinkedListNode> map;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        //初始化lru链表
        this.capacity = capacity;
        //指向空头结点,尾结点，用作辅助结点
        this.lruHead = new DLinkedListNode(-1, -1, null, null);
        this.lruTail = new DLinkedListNode(-1, -1, null, null);
        lruHead.next = lruTail;
        lruTail.pre = lruHead;
        map = new HashMap<>(capacity);
        //初始化个数
        this.size = 0;
    }

    public int get(int key) {
        DLinkedListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedListNode node = map.get(key);
        //先搜索一下是否是相同key
        if (node != null) {
            node.value = value;
            moveToHead(node);
        }
        //找不到该结点node==null
        else {
            //新建一个结点，插入头部，当size小于容量时，直接插入头部
            if (size < capacity) {
                node = new DLinkedListNode(key, value, null, null);
                //插入头部
                addToHead(node);
                map.put(key, node);
                size++;
            }
            //当size等于容量时，删除最后一个结点，将新节点插入头部
            else if (size == capacity) {
                node = removeTail();
                map.remove(node.key);
                //插入头部
                node.key = key;
                node.value = value;
                addToHead(node);
                map.put(key, node);
            }
        }
    }

    /**
     * 删除结点
     *
     * @param node 待删除结点
     */
    public void removeNode(DLinkedListNode node) {
        //断链,删除结点
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 插入头部
     *
     * @param node 待插入结点
     */
    public void addToHead(DLinkedListNode node) {
        node.next = lruHead.next;
        lruHead.next = node;
        node.pre = lruHead;
        node.next.pre = node;
    }

    /**
     * 移动到头部
     *
     * @param node 待移动结点
     */
    public void moveToHead(DLinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾结点
     *
     * @return 返回删除结点
     */
    public DLinkedListNode removeTail() {
        DLinkedListNode res = lruTail.pre;
        removeNode(res);
        return res;
    }
}

/**
 * 双向链表
 */
class DLinkedListNode {
    int key;
    int value;
    DLinkedListNode pre;
    DLinkedListNode next;

    public DLinkedListNode() {
    }

    public DLinkedListNode(int key, int value, DLinkedListNode next, DLinkedListNode pre) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DLinkedListNode{" +
                "key=" + key +
                ", value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}