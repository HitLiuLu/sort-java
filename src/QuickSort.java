/**
 *  分类 ------------ 内部比较排序
 *  数据结构 --------- 数组
 *  最差时间复杂度 ---- 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
 *  最优时间复杂度 ---- 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
 *  平均时间复杂度 ---- O(nlogn)
 *  所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
 *  稳定性 ---------- 不稳定
 *  比如序列：{ 1, 3, 4, 2, 8, 9, 8, 7, 5 }，基准元素是5，一次划分操作后5要和第一个8进行交换，从而改变了两个元素8的相对次序。
 */
public class QuickSort {

    /**
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     * @param a
     * @param start
     * @param end
     * https://blog.csdn.net/nrsc272420199/article/details/82587933
     */
    private static int partition(int[] arr, int low, int high) {
        // 每次都以最右边的元素作为基准值
        int pivot = arr[low];
        // low一旦等于high，就说明左右两个指针合并到了同一位置，结束此轮循环
        while (low < high) {
            // 当队尾元素大于基准数据时，向前挪动high指针
            while (low < high && arr[high] > pivot) {
                high--;
            }
            // 如果队尾元素小于pivot了，需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素大于pivot时，向后移动low指针
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            // 当队首元素大于pivot时，需要将其赋值给high
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        // 获取pivot的正确位置
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

        QuickSort.sort(a, 0, a.length-1);

        System.out.println("排序后的结果：");
        for(int x : a){
            System.out.print(x+" ");
        }

    }
}
