import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
        static int rand=0;
    public static void main(String[] args) {
        //this is for the time taken by the thread
        Instant start = Instant.now();


//the number fo threads given in the NEWFIXEDTHREADPOOL method is firstly making all the threads, assigning them the tasks randomly
//as soon as they complete the prev one until the final task has been done
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int counter = 0; counter < 1176; counter++) {
            FirstThread firstThread = new FirstThread();
            executor.execute(firstThread);
//
//            try {
//                //every new thread gonna be on sleep for 1 sec before execution
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        }

        executor.shutdown();
        Instant end = Instant.now();

    }
}