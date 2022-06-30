import java.util.*;
public class MinimumSubsetSumDifference{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		System.out.println(minimumSubsetSumDifference(nums,n));
	}

	public static int minimumSubsetSumDifference(int[] nums,int n){
		int range = 0;
		for(int i=0;i<n;i++){
			range += nums[i];
		}

		//get the last row from subset sum
		boolean[] subsetSum = getSubsetSum(nums,range,n);

		//traverse subsetsum array and assign the very first index to first if true, that means the max sum possible from 0 to half range
		int first = 0,second = 0;
		for(int i=range/2; i>=0;i--){
			if(subsetSum[i]){
				first=i;
				break;
			}
		}
		
		//assign index to second if true, that means the min sum possible from half range to full range 
		for(int i=(range/2)+1; i<=range;i++){
			if(subsetSum[i]){
				second=i;
				break;
			}
		}

		// return max from first half - min from second half to get the minimum difference 
		return Math.abs(first-second);
	}

	//function to return the last row of subset sum so that 
	//we can get all the sums that can be generated using the subsets
	public static boolean[] getSubsetSum(int[] nums, int sum, int n){
		boolean[][] dp = new boolean[n+1][sum+1];
		//initializing dp 
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

		//dp
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				if(nums[i-1]<=j){
					dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n];
	}
}