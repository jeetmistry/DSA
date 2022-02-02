import java.io.*;
import java.util.*;
public class Sort{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println("\nBefore Sorting : ");
        printArr(arr);
        // insertionSort(arr,n);
        // selectionSort(arr, n);
        // quickSort(arr, 0, n-1);
        mergeSort(arr, 0, n-1);
        System.out.println("After sorting");
        printArr(arr);
    }

    public static void insertionSort(int arr[],int n){
        System.out.println("Performing insertion sort");
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void Merge(int arr[], int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++){
            left[i] = arr[l+i];
        }

        for(int i=0;i<n2;i++){
            right[i] = arr[mid+i+1];
        }

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }

        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
        System.out.println();
        printArr(arr);
    }


    public static void mergeSort(int arr[],int l,int r){
        if(l<r){
            int mid = l+(r-l)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            Merge(arr,l,mid,r);
        }
    }
    public static int partition(int arr[],int l,int r){
        int pivot = arr[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1,r);
        System.out.println();
        printArr(arr);
        return i+1;
    }
    public static void quickSort(int arr[],int l,int r){
        if(l<r){
            int pivot = partition(arr,l,r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int arr[],int n){
        System.out.println("\nPerforming Selection Sort\n");
        
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    public static void printArr(int arr[]){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}