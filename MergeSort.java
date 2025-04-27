public class MergeSort {

    private static long mergeIterations = 0;

    public static long getMergeIterations() {
        return mergeIterations;
    }

    public static void mergeSort(int[] array) {
        mergeIterations = 0; 
        if (array == null || array.length <= 1) {
            return;
        }

        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);

    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            mergeIterations++;
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
            mergeIterations++; 
        }

        
    }
}
