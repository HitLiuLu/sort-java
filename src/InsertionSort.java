/**
 *  插入排序
 *  分类 ------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 *  最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 *  平均时间复杂度 ---- O(n^2)
 *  所需辅助空间 ------ O(1)
 *  稳定性 ------------ 稳定
 *  插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，比如量级小于千，
 *  那么插入排序还是一个不错的选择。 插入排序在工业级库中也有着广泛的应用，在STL的sort算法和stdlib的qsort算法中，
 *  都将插入排序作为快速排序的补充，用于少量元素的排序（通常为8个或以下）。
 */
public class InsertionSort {
    private InsertionSort() {}

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 右手抓到一张牌
            int get = arr[i];
            // 拿在左手上的牌 是排好序的
            int j = i - 1;
            // 将抓到的牌与手里的牌从右向左进行比较
            while (j >= 0 && arr[j] > get) {
                // 只要手牌大于抓到的牌，我们就将手牌向右移动一个位置，以将位置空出给新抓的牌，直到抓到的牌大于前一张牌
                arr[j + 1] = arr[j];
                j--;
            }
            // 因为指针已经移动到插入牌的前面一个位置了，所以是j+1
            arr[j + 1] = get;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
