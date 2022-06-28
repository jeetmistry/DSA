import java.util.*;

public class FindDuplicates{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("The duplicate element is : "+findDuplicate(arr));
	}

	public static int findDuplicate(int[] arr){
		int low = 1, high = arr.length-1;
		int duplicate = -1;
		//count how many numbers are there in the array less than or equal to mid 
		while(low<=high){
			int mid = low + (high-low)/2;
			int count = 0;

			for(int num : arr){
				if(num<=mid){
					if(num==0) continue;
					count++;
				}
			}
			if(count>mid){
				duplicate = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return duplicate;
	}
}