package starterkit;

/**
 * Created by codebased on 19/07/16.
 */
public class ErrorHandlerClass {

    public void play() {
        try {
            play2();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("play finally called");
        }
    }

    private void play2() throws NoSuchFieldException {
        try {
            throw new NoSuchFieldException();
        } finally {
            System.out.println("play2 finally called");
        }
    }
}
