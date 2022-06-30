import java.util.*;
public class Utilities{
	public static void print(int[] arr){
		for(int val : arr){
			System.out.print(val+" ");
		}
	}

	public static void print(int[][] arr){
		for(int[] vals : arr){
			for(int val : vals){
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
	public static void print(boolean[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" | ");
		}
	}

	public static void print(boolean[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" | ");
			}
			System.out.println();
		}
	}

	public static int getSum(int[] arr){
		int sum = 0;
		for(int i : arr){
			sum+=i;
		}
		return sum;
	}

	public static int[][] initializeDP(int n,int W){
		int[][] dp = new int[n+1][W+1];

		for(int i=0;i<n+1;i++){
			for(int j=0;j<W+1;j++){
				if(i==0){
					dp[i][j] = 0;
				}
				if(j==0){
					dp[i][j] = 1;
				}
			}
		}
		return dp;
	}

}