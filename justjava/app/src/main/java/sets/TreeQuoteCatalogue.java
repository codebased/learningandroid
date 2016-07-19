package sets;


import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import models.Quote;
import models.QuoteFixtures;

public class TreeQuoteCatalogue implements Iterable<Quote> {

    private SortedSet<Quote> quotes = new TreeSet<>(new Comparator<Quote>() {
        @Override
        public int compare(Quote lhs, Quote rhs) {
            if (lhs.getId() == rhs.getId()) return 0;
            if (lhs.getId() > rhs.getId()) return 1;
            return -1;
        }
    });


    public Iterator<Quote> iterator() {
        return quotes.iterator();
    }

    public void add(Quote quote) {
        quotes.add(quote);
    }

    public void print() {

        for (Quote quote :
                quotes) {
            System.out.println(quote);
        }
    }

    public static void main(String[] args) {
        TreeQuoteCatalogue catalogue = new TreeQuoteCatalogue();

        catalogue.add(QuoteFixtures.q1);
        catalogue.add(QuoteFixtures.q1);
        catalogue.add(QuoteFixtures.q2);
        catalogue.add(QuoteFixtures.q3);
        catalogue.add(QuoteFixtures.q4);
        catalogue.print();
    }
}