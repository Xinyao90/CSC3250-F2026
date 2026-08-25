public class GradeCalculator {

    public static double average(int[] scores) {
        // TODO
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("Scores cannot be null or empty.");
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.length;
        return average;
    }

    public static int highest(int[] scores) {
        // TODO
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("scores cannot be null or empty.");
        }
        int highest = scores[0];
        for (int score : scores) {
            if (score > highest) highest = score;
        }
        return highest;

    }

    public static void main(String[] args) {
        int[] scores = {85, 90, 72, 96, 88};

        System.out.println("Average: " + average(scores));
        System.out.println("Highest: " + highest(scores));
    }
}
