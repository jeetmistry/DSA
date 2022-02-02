import java.io.*;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.plaf.OptionPaneUI;

public class RearrangeArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int[] arr = new int[s.length];

        for(int i=0;i<s.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        //Method 1 using 2 pointer without maintaining the order 
        /*
        System.out.println("Array is : \n");
        printArray(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]<0 && arr[j]>=0){
                i++;j--;
            }
            else if(arr[i]<0 && arr[j]<0){
                i++;
            }
            else if(arr[i]>=0 && arr[j]>=0){
                j--;
            }
            else{
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }//now we have positive and negative elements to either sides 
        
        System.out.println("Updated Array is : \n");
        printArray(arr);

        //Now we find till where out positive element is listed and increment j till there 
        i=1;j=1;
        while(arr[j]<0){
            j++;
        }

        //Once we find the positive element we swap every i+2 index position with positive value
        while(j<arr.length){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i+=2;j+=1;
        }
        System.out.println("Final Array is : \n");
        printArray(arr);
        //Method 1 ends 
        */

        /*Method 2 where we have to maintain the order of array*/

        int wrongIndex = -1,oppositeIndex=-1;
        printArray(arr);
        for(int i=0;i<arr.length;i++){
           if(arr[i]>=0 && i%2==0){
               wrongIndex = i;
               oppositeIndex = i;
               try{
                while(oppositeIndex<arr.length && arr[oppositeIndex]>=0){
                    oppositeIndex++;
                }
               }catch(Exception e){
                   e.printStackTrace();
               }
               if(oppositeIndex<arr.length){
                rightRotate(arr, wrongIndex, oppositeIndex);
               }
               
           }else if(arr[i]<0 && i%2==1){
               wrongIndex = i;
               oppositeIndex = i;
               while(oppositeIndex<arr.length && arr[oppositeIndex]<0){
                    oppositeIndex++;
               }
               if(oppositeIndex<arr.length){
                rightRotate(arr, wrongIndex, oppositeIndex);
               }
               
           }
        }
        printArray(arr);
    }

    public static void rightRotate(int arr[], int start, int end){
        int temp = arr[end];
        for(int i=end;i>start;i--){
            arr[i] = arr[i-1];
        }
        arr[start] = temp;
        printArray(arr);
    }
    public static void printArray(int arr[]){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
