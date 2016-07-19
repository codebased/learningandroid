package starterkit;

/**
 * Created by codebased on 19/07/16.
 */
public class LogicLooping {

    public void play() {
        playCondition();
        playLogicalConditionalOperators();
        playWhile();
        playDoWhile();
        playFor();
        playArray();
    }

    private void playArray() {
        float[] values = {
                1.2f,
                1.3f
        };

        for (int idx = 0; idx < values.length; idx++) {
            System.out.println(values[idx]);
        }


        float[] values2 = new float[2];
        values2[1] = 1.2f;
        values2[0] = 1.3f;

        for (float v :
                values2) {

            System.out.println(v);
        }

        float[] value3 = new float[]{1.2f, 1.3f};

        for (float v :
                value3) {

            System.out.println(v);
        }
    }

    private void playFor() {
        int value = 10;

        // initialize; condition; update (optional)
        for (int idx = 0; idx < 10; idx++) {
            System.out.println(value - idx);
        }
    }

    private void playDoWhile() {

        // check the condition after executing once.
        int value = 10;

        do {
            System.out.println(value);
        }
        while (value-- > 0);
    }

    private void playWhile() {

        // check the condition first.
        int value = 10;
        while (value-- > 0) {
            System.out.println(value);
        }
    }

    private void playLogicalConditionalOperators() {

        int value = 1;
        int value2 = 10;

        if (value == 1 && value2 == 2) {
            System.out.println("All is well");
        } else if (value == 1 || value2 == 2) {
            System.out.println("something is well");
        } else
            System.out.println("nothing is well");
    }

    private void playCondition() {

        String value = 10 > 20 ? "I am great" : "all are great";
        System.out.println(value);

        // if with block statement { ... }
        if (20 > 10) {
            value = "I am great";
        } else {
            value = "all are great";
        }

        System.out.println(value);

        int trial = 120;
        switch (trial) {
            case 20:
            case 10:
                value = "I am great";
            default:
                value = "You are great";

        }

        System.out.println(value);
    }
}
