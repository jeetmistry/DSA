import java.util.*;
public class NBitBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n-1,0,1,"1");
    }

    private static void solve(int n, int zero, int one, String output) {
        if(n==0){
            System.out.println(output);
            return;
        }
        if(zero<one){
            String output1 = output;
            String output2 = output;
            output1+="1";
            output2+="0";
            solve(n-1,zero,one+1,output1);
            solve(n-1,zero+1,one,output2);
            return;
        }else{
            String output1 = output;
            output1+="1";
            solve(n-1,zero,one+1,output1);
            return;
        }
    }
}
