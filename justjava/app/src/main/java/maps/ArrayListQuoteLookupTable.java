package maps;


import java.util.ArrayList;
import java.util.List;

import models.Quote;

public class ArrayListQuoteLookupTable implements QuoteLookupTable {
    private final List<Quote> quotes = new ArrayList<>();

    @Override
    public Quote addQuote(final Quote quote) {
        final int uniqueId = quote.getId();

        Quote searchQuote = lookupById(uniqueId);

        if (searchQuote == null) {
            quotes.add(quote);
        } else {
            throw new IllegalArgumentException(
                    "Unable to add quote, duplicate id for: " + quote);
        }

        quotes.add(quote);

        return quote;
    }

    @Override
    public Quote lookupById(final int id) {
        for (final Quote quote : quotes) {
            if (quote.getId() == id) {
                return quote;
            }
        }

        return null;
    }

    public void clear() {
        quotes.clear();
    }
}
