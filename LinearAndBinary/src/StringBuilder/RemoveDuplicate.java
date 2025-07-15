package StringBuilder;

import java.util.HashSet;

public class RemoveDuplicate {
     public static void main(String[] args) {
    	 String  string= "abcbadba";
    	 HashSet<Character> set = new HashSet<>();
    	 StringBuilder sb = new StringBuilder();
    	 for(int i = 0 ; i < string.length(); i++) {
    		 char a = string.charAt(i);
    		 if(!set.contains(a)) {
    			 sb.append(a);
    			 set.add(a);
    		 }
    	 }
    	 System.out.print(sb);
    	 
     }
}
