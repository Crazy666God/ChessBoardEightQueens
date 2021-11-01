package com.company;



public class Box {
    private int[][] chessBoard = new int[8][8];

    Box(int[][] chessBoard) {
        setChessBoard(chessBoard);
    }

    public int[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(int[][] chessBoard) {
        for(int i = 0; i < 8; ++i) {
            System.arraycopy(chessBoard[i], 0, this.chessBoard[i], 0, 8);
        }
    }
// а так же тут всес свое гавно
    private static void printChessBoard(int[][] chessBoard) {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                System.out.printf("%d ",chessBoard[i][j]);
            }
            System.out.println();
        }
    }
}
