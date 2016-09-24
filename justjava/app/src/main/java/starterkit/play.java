// packaging provide organization
// the package name should match the folder structure (java does not care but the IDE does ??)
// get the global uniqueness by using reversed domain name.
// package and folder names are written in small letters.
package starterkit;

// importing all static members (methods and variables);

import static starterkit.StaticClass.*;

public class play {


    public static void main(String args[]) {

        System.out.println("Hello Steven");

//        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
//        primitiveTypes.play();
//
//        LogicLooping logicLooping = new LogicLooping();
//        logicLooping.play();
//
//        BaseClass baseClass = new BaseClass(12);
//        baseClass.play();
//        baseClass.play3();
//        // I can access this: baseClass.defaultAccessModifer - why? do you know :) ?;
//
//        DerivedClass derivedClass = new DerivedClass(12);
//        derivedClass.play();

//        FinalClass finalClass = new FinalClass();
//        finalClass.play();
//
        StringClass stringClass = new StringClass();
        stringClass.play();
//
//        ErrorHandlerClass errorHandlerClass = new ErrorHandlerClass();
//        errorHandlerClass.play();

//        ComparableInterfaceClass comparableInterfaceClass = ComparableInterfaceClass.getInstance();
//        comparableInterfaceClass.play();

        // wondering where it is coming from? guess guess?
        // it is because of import static starterkit.StaticClass.* statement in the beginning
//        play();

//        AnonymousClass anonymousClass = new AnonymousClass();
//        anonymousClass.play();
    }
}
