package starterkit;

import java.io.Console;

/**
 * Created by codebased on 19/07/16.
 */

// classes are reference types
// convention is pascal case.
// can use letters and numbers
// the first character is always a letter.
// every class has at least one constructor if no explicit consturtor, java provides one.
// every class base class (superclass) Object class.
public class BaseClass extends AbstractClass {


    int defaultAccessModifier;

    // data members along methods operate on the data called encapsulation,
    // field initial state for integers are 0
    // you can set the value here (called field initializer)
    // can be simple value assignment, equation, reference other fields, or even a method call.
    // field initialization happens before initialization block and constructor
    private int privateAccessModifier = 100 * defaultAccessModifier + defaultValue();
    protected String defaultName;


    //block initialization happens before constructor
    {
        // this is called initialization block, which is shared across all constructors.
        // it is executed as if the code were placed at the start of each constructor.
        defaultName = "Boss";
    }

    // constructor initialization happens after initialization block and constructor
    // ahh now no one can do new ClassMatters() outside of this class ;-)
    private BaseClass() {
        // it calls parameter constructor
        this(10);
    }

    public BaseClass(int defaultValue) {
        this.defaultAccessModifier = defaultValue;
    }

    private int defaultValue() {
        return 0;
    }

    // very common behaviour in Android of creating an intent or activity object object.
    public static BaseClass getInstance() {
        return new BaseClass();
    }

    // convention: names are camel case so the param names.
    public void play() {

        // public means it is usable on classes, and usable on members.
        // this is an implicit reference to the current object; you don't have to use it.
        int value = 10;
        System.out.printf("Default value is %d\n", value);

        // overloading sees - name,number of parameters and type of each parameter.
        this.play(value);

        System.out.printf("After call the value is %d\n", value);

        BaseClass object1 = new BaseClass();
        BaseClass object2 = new BaseClass();

        System.out.println(object1 == object2);
        System.out.println(object1.equals(object2));
    }

     private void play(int immutableValue) {
        // I can be called only from inside the ClassMatters itself or its members.
        // I can decide to return
        immutableValue = 20;
        System.out.printf("Changed value (inside of a called method) is %d\n", immutableValue);
        if (1 == 1)
            return;

        System.out.println("I am not going to get printed");
    }

    // once it is defined as private no derived class override :)
    final void play3() {
        // because thereis no access modifier specified the default is visible only within its own package.
    }

    // convention: accessors are defined with get<fieldName> and set<fieldName> ; again all are in camel case.
    public int getPrivateAccessModifier() {
        return privateAccessModifier;
    }

    public void setPrivateAccessModifier(int privateAccessModifier) {
        this.privateAccessModifier = privateAccessModifier;
    }

    private class Mode {
        // once the top level class is private, everything within is private to all nested classes.
    }
}
