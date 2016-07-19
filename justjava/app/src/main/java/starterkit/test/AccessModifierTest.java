package starterkit.test;

import starterkit.BaseClass;

/**
 * Created by codebased on 19/07/16.
 */
public class AccessModifierTest {

    public void test() {
        BaseClass wowClass = new BaseClass(10);
        wowClass.play();
        // wowClass.play3() is not avaialble here because the package is changed.
    }
}
