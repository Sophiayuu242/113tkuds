import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13}; 
        Scanner scn = new Scanner(System.in);

        System.out.print("請輸入要查找的數字：");
        int x = scn.nextInt(); 

        boolean found = false;
        for (int num : s) {
            if (num == x) {
                found = true;
                break;
            }
        }
    }
}