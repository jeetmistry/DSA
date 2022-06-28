import java.util.*;

public class Matrix90{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		rotate(arr,n,m);
	}

	public static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void rotate(int[][] matrix,int n,int m){
		int row = n, col = m;
		//transpose of matrix
		for(int i=0;i<row;i++){
			for(int j=i;j<col;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		System.out.println("The transpose of matrix is : \n");
		print(matrix);

		//reverse row wise
		for(int i=0;i<row;i++){
			int start = 0,end = col-1;
			while(start<=end){
				int temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;
				start++;end--;
			}
		}
		System.out.println("\nThe rotated matrix is : \n");
		print(matrix);
	}
}