import java.io.*;
public class PermutationCaseChange {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String output = "";
        solve(input,output);
    }

    private static void solve(String input, String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        char c = input.charAt(0);
        String in = input.substring(1);
        String output1 = output;
        String output2 = output;
        if(Character.isAlphabetic(c)){
            output1+=Character.toString(Character.toLowerCase(c));
            output2+=Character.toString(Character.toUpperCase(c));
            solve(in,output1);
            solve(in,output2);
            return;
        }else{
            output+=Character.toString(c);
            solve(in,output);
            return;
        }
    }
}
