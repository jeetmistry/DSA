import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class SumSubarrayGreaterThanX {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int min_subarray = n+1;

        int i=0,j=0;
        int sum=0;
        while(j<n){
            while(j<n && sum<=x){
                sum+=arr[j++];
            }
            while(sum>x && i<n){
                if(j-i < min_subarray){
                    min_subarray = j-i;
                    System.out.println(min_subarray);
                }
                sum-=arr[i++];
            }
        }
        if(sum<=x){
            System.out.println(-1);
        }
    }
}
