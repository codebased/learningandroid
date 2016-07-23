package threads;

/**
 * Created by codebased on 21/07/16.
 */
public class FileLoaderAsyncTask {

    public static void main(String args[]) throws InterruptedException {

        System.out.printf("MAIN METHOD WITH THREAD ID...%s\n", Thread.currentThread().getId());

        FileLoaderRunnable fileLoaderAsyncTask = new FileLoaderRunnable();
        fileLoaderAsyncTask.play();

        System.out.println("MAIN METHOD END");
    }

}
