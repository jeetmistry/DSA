import java.util.*;
public class NQueensAllSolutions {
    static boolean[] leftdiagonal,cols,rightdiagonals;
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    // static final int N = 4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        leftdiagonal = new boolean[2*N];
        cols= new boolean[2*N];
        rightdiagonals = new boolean[2*N];
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<N;i++) temp.add(0);
        nQueens(result,N,0,temp);
        System.out.println(result);
    }
    private static void nQueens(List<List<Integer>> result, int N, int row, List<Integer> temp) {
        if(row==N){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int col=0;col<N;col++){
            if(cols[col] || leftdiagonal[row+col] || rightdiagonals[row-col+N]){
                continue;
            }

            cols[col] = leftdiagonal[row+col] = rightdiagonals[row-col+N] = true;
            temp.set(col,row+1);
            nQueens(result, N, row+1, temp);
            cols[col] = leftdiagonal[row+col] = rightdiagonals[row-col+N] = false;
        }
    }
}
