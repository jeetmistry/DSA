import java.io.*;
import java.util.*;

public class Knapsack{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] weight = new int[n];
		int[] val = new int[n];
		int W = Integer.parseInt(br.readLine().trim());
		String[] w = br.readLine().trim().split(" ");
		String[] v = br.readLine().trim().split(" ");

		for(int i=0;i<n;i++){
			weight[i] = Integer.parseInt(w[i]);
			val[i] = Integer.parseInt(v[i]);
		}
		
		int ans = knapsack(weight,val,W,n);
		System.out.println(ans);
	}

/*
	public static int knapsack(int wt[], int val[],int W,int n,int[][] dp){
		if(W==0 || n==0){
			return 0;
		}
		if(dp[n][W]!=-1){
			return dp[n][W];
		}
		if(wt[n-1]<=W){
			return dp[n][W] = Math.max(val[n-1]+knapsack(wt,val,W-wt[n-1],n-1,dp),knapsack(wt,val,W,n-1,dp));
		}else{
			return dp[n][W]= knapsack(wt,val,W,n-1,dp);
		}
	}
	*/

	public static int knapsack(int wt[], int val[],int W,int n){
		int [][] dp = new int[n+1][W+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<W+1;j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
			}
		}

		print(dp);
		for(int i=1;i<n+1;i++){
			for(int j=1;j<W+1;j++){
				if(wt[i-1]<=j){
					dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		print(dp);
		return dp[n][W];
	}

	public static void print(int[][] arr){
		for(int[] val : arr){
			for(int v : val){
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}