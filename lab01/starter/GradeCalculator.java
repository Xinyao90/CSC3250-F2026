public class GradeCalculator {

    public static double average(int[] scores) {
        // TODO
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException(
                    "Scores cannot be null or empty."
            );
        }
        return 0;
    }

    public static int highest(int[] scores) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        int[] scores = {85, 90, 72, 96, 88};

        System.out.println("Average: " + average(scores));
        System.out.println("Highest: " + highest(scores));
    }
}