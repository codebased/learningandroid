package tests;

import junit.framework.Assert;

import org.junit.Test;

import models.QuoteFixtures;
import sets.QuoteCatalogue;

/**
 * Created by codebased on 18/07/16.
 */
public class QuoteCatalogueTests {


    @Test
    public void addDuplicate() {
        QuoteCatalogue quoteCatalogue = new QuoteCatalogue();
        quoteCatalogue.add(QuoteFixtures.q1);
        quoteCatalogue.add(QuoteFixtures.q1);
        quoteCatalogue.print();
        Assert.assertEquals(quoteCatalogue.size(),1);
    }

    @Test
    public void checkOrder() {
        QuoteCatalogue quoteCatalogue = new QuoteCatalogue();
        quoteCatalogue.add(QuoteFixtures.q1);
        quoteCatalogue.add(QuoteFixtures.q2);
        quoteCatalogue.add(QuoteFixtures.q3);
        quoteCatalogue.add(QuoteFixtures.q4);
        quoteCatalogue.print();
    }
}
