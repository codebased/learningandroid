package starterkit;

/**
 * Created by codebased on 19/07/16.
 */

// extends keyword is used first before you can use implements
// It can be assigned to base class typed reference:
//    BaseClass baseClass = new DervivedClass();

public class DerivedClass extends BaseClass {

    // fields hide base class field with same name
    // no error is found.
    protected String defaultName;

    {
        defaultName = "NO BOSS";
    }

    public DerivedClass(int defaultValue) {
        super(defaultValue);
    }

    // you don't have to write @Override but it is nice to tell the compiler so that the compiler checks that the base class
    // has got the same method signature and report a compile time error :)
    @Override
    public void play() {

        // TIP SUPER: similar to this keyword, super is implicit reference to the current object
        // super treats the object as if it is an instance of its base class.
        // it is useful for accessing base class members that have been overriden.
        super.play();

        DerivedClass object1 = new DerivedClass(10);
        DerivedClass object2 = new DerivedClass(10);

        System.out.println(object1 == object2); // should print false
        System.out.println(object1.equals(object2)); // should print true
    }

//   You cannot do this because the base class, play3, has declared as final!!!
//    @Override
//    void play3() {
//        super.play3();
//    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof DerivedClass) {
            return this.defaultName.equalsIgnoreCase(((DerivedClass) o).defaultName);
        }
        return false;
    }
}