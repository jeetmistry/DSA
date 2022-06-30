import java.util.*;
public class RodCutting{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int N = sc.nextInt();
		int[] length = new int[n];
		int[] prices = new int[n];
		for(int i=0;i<n;i++){
			length[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			prices[i] = sc.nextInt();
		}

		System.out.println(getMaxPriceForRodCutting(length,prices,N,n));
	}

	public static int getMaxPriceForRodCutting(int [] length, int[] prices, int N, int n){
		int[][] dp = new int[n+1][N+1];

		//initializing dp with first row and column as 0
		for(int i=0;i<n+1;i++){
			for(int j=0;j<N+1;j++){
				if(i==0 || j==0){
					dp[i][j] = 0;
				}
			}
		}

		for(int i=1;i<n+1;i++){
			for(int j=1;j<N+1;j++){
				if(length[i-1]<=j){
					dp[i][j] = Math.max(prices[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][N];
	}
}