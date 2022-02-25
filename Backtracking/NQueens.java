import java.util.*;
public class NQueens{
    final static int N = 4;
    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if(nQueens(board,0)==true){
            // printBoard(board);
        }else{
            System.out.println("No Solution exist");
        }
    }

    static boolean nQueens(int[][] board, int col){
        if(col>=N){
            printBoard(board);
            return true;
        }

        for(int i=0;i<N;i++){
            if(isSafe(board,col,i)){
                board[i][col] =1;
                if(nQueens(board,col+1)==true){
                    return true;
                }
    
                board[i][col]=0;
            }
            board[i][col]=0;
        }
        return false;
    }


    static boolean isSafe(int[][] board, int col, int row){
        for(int i=0;i<col;i++){
            if(board[row][i]==1) return false;
        }

        for(int i=row,j=col;i>=0&&j>=0;j--,i--){
            if(board[i][j]==1) return false;
        }

        for(int i=row,j=col;i<N&&j>=0;i++,j--){
            if(board[i][j]==1) return false;
        }
        return true;
    }



    static void printBoard(int[][] board){
        for(int[] i : board){
            for(int a : i){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}