package LinearSearch;

public class SearchNegativeValue {
     public static void main(String[] main) {
    	 int[] array = {1,5,2,3,-2,9};
    	 int foundIndex = -1;
    	 for(int i = 0 ; i < array.length ; i++) {
    		 if(array[i]<0) {
    			 foundIndex = i;
    			 break;
    		 }
    	 }
    	 
    	 System.out.print(foundIndex);
    	 }
}
