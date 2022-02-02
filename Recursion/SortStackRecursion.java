import java.util.*;
import java.io.*;
public class SortStackRecursion{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            stack.push(Integer.parseInt(s[i]));
        }
        System.out.println(stack.size());
        
        //sort the stack
        sort(stack);

        //print sorted stack
        System.out.println(stack);
    }
    
    //function to sort stack
    public static void sort(Stack<Integer> stack){

        //check if stack is having only one element then it is already sorted, return 
        if(stack.size()==1){
            return;
        }

        //remove last element and then recursively call sort on reduced stack
        int val = stack.pop();
        sort(stack);

        //finally insert the element into the stack
        insert(stack,val);

        //return to main 
        return;
    }


    //function to insert an element in sorted form
    public static void insert(Stack<Integer> stack,int value){

        /*check is stack is empty or the value is larger than the top element in the 
        stack then push the element on to the stack and return*/
        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);
            return;
        }

        /*get top element of stack and recursively call insert on reduced stack
        to insert element in sorted order*/
        int val = stack.pop();
        insert(stack,value);

        //finally push the popped element in the stack and return to sort method
        stack.push(val);
        return;
    }
}