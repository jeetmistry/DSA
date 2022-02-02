import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MedianOfArray{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().trim().split(" ");
        String[] s2 = br.readLine().trim().split(" ");
        int n = s1.length, m=s2.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(s1[i]);
        }
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        printArray(arr1);
        System.out.println();
        printArray(arr2);
        int median = findMedian(arr1,arr2,n,m);
        System.out.println("\nMedian of arrays is : "+ median);
    }

    public static void swap(int arr1[],int arr2[], int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    
    public static int findMedian(int arr1[],int arr2[], int n, int m){
        int median= 0;
        int i=0,j=n-1;
        while(i<m && j>=0){
            if(arr1[j]>arr2[i]){
                swap(arr1,arr2,j,i);
            }
            i++;j--;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("\nFinal array after merging is : ");
        printArray(arr1);
        System.out.println();
        printArray(arr2);
        
        int len = m+n;
        if(len%2==0){
            int idx1 = (len/2)-1;
            int idx2 = len/2;
            int med1,med2;
            if(idx1<n){
                med1 = arr1[idx1-1];
            }else{
                med1 = arr2[m-idx1-1];
            }

            if(idx2<n){
                med2 = arr1[idx1-1];
            }else{
                med2 = arr2[m-idx2-1];
            }
            median = (med1+med2)/2;
        }else{
            int idx = len/2;
            if(idx<n){
                median = arr1[idx-1];
            }else{
                median = arr2[m-idx-1];
            }
        }

        return median;
    }

    public static void printArray(int arr[]){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}