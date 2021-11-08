package data_structure.sort_algorithm;

/**
 * @author Nebula
 * @date 2021/11/7 11:02
 * @description: TODO
 */
public class HeapSortTest2 {
    public static void main(String[] args) {
        HeapSortTest2 heapSort = new HeapSortTest2();
        int[] arr = new int[]{111111, 9, 22, 6, 3, 8, 1, 125, 546, 874, 1215, 124, 0, 23, 6};
        //int[] arr1 = new int[arr.length + 1];
        //System.arraycopy(arr, 0, arr1, 1, arr.length);
        //for (int i : arr1) {
        //    System.out.print(i);
        //    System.out.print(" ");
        //}
        //System.out.println();
        //heapSort.headSort(arr1, arr1.length - 1);
        //for (int i : arr1) {
        //    System.out.print(i);
        //    System.out.print(" ");
        //}
        heapSort.headSort2(arr,arr.length);
        for (int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }

    }

    /**
     * 该数组所有元素都为待排序结点
     * 数组第一个元素也存放元素
     *
     * @param arr 待排序数组
     * @param k   第k个待调整的根节点，为该结点的数组下标+1
     * @param len 数组长度。也就是结点个数
     */
    public void HeadAdjust2(int[] arr, int k, int len) {
        //暂存当前根节点，后续需要比较
        int temp = arr[k - 1];
        for (int i = k * 2; i <= len; i *= 2) {
            //选择较大的孩子结点
            if (i < len && arr[i - 1] < arr[i]) {
                i++;
            }
            if (temp > arr[i - 1]) {
                break;
            } else {
                //将大的孩子，赋值给根节点
                arr[k - 1] = arr[i - 1];
                //继续下坠
                k = i;
            }
        }
        //循环结束，下坠完成，将根结点放到最终位置
        arr[k - 1] = temp;
    }

    /**
     * 堆排序
     * 先建堆，
     * 再取根节点排序
     *
     * @param arr
     * @param len
     */
    public void headSort2(int[] arr, int len) {
        buildMaxHeap(arr, len);
        for (int i = len; i > 1; i--) {
            swap2(arr, i);
            HeadAdjust2(arr,1,i-1);
        }
    }

    /**
     * 交换当前堆顶和堆底元素
     *
     * @param arr 待交换数组
     * @param len 当前结点个数
     */
    public void swap2(int[] arr, int len) {
        int temp = arr[0];
        arr[0] = arr[len - 1];
        arr[len - 1] = temp;
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
     * 建立大根堆
     *
     * @param arr 待操作数组
     * @param len 结点个数
     */
    public void buildMaxHeap(int[] arr, int len) {
        //自底向上，开始调整，从最后一个非终端结点开始
        //若从上往下，下面结点调整后，不能保证上面结点满足大根堆
        for (int i = len / 2; i > 0; i--) {
            HeadAdjust2(arr, i, len);
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
