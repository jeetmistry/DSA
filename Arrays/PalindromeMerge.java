import java.io.*;
import java.util.*;
public class PalindromeMerge{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        System.out.println("Length of array : "+n);
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int i=0;
        int j=n-1;
        int min = 0;
        while(i<=j){
            if(arr[i]==arr[j]){
                i++;j--;
            }
            else if(arr[i]<=arr[j]){
                i++;
                arr[i]+=arr[i-1];
                min++;
            }else{
                j--;
                arr[j]+=arr[j+1];
                min++;
            }
        }
        System.out.println("Swaps req = " + min);
    }
}