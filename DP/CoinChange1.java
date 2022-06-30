import java.util.*;
public class CoinChange1 extends Utilities{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] coins = new int[n];
		for(int i=0;i<n;i++){
			coins[i] = sc.nextInt();
		}
		System.out.println(getCoinChange1(coins,sum,n));
	}

	public static int getCoinChange1(int[] coins, int sum, int n){
		Utilities u = new Utilities();
		int[][] dp = u.initializeDP(n,sum);
		
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				if(coins[i-1]<=j){
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		u.print(dp);
		return dp[n][sum];
	}
}