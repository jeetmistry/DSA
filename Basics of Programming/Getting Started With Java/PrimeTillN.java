//program to print all the prime numbers in between a given range
import java.io.*;

public class PrimeTillN{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine().trim());
        int n2 = Integer.parseInt(br.readLine().trim());
        for(int i=n1;i<=n2;i++){
            if(checkPrimeTillN(i)){
                System.out.println(i);
            }
        }
    }

    //function to check prime number
    static boolean checkPrimeTillN(int n){

        for(int div=2;div*div<=n;div++){
            //if number is divisible by any other number then return not prime
            if(n%div==0){
                return false;
            }
        }
        return true;
    }
}