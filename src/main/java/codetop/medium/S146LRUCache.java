package codetop.medium;

/**
 * @author Nebula
 * @date 2021/10/9 9:53
 * @description: 146. LRU 缓存机制 中等
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 S146LRUCache2 类：
 * S146LRUCache2(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 算法思想：
 * 利用链表实现，每次遍历搜索key值
 * {
 * 法1.在初始将链表循环创建，根据capacity创建结点，后序每次查找都要循环整个链表----错误
 * 法2.初始只创建一个结点，每次添加时跟capacity比较是否小于容量，不用每次进行链表循环
 * <p>
 * 将每次get的结点放到头结点上来，put添加结点时，若大于容量则删除尾结点，并将新的结点添加到头，不大于则直接添加到头结点
 * <p>
 * }
 *
 * 法3：使用双向链表+map 实现O(1)的时间复杂度
 * <p>
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 */
public class S146LRUCache {
    public static void main(String[] args) {
        S146LRUCache lruCache = new S146LRUCache(10);

        lruCache.put(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 2);
        lruCache.put(3, 2);
        lruCache.put(4, 2);
        lruCache.put(5, 2);
        lruCache.put(6, 2);
        lruCache.put(7, 2);
        lruCache.put(8, 2);
        lruCache.put(9, 2);
        lruCache.put(10, 2);
        lruCache.put(1, 1);


        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.lruList);

        //[7,22],[11,26],[8,17],[9,29],[3,4],[12],[4,29]
        // [10,28],[1,20],[11,13],[7]
    }

    LinkedListNode lruList;
    int capacity;
    int size;

    /**
     * 超时
     * @param capacity
     */
    public S146LRUCache(int capacity) {
        //初始化lru链表
        this.capacity = capacity;
        //指向空头结点，用作辅助结点
        this.lruList = new LinkedListNode(-1, -1, null);
        //初始化个数
        this.size = 0;
    }

    public int get(int key) {
        LinkedListNode pointer = lruList;
        while (pointer.next != null) {
            if (pointer.next.key == key) {
                LinkedListNode newHead = pointer.next;
                pointer.next = pointer.next.next;
                newHead.next = lruList.next;
                lruList.next = newHead;
                return newHead.value;
            }
            pointer = pointer.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        LinkedListNode pointer = lruList;
        //先搜索一下是否相同key
        while (pointer.next != null) {
            //找关键字，若value不同则更新,再将更新后的结点放到头结点
            if (pointer.next.key == key && pointer.next.value != value) {
                pointer.next.value = value;
                LinkedListNode newHead = pointer.next;
                pointer.next = pointer.next.next;
                newHead.next = lruList.next;
                lruList.next = newHead;
                return;
            }
            //需要判断当put的key value相同时，不改变原来的缓存链表
            else if (pointer.next.key == key && pointer.next.value == value){
                return;
            }
            pointer = pointer.next;
        }
        //若找不到相同关键字,插入key到头结点,未达容量上限
        if (size < capacity) {
            LinkedListNode node = new LinkedListNode(key, value, null);
            node.next = lruList.next;
            lruList.next = node;
            ++size;
        }
        //若容量满了，删除尾结点,并加到头结点处,可以使用双向链表，此处用循环找尾结点
        else if (size == capacity) {
            //保存尾结点的前一个结点
            LinkedListNode last = lruList;
            //找到尾结点的前一个结点
            for (int i = size; i > 1; i--) {
                last = last.next;
            }
            //添加结点到头结点
            //更新key value
            last.next.key=key;
            last.next.value=value;
            //连接到头结点处
            if (size!=1){
                last.next.next=lruList.next;
                lruList.next=last.next;
                last.next=null;
            }

        }
    }
}

/**
 * 链表
 */
class LinkedListNode {
    int key;
    int value;
    LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int key, int value, LinkedListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
/**
 * Your S146LRUCache2 object will be instantiated and called as such:
 * S146LRUCache2 obj = new S146LRUCache2(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
