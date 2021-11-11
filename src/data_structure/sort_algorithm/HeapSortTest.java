package data_structure.sort_algorithm;

/**
 * @author Nebula
 * @date 2021/11/7 08:21
 * @description: 堆排序
 * 堆分为大根堆和小根堆，是一个完全二叉树，根 > 左、右
 * 大根堆，堆顶元素最大，根节点最大，满足沿着某一条分支都小于其父节点
 * 小根堆，堆顶元素最小，根节点最小，满足沿着某一条分支都大于其父节点
 * 与平衡二叉树有所不同
 * <p>
 * i>=1 ，一般若用数组存储，0位置空出来，i表示第i个结点
 * i的左孩子 2i
 * i的右孩子 2i+1
 * i的父节点 [i/2] 向下取整
 * 非终端结点: i<=[n/2]
 * 算法思想：
 * 一、建立大根堆
 * 1.从下往上，将所有非终端结点都检查一遍，是否满足大根堆要求(根>左、右)；
 * 2.若不满足则进行调整(将当前结点与更大的一个孩子交换)，
 * 将小元素下坠，若元素互换破坏了下一级的堆，采用相同方式调整，直到坠到最低。
 * 4.循环1,2完成建堆
 * 3.进行堆排序：
 * 5.再将待排序序列再次调整为大根堆(小元素不断下坠)
 * 完成一个升序排序序列
 *
 * 若数组第一个元素存放元素，
 * 1.复制到大的数组，再复制回来
 * 2.将下标改动，比较麻烦
 */
public class HeapSortTest {
    public static void main(String[] args) {
        HeapSortTest heapSort = new HeapSortTest();
        int[] arr = new int[]{0, 9, 22, 6, 3, 8, 1, 125, 546, 874, 1215, 124, 0, 23, 6};
        int len = arr.length - 1;
        //heapSort.buildMaxHeap(arr,len);
        //heapSort.headSortRecursive(arr,len);
        heapSort.headSort(arr, len);
        for (int i : arr) {
            System.out.println(i);

        }
    }

    /**
     * 非递归堆排序
     *
     * @param arr
     * @param len
     */
    public void headSort(int[] arr, int len) {
        buildMaxHeap(arr, len);
        //进行堆排，每一趟将堆顶元素加入有序子序列(与待排序列的最后一个元素(最小的)交换)，
        for (int i = len; i > 1; i--) {
            swap(arr, i);
            HeadAdjust(arr, 1, i - 1);
        }
    }

    public void swap(int[] arr, int len) {
        arr[0] = arr[1];
        arr[1] = arr[len];
        arr[len] = arr[0];
    }

    /**
     * 堆排序，递归，需要先建大根堆
     *
     * @param arr
     * @param len
     */
    public void headSortRecursive(int[] arr, int len) {
        if (len < 0) {
            return;
        }
        //进行堆排，每一趟将堆顶元素加入有序子序列(与待排序列的最后一个元素(最小的)交换)，
        arr[0] = arr[1];
        arr[1] = arr[len];
        arr[len] = arr[0];
        HeadAdjust(arr, 1, --len);
        headSortRecursive(arr, len);
    }

    /**
     * 建立大根堆
     *
     * @param arr 待操作数组
     * @param len 结点个数
     */
    public void buildMaxHeap(int[] arr, int len) {
        //自底向上，开始调整，从最后一个非终端结点开始
        //若从上往下，下面结点调整后，不能保证上面结点满足大根堆
        for (int i = len / 2; i > 0; i--) {
            HeadAdjust(arr, i, len);
        }
    }

    /**
     * 将以k为根的子树调整为大根堆
     * 数组一个位置不使用
     *
     * @param arr 待调整数组
     * @param k   k为当前子树根结点下标
     * @param len 结点个数
     */
    public void HeadAdjust(int[] arr, int k, int len) {
        //用数组第一个位置，暂存子树的根节点.。若不用数组第一个位置保存结点，需要将i-1
        arr[0] = arr[k];
        //沿着值较大的子节点往下筛选，i的左子节点为2*i
        for (int i = 2 * k; i <= len; i *= 2) {
            //选择较大的子节点，跟根结点进行比较
            if (i < len && arr[i] < arr[i + 1]) {
                i++;
            }
            //若根节点大于较大的子节点，比较结束
            if (arr[0] >= arr[i]) {
                break;
            }
            //根结点小于较大的子节点
            else {
                //将较大的子节点arr[i]调整到父节点上
                arr[k] = arr[i];
                //修改k值，从当前位置开始，将根节点继续向下坠
                k = i;
            }
        }
        //循环结束,下坠完成,将筛选结点(根节点)放入最终位置
        arr[k] = arr[0];
    }
}
