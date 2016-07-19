package starterkit;

/**
 * Created by codebased on 19/07/16.
 */
public class StaticClass {

    static int staticValue;

    static {
        // static initialize block
        staticValue = 10;
    }

    public static void play() {
        System.out.println(StaticClass.staticValue);
    }
}
