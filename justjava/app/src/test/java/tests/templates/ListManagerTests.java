package tests.templates;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import generics.ListManager;
import generics.ListUtils;
import models.Quote;
import models.QuoteFixtures;

/**
 * Created by codebased on 23/07/16.
 */
public class ListManagerTests {

    final Comparator<Quote> ORDER_BY_AUTHOR = new Comparator<Quote>() {
        @Override
        public int compare(Quote lhs, Quote rhs) {
            return lhs.getAuthor().compareTo(rhs.getAuthor());
        }
    };
    final Comparator<Quote> ORDER_BY_ID = new Comparator<Quote>() {
        @Override
        public int compare(Quote lhs, Quote rhs) {
            if (lhs.getId() == rhs.getId()) return 0;
            if (lhs.getId() > rhs.getId()) return 1;
            return -1;
        }
    };

    @Test
    public void add_integer_list() {
        ListManager<Integer> listManager = new ListManager<>();
        listManager.add(10);
        Assert.assertEquals(listManager.get(0), new Integer(10));
    }

    @Test
    public void get_quotes_sort_by_name() {
        ListManager<Quote> listManager = new ListManager<>();
        listManager.add(QuoteFixtures.q1, QuoteFixtures.q2, QuoteFixtures.q3,
                QuoteFixtures.q4, QuoteFixtures.q5, QuoteFixtures.q6);

        listManager.sort(ORDER_BY_AUTHOR);
        Assert.assertEquals(listManager.get(0).getQuote(), "Quote1");

    }

    @Test
    public void get_quotes_sort_by_name_descending() {
        ListManager<Quote> listManager = new ListManager<>();
        listManager.add(QuoteFixtures.q1, QuoteFixtures.q2, QuoteFixtures.q3,
                QuoteFixtures.q4, QuoteFixtures.q5, QuoteFixtures.q6);

        listManager.sortDescending(ORDER_BY_AUTHOR);
        Assert.assertEquals(listManager.get(0).getQuote(), "Quote2");

    }

    @Test
    public void get_quotes_min_id_through_list_util() {
        ListManager<Quote> listManager = new ListManager<>();
        listManager.add(QuoteFixtures.q1, QuoteFixtures.q2, QuoteFixtures.q3,
                QuoteFixtures.q4, QuoteFixtures.q5, QuoteFixtures.q6);


        Quote quote = ListUtils.min(listManager.get(), ORDER_BY_ID);


        Assert.assertEquals(quote.getId(), 1);

    }
}
