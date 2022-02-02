import java.util.*;
import java.io.*;
public class RemoveMiddleElementFromStack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            stack.push(Integer.parseInt(s[i]));
        }
        System.out.println(stack.size());

        //call solve for removing middle element
        solve(stack,(stack.size()%2 == 1) ? stack.size()/2 : (stack.size()/2) -1 );

        //print the stack without middle element 
        System.out.println(stack);
    }
    
    //function to remove middle element
    public static void solve(Stack<Integer> stack,int k){

        //check if k is 0 then pop the element and return 
        if(k==0){
            stack.pop();
            return;
        }

        //remove last element and then recursively call solve on reduced stack with k-1
        int val = stack.pop();
        solve(stack,k-1);

        //finally insert the removed element into the stack
        insert(stack,val);

        //return to main 
        return;
    }


    //function to insert an element in stack
    public static void insert(Stack<Integer> stack,int value){

        stack.push(value);
        return;
    }
}
