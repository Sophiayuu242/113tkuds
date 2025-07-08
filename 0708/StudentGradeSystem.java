class StudentGradeSystem {
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        return 'D';
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        int[] gradeCount = new int[4]; // A, B, C, D

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
            char grade = getGrade(scores[i]);
            switch (grade) {
                case 'A' -> gradeCount[0]++;
                case 'B' -> gradeCount[1]++;
                case 'C' -> gradeCount[2]++;
                case 'D' -> gradeCount[3]++;
            }
        }

        double average = (double) sum / scores.length;
        int aboveAvgCount = 0;
        for (int score : scores) {
            if (score > average) aboveAvgCount++;
        }

        System.out.println("=== 成績報告 ===");
        System.out.println("總分: " + sum);
        System.out.printf("平均: %.2f\n", average);
        System.out.println("最高分: " + max + " (編號 " + (maxIndex + 1) + ")");
        System.out.println("最低分: " + min + " (編號 " + (minIndex + 1) + ")");
        System.out.printf("高於平均比例: %.2f%%\n", 100.0 * aboveAvgCount / scores.length);
        System.out.println("各等級人數: A: " + gradeCount[0] + ", B: " + gradeCount[1] + ", C: " + gradeCount[2] + ", D: " + gradeCount[3]);

        System.out.println("\n詳細成績：");
        System.out.println("編號\t分數\t等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%2d\t%3d\t%c\n", i + 1, scores[i], getGrade(scores[i]));
        }
    }
}
