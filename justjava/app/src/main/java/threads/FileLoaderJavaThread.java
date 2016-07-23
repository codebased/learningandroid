package threads;

/**
 * Created by codebased on 21/07/16.
 */
public class FileLoaderJavaThread {

    public static void main(String args[]) throws InterruptedException {

        System.out.printf("MAIN METHOD WITH THREAD ID...%s\n", Thread.currentThread().getId());

        FileLoaderRunnable.play();

        System.out.printf("MAIN METHOD END WITH THREAD ID...%s", Thread.currentThread().getId());
    }
}
