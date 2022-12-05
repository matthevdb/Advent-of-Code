import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzleInput1.txt"));
        int mostCalories = 0;
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
                }
                calorySum = 0;
            }
        }

        scanner.close();

        System.out.println("Most calories: " + mostCalories);
    }
}
