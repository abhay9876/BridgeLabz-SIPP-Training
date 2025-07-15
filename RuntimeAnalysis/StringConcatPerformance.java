public class StringConcatPerformance {
    public static void main(String[] args) {
        int n = 10000;
        long start;

        start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) str += "a";
        System.out.println("String: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < n; i++) sf.append("a");
        System.out.println("StringBuffer: " + (System.currentTimeMillis() - start) + "ms");
    }
}