import java.util.*;
import java.io.*;

public class ReverseStackRecursion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            stack.push(Integer.parseInt(s[i]));
        }
        System.out.println(stack);

        //call reverse to reverse the stack
        reverse(stack);

        //print the reverse stack
        System.out.println(stack);
    }
    
    //function to reverse stack
    public static void reverse(Stack<Integer> stack){

        //if stack is empty then return : base case
        if(stack.isEmpty()){
            return;
        }
        //remove last element and then recursively call solve on reduced stack until its not empty
        int val = stack.pop();
        reverse(stack);
        
        //finally insert the removed element into the stack at first position
        insert(stack,val);

        //return to main 
        return;
    }


    //function to insert an element in stack in first position
    public static void insert(Stack<Integer> stack,int value){
        if(stack.isEmpty()){
            stack.push(value);
            return;
        }

        //remove elements till stack is empty (recursion will handle this)
        int val = stack.pop();

        //call the insert function to recursively pop elements until stack is empty
        insert(stack,value);

        //finally push the value popped 
        stack.push(val);
        return;
    }
}
