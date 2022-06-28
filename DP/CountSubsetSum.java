import java.util.*;
public class CountSubsetSum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		System.out.print(countSubsetSum(nums,sum,n));
	}

	public static int countSubsetSum(int[] nums, int sum, int n){
		int[][] dp = new int[n+1][sum+1];

		//intitializing the dp 
		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){
				if(i==0){
					dp[i][j]=0;
				}
				if(j==0){
					dp[i][j]=1;
				}
			}
		}

		//dp logic
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				if(nums[i-1]<=j){
					dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}
}