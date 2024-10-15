import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void showBoard() {
        System.out.println("Here's the current board:");
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.showBoard();
            System.out.print("Player " + game.currentPlayer + ", make your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.isWinner()) {
                    game.showBoard();
                    System.out.println("Congratulations! Player " + game.currentPlayer + " wins!");
                    break;
                }
                if (game.isDraw()) {
                    game.showBoard();
                    System.out.println("It's a draw! Well played!");
                    break;
                }
                game.switchPlayer();
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }

        scanner.close();
    }
}
