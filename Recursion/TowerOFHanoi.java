import java.io.*;
public class TowerOFHanoi {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = "Tower 1";
        String h = "Tower 2";
        String d = "Tower 3";

        solve(n,s,d,h);
    }

    static void solve(int n, String s,String d, String h){

        /* 
        If there is only one plate in tower then we can put directly in 
        tower 3 and then return because it is the base case
        */
        if(n==1){
            System.out.println(n +" from " +s +" to " + d );
            return;
        }

        /*
        If the there are more plates in the tower then we will need to put the plates
        in tower 2 because we cannot place big plate on small plate
        therefore call source as tower 1, destination as tower 2 and helper tower as tower 3

        1. it will take plate 1 from tower 1 and place it on tower 3.
        2. It will take plate 2 from tower 1 and place it on tower 2
        |   |   |
        |   |   |
        |3  |2  |1
        */
        solve(n-1,s,h,d);
        System.out.println(n +" from " +s +" to " + d);

        /*Finally 
        Place all the plates from helper tower to the destination tower with the help of source tower
        1. It will take plate 1 from tower 3 and place it on top of tower 2 
        */
        solve(n-1,h,d,s); //here source is now helper and destination is sorurce

        /*

        |   |   |                                   |   |   |                                           
        |3  |2  |      =>Then add 3 on tower 3      |   |1  |                    
        |   |1  |                                   |   |2  |3


        Finally add 1 on tower 1 and 2 on tower 3 and then finally 1 on tower 3

        |   |   |1
        |   |   |2
        |   |   |3
       */ 
        return;
    }
}
