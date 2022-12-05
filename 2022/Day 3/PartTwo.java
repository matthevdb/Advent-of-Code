import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzle_input.txt"));

        int sum = 0;

        ArrayList<String> rucksacks = new ArrayList<>();

        while (scanner.hasNextLine()) {
            rucksacks.add(scanner.nextLine());
        }

        char badge = 'a';

        for (int i = 0; i < rucksacks.size(); i+=3) {
            for (char character : rucksacks.get(i).toCharArray()) {
                if (rucksacks.get(i).indexOf(character) > -1 && rucksacks.get(i + 1).indexOf(character) > -1 && rucksacks
                        .get(i + 2).indexOf(character) > -1) {
                    badge = character;
                }
            }

            sum += characterToPriority(badge);
        }

        System.out.println("Sum of badge priorities: " + sum);
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
