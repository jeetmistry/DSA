import java.util.*;
public class Balancedparanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        sc.close();
        String output = "";
        solve(in,in,output);
    }

    private static void solve(int open, int close, String output) {
        if(open==0 && close==0){
            System.out.println(output);
            return;
        }

        if(close>open){
            String output1=output;
            String output2=output;
            if(open!=0){
                output1+="(";
                solve(open-1,close,output1);
            }  
            output2+=")";
            solve(open,close-1,output2);
        }else{
            String output1 = output;
            output1+="(";
            solve(open-1,close,output1);
        }
        return;
    }
}
