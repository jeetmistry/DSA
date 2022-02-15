import java.util.Scanner;

public class LuckyNumberRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(check(n,2));
    }

    private static boolean check(int n, int counter) {
        if(n<counter){
            return true;
        }
        if(n%counter==0){
            return false;
        }
        n-=n/counter;
        counter++;
        return check(n,counter);
    }
}
