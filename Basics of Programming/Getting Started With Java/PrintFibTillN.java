import java.io.*;

public class PrintFibTillN{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        printFibonacci(n);        
    }

    static void printFibonacci(int n){
        int a=0;
        int b=1;
        while(n-->0){
            int c=a+b;
            System.out.println(a);
            a=b;
            b=c;
        }
    }
}