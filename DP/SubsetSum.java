import java.util.*;
public class SubsetSum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		System.out.println(subsetSum(nums,sum,n));
	}

	public static boolean subsetSum(int[] nums, int sum, int n){
		boolean[][] dp = new boolean[n+1][sum+1];

		//initializing the dp
		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){
				if(i==0){
					dp[i][j]=false;
				}
				if(j==0){
					dp[i][j]=true;
				}
			}
		}

		//dp logic
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				if(nums[i-1]<=j){
					dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}

	public static void print(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+" | ");
			}
			System.out.println();
		}
	}
}