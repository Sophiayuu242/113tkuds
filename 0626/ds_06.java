import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();

        System.out.print("陣列內容：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("\n最大值為" + max);
    }
}
