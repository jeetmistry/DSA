import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class AddTwoNumbersRepresentedByLinkedList{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // return head of sum list
        
        int count1 = count(first);
        int count2 = count(second);
        if(count1<count2){
            Node temp = first;
            first = second;
            second = temp;
            
        }
        //calculate reverse of first which is greatest always
        Node firstRev = reverse(first);
        Node secondRev = reverse(second);
        
        Node s = secondRev;
        
        while(s.next!=null){
            s=s.next;
        }
        count1 = count(firstRev);
        count2 = count(secondRev);
        int dif = count1-count2;
        
        //add 0 at the end of second Reversed list
        while(dif-->0){
            Node n = new Node(0);
            s.next = n;
            s = s.next;
        }
        
        //Creating result list 
        Node result=null;
        Node tempresult=null;
        int carry=0;
        Node f=firstRev;s=secondRev;
        while(f!=null && s!=null){
            int sum=0;
            int n1 = f.data;
            int n2 = s.data;
            if(carry==1){
                sum = n1+n2+carry;
            }
            else{
                sum=n1+n2;
            }
            carry = sum/10;
            sum = sum%10;
            Node n = new Node(sum);
            if(result==null){
                result = n;
                tempresult = result;
            }else{
                tempresult.next = n;
                tempresult = tempresult.next;
            }
            f=f.next;
            s=s.next;
        }
    
        if(carry!=0){
            Node n = new Node(carry);
            tempresult.next = n;
            tempresult = tempresult.next;
        }
        
        return reverse(result);
    }
    
    public static int count(Node node){
        Node start = node;
        int count=0;
        while(start!=null){
            start=start.next;
            count++;
        }
        return count;
    }
    
    public static Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}