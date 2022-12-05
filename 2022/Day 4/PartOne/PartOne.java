import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzleInput.txt"));
        int sum = 0;

        while (scanner.hasNextLine()) {
            String[] sectionPair = scanner.nextLine().split(",");
            
            Section sectionOne = new Section(Integer.valueOf(sectionPair[0].split("-")[0]), Integer.valueOf(sectionPair[0].split("-")[1]));
            Section sectionTwo = new Section(Integer.valueOf(sectionPair[1].split("-")[0]), Integer.valueOf(sectionPair[1].split("-")[1]));

            if (sectionOne.contains(sectionTwo) || sectionTwo.contains(sectionOne)) {
                sum++;
            }
        }

        System.out.println("Amount of sections that contain other sections: " + sum);
    }
}