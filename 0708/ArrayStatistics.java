class ArrayStatistics {
    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = 0, max = data[0], min = data[0];
        int maxIndex = 0, minIndex = 0;
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
            if (data[i] % 2 == 0) evenCount++;
            else oddCount++;
        }

        double average = (double) sum / data.length;
        int aboveAverageCount = 0;
        for (int value : data) {
            if (value > average) aboveAverageCount++;
        }

        System.out.println("=== 陣列統計分析報告 ===");
        System.out.printf("總和: %d\n平均值: %.2f\n", sum, average);
        System.out.printf("最大值: %d (索引 %d)\n", max, maxIndex);
        System.out.printf("最小值: %d (索引 %d)\n", min, minIndex);
        System.out.printf("大於平均的個數: %d\n", aboveAverageCount);
        System.out.printf("偶數個數: %d\n奇數個數: %d\n", evenCount, oddCount);
    }
}
