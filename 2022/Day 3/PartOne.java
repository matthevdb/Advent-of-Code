import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzle_input.txt"));

        int sum = 0;

        while (scanner.hasNextLine()) {
            String rucksack = scanner.nextLine();

            String compOne = rucksack.substring(0, rucksack.length() / 2);
            String compTwo = rucksack.substring(rucksack.length() / 2, rucksack.length());

            char appearsInBoth = 'a';

            for (char character : compOne.toCharArray()) {
                if (compTwo.indexOf(character) > -1) {
                    appearsInBoth = character;
                }
            }

            int priority = characterToPriority(appearsInBoth);

            sum += priority;
        }

        System.out.println("Sum of priorities: " + sum);
    }

    private static int characterToPriority(char character) {
        int asciiValue = (int) character;
        int priority;
        
        // If character is a capital letter, map priority to 27-52.
        if (asciiValue >= 65 && asciiValue <= 90) {
            priority = asciiValue - 64 + 26;
        }
        // If character is a lowercase letter, map priority to 1-26.
        else {
            priority = asciiValue - 96;
        }
        return priority;
    }
}