package Strings;

public class IsUnique {

	public static void main(String[] args) {
		if(IsUniqueCheck("heloa")){
			System.out.println("This string is unique.");
		}
		else {
			System.out.println("This string is NOT unique.");
		}	
		
		if(IsUniqueCheckNoExtraSpace("heloa")){
			System.out.println("This string is unique.");
		}
		else {
			System.out.println("This string is NOT unique.");
		}	
	}
	
	public static boolean IsUniqueCheck(String s) {
		boolean result = true;
		
		boolean[] check = new boolean[128];
		for(int i = 0; i < s.length(); i++) {
			//System.out.println(s.charAt(i));
			if(check[s.charAt(i)]){
				result = false;
				break;
			}
			check[s.charAt(i)] = true;
		}
				
		return result;
	}
	
	public static boolean IsUniqueCheckNoExtraSpace(String s) {
		boolean result = true;
		
		for(int i = 0; i<s.length(); i++) {
			for(int j = i+1; j<s.length(); j++) {
				//System.out.println("This is the ith char: " + s.charAt(i));
				//System.out.println("This is the jth char: " + s.charAt(j));
				if(s.charAt(i) == s.charAt(j)) {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
}
