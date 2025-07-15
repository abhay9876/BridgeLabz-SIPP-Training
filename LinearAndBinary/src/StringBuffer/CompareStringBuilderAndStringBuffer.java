package StringBuffer;

public class CompareStringBuilderAndStringBuffer {
    public static void main(String[] args) {
    	long start,end;
    	
    	StringBuilder sBuilder = new StringBuilder();
    	StringBuffer sBuffer = new StringBuffer();
    	
    	start = System.nanoTime();
    	for(int i = 0 ; i< 100000 ; i++) {
    		sBuilder.append("hehe kya haal hai");
    	}
    	end = System.nanoTime();
    	System.out.println("StringBuilder Time : " +(end-start) +" ns");
    	
    	start = System.nanoTime();
    	for(int i = 0 ; i< 10000 ; i++) {
    		sBuffer.append("hehe");
    	}
    	end = System.nanoTime();
    	System.out.println("StringBuffer  Time : " +(end-start) +" ns");
    	
    }
}
