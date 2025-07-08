class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};
        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }

        double average = (double) sum / scores.length;
        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) countAboveAverage++;
        }

        System.out.printf("總分: %d\n", sum);
        System.out.printf("平均: %.2f\n", average);
        System.out.printf("最高分: %d (索引 %d)\n", max, maxIndex);
        System.out.printf("最低分: %d (索引 %d)\n", min, minIndex);
        System.out.printf("高於平均的人數: %d\n", countAboveAverage);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生編號 " + (i + 1) + ": " + scores[i]);
        }
    }
}