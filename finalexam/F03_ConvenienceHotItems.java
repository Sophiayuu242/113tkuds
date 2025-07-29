import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            qtys[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            String nameKey = names[i];
            int qtyKey = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < qtyKey) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = nameKey;
            qtys[j + 1] = qtyKey;
        }

        int limit = Math.min(n, 10);
        for (int i = 0; i < limit; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：插入排序在最壞情況（反向排序）下需要 O(n^2) 次比較與移動。
 */