/**
 *  选择排序
 *  分类 -------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- O(n^2)
 *  最优时间复杂度 ---- O(n^2)
 *  平均时间复杂度 ---- O(n^2)
 *  所需辅助空间 ------ O(1)
 *  稳定性 ------------ 不稳定
 *  不稳定举例： { 5, 8, 5, 2, 9 }，一次选择的最小元素是2，然后把2和第一个5进行交换，从而改变了两个元素5的相对次序。
 */
public class SelectionSort {
    private SelectionSort() {}

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 0};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
