public class BackgroundJobExecution {
    public static void main(String[] args) {
        Runnable job=()->{
            for(int  i = 0  ; i <= 5 ;i++ ){
                System.out.println("Step : "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(job);
        thread.start();
    }
}
