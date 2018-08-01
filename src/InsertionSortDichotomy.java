/**
 *  二分插入排序
 *  分类 -------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- O(n^2)
 *  最优时间复杂度 ---- O(nlogn)
 *  平均时间复杂度 ---- O(n^2)
 *  所需辅助空间 ------ O(1)
 *  稳定性 ------------ 稳定
 *  当n较大时，二分插入排序的比较次数比直接插入排序的最差情况好得多，但比直接插入排序的最好情况要差，
 *  所当以元素初始序列已经接近升序时，直接插入排序比二分插入排序比较次数少。
 *  二分插入排序元素移动次数与直接插入排序相同，依赖于元素初始序列。
 */
public class InsertionSortDichotomy {
    // 左手的牌是排好序的，可以使用二分法
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 右手抓到一张牌
            int get = arr[i];
            // 手牌左右边界初始化
            int left = 0;
            int right = i - 1;
            // 二分法定义新牌的位置
            while (left <= right) {  // 因为是小于*等于*，left 一定会在right的右边，这个位置就是插入位
                int mid = (left + right) / 2;
                if (arr[mid] > get) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            // 将大于手牌的牌从右向左依次向后移动一位
            for (int j = i - 1; j >= left ; j--) {
                arr[j + 1] = arr[j];
            }
            // 将手牌插入插入位
            arr[left] = get;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSortDichotomy.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
