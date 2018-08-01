/**
 *  冒泡排序改进 鸡尾酒排序
 *  分类 -------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- O(n^2)
 *  最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
 *  平均时间复杂度 ---- O(n^2)
 *  所需辅助空间 ------ O(1)
 *  稳定性 ------------ 稳定
 */
public class CocktailSort {
    private CocktailSort(){}

    public static void sort(int[] arr) {
        int n = arr.length;

        // 初始化边界
        int left = 0;
        int right = n - 1;

        while (left < right) {
            // 前半轮
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            right--;
            // 后半轮
            for (int i = right; i > left ; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }
            left++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        CocktailSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
