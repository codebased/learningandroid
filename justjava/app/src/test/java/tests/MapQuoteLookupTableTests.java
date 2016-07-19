package tests;

import maps.MapQuoteLookupTable;
import maps.QuoteLookupTable;

/**
 * Created by codebased on 18/07/16.
 */
public class MapQuoteLookupTableTests extends QuoteLookupTableTests {

    @Override
    QuoteLookupTable getInstance() {
        return new MapQuoteLookupTable();
    }
}
