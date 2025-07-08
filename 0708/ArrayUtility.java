import java.util.Arrays;

class ArrayUtility {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : array) {
            if (n > max) {
                second = max;
                max = n;
            } else if (n > second && n != max) {
                second = n;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列: ");
        printArray(data);

        reverseArray(data);
        System.out.print("反轉後: ");
        printArray(data);

        int[] copy = copyArray(data);
        System.out.print("複製陣列: ");
        printArray(copy);

        System.out.println("第二大值: " + findSecondLargest(data));
    }
}
