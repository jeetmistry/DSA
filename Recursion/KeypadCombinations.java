import java.util.*;

public class KeypadCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }
static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String rem = str.substring(1);

        ArrayList<String> rres = getKPC(rem);
        ArrayList<String> mres = new ArrayList<>();

        String codeforch = codes[ch-'0'];
        for(int i=0;i<codeforch.length();i++){
            char chcode = codeforch.charAt(i);
            for(String rstr : rres){
                mres.add(chcode+rstr);
            }
        }
        return mres;
    }
}
