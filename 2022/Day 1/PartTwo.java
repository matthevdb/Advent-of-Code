import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzleInput1.txt"));
        int mostCalories = 0;
        int secondMostCalories = 0;
        int thirdMostCalories = 0;
        int calorySum = 0;

        while (scanner.hasNextLine()) {
            String calory = scanner.nextLine();
            
            if (!calory.isEmpty()) {
                try {
                    calorySum += Integer.valueOf(calory);
                } catch (Exception e) {
                    System.out.println("Couldn't read number: " + e);
                }
            } else {
                if (calorySum > mostCalories) {
                    mostCalories = calorySum;
                } else if (calorySum > secondMostCalories) {
                    secondMostCalories = calorySum;
                } else if (calorySum > thirdMostCalories) {
                    thirdMostCalories = calorySum;
                }
                calorySum = 0;
            }
        }

        scanner.close();

        System.out.println("Most calories: " + mostCalories);
        System.out.println("Second most calories: " + secondMostCalories);
        System.out.println("Third most calories: " + thirdMostCalories);
        System.out.println("Sum of top 3: " + (mostCalories + secondMostCalories + thirdMostCalories));
    }
}
