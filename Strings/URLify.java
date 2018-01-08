package Strings;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(URLifyWord("Mr John Smith    ", 13));
		String s = "Mr John Smith    ";
		char[] test = s.toCharArray();
		System.out.println(URLifyWordInPlace(test, 13));
	}
	
	public static String URLifyWord(String s, int n) {
		String result = "";
		
		//char[] origArray = new char[n];
		int finLength = s.length()-1;
		char[] resArray = new char[finLength];
		resArray = s.toCharArray();
		System.out.println(finLength);
		for(int i = n-1; i>=0; i--) {
			//System.out.println(resArray[i]);
			//System.out.println(resArray[finLength]);
			if(resArray[i] == ' ') {				
				resArray[finLength] = '0';
				resArray[finLength-1] = '2';
				resArray[finLength-2] = '%';
				finLength-=3;
			}
			else {
				resArray[finLength] = resArray[i];
				finLength--;
			}						
		}
		
		result = String.valueOf(resArray);
		//System.out.println(resArray[i]);
		return result;
	}
	
	public static String URLifyWordInPlace(char[] c, int n) {
		String result = "";
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			if(c[i] == ' ') {
				count++;
			}
		}
		
		int finLength = n + count * 2;
		//System.out.println(finLength);
		for(int i = n-1; i>=0; i--) {
			if(c[i] == ' ') {				
				c[finLength-1] = '0';
				c[finLength-2] = '2';
				c[finLength-3] = '%';
				finLength-=3;
			}
			else {
				c[finLength-1] = c[i];
				finLength--;
			}						
		}
		
		result = String.valueOf(c);
		//System.out.println(resArray[i]);
		return result;
	}

}
