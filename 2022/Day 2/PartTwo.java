import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("puzzleInput1.txt"));

        int totalPoints = 0;

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            String oppTurn = parts[0];
            String plrTurn = parts[1];

            totalPoints += calculatePoints(oppTurn, plrTurn);
        }

        System.out.println("Total points: " + totalPoints);
    }

    private static int calculatePoints(String opp, String plr) {
        if (plr.equals("X")) {
            return lose(opp, plr);
        } else if (plr.equals("Y")) {
            return draw(opp, plr);
        } else {
            return win(opp, plr);
        }
    }
    
    private static int lose(String opp, String plr) {
        switch (opp) {
            case "A":
                return 3;
            case "B":
                return 1;
            case "C":
                return 2;
        }

        return 0;
    }

    private static int draw(String opp, String plr) {
        switch (opp) {
            case "A":
                return 3 + 1;
            case "B":
                return 3 + 2;
            case "C":
                return 3 + 3;
        }

        return 0;
    }

    private static int win(String opp, String plr) {
        switch (opp) {
            case "A":
                return 6 + 2;
            case "B":
                return 6 + 3;
            case "C":
                return 6 + 1;
        }

        return 0;
    }
}