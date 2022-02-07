import java.util.*;
import java.io.*;

public class SubsetWithSpaces {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Taking user input
        String input = br.readLine().trim();

        //We know that we dont want space before the first element so we take first element as output
        String output = Character.toString(input.charAt(0));

        //We reduce the length of string by removing 1st element because we made a decision
        String in = input.substring(1);

        //solve for the input 
        solve(in,output);
    }

    //method to generate subset with spaces
    public static void solve(String input, String output){

        //if input is empty then print the output, we got out subsets
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        //Initializing both outputs with original output
        String output1 = output;
        String output2 = output;

        //insert 1st element without taking space _
        output1+=Character.toString(input.charAt(0));
        
        //insert 1st element with taking space in the prefix
        output2+="_"+Character.toString(input.charAt(0));

        //reduce the string by removing 1st element 
        String in = input.substring(1);

        //call solve recursively for 1st output
        solve(in,output1);

        //call solve recursively for 1st output
        solve(in,output2);
        return;
    }
}
