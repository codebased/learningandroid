package tests;

import junit.framework.Assert;

import org.junit.Test;

import maps.QuoteLookupTable;
import models.Quote;
import models.QuoteFixtures;

/**
 * Created by codebased on 18/07/16.
 */
public abstract class QuoteLookupTableTests {
    @Test
    public void addNewQuote() {

        QuoteLookupTable quoteLookupTable = getInstance();
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q1), "Quote1");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q2), "Quote2");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q3), "Quote3");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q4), "Quote4");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q5), "Quote5");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q6), "Quote6");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q7), "Quote7");
        assertValue(quoteLookupTable.addQuote(QuoteFixtures.q8), "Quote8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateQuote() {
        QuoteLookupTable quoteLookupTable = getInstance();
        Quote quote = quoteLookupTable.addQuote(new Quote(1, "QuoteTest", "Author", "Genre"));
        Quote quote1 = quoteLookupTable.addQuote(new Quote(1, "QuoteTest", "Author", "Genre"));
    }

    abstract QuoteLookupTable getInstance();

    private void assertValue(Quote quote, String expectedQuoteValue) {
        Assert.assertNotNull(quote);
        Assert.assertEquals(quote.getQuote(), expectedQuoteValue);
    }
}
