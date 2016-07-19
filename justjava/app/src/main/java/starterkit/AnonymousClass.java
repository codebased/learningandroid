package starterkit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Quote;
import models.QuoteFixtures;

/**
 * Created by codebased on 19/07/16.
 */
public class AnonymousClass {
    public void play() {
        final List<Quote> quotes = new ArrayList<>();
        quotes.add(QuoteFixtures.q1);
        quotes.add(QuoteFixtures.q2);
        quotes.add(QuoteFixtures.q3);

        Iterator<Quote> quoteIterator = new Iterator<Quote>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < quotes.size();
            }

            @Override
            public Quote next() {
                return quotes.get(index++);
            }

            @Override
            public void remove() {
            }
        };

        while (quoteIterator.hasNext()) {
            System.out.println(quoteIterator.next());
        }
    }
}
