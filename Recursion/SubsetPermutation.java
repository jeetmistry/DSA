import java.util.*;
import java.io.*;
public class SubsetPermutation {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Taking input string 
        String s = br.readLine().trim();

        //initializing output string as empty string
        String o = "";
        solve(s,o);
    }

    public static void solve(String s,String o){

        //if input string is empty then we are at base case and need to print the output 
        if(s.length()==0){

            //printing BLANK instead of empty string 
            if(o.equals("")){
                System.out.println("BLANK");
                return;
            }

            //printing output string 
            System.out.println(o);
            return;
        }

        //Initializing output string with original output for decision maklng  
        String o2=o;

        //adding first value of the input string to output string 
        o2+=Character.toString(s.charAt(0));

        //removing first value from the input string : reducing size
        String ss = s.substring(1);

        //call solve on both output : this will let us make decision to whether choose or not
        solve(ss,o);
        solve(ss,o2);
        return;
    }
}
