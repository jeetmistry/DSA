import java.util.*;

public class Kadane{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("To find max sum subarray from : ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+ " ");
		}
				
		int result = kadane(arr,n);

		System.out.println("\n\nThe max sum in the subarray is : "+ result);
		
	}

	public static int kadane(int[] arr,int n){
		int max = arr[0];
		int maximum = arr[0];

		for(int i=1;i<arr.length-1;i++){
			max = Math.max(arr[i]+max,arr[i]);
			maximum = Math.max(maximum,max);
		}
		return maximum;
	}
}