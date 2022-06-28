import java.util.*;
public class EqualSumPartition extends SubsetSum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		System.out.println(equalSumPartition(nums,n));
	}

	public static boolean equalSumPartition(int[] nums,int n){
		//checking if sum of the items is even, else return false because we cannot get equal partition
		int sum = 0;
		for(int val : nums){
			sum+=val;
		}
		if(sum%2!=0){
			return false;
		}else{
			//problem reduces to subset sum, we have to find one subset that has sum/2 sum then we will have the answer

			//function definition of subsetSum(int[],int,int) is in SubsetSum.java file
			return subsetSum(nums,sum/2,n);
		}
	}
}