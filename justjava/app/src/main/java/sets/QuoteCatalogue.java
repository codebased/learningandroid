package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import models.Quote;

public class QuoteCatalogue {
    private Set<Quote> quotes = new HashSet<>();

    public void add(Quote quote) {
        quotes.add(quote);
    }

    public void print() {
        System.out.println(Arrays.toString(quotes.toArray()));
    }

    public int size() {
        return quotes.size();
    }
}
