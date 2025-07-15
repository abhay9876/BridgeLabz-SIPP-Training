package StringBuffer;

public class Concatenate {
     public static void main(String[] args) {
    	 String[] array = {"hello", "kya", "haal","hai"};
    	 StringBuffer sb = new StringBuffer();
    	 for(int i = 0 ; i < array.length ; i++) {
    		 sb.append(array[i]+" ");
    	 }
    	 
    	 System.out.print(sb);
     }
}
