import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(Paths.get("input.txt"));
        ArrayList<Character>[] piles = new ArrayList[(35 + 2) / 4];

        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            
            // For each box at level of current height (line) (from top to bottom)
            for (int i = 1; i < line.length() - 1; i += 4) {
                Character character = Character.valueOf(line.charAt(i));
                if (character != ' ') { // If there is a anything at current pile and height
                    if (Character.isDigit(character)) {
                        break;
                    }
                    if (piles[i / 4] == null) {
                        piles[i / 4] = new ArrayList<>();
                    }
                    piles[i /4].add(0, character); // Add box below existing boxes in pile
                }
            }
        }

        inputScanner.close();

        Scanner cScanner = new Scanner(Paths.get("commands.txt"));

        while (cScanner.hasNextLine()) {
            String line = cScanner.nextLine();
            ArrayList<Integer> params = new ArrayList<>();
            
            for (String word : line.split(" ")) {
                if (word.matches("-?\\d+")) {
                    params.add(Integer.valueOf(word));
                }
            }

            int amount = params.get(0);
            int from = params.get(1);
            int to = params.get(2);

            ArrayList<Character> fromPile = piles[from - 1];
            ArrayList<Character> toPile = piles[to - 1];

            for (int i = 0; i < amount; i++) {
                toPile.add(fromPile.get(fromPile.size() - i - 1));
            }

            fromPile.subList(fromPile.size() - amount, fromPile.size()).clear();
        }
        
        String toPrint = "";

        for (ArrayList<Character> pile : piles) {
            toPrint += pile.get(pile.size() - 1);
        }

        System.out.println("Top boxes: " + toPrint);
    }
}
