package Strings;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		System.out.println(IsRotation("carlos", "loscar"));
		System.out.println(IsRotation("tony", "nyto"));
		
	}
	
	public static boolean IsRotation(String s1, String s2) {
		if(s1.length()!= s2.length()) {
			return false;
		}
		
		String second = s2 + s2;
		if(second.contains(s1)) {
			return true;
		}
		
		return false;
	}

}
