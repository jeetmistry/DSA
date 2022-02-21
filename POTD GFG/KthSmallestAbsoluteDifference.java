import java.util.*;
public class KthSmallestAbsoluteDifference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long a=0;
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        PriorityQueue<Long> ans= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans.add((long)Math.abs(arr[i]-arr[j]));
            }
        }
        System.out.println(ans);
        Iterator val = ans.iterator();
        k=k%n;
        while(k-- >= 0){
            if(val.hasNext()){
                a = (long) val.next();
            }
        }
        System.out.println(a);
    }
}