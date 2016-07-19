package starterkit;

/**
 * Created by codebased on 19/07/16.
 */

// use final to prevent inheriting and/ or overriding
final public class FinalClass {

    // a final field must be set during cration - field initializer, initlaizaation block or a constructor.
    // adding a static modifier makes a final field a named constants cannot be set by an object instance.

    final static int constant = 10;

    public void play() {
        System.out.println(FinalClass.constant);
    }


}

// this will give an error.
//public class SubFinalClass extends FinalClass {
//
//}
