import java.util.*;

public class NextPermutation{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("To find next greater permutation of : ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+ " ");
		}
				
		int[] result = findPermutation(arr,n);

		System.out.println("\nThe next greatest permutation is :");
		for(int i=0;i<n;i++){
			System.out.print(result[i]+ " ");
		}
	}

	public static int[] findPermutation(int[] arr,int n){
		int i = n-1,j;
		while(i-->=0 && arr[i-1]>arr[i]){
			i--;
		}

		if(i<=0){
			reverse(arr,0,n-1);
			return arr;
		}else{
			j=n-1;
			while(arr[j]<=arr[i-1]){
				j--;
			}
			swap(arr,i-1,j);
			reverse(arr,i,n-1);
		}
		return arr;
	}

	public static void reverse(int arr[], int start, int end){
		while(start<=end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;end--;
		}
	}
	public static void swap(int arr[], int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}