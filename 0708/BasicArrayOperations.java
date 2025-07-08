public class BasicArrayOperations {
    public static void main(String[] args) {
        int[] array = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};
        System.out.println("陣列長度: " + array.length);

        array[2] = 99;
        array[array.length - 1] = 100;

        for (int i = 0; i < array.length; i++) {
            System.out.println("索引 " + i + ": " + array[i]);
        }
    }
}
