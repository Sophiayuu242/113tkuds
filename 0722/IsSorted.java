public class IsSorted {
    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 3, 4, 5};
        int[] unsortedArr = {5, 3, 4};
        System.out.println("isSorted(sortedArr): " + isSorted(sortedArr, 0));
        System.out.println("isSorted(unsortedArr): " + isSorted(unsortedArr, 0));
    }
}