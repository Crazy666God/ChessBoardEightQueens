package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Box> listBox = new ArrayList<>();
    public static int[][] chessBoard = new int[8][8];

    public static void main(String[] args) {
        solution(0, 0);
        //printList();
        System.out.printf("Итого = %d, варианта растановки ферзей\n", listBox.size());
    }

    public static boolean solution(int height, int chessPiece) {
        if(height >= 8 || chessPiece >= 8) {
            if(!checkingChessBoardInList(chessBoard)) {
                listBox.add(new Box(chessBoard));
                return false;
            }
            clearChessBoard();
            return true;
        }
        for(int width = 0; width < 8; ++width) {
            if(checkingForAnIntersection(height, width)) {
                chessBoard[height][width] = 1;
                if(solution(height + 1, chessPiece + 1)) {
                    return true;
                } else {
                    chessBoard[height][width] = 0;
                }
            }
        }
        return false;
    }


    public static boolean checkingForAnIntersection(int height, int width) {
        int i, j;
        
        for(i = 0, j = width; i < 8; ++i) {
            if(i == height) {
                continue;
            }
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
       
        for(i = height, j = 0; j < 8; ++j) {
            if(j == width) {
                continue;
            }
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        
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

    public static boolean checkingChessBoardInList(int[][] chessBoard) {
        int size = listBox.size();
        if(size <= 0) {
            return false;
        }
        int[][] boardList = listBox.get(size - 1).getChessBoard();
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                if(chessBoard[i][j] != boardList[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
