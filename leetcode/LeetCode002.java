import java.util.Arrays;

public class LeetCode002 {


    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 1) return;
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        int j = right;
        int temp;
        while (i < j) {
            while (i < j && arr[i] <= pivot) i++;
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[right] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        quickSort(nums, 0, nums.length - 1);

        System.out.print(Arrays.toString(nums));
    }
}