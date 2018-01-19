package Strings;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringCompression("abcd"));
	}
	
	public static String StringCompression(String s) {
		char[] orig = s.toCharArray();
		
		int count = 0;
		int index = 0;
		
		StringBuilder sb = new StringBuilder();
		String result = "";
		for(int i=0;i<s.length();i++){
			count++;
			if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				sb.append(s.charAt(i));				
				sb.append(count);
				if(sb.length() > s.length()) {
					return s;
				}
				count=0;
			}
		}
		result = sb.toString();
		return result;
	}

}
