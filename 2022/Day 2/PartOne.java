import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartOne {
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
        if (oppWins(opp, plr)) {
            switch (plr) {
                case "X":
                    return 1;
                case "Y":
                    return 2;
                case "Z":
                    return 3;
            }

            return 0;
        } else if (playerWins(opp, plr)) {
            switch (plr) {
                case "X":
                    return 1 + 6;
                case "Y":
                    return 2 + 6;
                case "Z":
                    return 3 + 6;
            }

            return 0;
        } else {
            switch (plr) {
                case "X":
                    return 1 + 3;
                case "Y":
                    return 2 + 3;
                case "Z":
                    return 3 + 3;
            }

            return 0;
        }
    }

    private static boolean oppWins(String opp, String plr) {
        if (
            (opp.equals("A") && plr.equals("Z")) ||
            (opp.equals("B") && plr.equals("X")) ||
            (opp.equals("C") && plr.equals("Y"))) {
            return true;
        }

        return false;
    }

    private static boolean playerWins(String opp, String plr) {
        if (
            (opp.equals("A") && plr.equals("Y")) ||
            (opp.equals("B") && plr.equals("Z")) ||
            (opp.equals("C") && plr.equals("X"))) {
            return true;
        }

        return false;
    }

}