package starterkit;

/**
 * Created by codebased on 19/07/16.
 */

// String is mutable in nature
public class StringClass {

    // stored using UTF-16 encoding.
    private String value;

    public void play() {

        //any manipulation with the string is creating a new object.
        String greeting = "Hello";
        // object two.
        greeting = "";

        // String reference: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
        String s1 = "Love Java";
        String s2 = "Love";
        s2 += " Java";

        System.out.println(s1 == s2); // return false because it first compares the object memory address
        System.out.println(s1.equals(s2)); // return true because it compares the value.



        /// now s3 and s4 is pointing to the same address; thus the comparison is going to be at memory address pointer level and it will be faster.
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s3 == s4); // return true

        String s5 = "Hello";
        String s6 = "Hello";
        System.out.println(s5 == s6); // return true -- hahah do you know why?

        System.out.println(String.valueOf(1) + " World");

        // Use StringBuilder for mutable string buffer for better performance
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(" world");
        System.out.println(stringBuilder);

    }
}
