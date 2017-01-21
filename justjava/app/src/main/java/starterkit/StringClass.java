package starterkit;

/**
 * Created by codebased on 19/07/16.
 */

// Strings are different from most other Java objects in that they are immutable. What this
// means is that you cannot modify a String object. If you do then you are going to get the
    // new object
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

        // now s3 and s4 is pointing to the same address; thus the comparison is going to be at memory address pointer level and it will be faster.
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s3 == s4); // return true

        String s5 = "Hello";
        String s6 = "Hello";
        System.out.println(s5 == s6); // return true -- hahah do you know why?

        System.out.println(String.valueOf(1) + " World");

        // Use StringBuilder for mutable string buffer for better performance
        // The StringBuilder class was introduced in Java 5.0 as a replacement for the StringBuffer.
        // The StringBuffer has the same methods as the StringBuilder, but is designed for programs
        // that have multiple threads of execution.
        // The default capacity of an empty StringBuilder object is 16 characters
        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.append(1);
        stringBuilder.append(" world");
        System.out.println(stringBuilder);



        String s7 = "Hey this is so great";
        // \\s - remove any whitespace
        // \\S - reverse of \\s
        // \\w - [A-Za-z_0-9]
        // \\d - [0-9]
        String[] token = s7.split("\\s+");
        for (String s :
                token) {
            System.out.println(s);
        }

    }
}
