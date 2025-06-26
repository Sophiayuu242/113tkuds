public class ds_05 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("陣列總和為：" + sum);
    }
}
