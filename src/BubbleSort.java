/**
 *  冒泡排序
 *  分类 -------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- O(n^2)
 *  最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 *  平均时间复杂度 ---- O(n^2)
 *  所需辅助空间 ------ O(1)
 *  稳定性 ------------ 稳定
 */
public class BubbleSort {

    // 不允许产生任何实例
    private BubbleSort() {}

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 增加一个flag以判断后面循环还需不需要
    public static void sortOptimize(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int flag = 0;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = 1;
                }
            }

            if (flag == 0) {
                return;
            }
        }
    }

    public static void sortOptimize2(int[] arr) {
        int n = arr.length;
        int k = n - 1, pos = 0;
        for (int i = 0; i < n - 1; i++) {
            int flag = 0;

            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = 1;  // 只要发生了交换，flag就置1
                    pos = j;  // 记录最后一次交换的位置
                }
            }

            k = pos;    // 每趟扫描中，记住最后一次交换发生的位置lastExchange，（该位置之后的相邻记录均已有序）。
                        // 下一趟排序开始时，R[1..lastExchange-1]是无序区，R[lastExchange..n]是有序区。
            if (flag == 0) {
                return;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        BubbleSort.sort(arr);
//        BubbleSort.sortOptimize(arr);
        BubbleSort.sortOptimize2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
