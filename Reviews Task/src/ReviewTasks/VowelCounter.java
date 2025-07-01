package ReviewTasks;

public class VowelCounter {
     public static void main(String[] args) {
    	 String alphabet= "arerightbuddy";
    	 System.out.println("The String is :" +alphabet);
    	 int countVowel =0;
    	 for(int i = 0 ; i<alphabet.length();i++ ) {
    		 char c = alphabet.charAt(i);
    		 if(c=='a' || c =='e' || c=='i' || c=='o' || c=='u') {
    			 countVowel++;
    		 }
    	 }
    	 int countConstant = alphabet.length()-countVowel;
    	 System.out.println("Total Number of Vowel : "+countVowel);
    	 System.out.println("Total Number of Constant : "+countConstant);
    	 
     }
}
