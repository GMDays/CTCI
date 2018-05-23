package Strings;

public class Hackerrank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(twoStrings("hello", "world"));
	}
	
	static String twoStrings(String s1, String s2){
        // Complete this function
		boolean[] check = new boolean[128];
		for(char c : s1.toCharArray()) {
			check[c]=true;
		}
		for(char c : s2.toCharArray()) {
			if(check[c]) {
				return "YES";
			}
		}
		return "NO";
    }
}
