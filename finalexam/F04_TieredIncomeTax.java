import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
            taxes[i] = calculateTax(incomes[i]);
            totalTax += taxes[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Tax: $" + taxes[i]);
        }

        System.out.printf("Average: $%d\n", totalTax / n);
    }

    static int calculateTax(int income) {
        int tax = 0;
        int[] brackets = {0, 560000, 1260000, 2520000, 4720000};
        int[] rates = {5, 12, 20, 30, 40};

        for (int i = brackets.length - 1; i >= 0; i--) {
            if (income > brackets[i]) {
                tax += (income - brackets[i]) * rates[i] / 100;
                income = brackets[i];
            }
        }
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入獨立計算稅額，稅率階段固定為常數，總體需走訪 n 筆資料，為線性時間。
 */