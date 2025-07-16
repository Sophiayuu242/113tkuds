import java.util.Scanner;

public class TicTacToe5x5 {
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final int SIZE = 5;

    /**
     * 初始化 5x5 的井字遊戲棋盤
     */
    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        
        return board;
    }
    
    /**
     * 列印棋盤，包含行列座標
     */
    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    /**
     * 放置棋子
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        // 檢查座標是否有效
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d)，請輸入 0-%d 之間的數字\n", row, col, SIZE - 1);
            return false;
        }
        
        // 檢查該位置是否已被佔用
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }
    
    /**
     * 檢查是否有玩家獲勝
     */
    static char checkWinner(char[][] board) {
        // 檢查行
        for (int row = 0; row < SIZE; row++) {
            char first = board[row][0];
            if (first != EMPTY) {
                boolean win = true;
                for (int col = 1; col < SIZE; col++) {
                    if (board[row][col] != first) {
                        win = false;
                        break;
                    }
                }
                if (win) return first;
            }
        }
        
        // 檢查列
        for (int col = 0; col < SIZE; col++) {
            char first = board[0][col];
            if (first != EMPTY) {
                boolean win = true;
                for (int row = 1; row < SIZE; row++) {
                    if (board[row][col] != first) {
                        win = false;
                        break;
                    }
                }
                if (win) return first;
            }
        }
        
        // 檢查主對角線
        char first = board[0][0];
        if (first != EMPTY) {
            boolean win = true;
            for (int i = 1; i < SIZE; i++) {
                if (board[i][i] != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }
        
        // 檢查反對角線
        first = board[0][SIZE - 1];
        if (first != EMPTY) {
            boolean win = true;
            for (int i = 1; i < SIZE; i++) {
                if (board[i][SIZE - 1 - i] != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }
        
        return EMPTY;  // 沒有獲勝者
    }
    
    /**
     * 檢查棋盤是否已滿
     */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        
        System.out.println("=== 5x5 井字遊戲 ===");
        System.out.println("玩家 X 和 O 輪流輸入座標 (行 列) 進行遊戲");
        printBoard(board);
        
        char currentPlayer = PLAYER_X;
        
        while (true) {
            // 獲取玩家輸入
            System.out.printf("\n玩家 %c 的回合，請輸入座標 (行 列): ", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);
                
                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("\n🤝 平手！");
                    break;
                }
                
                // 切換玩家
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        
        scanner.close();
    }
}