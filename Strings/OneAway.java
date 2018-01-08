package Strings;

public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IsItOneAway("baled", "balde"));
	}
	
	public static boolean IsItOneAway(String s1, String s2) {	
		if(Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		
		int count = 0;
		String string1 = "";
		String string2 = "";
		if(s1.length() < s2.length()) {
			string1 = s2;
			string2 = s1;
		}
		else {
			string1 = s1;
			string2 = s2;
		}
		
		int count1 = 0;
		int count2 = 0;
				
		boolean diff = false;
		
		while(count1<string1.length() && count2<string2.length()) {
			if(string1.charAt(count1) != string2.charAt(count2)) {
				if(diff) {
					return false;
				}
				if(s1.length() == s2.length()) {
					count1++;
				}
				diff = true;				
			}
			else {
				count1++;
			}
			count2++;
		}		
		
		System.out.println(count);
		return true;
	}
}
