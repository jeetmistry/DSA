import java.io.*;

public class PermutaionCases {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String output = "";
        solve(input,output);
        // System.out.println((char)(input-32));
    }

    private static void solve(String input,String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        //taking output and adding 1st element of input to upper case
        String output1 = output+Character.toString(input.charAt(0)).toUpperCase();

        //adding first element of input without case change
        output+=Character.toString(input.charAt(0));

        //reducing string by removing 1st element 
        String in = input.substring(1);
        solve(in,output);
        solve(in, output1);
        return;

    }
}
