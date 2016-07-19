package tests;

import maps.ArrayListQuoteLookupTable;
import maps.QuoteLookupTable;

/**
 * Created by codebased on 18/07/16.
 */
public class ArrayListQuoteLookupTableTests extends QuoteLookupTableTests {

    @Override
    QuoteLookupTable getInstance() {
        return new ArrayListQuoteLookupTable();
    }
}
