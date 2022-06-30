import java.util.*;
public class NumberOfSubsetWithGivenDifference{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int diff = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}

		System.out.println(numberOfSubsetWithGivenDifference(nums,diff,n));
	}

	public static int getSum(int arr[]){
		int sum = 0;
		for(int i : arr){
			sum+=i;
		}
		return sum;
	}

	public static int numberOfSubsetWithGivenDifference(int[] nums, int diff, int n){
		int finalSum = (diff + getSum(nums))/2;
		return getCountSubsetSum(nums,finalSum,n);
	}

	public static int getCountSubsetSum(int[] nums, int sum, int n){
		int[][] dp = new int[n+1][sum+1];

		//initializing dp
		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){
				if(i==0){
					dp[i][j] = 0;
				}
				if(j==0){
					dp[i][j]=1;
				}
			}
		}

		// dp
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