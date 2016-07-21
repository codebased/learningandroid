package threads;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// runnable class is avaialble for android as well as java.
public class FileLoaderRunnable implements Runnable {

    String fileName = "/Users/codebased/Documents/gits/learningandroid/justjava/app/src/main/java/threads/quotes.json";

    @Override
    public void run() {

        System.out.printf("RUN THREAD ID...%s\n===========\n", Thread.currentThread().getId());
        // executed under background thread.
        File file = new File(fileName);
        System.out.println(file.length());
        FileInputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int count = 0;
        try {
            inputStream = new FileInputStream(file);
            int character = inputStream.read();
            while (character != -1) {
                byteArrayOutputStream.write(character);
                character = inputStream.read();
                count++;
                publishProgress(count, file.length());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println("END...run");

    }

    private void publishProgress(int count, long total) {
        System.out.printf("Progress...ThreadId (%d) -> (%d of %d) \n", Thread.currentThread().getId(), count, total);
    }

    public static void play() throws InterruptedException {

        System.out.printf("MAIN THREAD ID...%s\n", Thread.currentThread().getId());

        Thread thread = new Thread(new FileLoaderRunnable());
        thread.start();
        // waits for this thread to die
        thread.join();
        // this line will execute after the thread is finish.
        System.out.println("MAIN THREAD END");
    }
}