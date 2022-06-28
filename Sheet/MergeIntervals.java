import java.util.*;

public class MergeIntervals{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		System.out.println("The intervals to merge are : \n");
		print(arr);
		System.out.println("\nThe intervals after merging are : \n");
		int[][] res = merge(arr);
		print(res);
	}

	public static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] merge(int[][] intervals){
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
		LinkedList<int[]> result = new LinkedList<>();
		for(int[] interval : intervals){
			if(result.isEmpty() || interval[0]>result.getLast()[1]){
				result.add(interval);
			}else{
				result.getLast()[1] = Math.max(result.getLast()[1],interval[1]);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}