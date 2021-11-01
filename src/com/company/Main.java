package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Box> listBox = new ArrayList<>();
    public static int[][] chessBoard = new int[8][8];
    public static int MAX_VALUE = 64;

    public static void main(String[] args) {
        solution(0);
        printList();
    }




    public static boolean solution(int count/*, int chessPiece*/) {
        if(count >= MAX_VALUE/* || chessPiece == 8*/) {
            printChessBoard(chessBoard);
            System.out.println();
            listBox.add(new Box(chessBoard));
            clearChessBoard();
            return true;
        }
        int height = count / 8;
        //int width = count % 8;
        for(int i = 0; i < 8; ++i) {
            if (checkingForAnIntersection(height, i)) {
                chessBoard[height][i] = 1;
                if (solution(++count/*, ++chessPiece*/)) {
                    return true;
                } else {
                    chessBoard[height][i] = 0;
                   // --chessPiece;
                }
            }
        }
        return false;
    }



    public static boolean checkingForAnIntersection(int height, int width) {
        int i, j;
        //проверка по вертикали
        for(i = 0, j = width; i < 8; ++i) {
            if(i == height) {
                continue;
            }
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        //проверка по горизотале
        for(i = height, j = 0; j < 8; ++j) {
            if(j == width) {
                continue;
            }
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        //проверка диагонали с лева на право
        for(i = height - 1, j = width - 1; i >= 0 && j >= 0; --i, --j) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        for(i = height + 1, j = width + 1; i < 8 && j < 8; ++i, ++j) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        //проверка диагонали с права на лево
        for(i = height - 1, j = width + 1; i >= 0 && j < 8; --i, ++j) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        for(i = height + 1, j = width - 1; i < 8 && j >= 0; ++i, --j) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    public static void printChessBoard(int[][] chessBoard) {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                System.out.printf("%d ",chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void printList() {
        for(Box box : listBox) {
            printChessBoard(box.getChessBoard());
            System.out.println("--------------------------");
        }

    }

    public static void clearChessBoard() {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                chessBoard[i][j] = 0;
            }
        }
    }

}
