package lists;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import models.Quote;
import models.QuoteFixtures;

public class ThirdCollectionConcepts {


    public static void main(String[] args) {
        Quote q1 = QuoteFixtures.q1;
        Quote q2 = QuoteFixtures.q2;
        Quote q3 = QuoteFixtures.q3;

        Collection<Quote> quotes = new ArrayList<>();
        quotes.add(q1);
        quotes.add(q2);
        quotes.add(q3);

        // 0. Iterable
        // tests. Collection with foreach
        // 2. Can't print out and remove - CME
        // 3. refactor to iterator

        Iterator<Quote> iterator = quotes.iterator();
        while (iterator.hasNext()) {
            final Quote q = iterator.next();
            if (q.getId() >= 1) {
                System.out.println(q);
            } else {
                iterator.remove();
            }
        }

        System.out.println(quotes);

        // 4. other methods
        System.out.println(quotes.size());
        System.out.println(quotes.isEmpty());

        System.out.println(quotes.contains(q1));

        quotes.remove(q3);

        System.out.println(quotes.contains(q3));

        // 5. removeAll
        List<Quote> otherQuotes = new ArrayList<>();
        otherQuotes.add(q1);
        otherQuotes.add(q2);

        quotes.removeAll(otherQuotes);
        System.out.println(quotes);

        quotes.addAll(otherQuotes);
        Collections.addAll(quotes, QuoteFixtures.q4, QuoteFixtures.q3);

        // 6. sort
        Collections.sort((List<Quote>) quotes, Quote.BY_GENRE);
        System.out.print("Sort: ");
        System.out.println(quotes);

        // 7. shuffle
        Collections.shuffle((List<Quote>) quotes);
        System.out.println(quotes);

        // 7. rotate
        Collections.rotate((List<Quote>) quotes, 3);
        System.out.println(quotes);
    }
}
