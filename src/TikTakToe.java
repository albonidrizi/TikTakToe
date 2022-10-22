import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TikTakToe {
    static String turn;
    static String[] tabela;

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String reshti = null;

            switch (a) {
                case 0:
                    reshti = tabela[0] + tabela[1] + tabela[2];
                    break;
                case 1:
                    reshti = tabela[3] + tabela[4] + tabela[5];
                    break;
                case 2:
                    reshti = tabela[6] + tabela[7] + tabela[8];
                    break;
                case 3:
                    reshti = tabela[0] + tabela[3] + tabela[6];
                    break;
                case 4:
                    reshti = tabela[1] + tabela[4] + tabela[7];
                    break;
                case 5:
                    reshti = tabela[2] + tabela[5] + tabela[8];
                    break;
                case 6:
                    reshti = tabela[0] + tabela[4] + tabela[8];
                    break;
                case 7:
                    reshti = tabela[2] + tabela[4] + tabela[6];
                    break;
            }

            //For X winner
            if (reshti.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (reshti.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(tabela).contains(
                    String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/

    static void printBoard()
    {
        System.out.println(" ___________");
        System.out.println("| " + tabela[0] + " | " + tabela[1] + " | " + tabela[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tabela[3] + " | " + tabela[4] + " | " + tabela[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tabela[6] + " | " + tabela[7] + " | " + tabela[8] + " |");
        System.out.println("-------------");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        tabela = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            tabela[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to Tic Tac Toe game.");
        printBoard();

        System.out.println(
                "X will play first. Enter a number to place X in:");

        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter number:");
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (tabela[numInput - 1].equals(
                    String.valueOf(numInput))) {
                tabela[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! Thanks for playing.");
        }
    }

}


