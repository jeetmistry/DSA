import java.util.*;

public class PascalTriangle{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nRows = sc.nextInt();

		List<List<Integer>> res = pascal(nRows);
		for(List<Integer> list : res) System.out.println(list);

	}

	public static List<List<Integer>> pascal(int n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> prev = null, list;

		for(int i=0;i<n;i++){
			list = new ArrayList<>();
			for(int j=0;j<=i;j++){
				if(j==0 || j==i){
					list.add(1);
				}else{
					list.add(prev.get(j-1)+prev.get(j));
				}
			}
			prev = list;
			result.add(list);
		}
		return result;
	}
}