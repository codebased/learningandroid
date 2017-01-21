package datastructure;

/**
 * Created by codebased on 17/09/16.
 */
public class recursion {

    public static int fib(int x) {

        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        return  fib(x - 1) + fib(x - 2);
    }
}
