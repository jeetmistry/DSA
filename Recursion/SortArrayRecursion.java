import java.util.*;
import java.io.*;
public class SortArrayRecursion{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            arr.add(Integer.parseInt(s[i]));
        }
        System.out.println(arr.size());
        System.out.println(arr);
        sort(arr);
        // System.out.println(arr);
    }
    
    public static void sort(ArrayList<Integer> arr){
        if(arr.size()==1){
            return;
        }
        int val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        sort(arr);
        System.out.println("Sort : "+arr);
        insert(arr,val);
        return;
    }

    public static void insert(ArrayList<Integer> arr,int value){
        if(arr.size()==0 || arr.get(arr.size()-1) <= value){
            arr.add(value);
            return;
        }
        int val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        insert(arr,value);
        arr.add(val);
        System.out.println("Insert : "+arr);
        return;
    }
}