import java.util.*;
import java.io.*;
public class IsPrime{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            //if n is prime then print prime else print not prime
            if(checkPrime(n)){
                System.out.println("prime");
            }
            else{
                System.out.println("not prime");
            }
        }
    }

    //function to check if prime and return true if prime else return false 
    static boolean checkPrime(int n){
        int count=0;
        /* This solution will work but not efficient because we are 
        doing repetative division till n
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
        */

        /*Efficient Solution : 
        This will work because we are always checking till 
        square root of n, because any number has factors repeting after its square root
        */
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==0){
            return true;
        }else{
            return false;
        }
    }
}