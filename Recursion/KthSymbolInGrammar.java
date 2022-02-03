
import java.io.*;
public class KthSymbolInGrammar {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        //print the value 
        System.out.println(solve(n,k));
    }

    //function to solve the grammar 
    public static int solve(int n,int k){

        // when 1st row and 1st element is encountered then return 0
        if(n==1 && k==1){
            return 0;
        }

        //else calculate mid and check if k is less than or equal to mid 
        int mid = (int)Math.pow(2,n-1)/2;

        // if k is less than or equal to mid then recursively call solve on previous row and k
        if(k<=mid){
            return solve(n-1,k);
        }

        // else call solve 1 exor the result so that we can negate the result in column new to mid
        return 1 ^ solve(n-1,k-mid);
    }
}
