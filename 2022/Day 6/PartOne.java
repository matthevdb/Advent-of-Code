import java.io.IOException;
import java.nio.file.Paths;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("input.txt"));

        char[] chars = scanner.next().toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            int lowerBound = i - 4;
            if (lowerBound < 0) lowerBound = 0;

            ArrayList<Character> selection = new ArrayList<>();

            for (int j = lowerBound; j < i; j++) {
                selection.add(chars[j]);
            }

            System.out.println(selection);

            for (Character character : selection) {
                ArrayList<Character> selectionWithout = new ArrayList<>(selection);
                selectionWithout.remove(character);

                if (!selectionWithout.contains(character)) {
                    index = i;
                    break;
                }
            }
        }

        System.out.println(index);
    }
}