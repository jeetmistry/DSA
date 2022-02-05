import java.util.*;
import java.io.*;
public class SubsetPermutationUnique {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Taking input string 
        String s = br.readLine().trim();

        //initializing output string as empty string
        String o = "";
        solve(s,o,new HashSet<String>());
    }

    //function to print uniqu permutaions of the string 
    public static void solve(String s,String o,HashSet<String> set){

        //if input string is empty then we are at base case and need to add output in set
        if(s.length()==0){

            //adding BLANK instead of empty string 
            if(o.equals("")){
                set.add("Blank");
                return;
            }

            //return if the element is already existing in the set/map
            if(set.contains(o)) return;

            //add element into set
            set.add(o);
            return;
        }

        //Initializing output string with original output for decision maklng  
        String o2=o;

        //adding first value of the input string to output string 
        o2+=Character.toString(s.charAt(0));

        //removing first value from the input string : reducing size
        String ss = s.substring(1);

        //call solve on both output : this will let us make decision to whether choose or not
        solve(ss,o,set);
        solve(ss,o2,set);
        
        System.out.println(set);
        return;
    }
}
