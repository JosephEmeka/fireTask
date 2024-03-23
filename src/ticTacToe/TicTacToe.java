package ticTacToe;

import javax.swing.*;


public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for (int rowCount = 0; rowCount < 3; rowCount++) {
            for (int columnCount = 0; columnCount < 3; columnCount++) {
                board[rowCount][columnCount] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int rowCount = 0; rowCount < 3; rowCount++) {
            for (int columnCount = 0; columnCount < 3; columnCount++) {
                stringBuilder.append(board[rowCount][columnCount]);
                if (columnCount < 2) {
                    stringBuilder.append('|');
                }
            }
            stringBuilder.append('\n');
            if (rowCount < 2) {
                stringBuilder.append("-----\n");
            }
        }
        JOptionPane.showMessageDialog(null, stringBuilder.toString());
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid move. Try again.");
        }
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }
        return ' ';
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() {
        while (true) {
            printBoard();
            String enterMove = JOptionPane.showInputDialog("Enter number between 1 and 9: ");
            int move = Integer.parseInt(enterMove);
            if (move >= 1 && move <= 9) {
                move -= 1;
                int row = move / 3;
                int col = move % 3;
                makeMove(row, col);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid entry. Please try again.");
            }

            char winner = checkWinner();
            if (winner != ' ') {
                printBoard();
                JOptionPane.showMessageDialog(null, STR."Player \{winner} wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                JOptionPane.showMessageDialog(null, "It's a draw!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}


