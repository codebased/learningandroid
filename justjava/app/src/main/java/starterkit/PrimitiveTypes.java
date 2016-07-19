package starterkit;

/**
 * Created by codebased on 19/07/16.
 */
// Primitive types are build into language
public class PrimitiveTypes {
    // stored by values not in heap.
    // don't use number as a first character, convention - use camelcase.

    private IntegerType mIntegerType;
    private CharType mCharType;
    private FloatType mFloatType;


    //  stored by values
    public class IntegerType {

        // 32 bits.
        int intergerValue = 10;

        // 8 bits.
        byte byteValue = -128;

        // 16 bits.
        short shortValue = 32767;

        // 64 bits
        long longValue = 23423L;
    }

    //  stored by values
    public class FloatType {

        // 32 bits.
        float floatValue = 234.23f;

        // 64 bits;
        double doubleValue = 233.23d;
    }

    //  stored by values
    public class CharType {

        char charValue = 'A';
        char uniCharValue = '\u0024'; //$ sign
    }


    public IntegerType getIntegerType() {
        return mIntegerType;
    }

    public CharType getCharType() {
        return mCharType;
    }

    public FloatType getFloatType() {
        return mFloatType;
    }


    public PrimitiveTypes() {
        this.mFloatType = new FloatType();
        this.mCharType = new CharType();
        this.mIntegerType = new IntegerType();
    }

    // you have to set the value before you use but no compile time error
    // . System.out.println(mynumber) is going to throw an exception.
        /*int anotherNumber;
        PrimitiveTypes types = new PrimitiveTypes();
        System.out.print(types.anotherNumber);*/


    public void play() {

        playUniCode();
        playPrePostFixOperators();
        playCompoundAssignmentOperators();
        playConversion();
        playOperatorPriority();

    }


    private void playConversion() {
        // explicit conversion
        short localShortValue = 10;
        int localIntegerValue = 2342;
        // when calculate it takes the highest type, thus the result is in highest type that needs the explicit conversion
        // error: short result = localIntegerValue - localShortValue;
        short result = (short) (localIntegerValue - localShortValue);

        System.out.println(result);

        //  when calculate it takes the highest type, thus here the long can take integer calculation.
        long result1 = localIntegerValue - localShortValue;

        System.out.println(result1);

    }

    private void playCompoundAssignmentOperators() {
        // compound assignment operators (+= -= *= /= %=)
        this.mIntegerType.intergerValue += 10;
        System.out.println(this.mIntegerType.intergerValue);

    }

    private void playPrePostFixOperators() {
        // pre and post fix operators (++ and --)
        System.out.println(this.mIntegerType.intergerValue++);
        System.out.println(++this.mIntegerType.intergerValue);

    }

    private void playUniCode() {
        // statements ends with ;
        // statements can have multiple lines, whitespace :-)
        /* You can even call multiple lines (block) comments like swift ehhh */
        /** JavaDoc comments */
        // You cannot nest block comments like swift
        System.out.println(this.getCharType().uniCharValue);

    }


    private void playOperatorPriority() {
        // order is () nested first, post (left to right), pre (left to right), multiplications (%/* left to right), add (+- left to right)
        int localValue = 10;
        localValue += localValue++ - localValue;
        System.out.println(localValue);
    }

}