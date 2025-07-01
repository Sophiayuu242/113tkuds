public class matrix_mul {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] b = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] c = new int[3][3];

        for (int i = 0; i < 3; i++) {           // a 的列
            for (int j = 0; j < 3; j++) {       // b 的欄
                System.out.println("計算 c[" + i + "][" + j + "]：");
                for (int k = 0; k < 3; k++) {
                    int product = a[i][k] * b[k][j];
                    c[i][j] += product;
                    System.out.println("a[" + i + "][" + k + "] * b[" + k + "][" + j + "] = " +
                            a[i][k] + " * " + b[k][j] + " = " + product);
                }
                System.out.println("→ c[" + i + "][" + j + "] = " + c[i][j]);
                System.out.println();
            }
        }
    }
}
