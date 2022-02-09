import java.util.*;
public class JosephusProblemRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking n and k input 
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        // Creating array consisting of 1 to n elements 
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i+1);
        }
        System.out.println(arr);

        //We are dealing with 0 base indexing so we need to decrease k by -1 to get to the proper index
        k--;
        // solve the problem 
        solve(arr,k,0);
    }

    private static void solve(ArrayList<Integer> arr, int k, int index) {

        // If only one element is present then print the number who is alive
        if(arr.size()==1){
            System.out.println(arr);
            return;
        }

        // Calculate index by adding k and modulo size of array to avoid arrayindexoutofbounds
        index = (index+k)%arr.size();

        // remove the element from the index 
        arr.remove(index);
        System.out.println(arr);
        
        // Call solve on reduced array and passing index mod size so that the 
        // we start counting from the index which was deleted
        solve(arr,k,index%arr.size());

        // Finally return
        return;
    }

}
