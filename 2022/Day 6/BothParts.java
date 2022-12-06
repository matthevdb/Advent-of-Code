import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BothParts {
    public static void main(String[] args) throws IOException {
        int codeLength = 14;
        int index = 0;
        Scanner scanner = new Scanner(Paths.get("input.txt"));

        char[] chars = scanner.next().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int lowerBound = i - codeLength + 1;
            if (lowerBound < 0) lowerBound = 0;

            ArrayList<Character> prevChars = new ArrayList<>();

            for (int j = lowerBound; j <= i; j++) {
                prevChars.add(chars[j]);
            }

            System.out.println(prevChars + " Cur: " + chars[i]);

            if (i >= codeLength && areAllUnique(prevChars)) {
                index = i + 1;
                break;
            }
        }

        System.out.println("At index " + index + " the past " + codeLength + " characters are unique.");
    }

    public static boolean areAllUnique(List<Character> chars) {
        Set<Character> set = new HashSet<>();

        for (Character character : chars) {
            set.add(character);
        }

        return set.size() == chars.size();
    }
}