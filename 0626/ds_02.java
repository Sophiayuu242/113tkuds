import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入圓的半徑：");
        int i =scanner.nextInt();
        System.out.println("圓的面積為：" + i*i*3.14);
    }
}
