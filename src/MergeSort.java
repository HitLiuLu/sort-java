/**
 *  分类 -------------- 内部比较排序
 *  数据结构 ---------- 数组
 *  最差时间复杂度 ---- O(nlogn)
 *  最优时间复杂度 ---- O(nlogn)
 *  平均时间复杂度 ---- O(nlogn)
 *  所需辅助空间 ------ O(n)
 *  稳定性 ------------ 稳定
 *  每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);  // 左边归并，使得左子序列有序
            sort(arr, mid + 1, right, temp);  // 右边归并，使得右子序列有序
            merge(arr, left, mid, right, temp);  // 将两个有序数组合并
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 左序列指针
        int j = right;  // 右序列指针
        int t = 0;  // 临时数组的指针
        while (i <=mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {  // 将左边剩余元素加到temp里
            temp[t++] = arr[i++];
        }

        while (j <= right) {  // 将右边剩余元素加到temp里
            temp[t++] = arr[j++];
        }

        t = 0;

        // 将temp中的元素全部拷进原数组中，原数组进下一轮递归
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
